package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Venta;
import view.Internal_verVentas;
import model.Servicio;

public class Ctrl_Inter_verVentas implements ActionListener {

    public Internal_verVentas verVentas;
    private Servicio serv;

    public Ctrl_Inter_verVentas() {

        this.serv = new Servicio();
        this.verVentas = new Internal_verVentas();
        verVentas.setVisible(true);
        cargarVentas();

        verVentas.btn_buscarVenta.addActionListener(this);
        verVentas.btn_actualizarVentas.addActionListener(this);
        verVentas.btn_eliminarVenta.addActionListener(this);

        verVentas.txt_idVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent e) {
                buscarVentaPressed(e);
            }
        });
    }

    private void buscarVentaPressed(java.awt.event.KeyEvent e) {
        if (e.getKeyCode() == e.VK_ENTER) {
            buscarVenta();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == verVentas.btn_buscarVenta) {
            buscarVenta();
        } else if (e.getSource() == verVentas.btn_actualizarVentas) {
            cargarVentas();
        } else if (e.getSource() == verVentas.btn_eliminarVenta) {
            eliminarVenta();
        }
    }

    private void buscarVenta() {
        int idVenta = (int) verVentas.txt_idVenta.getValue();

        Venta ventaEncontrada = serv.buscarVenta(idVenta);
        if (ventaEncontrada != null) {
            
            DefaultTableModel modelo = (DefaultTableModel) verVentas.table_ventas.getModel();

            int filaEncontrada = -1;
            for (int i = 0; i < modelo.getRowCount(); i++) {
                int idTabla = (int) modelo.getValueAt(i, 0);
                if (idTabla == ventaEncontrada.getId()) {
                    filaEncontrada = i;
                    break;
                }
            }

            if (filaEncontrada != -1) {
                verVentas.table_ventas.setRowSelectionInterval(filaEncontrada, filaEncontrada);
                verVentas.table_ventas.scrollRectToVisible(verVentas.table_ventas.getCellRect(filaEncontrada, filaEncontrada, true));
            }
            
        } else {
            JOptionPane.showMessageDialog(null, "Error al encontrar la venta.");
        }
    }

    private void cargarVentas() {
        List<Venta> ventas = serv.cargarVentas();

        DefaultTableModel tablaVentaModelo = new DefaultTableModel();

        tablaVentaModelo.addColumn("Id");
        tablaVentaModelo.addColumn("Fecha");
        tablaVentaModelo.addColumn("Cliente");
        tablaVentaModelo.addColumn("Pago");
        tablaVentaModelo.addColumn("Funcion");

        for (Venta venta : ventas) {
            tablaVentaModelo.addRow(new Object[]{
                venta.getId(),
                venta.getFecha(),
                venta.getCliente().getNombre(),
                venta.getPago().getId(),
                venta.getFuncion().getHorario()
            });
        }

        verVentas.table_ventas.setModel(tablaVentaModelo);
    }

    private void eliminarVenta() {

        int filaSeleccionada = verVentas.table_ventas.getSelectedRow();
        System.out.println("fila seleccionada: " + filaSeleccionada);

        if (filaSeleccionada != -1) {
            int valorId = (int) verVentas.table_ventas.getValueAt(filaSeleccionada, 0);

            Venta ventaSeleccionada = serv.buscarVenta(valorId);

            if (ventaSeleccionada != null) {

                int respuestaEliminacion = JOptionPane.showConfirmDialog(
                        null,
                        "¿Desea eliminar la venta Numero: \"" + ventaSeleccionada.getId() + "\"?",
                        "Confirmar eliminación",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE
                );

                if (respuestaEliminacion == JOptionPane.YES_OPTION) {
                    try {
                        serv.eliminarVenta(ventaSeleccionada.getId());
                        cargarVentas();
                    } catch (Exception e) {
                        System.out.println("Error al llamar al metodo para borrar la venta: " + e);
                    }

                }

            } else {
                JOptionPane.showMessageDialog(null, "Venta no encontrada.");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una venta.");
        }
    }

}

package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Cliente;
//import model.ClienteVip;
import view.Internal_gestionarClientes;
import model.Servicio;

public class Ctrl_Inter_gestorCliente implements ActionListener {

    Internal_gestionarClientes gestorClientes;
    private Servicio serv;

    public Ctrl_Inter_gestorCliente() {
        
        this.serv = new Servicio();
        
        this.gestorClientes = new Internal_gestionarClientes();
        gestorClientes.setVisible(true);
        this.cargarTablaClientes();

        gestorClientes.btn_buscar.addActionListener(this);
        gestorClientes.btn_eliminar.addActionListener(this);
        gestorClientes.btn_actualizar.addActionListener(this);

        gestorClientes.txt_busqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent event) {
                buscarClientePressed(event);
            }
        });

    }

    private void buscarClientePressed(java.awt.event.KeyEvent event) {
        if (event.getKeyCode() == event.VK_ENTER) {
            buscarCliente();
        }
    }
    
    private void cargarTablaClientes() {

        List<Cliente> clientes = serv.todosClientes();

        if (clientes != null) {
            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("N° cliente");
            modelo.addColumn("Nombre y Apellido");
            modelo.addColumn("Correo");
            modelo.addColumn("Cliente VIP");
            modelo.addColumn("Descuento");

            for (Cliente emp : clientes) {
                
                if(emp.getTipo() == "ClienteVip"){
                    modelo.addRow(new Object[]{emp.getId(), emp.getNombre(), emp.getEmail(), emp.getTipo(), "10%"});
                } else {
                    modelo.addRow(new Object[]{emp.getId(), emp.getNombre(), emp.getEmail(), emp.getTipo(), "---"});
                }
            }
            gestorClientes.table_clientes.setModel(modelo);

        } else {
            JOptionPane.showMessageDialog(null, "Error al cargar los datos de los empleados");
        }

    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == gestorClientes.btn_buscar) {
            buscarCliente();
        } else if (event.getSource() == gestorClientes.btn_actualizar) {
            cargarTablaClientes();
        } else if (event.getSource() == gestorClientes.btn_eliminar) {
            eliminarCliente();
        }
    }
    
    private void buscarCliente() {

        Cliente clienteEncontrado = serv.buscarCliente(Integer.parseInt(gestorClientes.txt_busqueda.getText().trim()));
        DefaultTableModel modelo = (DefaultTableModel) gestorClientes.table_clientes.getModel();

        int filaEncontrada = -1;
        for (int i = 0; i < modelo.getRowCount(); i++) {
            int idTabla = (int) modelo.getValueAt(i, 0);
            if (idTabla == clienteEncontrado.getId()) {
                filaEncontrada = i;
                break;
            }
        }

        if (filaEncontrada != -1) {
            gestorClientes.table_clientes.setRowSelectionInterval(filaEncontrada, filaEncontrada);
            gestorClientes.table_clientes.scrollRectToVisible(gestorClientes.table_clientes.getCellRect(filaEncontrada, filaEncontrada, true));
        }

    }

    private void eliminarCliente() {
        // Obtener la fila seleccionada
        int filaSeleccionada = gestorClientes.table_clientes.getSelectedRow();

        if (filaSeleccionada != -1) {
            
//            Object valorId = gestorEmpleado.table_empleados.getValueAt(filaSeleccionada, 0);
//            int idEmpleado = Integer.parseInt(valorId.toString());
            
            Object valorId = gestorClientes.table_clientes.getValueAt(filaSeleccionada, 0);
            int idCliente = Integer.parseInt(valorId.toString());

            Cliente clienteSeleccionado = serv.buscarCliente(idCliente);

            if (clienteSeleccionado != null) {

                int respuestaEliminacion = JOptionPane.showConfirmDialog(
                        null,
                        "¿Desea eliminar al empleado \"" + clienteSeleccionado.getNombre() + "\"?",
                        "Confirmar eliminación",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE
                );

                if (respuestaEliminacion == JOptionPane.YES_OPTION) {

                    serv.borrarCliente(clienteSeleccionado);

                    JOptionPane.showMessageDialog(null, "Empleado eliminado correctamente.");

                    cargarTablaClientes() ;
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el empleado seleccionado.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un empleado en la tabla.");
        }
    
    }

}

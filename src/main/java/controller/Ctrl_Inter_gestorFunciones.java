package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import model.Entrada;
import model.Funcion;
import model.Pelicula;
import view.Internal_gestionarFunciones;
import model.Servicio;

/**
 *
 * @author nico-ruiz
 */
public class Ctrl_Inter_gestorFunciones implements ActionListener {

    public Internal_gestionarFunciones gestorFunciones;
    private Servicio serv;

    public Ctrl_Inter_gestorFunciones() {
        
        this.serv = new Servicio();
        this.gestorFunciones = new Internal_gestionarFunciones();
        gestorFunciones.setVisible(true);
        this.cargarFunciones();

        gestorFunciones.btn_actualizar.addActionListener(this);
        gestorFunciones.btn_buscarFuncion.addActionListener(this);
        gestorFunciones.btn_eliminar.addActionListener(this);
        gestorFunciones.txt_buscarFuncion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent event) {
                txt_buscarFuncionPressed(event);
            }
        });

        gestorFunciones.table_funciones.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        gestorFunciones.table_funciones.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {
                if (!lse.getValueIsAdjusting()) {
                    int filaSeleccionada = gestorFunciones.table_funciones.getSelectedRow();
                    if (filaSeleccionada != -1) {
                        int idFuncion = (int) gestorFunciones.table_funciones.getValueAt(filaSeleccionada, 0);
                        cargarEntradas(idFuncion);
                    }
                }
            }
        });

    }

    private void txt_buscarFuncionPressed(java.awt.event.KeyEvent event) {
        if (event.getKeyCode() == event.VK_ENTER) {
            buscarFuncion();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == gestorFunciones.btn_actualizar) {
            cargarFunciones();
        } else if (e.getSource() == gestorFunciones.btn_buscarFuncion) {
            if (!gestorFunciones.txt_buscarFuncion.getText().isEmpty()) {
                buscarFuncion();
            } else if (!gestorFunciones.txt_buscarTitulo.getText().isEmpty()) {
                buscarFuncionPorPelicula();
            }
            
        } else if (e.getSource() == gestorFunciones.btn_eliminar) {
            eliminarFuncion();
        }
    }

    private void cargarFunciones() {
        List<Funcion> funciones = serv.obtenerTodasLasFunciones();

        if (funciones != null) {
            DefaultTableModel modeloFunciones = new DefaultTableModel();
            modeloFunciones.addColumn("Id");
            modeloFunciones.addColumn("Pelicula");
            modeloFunciones.addColumn("Horario");
            modeloFunciones.addColumn("Sala");

            for (Funcion funcion : funciones) {
                modeloFunciones.addRow(new Object[]{funcion.getId(), funcion.getPelicula().getTitulo(), funcion.getHorario(), funcion.getSala().getNumero()});
            }

            gestorFunciones.table_funciones.setModel(modeloFunciones);
        }
    }

    private void buscarFuncion() {
        Funcion funcionEncontrada = serv.buscarFuncion(Integer.parseInt(gestorFunciones.txt_buscarFuncion.getText().trim()));
        DefaultTableModel modeloTablaFunciones = (DefaultTableModel) gestorFunciones.table_funciones.getModel();

        int filaEncontrada = -1;

        for (int i = 0; i < modeloTablaFunciones.getRowCount(); i++) {
            int id = (int) modeloTablaFunciones.getValueAt(i, 0);
            if (id == funcionEncontrada.getId()) {
                filaEncontrada = i;
                break;
            }
        }

        if (filaEncontrada != -1) {
            gestorFunciones.table_funciones.setRowSelectionInterval(filaEncontrada, filaEncontrada);
            gestorFunciones.table_funciones.scrollRectToVisible(gestorFunciones.table_funciones.getCellRect(filaEncontrada, filaEncontrada, true));
        }
    }

    private void buscarFuncionPorPelicula() {

        String titulo = gestorFunciones.txt_buscarTitulo.getText().trim();
        if (titulo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese un titulo");
            return;
        }
        Pelicula peliculaEncontrada = serv.buscarPelicula(titulo);
        if (peliculaEncontrada != null) {
            List<Funcion> funciones = peliculaEncontrada.getFunciones();
            DefaultTableModel modeloFuncionesPorPelicula = new DefaultTableModel();

            modeloFuncionesPorPelicula.addColumn("Id");
            modeloFuncionesPorPelicula.addColumn("Pelicula");
            modeloFuncionesPorPelicula.addColumn("Horario");
            modeloFuncionesPorPelicula.addColumn("Sala");

            for (Funcion funcion : funciones) {
                modeloFuncionesPorPelicula.addRow(new Object[]{
                    funcion.getId(),
                    funcion.getPelicula().getTitulo(),
                    funcion.getHorario(),
                    funcion.getSala().getNumero()
                });

            }

            gestorFunciones.table_funciones.setModel(modeloFuncionesPorPelicula);
        } else {
            JOptionPane.showMessageDialog(null, "La pelicula no existe");
            return;
        }

    }

    private void eliminarFuncion() {
        int filaSeleccionada = gestorFunciones.table_funciones.getSelectedRow();

        if (filaSeleccionada != -1) {
            int valorId = (int) gestorFunciones.table_funciones.getValueAt(filaSeleccionada, 0);

            Funcion funcionEncontrada = serv.buscarFuncion(valorId);

            if (funcionEncontrada != null) {
                int respuestaEliminacion = JOptionPane.showConfirmDialog(null, "¿Desea eliminar la funcion?", "Confirmar eliminacion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                if (respuestaEliminacion == JOptionPane.YES_OPTION) {
                    serv.eliminarFuncion(valorId);
                    JOptionPane.showMessageDialog(null, "Funcion eliminada exitosamente");
                    cargarFunciones();
                }

            } else {
                JOptionPane.showMessageDialog(null, "No se encontro la funcion seleccionada.");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una funcion en la tabla para eliminarla.");
        }
    }

    private void cargarEntradas(int id) {
        Funcion funcionEncontrada = serv.buscarFuncion(id);
        List<Entrada> entradas = funcionEncontrada.getEntrada();

        if (funcionEncontrada != null) {
            DefaultTableModel modeloTablaEntradas = new DefaultTableModel();

            modeloTablaEntradas.addColumn("Id");
            modeloTablaEntradas.addColumn("Precio");
            modeloTablaEntradas.addColumn("Asiento");

            for (Entrada entrada : entradas) {
                if(!entrada.isVendida()){
                    modeloTablaEntradas.addRow(new Object[]{entrada.getId(), entrada.getPrecio(), entrada.getAsiento()});
                }
                
            }

            gestorFunciones.table_entradas.setModel(modeloTablaEntradas);
        }
    }

}

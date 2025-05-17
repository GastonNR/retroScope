package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Empleado;
import view.Internal_gestionarEmpleados;
import model.Servicio;

class Ctrl_Inter_gestorEmpleado implements ActionListener {

    public Internal_gestionarEmpleados gestorEmpleado;
    private Servicio serv;

    public Ctrl_Inter_gestorEmpleado() {

        this.serv = new Servicio();
        this.gestorEmpleado = new Internal_gestionarEmpleados();
        gestorEmpleado.setVisible(true);
        this.cargarTablaEmpleados();

        gestorEmpleado.btn_actualizar.addActionListener(this);
        gestorEmpleado.btn_buscar.addActionListener(this);
        gestorEmpleado.btn_eliminar.addActionListener(this);
        gestorEmpleado.txt_buscador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent e) {
                txtBuscadorKeyPressed(e);
            }
        });

    }

    private void txtBuscadorKeyPressed(java.awt.event.KeyEvent e) {
        if (e.getKeyCode() == e.VK_ENTER) {
            buscarEmpleado();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(gestorEmpleado.btn_buscar)) {
            buscarEmpleado();
        } else if (e.getSource().equals(gestorEmpleado.btn_actualizar)) {
            cargarTablaEmpleados();
            //actualizarDatos();
        } else if (e.getSource().equals(gestorEmpleado.btn_eliminar)) {
            eliminarEmpleado();
        }

    }

    private void cargarTablaEmpleados() {

        List<Empleado> empleados = serv.obtenerTodosLosEmpleados();

        if (empleados != null) {
            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("Id");
            modelo.addColumn("Nombre");
            modelo.addColumn("DNI");
            modelo.addColumn("Correo");

            for (Empleado emp : empleados) {
                modelo.addRow(new Object[]{emp.getId(), emp.getNombre(), emp.getDNI(), emp.getEmail()});
            }

            gestorEmpleado.table_empleados.setModel(modelo);

        } else {
            JOptionPane.showMessageDialog(null, "Error al cargar los datos de los empleados");
        }

    }

    private void buscarEmpleado() {

        Empleado empleadoEncontrado = serv.buscarEmpleado(Integer.parseInt(gestorEmpleado.txt_buscador.getText().trim()));
        DefaultTableModel modelo = (DefaultTableModel) gestorEmpleado.table_empleados.getModel();

        int filaEncontrada = -1;
        for (int i = 0; i < modelo.getRowCount(); i++) {
            int idTabla = (int) modelo.getValueAt(i, 0);
            if (idTabla == empleadoEncontrado.getId()) {
                filaEncontrada = i;
                break;
            }
        }

        if (filaEncontrada != -1) {
            gestorEmpleado.table_empleados.setRowSelectionInterval(filaEncontrada, filaEncontrada);
            gestorEmpleado.table_empleados.scrollRectToVisible(gestorEmpleado.table_empleados.getCellRect(filaEncontrada, filaEncontrada, true));
        }

    }

    private void eliminarEmpleado() {
        
        int filaSeleccionada = gestorEmpleado.table_empleados.getSelectedRow();

        if (filaSeleccionada != -1) {
            
            Object valorId = gestorEmpleado.table_empleados.getValueAt(filaSeleccionada, 0);
            int idEmpleado = Integer.parseInt(valorId.toString());

            Empleado empleadoSeleccionado = serv.buscarEmpleado(idEmpleado);

            if (empleadoSeleccionado != null) {

                int respuestaEliminacion = JOptionPane.showConfirmDialog(
                        null,
                        "¿Desea eliminar al empleado \"" + empleadoSeleccionado.getNombre() + "\"?",
                        "Confirmar eliminación",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE
                );

                if (respuestaEliminacion == JOptionPane.YES_OPTION) {

                    serv.eliminarEmpleado(empleadoSeleccionado);


                    JOptionPane.showMessageDialog(null, "Empleado eliminado correctamente.");

                    cargarTablaEmpleados();
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el empleado seleccionado.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un empleado en la tabla.");
        }
    }

}

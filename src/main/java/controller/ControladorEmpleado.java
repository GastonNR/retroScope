package controller;

import model.Servicio;
import model.Empleado;
import persistencia.EmpleadoJpaController;

public class ControladorEmpleado {

    private Servicio serv;

    public ControladorEmpleado() {
        Servicio serv = new Servicio();

    }

    public boolean validarCredenciales(int id, String claveEmpleado) {

        try {

            Empleado empleado = serv.buscarEmpleado(id);

            return empleado != null && empleado.getPassword().equals(claveEmpleado);

        } catch (Exception ex) {

            return false;
        }
    }
}

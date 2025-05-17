package controller;

import model.Empleado;
import persistencia.EmpleadoJpaController;


public class ControladorEmpleado {
    
    private EmpleadoJpaController empleadoJpaControlador;

    public ControladorEmpleado() {
        this.empleadoJpaControlador = new EmpleadoJpaController();
    }

    
    
    public boolean validarCredenciales(int id, String claveEmpleado){
       
        System.out.println("Entro en la funicion de validarCredenciales....");
        
        try{
            
            Empleado empleado = empleadoJpaControlador.findEmpleado(id);
            
            return empleado != null && empleado.getPassword().equals(claveEmpleado);
            
        }catch(Exception ex){
            
            return false;
        }
    }
}

package model;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.swing.JOptionPane;
import persistencia.EmpleadoJpaController;

@Entity
public class Empleado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Basic
    private String nombre;
    private String DNI;
    private String email;
    private String password;
    public List<Cine> cines = new ArrayList();

    public Empleado() {
    }

    public Empleado(String nombre, String DNI, String email, String password) {

        this.nombre = nombre;
        this.DNI = DNI;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void addCine(Cine cine) {
        cine.addEmpleado(this);
        this.cines.add(cine);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Cine> getCines() {
        return cines;
    }

    public void setCines(List<Cine> cines) {
        this.cines = cines;
    }

    
    
    @Override
    public String toString() {
        return "Empleado{"
                + "nombre='" + nombre + '\''
                + ", DNI='" + DNI + '\''
                + '}';
    }

    public void guardarEmpleado() {

        EmpleadoJpaController jpaCtr_empleado = new EmpleadoJpaController();

        try {

            jpaCtr_empleado.create(this);
            JOptionPane.showMessageDialog(null, "Empleado guardado exitosamente.");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al guardar en la base de datos..." + e);
        }

    }

    public static List<Empleado> obtenerTodosLosEmpleados() {

        EmpleadoJpaController empleadoController = new EmpleadoJpaController();
        
        try {

            return empleadoController.findEmpleadoEntities();

        } catch (Exception e) {

            System.out.println("Error al obtener los empleados: " + e.getMessage());
            return null;

        }
    }
    
    public static Empleado buscarEmpleado(int id){
        
        EmpleadoJpaController ctr_jpaEmpleado = new EmpleadoJpaController();
        
        try{
            Empleado empleado = ctr_jpaEmpleado.findEmpleado(id);
            
            if(empleado != null){
                return empleado;
            }else{
                JOptionPane.showMessageDialog(null, "El usuario no existe...");
                return null;
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "El usuario no existe...");
            return null;
        }
        
    }
    
    public static void eliminarEmpleado(Empleado empleado){
        EmpleadoJpaController ctr_jpaEmpleado = new EmpleadoJpaController();
        
        try{
           ctr_jpaEmpleado.destroy(empleado.getId());
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Empleado borrado con exito.");
        }
    }
}

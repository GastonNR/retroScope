package model;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.swing.JOptionPane;
import persistencia.ClienteJpaController;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TIPO", discriminatorType = DiscriminatorType.STRING)
public class Cliente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Basic
    private String nombre;
    private String email;
    @Column(name="TIPO", insertable= false, updatable = false)
    private String tipo;

    public Cliente() {
    }

    public Cliente(String nombre, String email) {
        this.email = email;
        this.nombre = nombre;
    }    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
 
    
    public static void guardarCliente(Cliente cliente){
        
        ClienteJpaController ctr_jpa_cliente = new ClienteJpaController();
        
        try{
            
            ctr_jpa_cliente.create(cliente);
            JOptionPane.showMessageDialog(null, "Cliente guardado con exito");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al guardar el nuevo cliente.");
        }
    }
    
    public static List<Cliente> obtenerTodosLosClientes() {

        ClienteJpaController clienteController = new ClienteJpaController();
        
        try {

            return clienteController.findClienteEntities();

        } catch (Exception e) {

            System.out.println("Error al obtener los clientes: " + e.getMessage());
            return null;

        }
    }
    
    public static Cliente buscarCliente(int id){
        ClienteJpaController ctr_jpaCliente = new ClienteJpaController();
        
        try{
            Cliente cliente = ctr_jpaCliente.findCliente(id);
            
            if(cliente != null){
                return cliente;
            }else{
                JOptionPane.showMessageDialog(null, "El cliente no existe...");
                return null;
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "El cliente no existe...");
            return null;
        }
    }
    
    public static void eliminarCliente(Cliente cliente){
        ClienteJpaController ctr_jpaCliente = new ClienteJpaController();
        
        try{
           ctr_jpaCliente.destroy(cliente.getId());
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Empleado borrado con exito.");
        }
    }
}

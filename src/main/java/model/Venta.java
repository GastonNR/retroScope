package model;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.swing.JOptionPane;
import persistencia.VentaJpaController;

@Entity
public class Venta implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private int id;
    @Temporal(TemporalType.DATE)
    private Date fecha;
    
    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;
    
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name = "pago_id", nullable = false)
    private Pago pago;
    
    @ManyToOne
    @JoinColumn(name = "funcion_id", nullable = false)
    private Funcion funcion;

    public Venta() {
    }

    public Venta(Cliente cliente, Pago pago, Funcion funcion, Date fecha) {
        
        this.cliente = cliente;
        this.pago = pago;
        this.funcion = funcion;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }

    public Funcion getFuncion() {
        return funcion;
    }

    public void setFuncion(Funcion funcion) {
        this.funcion = funcion;
    }

    public static void guardarVenta(Venta venta){
        VentaJpaController ventaJpa = new VentaJpaController();
        
        try{
            ventaJpa.create(venta);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al guardar la venta");
        }
    }
    
    public static Venta buscarVenta(int id){
        VentaJpaController ctr_jpaVenta = new VentaJpaController();
        
        try{
            return ctr_jpaVenta.findVenta(id);
        } catch (Exception e){
            System.out.println("Error de carga: " + e);
            JOptionPane.showMessageDialog(null, "Error al cargar los datos de la venta");
            return null;
        }
    }
    
    public static List<Venta> cargarVentas(){
        
        VentaJpaController ctr_jpaVenta = new VentaJpaController();
        
        try{
            return ctr_jpaVenta.findVentaEntities();
        } catch (Exception e){
            System.out.println("Error de carga: " + e);
            JOptionPane.showMessageDialog(null, "Error al cargar los datos de las ventas");
            return null;
        }
    }
    
    public static void eliminarVenta(int id){
        VentaJpaController ctr_jpaVenta = new VentaJpaController();
        
        try{
            ctr_jpaVenta.destroy(id);
        } catch (Exception e){
            System.out.println("Error al eliminar la venta: " + e);
            JOptionPane.showMessageDialog(null, "Error al eliminar los datos de la venta");
        }
    }
}

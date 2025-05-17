package model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Compra implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @OneToMany
    private List<Proveedor> proveedores = new ArrayList();
    @OneToMany
    private List<Insumo> insumos = new ArrayList();

    public Compra() {
    }

    public Compra(int id, Date fecha) {
        this.id = id;
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

    public void addProveedores(Proveedor proveedor){
        this.proveedores.add(proveedor);
    }

    public void addInsumo(String nombre, double precio){
        this.insumos.add(new Insumo(nombre, precio));
    }

    public List<Proveedor> getProveedores() {
        return proveedores;
    }

    public List<Insumo> getInsumos() {
        return insumos;
    }

    
}

package model;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cine implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private int id;
    @Basic
    private String nombre;
    private String direccion;
    @OneToMany
    private List<Pelicula> peliculas = new ArrayList<>();
    @OneToMany
    private List<Venta> ventas = new ArrayList<>();
    @OneToMany
    private List<Sala> salas = new ArrayList<>();
    @OneToMany
    private List<SalaVip> salaVips = new ArrayList<>();
    @OneToMany
    private List<Compra> compras = new ArrayList<>();
    @OneToMany
    private List<Empleado> empleados = new ArrayList<>();

    public Cine() {
    }

    
    public Cine(int id, String nombre, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void addPeliculas(String titulo, Genero genero, String duracion, Clasificacion clasificacion, String idioma, String subtitulos) {
        
        this.peliculas.add(new Pelicula(titulo, genero, duracion, clasificacion, idioma, subtitulos));
        
    }

    public void setVentas(Venta venta) {
        this.ventas.add(venta);
    }

    public void addSalas(Sala sala) {
        this.salas.add(sala);
    }


    public void addSalaVips(SalaVip salaVip) {
        this.salaVips.add(salaVip);
    }

    public void addCompras(Compra compra) {
        this.compras.add(compra);
    }

    public void addEmpleado(Empleado empleado){
        this.empleados.add(empleado);
    }

    public List<Pelicula> getPeliculas() {
        return peliculas;
    }

    public List<Venta> getVentas() {
        return ventas;
    }

    public List<Sala> getSalas() {
        return salas;
    }

    public List<SalaVip> getSalaVips() {
        return salaVips;
    }

    public List<Compra> getCompras() {
        return compras;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }
    
    
}

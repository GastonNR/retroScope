package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Entrada implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private double precio;
    private String asiento;
    private Funcion funcion;
    @Basic
    private boolean vendida;

    public Entrada() {
    }

    public Entrada(String asiento) {
        this.asiento = asiento;
    }

    public Entrada(int id, double precio, String asiento) {
        this.id = id;
        this.precio = precio;
        this.asiento = asiento;
        this.vendida = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getAsiento() {
        return asiento;
    }

    public void setAsiento(String asiento) {
        this.asiento = asiento;
    }

    public Funcion getFuncion() {
        return funcion;
    }

    public void setFuncion(Funcion funcion) {
        this.funcion = funcion;
    }

    public boolean isVendida() {
        return vendida;
    }

}

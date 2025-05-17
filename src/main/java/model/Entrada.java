package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.swing.JOptionPane;
import persistencia.EntradaJpaController;

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
    
    public static Entrada buscarEntrada(int id) {
        EntradaJpaController jpaEntrada = new EntradaJpaController();

        try {
            return jpaEntrada.findEntrada(id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se encontro la entrada.");
            return null;
        }
    }

    public static void venderEntrada(int id) {

        Entrada entrada = Entrada.buscarEntrada(id);
        EntradaJpaController jpaEntrada = new EntradaJpaController();

        try {
            jpaEntrada.actualizarEntrada(id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al vender la entrada.");
        }
    }

}

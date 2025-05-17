package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import persistencia.SalaJpaController;

/**
 *
 * @author nico-ruiz
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TIPO", discriminatorType = DiscriminatorType.STRING)
public class Sala implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int numero;
    @Basic
    private double precio;
    @Column(name = "TIPO", insertable = false, updatable = false)
    private String tipo;
    @OneToMany(mappedBy = "sala")
    private List<Funcion> funciones = new ArrayList();

    public Sala(int numero, double precio) {
        this.numero = numero;
        this.precio = precio;
    }

    public Sala() {
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void addFunicion(Funcion funcion) {
        this.funciones.add(funcion);
    }

    public List<Funcion> getFuncion() {
        return new ArrayList<>(funciones);
    }

    public static List<Sala> obtenerTodasLasSalas() {

        SalaJpaController salaController = new SalaJpaController();

        try {

            return salaController.findSalaEntities();

        } catch (Exception e) {

            System.out.println("Error al obtener los clientes: " + e.getMessage());
            return null;

        }
    }

    public static Sala buscarSala(int numeroSala) {
        SalaJpaController ctr_jpaSala = new SalaJpaController();
        try {
            return ctr_jpaSala.findSala(numeroSala);
        } finally {

        }
    }
}

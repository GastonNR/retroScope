package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.swing.JOptionPane;
import persistencia.PeliculaJpaController;
import persistencia.exceptions.NonexistentEntityException;

@Entity
public class Pelicula implements IPromocion, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idPelicula;
    @Enumerated(EnumType.STRING)
    private Genero genero;
    @Enumerated(EnumType.STRING)
    private Clasificacion clasificacion;
    @Basic
    private String titulo;
    private String duracion;
    private String idioma;
    private String subtitulos;
    @OneToMany(mappedBy = "Pelicula", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Funcion> funciones = new ArrayList();

    public Pelicula() {
    }

    public Pelicula(
            String titulo,
            Genero genero,
            String duracion,
            Clasificacion clasificacion,
            String idioma,
            String subtitulos
    ) {
        this.titulo = titulo;
        this.genero = genero;
        this.duracion = duracion;
        this.clasificacion = clasificacion;
        this.idioma = idioma;
        this.subtitulos = subtitulos;
    }

    public int getIdPelicula() {
        return idPelicula;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public void addFuncion(Funcion funcion) {
        this.funciones.add(funcion);
        funcion.setPelicula(this);
    }

    public void setFunciones(List<Funcion> funciones) {
        this.funciones = funciones;
    }

    public List<Funcion> getFunciones() {
        return new ArrayList<>(funciones);
    }

    public Clasificacion getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(Clasificacion clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getSubtitulos() {
        return subtitulos;
    }

    public void setSubtitulos(String subtitulos) {
        this.subtitulos = subtitulos;
    }

    @Override
    public float obtenerDescuento(float descuento) {
        return descuento;
    }

    public void guardarPelicula(Pelicula pelicula) {

        PeliculaJpaController ctr_jpa_pelicula = new PeliculaJpaController();

        try {

            ctr_jpa_pelicula.create(pelicula);
            JOptionPane.showMessageDialog(null, "Pelicula guardada con exito");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al guardar la nuevo pelicula.");
        }
    }

    public static List<Pelicula> obtenerTodasLasPeliculas() {

        PeliculaJpaController peliculaController = new PeliculaJpaController();

        try {

            return peliculaController.findPeliculaEntities();

        } catch (Exception e) {

            System.out.println("Error al obtener los clientes: " + e.getMessage());
            return null;

        }
    }

    public static void borrarPelicula(Pelicula pelicula) throws NonexistentEntityException {

        PeliculaJpaController peliculaController = new PeliculaJpaController();
        int idPelicula = pelicula.getIdPelicula();

        try {
            peliculaController.destroy(pelicula.getIdPelicula());
        } catch (NumberFormatException e) {
            System.out.println("error al destruir el objeto" + e);
        }
    }
    
    public static Pelicula buscarPelicula(int id) {

        PeliculaJpaController ctr_jpaPelicula = new PeliculaJpaController();

        try {
            Pelicula pelicula = ctr_jpaPelicula.findPelicula(id);

            if (pelicula != null) {
                return pelicula;
            } else {
                JOptionPane.showMessageDialog(null, "La pelicula no existe...");
                return null;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al buscar la pelicula...");
            return null;
        }
    }

    public static Pelicula buscarPelicula(String titulo) {

        PeliculaJpaController ctr_jpaPelicula = new PeliculaJpaController();

        try {
            Pelicula pelicula = ctr_jpaPelicula.buscarPelicula(titulo);

            if (pelicula != null) {
                return pelicula;
            } else {
                JOptionPane.showMessageDialog(null, "La pelicula no existe...");
                return null;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al buscar la pelicula...");
            return null;
        }
    }

    public void remove(Pelicula pelicula) {

    }

    public void add(Pelicula pelicula) {

    }

}

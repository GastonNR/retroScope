package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.swing.JOptionPane;
import persistencia.FuncionJpaController;

@Entity
public class Funcion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date horario;
    @OneToMany(mappedBy = "Funcion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Entrada> entradas;
    private Pelicula pelicula;
    @JoinColumn(name = "Sala_numero", referencedColumnName = "numero")
    private Sala sala;

    public Funcion() {
    }

    public Funcion(Date horario, Pelicula pelicula, Sala sala) {

        this.horario = horario;
        this.pelicula = pelicula;
        this.sala = sala;
        this.entradas = new ArrayList();
        
        for(int i=1; i < 50; i++){
            Entrada entrada = new Entrada(String.valueOf(i));
            entrada.setPrecio(this.sala.getPrecio());
            entrada.setFuncion(this);
            entradas.add(entrada);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getHorario() {
        return horario;
    }

    public void setHorario(Date horario) {
        this.horario = horario;
    }

    public void addEntradas(Entrada entrada) {
        this.entradas.add(entrada);
    }

    public List<Entrada> getEntrada() {
        return this.entradas;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public static void guardarFuncion(Funcion funcion) {
        FuncionJpaController ctr_jpaFuncion = new FuncionJpaController();
        try {
            ctr_jpaFuncion.create(funcion);
            JOptionPane.showMessageDialog(null, "Funcion guardada con exito");
        } catch (Exception e) {
            System.out.println("Error al guardar la funcion " + e);
        }
    }
    
    public static Funcion buscarFuncion(int id){
        FuncionJpaController funcionController = new FuncionJpaController();
        
        try{
            return funcionController.findFuncion(id);
            
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Erro al encontrar la funcion.");
            return null;
        }
    }

    public static List<Funcion> obtenerTodasLasFunciones() {

        FuncionJpaController funcionController = new FuncionJpaController();

        try {

            return funcionController.findFuncionEntities();

        } catch (Exception e) {

            System.out.println("Error al obtener los clientes: " + e.getMessage());
            return null;

        }
    }
    
    public static void eliminarFuncion(int id){
        
        FuncionJpaController ctrl_jpaFuncion = new FuncionJpaController();
        
        try{
            ctrl_jpaFuncion.destroy(id);
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "La funcion no se ha podido eliminar");
            System.out.println("Error al eliminar la funcion" + e);
        }
    }

    public static boolean validarHorario(Date horario, int numeroSala) {

        FuncionJpaController ctrl_jpaFuncion = new FuncionJpaController();

        Funcion funcionEncontrada = ctrl_jpaFuncion.coincidenciaSalaHorario(horario, numeroSala);
        if (funcionEncontrada != null) {
            return true;
        } else {
            return false;
        }
    }
}

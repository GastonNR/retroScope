package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import model.Funcion;
import model.Pelicula;
import model.Sala;
import view.Internal_crearFuncion;

public class Ctrl_Inter_crearFuncion implements ActionListener {

    public Internal_crearFuncion crearFuncion;

    public Ctrl_Inter_crearFuncion() {

        this.crearFuncion = new Internal_crearFuncion();
        crearFuncion.setVisible(true);

        this.cargarPeliculas();

        crearFuncion.btn_agregarFuncion.addActionListener(this);
        crearFuncion.btn_actualizar.addActionListener(this);

    }

    private void cargarPeliculas() {

        List<Pelicula> peliculas = Pelicula.obtenerTodasLasPeliculas();

        DefaultListModel modeloListaPelicula = new DefaultListModel<>();

        for (Pelicula pelicula : peliculas) {
            modeloListaPelicula.addElement(pelicula.getTitulo());
        }
        crearFuncion.list_peliculas.setModel(modeloListaPelicula);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == crearFuncion.btn_agregarFuncion) {
            agregarFuncion();
        } else if (e.getSource() == crearFuncion.btn_actualizar) {
            cargarPeliculas();
        } 
    }

    private void agregarFuncion() {
        
        if(validarDatos()){
            
            
            Pelicula pelicula = Pelicula.buscarPelicula( crearFuncion.list_peliculas.getSelectedValue().toString());
            Date horario = (Date) crearFuncion.spinner_horario.getValue();
            Sala sala = Sala.buscarSala((int) crearFuncion.spinner_salas.getValue());
            Funcion funcion = new Funcion(horario, pelicula, sala);
            pelicula.addFuncion(funcion);
            Funcion.guardarFuncion(funcion);
        }else{
            JOptionPane.showMessageDialog(null, "Error al validar los datos.");
        }
    }

    private boolean validarDatos() {
        if(crearFuncion.list_peliculas.getSelectedIndex() == -1){
            JOptionPane.showMessageDialog(null, "Seleccione una pelicula.");
            return false;
        }
        if((int) crearFuncion.spinner_salas.getValue() == -1){
            JOptionPane.showMessageDialog(null, "Seleccione una sala.");
            return false;
        }
        
        int numeroSala = (int) crearFuncion.spinner_salas.getValue();
        
        if(Funcion.validarHorario( (Date) crearFuncion.spinner_horario.getValue(), numeroSala)){
            JOptionPane.showMessageDialog(null, "El horario ya ha sido asignado a otra funcion o es antiguo.");
            return false;
        }
        return true;
    }

    
}

    

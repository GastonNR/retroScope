package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import model.Funcion;
import model.Pelicula;
import model.Sala;
import view.Internal_crearFuncion;
import model.Servicio;

public class Ctrl_Inter_crearFuncion implements ActionListener {

    public Internal_crearFuncion crearFuncion;
    private Servicio serv;

    public Ctrl_Inter_crearFuncion() {

        this.serv = new Servicio();
        this.crearFuncion = new Internal_crearFuncion();
        crearFuncion.setVisible(true);

        this.cargarPeliculas();

        crearFuncion.btn_agregarFuncion.addActionListener(this);
        crearFuncion.btn_actualizar.addActionListener(this);

    }

    private void cargarPeliculas() {

        List<Pelicula> peliculas = serv.obtenerTodasLasPeliculas();

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
            
            
            Pelicula pelicula = serv.buscarPelicula( crearFuncion.list_peliculas.getSelectedValue().toString());
            Date horario = (Date) crearFuncion.spinner_horario.getValue();
            Sala sala = serv.buscarSala((int) crearFuncion.spinner_salas.getValue());
            Funcion funcion = new Funcion(horario, pelicula, sala);
            pelicula.addFuncion(funcion);
            serv.guardarFuncion(funcion);
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
        
        if(serv.validarHorario( (Date) crearFuncion.spinner_horario.getValue(), numeroSala)){
            JOptionPane.showMessageDialog(null, "El horario ya ha sido asignado a otra funcion o es antiguo.");
            return false;
        }
        return true;
    }

    
}

    

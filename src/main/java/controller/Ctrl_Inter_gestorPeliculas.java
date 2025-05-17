package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import model.Funcion;
import model.Pelicula;
import persistencia.exceptions.NonexistentEntityException;
import view.Internal_gestionarPeliculas;

/**
 *
 * @author nico-ruiz
 */
public class Ctrl_Inter_gestorPeliculas implements ActionListener {

    public Internal_gestionarPeliculas gestorPeliculas;

    public Ctrl_Inter_gestorPeliculas() {

        this.gestorPeliculas = new Internal_gestionarPeliculas();
        gestorPeliculas.setVisible(true);
        this.cargarTablaPeliculas();

        gestorPeliculas.btn_buscar.addActionListener(this);
        gestorPeliculas.btn_actualizar.addActionListener(this);
        gestorPeliculas.btn_eliminar.addActionListener(this);

        gestorPeliculas.table_peliculas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        gestorPeliculas.table_peliculas.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {
                if (!lse.getValueIsAdjusting()) {
                    int filaSeleccionada = gestorPeliculas.table_peliculas.getSelectedRow();
                    if (filaSeleccionada != -1) {
                        int idPelicula = (int) gestorPeliculas.table_peliculas.getValueAt(filaSeleccionada, 0);
                        cargarFuncionesYSala(idPelicula);
                    }
                }
            }
        });

        gestorPeliculas.txt_tituloPelicula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent event) {
                tituloPeliculaPressed(event);
            }
        });

    }

    private void tituloPeliculaPressed(KeyEvent event) {
        if (event.getKeyCode() == event.VK_ENTER) {
            buscarPelicula();
        }
    }

    private void cargarTablaPeliculas() {
        List<Pelicula> peliculas = Pelicula.obtenerTodasLasPeliculas();

        if (peliculas != null) {
            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("Id");
            modelo.addColumn("Titulo");
            modelo.addColumn("Genero");
            modelo.addColumn("Clasificacion");
            modelo.addColumn("Duracion");
            modelo.addColumn("Audio original");
            modelo.addColumn("Subtitulos");

            for (Pelicula emp : peliculas) {
                modelo.addRow(new Object[]{
                    emp.getIdPelicula(),
                    emp.getTitulo(),
                    emp.getGenero(),
                    emp.getClasificacion(),
                    emp.getDuracion(),
                    emp.getIdioma(),
                    emp.getSubtitulos()
                });
            }

            gestorPeliculas.table_peliculas.setModel(modelo);

        } else {
            JOptionPane.showMessageDialog(null, "Error al cargar los datos de los empleados");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == gestorPeliculas.btn_buscar) {
            buscarPelicula();
        } else if (e.getSource() == gestorPeliculas.btn_actualizar) {
            cargarTablaPeliculas();
        } else if (e.getSource() == gestorPeliculas.btn_eliminar) {
            eliminarPelicula();
        }
    }

    private void buscarPelicula() {

        String titulo = gestorPeliculas.txt_tituloPelicula.getText().trim();
        if (titulo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese un titulo");
            return;
        }
        Pelicula peliculaEncontrada = Pelicula.buscarPelicula(titulo);
        if (peliculaEncontrada == null) {
            JOptionPane.showMessageDialog(null, "La pelicula no existe");
            return;
        }
        DefaultTableModel modelo = (DefaultTableModel) gestorPeliculas.table_peliculas.getModel();

        int filaEncontrada = -1;
        for (int i = 0; i < modelo.getRowCount(); i++) {
            String tituloPeliculaMarcado = (String) modelo.getValueAt(i, 1);
            if (tituloPeliculaMarcado.equalsIgnoreCase(peliculaEncontrada.getTitulo())) {
                filaEncontrada = i;
                break;
            }
        }

        if (filaEncontrada != -1) {
            gestorPeliculas.table_peliculas.setRowSelectionInterval(filaEncontrada, filaEncontrada);
            gestorPeliculas.table_peliculas.scrollRectToVisible(gestorPeliculas.table_peliculas.getCellRect(filaEncontrada, 0, true));
        } else {
            JOptionPane.showMessageDialog(null, "La pelicula existe en el sistema pero no esta disponible en la tabla.á");
        }
    }

    private void eliminarPelicula() {
        int filaSeleccionada = gestorPeliculas.table_peliculas.getSelectedRow();

        if (filaSeleccionada != -1) {

            Object valorId = gestorPeliculas.table_peliculas.getValueAt(filaSeleccionada, 1);
            String tituloPelicula = valorId.toString();

            Pelicula peliculaSeleccionada = Pelicula.buscarPelicula(tituloPelicula);

            if (peliculaSeleccionada != null) {

                int respuestaEliminacion = JOptionPane.showConfirmDialog(
                        null,
                        "¿Desea eliminar el titulo: \"" + peliculaSeleccionada.getTitulo() + "\"?",
                        "Confirmar eliminación",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE
                );

                if (respuestaEliminacion == JOptionPane.YES_OPTION) {
                    try {
                        Pelicula.borrarPelicula(peliculaSeleccionada);
                        cargarTablaPeliculas();
                    } catch (NonexistentEntityException e) {
                        System.out.println("Error al llamar al metodo para destruir la pelicula: " + e);
                    }

                    //JOptionPane.showMessageDialog(null, "Pelicula eliminada correctamente.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró la pelicula seleccionada.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una pelicula en la tabla.");
        }
    }
    
    private void cargarFuncionesYSala(int idPelicula){
        
       Pelicula pelicula = Pelicula.buscarPelicula(idPelicula);
       List<Funcion> funciones = pelicula.getFunciones();
       
       if (pelicula != null) {
            DefaultTableModel modeloFuncionesYSalas = new DefaultTableModel();
            
            modeloFuncionesYSalas.addColumn("Funciones");
            modeloFuncionesYSalas.addColumn("Sala");
            
            
            for (Funcion funcion : funciones) {
                modeloFuncionesYSalas.addRow(new Object[]{funcion.getHorario(), funcion.getSala().getNumero()});
            }
            gestorPeliculas.table_funcionesSalas.setModel(modeloFuncionesYSalas);
            gestorPeliculas.table_funcionesSalas.getColumnModel().getColumn(1).setPreferredWidth(25);
        }
        
    }
}

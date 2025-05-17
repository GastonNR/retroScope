package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import model.Clasificacion;
import model.Genero;
import model.Pelicula;
import view.Internal_agregarPelicula;

class Ctrl_Inter_agregarPelicula implements ActionListener {

    public Internal_agregarPelicula nuevaPelicula;

    public Ctrl_Inter_agregarPelicula() {

        this.nuevaPelicula = new Internal_agregarPelicula();
        nuevaPelicula.setVisible(true);

        nuevaPelicula.btn_agregarPelicula.addActionListener(this);
        
        nuevaPelicula.txt_titulo.addKeyListener(new java.awt.event.KeyAdapter(){
            public void keyPressed(java.awt.event.KeyEvent e){
                txtTituloKeyPressed(e);
            }
        });
        nuevaPelicula.combo_genero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent e){
                txtGeneroKeyPressed(e);
            }
        });
        nuevaPelicula.combo_clasificacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent e){
                txtClasificacionKeyPressed(e);
            }
        });
        nuevaPelicula.txt_duracion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent e){
                txtDuracionKeyPressed(e);
            }
        });
        nuevaPelicula.txt_idioma.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent e){
                txtIdiomaKeyPressed(e);
            }
        });
        nuevaPelicula.txt_subtitulos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent e){
                txtSubtitulosKeyPressed(e);
            } 
        });
        nuevaPelicula.combo_promocion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent e){
                txtPromocionKeyPressed(e);
            }
        });
    }
    
    private void txtTituloKeyPressed(java.awt.event.KeyEvent evt){
        if(evt.getKeyCode() == evt.VK_ENTER){
            nuevaPelicula.combo_genero.requestFocus();
        }
    }
    private void txtGeneroKeyPressed(java.awt.event.KeyEvent evt){
        if(evt.getKeyCode() == evt.VK_ENTER){
            nuevaPelicula.combo_clasificacion.requestFocus();
        }
    }
    private void txtClasificacionKeyPressed(java.awt.event.KeyEvent evt){
        if(evt.getKeyCode() == evt.VK_ENTER){
            nuevaPelicula.txt_duracion.requestFocus();
        }
    }
    private void txtDuracionKeyPressed(java.awt.event.KeyEvent evt){
        if(evt.getKeyCode() == evt.VK_ENTER){
            nuevaPelicula.txt_idioma.requestFocus();
        }
    }
    private void txtIdiomaKeyPressed(java.awt.event.KeyEvent evt){
        if(evt.getKeyCode() == evt.VK_ENTER){
            nuevaPelicula.txt_subtitulos.requestFocus();
        }
    }
    private void txtSubtitulosKeyPressed(java.awt.event.KeyEvent evt){
        if(evt.getKeyCode() == evt.VK_ENTER){
            nuevaPelicula.combo_promocion.requestFocus();
        }
    }
    private void txtPromocionKeyPressed(java.awt.event.KeyEvent evt){
        if(evt.getKeyCode() == evt.VK_ENTER){
           crearNuevaPelicula(); 
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == nuevaPelicula.btn_agregarPelicula) {
            
            crearNuevaPelicula();

        } else {

            JOptionPane.showMessageDialog(null, "Error al guardar los datos de la nueva pelicula.");

        }
    }

    private boolean verificarCampos() {

        Color fondoDeCampos = new Color(55, 21, 8);
        
        Pattern expRegDuracion = Pattern.compile("^-?\\d+$");
        Matcher duracionNumEntero = expRegDuracion.matcher(nuevaPelicula.txt_duracion.getText().trim());
        
        Pattern expRegIdioma = Pattern.compile("^[a-zA-Z]{2,3}$");
        Matcher idiomaAudioOriginal = expRegIdioma.matcher(nuevaPelicula.txt_idioma.getText().trim());
        Matcher idiomaSubtitulos = expRegIdioma.matcher(nuevaPelicula.txt_subtitulos.getText().trim());
        

        if (nuevaPelicula.txt_titulo == null || nuevaPelicula.txt_titulo.getText().trim().isEmpty()) {

            nuevaPelicula.txt_titulo.setBackground(Color.RED);
            JOptionPane.showMessageDialog(null, "campo titulo vacio");
            return false;

        } else {
            nuevaPelicula.txt_titulo.setBackground(fondoDeCampos);
        }

        if (nuevaPelicula.txt_duracion == null || nuevaPelicula.txt_duracion.getText().trim().isEmpty() || duracionNumEntero.matches() == false) {
            nuevaPelicula.txt_duracion.setBackground(Color.red);
            JOptionPane.showMessageDialog(null, "campo de duracion invalido");
            return false;
        } else {
            nuevaPelicula.txt_titulo.setBackground(fondoDeCampos);
        }

        if (nuevaPelicula.txt_idioma == null || nuevaPelicula.txt_idioma.getText().trim().isEmpty() || idiomaAudioOriginal.matches() == false) {
            nuevaPelicula.txt_idioma.setBackground(Color.red);
            JOptionPane.showMessageDialog(null, "campo de idioma vacio");
            return false;
        } else {
            nuevaPelicula.txt_titulo.setBackground(fondoDeCampos);
        }

        if (nuevaPelicula.txt_subtitulos == null || nuevaPelicula.txt_subtitulos.getText().trim().isEmpty() || idiomaSubtitulos.matches() == false) {
            nuevaPelicula.txt_subtitulos.setBackground(Color.red);
            JOptionPane.showMessageDialog(null, "campo de subtitulos vacio");
            return false;
        } else {
            nuevaPelicula.txt_titulo.setBackground(fondoDeCampos);
        }

        if (nuevaPelicula.combo_genero.getSelectedItem().equals("...")) {
            nuevaPelicula.combo_genero.setBackground(Color.red);
            JOptionPane.showMessageDialog(null, "Seleccione un genero.");
            return false;
        } else {
            nuevaPelicula.txt_titulo.setBackground(fondoDeCampos);
        }

        if (nuevaPelicula.combo_clasificacion.getSelectedItem().equals("...")) {
            nuevaPelicula.combo_clasificacion.setBackground(Color.red);
            JOptionPane.showMessageDialog(null, "Seleccione una clasificacion.");
            return false;
        } else {
            nuevaPelicula.txt_titulo.setBackground(fondoDeCampos);
        }

        return true;

    }
    
    private void crearNuevaPelicula(){
        
        if (verificarCampos()) {

            String titulo = nuevaPelicula.txt_titulo.getText().trim();
            Genero genero = Genero.valueOf(nuevaPelicula.combo_genero.getSelectedItem().toString());
            String minutos = nuevaPelicula.txt_duracion.getText().trim();
            Clasificacion clasificacion = Clasificacion.valueOf(nuevaPelicula.combo_clasificacion.getSelectedItem().toString());
            String idioma = nuevaPelicula.txt_idioma.getText().trim();
            String subtitulos = nuevaPelicula.txt_subtitulos.getText().trim();
            String promocion = nuevaPelicula.combo_promocion.getSelectedItem().toString();

            Pelicula pelicula = new Pelicula(titulo, genero, minutos, clasificacion, idioma, subtitulos);
            pelicula.guardarPelicula(pelicula);
            limpiarCampos();

        } else {

            JOptionPane.showMessageDialog(null, "Complete los campos correctamente.");

        }
    }
    
    private void limpiarCampos(){
        nuevaPelicula.txt_titulo.setText("");
        nuevaPelicula.combo_genero.setSelectedIndex(0);
        nuevaPelicula.combo_clasificacion.setSelectedIndex(0);
        nuevaPelicula.txt_duracion.setText("");
        nuevaPelicula.txt_idioma.setText("");
        nuevaPelicula.txt_subtitulos.setText("");
        nuevaPelicula.combo_promocion.setSelectedIndex(0);
    }

}

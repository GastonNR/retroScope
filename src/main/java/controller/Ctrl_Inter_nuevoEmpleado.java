package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import model.Empleado;
import view.Internal_nuevoEmpleado;
import model.Servicio;

public class Ctrl_Inter_nuevoEmpleado implements ActionListener {

    public Internal_nuevoEmpleado nuevoEmpleado;
    private Servicio serv;
    
    public Ctrl_Inter_nuevoEmpleado() {
        
        this.serv = new Servicio();
        this.nuevoEmpleado = new Internal_nuevoEmpleado();
        nuevoEmpleado.setVisible(true);

        nuevoEmpleado.btn_crearEmpleado.addActionListener(this);

        nuevoEmpleado.txt_nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent e) {
                txtNombreKeyPressed(e);
            }
        });
        nuevoEmpleado.txt_dni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent e) {
                txtDniKeyPressed(e);
            }
        });
        nuevoEmpleado.txt_correo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent e) {
                txtCorreotKeyPressed(e);
            }
        });
        nuevoEmpleado.txt_pass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent e) {
                txtPassKeyPressed(e);
            }
        });
        nuevoEmpleado.txt_passRep.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent e) {
                txtPassRepKeyPressed(e);
            }
        });
    }

    private void txtNombreKeyPressed(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == evt.VK_ENTER) {
            nuevoEmpleado.txt_dni.requestFocus();
        }
    }

    private void txtDniKeyPressed(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == evt.VK_ENTER) {
            nuevoEmpleado.txt_correo.requestFocus();
        }
    }

    private void txtCorreotKeyPressed(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == evt.VK_ENTER) {
            nuevoEmpleado.txt_pass.requestFocus();
        }
    }

    private void txtPassKeyPressed(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == evt.VK_ENTER) {
            nuevoEmpleado.txt_passRep.requestFocus();
        }
    }

    private void txtPassRepKeyPressed(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == evt.VK_ENTER) {
            crearEmpleado();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == nuevoEmpleado.btn_crearEmpleado) {
            crearEmpleado();
        } else {
            JOptionPane.showMessageDialog(null, "Error al guardar los datos del nuevo empleado.");
        }
    }

    private boolean verificarCampos() {

        Color fondoDeCampos = new Color(55, 21, 8);

        Pattern expRegNombre = Pattern.compile("^[A-ZÁÉÍÓÚÑÜ][a-záéíóúñü]+(?: [A-ZÁÉÍÓÚÑÜ][a-záéíóúñü]+)*$");
        Matcher nombreEmpleadoMatcher = expRegNombre.matcher(nuevoEmpleado.txt_nombre.getText().trim());

        Pattern expRegDni = Pattern.compile("^\\d{7,8}$");
        Matcher dniEmpleadoMatcher = expRegDni.matcher(nuevoEmpleado.txt_dni.getText().trim());

        Pattern expRegCorreo = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
        Matcher correoEmpleadoMatcher = expRegCorreo.matcher(nuevoEmpleado.txt_correo.getText().trim());

        if (nuevoEmpleado.txt_nombre == null || nuevoEmpleado.txt_nombre.getText().trim().isEmpty() || nombreEmpleadoMatcher.matches() == false) {

            nuevoEmpleado.txt_nombre.setBackground(Color.RED);
            JOptionPane.showMessageDialog(null, "campo nombre y apellido vacio");
            return false;

        } else {
            nuevoEmpleado.txt_nombre.setBackground(fondoDeCampos);
        }

        if (nuevoEmpleado.txt_dni == null || nuevoEmpleado.txt_dni.getText().trim().isEmpty() || dniEmpleadoMatcher.matches() == false) {
            nuevoEmpleado.txt_dni.setBackground(Color.red);
            JOptionPane.showMessageDialog(null, "campo numero de documento invalido");
            return false;
        } else {
            nuevoEmpleado.txt_dni.setBackground(fondoDeCampos);
        }

        if (nuevoEmpleado.txt_correo == null || nuevoEmpleado.txt_correo.getText().trim().isEmpty() || correoEmpleadoMatcher.matches() == false) {
            nuevoEmpleado.txt_correo.setBackground(Color.red);
            JOptionPane.showMessageDialog(null, "campo de correo electronico vacio");
            return false;
        } else {
            nuevoEmpleado.txt_correo.setBackground(fondoDeCampos);
        }

        if (nuevoEmpleado.txt_pass == null || nuevoEmpleado.txt_pass.getText().trim().isEmpty()) {
            nuevoEmpleado.txt_pass.setBackground(Color.red);
            JOptionPane.showMessageDialog(null, "campo de subtitulos vacio");
            return false;
        } else {
            nuevoEmpleado.txt_pass.setBackground(fondoDeCampos);
        }

        if (nuevoEmpleado.txt_passRep == null || nuevoEmpleado.txt_pass.getText().trim().isEmpty()) {
            nuevoEmpleado.txt_passRep.setBackground(Color.red);
            JOptionPane.showMessageDialog(null, "Seleccione un genero.");
            return false;
        } else {
            nuevoEmpleado.txt_passRep.setBackground(fondoDeCampos);
        }

        if (!nuevoEmpleado.txt_pass.getText().trim().equals(nuevoEmpleado.txt_passRep.getText().trim())) {
            nuevoEmpleado.txt_passRep.setBackground(Color.RED);
            JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden.");
            return false;
        } else {
            nuevoEmpleado.txt_passRep.setBackground(fondoDeCampos);
        }

        return true;

    }

    private void limpiarCampos() {
        nuevoEmpleado.txt_nombre.setText("");
        nuevoEmpleado.txt_dni.setText("");
        nuevoEmpleado.txt_correo.setText("");
        nuevoEmpleado.txt_pass.setText("");
        nuevoEmpleado.txt_passRep.setText("");
    }

    private void crearEmpleado() {
        if (verificarCampos()) {

            String nombre = nuevoEmpleado.txt_nombre.getText().trim();
            String dni = nuevoEmpleado.txt_dni.getText().trim();
            String correo = nuevoEmpleado.txt_correo.getText().trim();
            String password = nuevoEmpleado.txt_pass.getText().trim();

            Empleado empleado = new Empleado(nombre, dni, correo, password);
            serv.guardarEmpleado(empleado);
            limpiarCampos();

        }
    }

}

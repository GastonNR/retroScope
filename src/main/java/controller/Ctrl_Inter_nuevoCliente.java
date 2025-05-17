package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import model.Cliente;
import model.ClienteVip;
import model.Servicio;
import view.Internal_nuevoCliente;

class Ctrl_Inter_nuevoCliente implements ActionListener {
    
    public Internal_nuevoCliente nuevoCliente;
    private Servicio serv;
    
    public Ctrl_Inter_nuevoCliente() {
        
        this.nuevoCliente = new Internal_nuevoCliente();
        nuevoCliente.setVisible(true);
        
        nuevoCliente.btn_crearNuevoCliente.addActionListener(this);
        
        nuevoCliente.txt_nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent e) {
                txtNombrePressed(e);
            }
            
        });
        nuevoCliente.txt_correo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent e) {
                txtCorreoPressed(e);
            }
        });
        nuevoCliente.check_VIP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent e) {
                txtCheckVipPressed(e);
            }
        });
        
    }
    
    private void txtNombrePressed(java.awt.event.KeyEvent e) {
        if (e.getKeyCode() == e.VK_ENTER) {
            nuevoCliente.txt_correo.requestFocus();
        }
    }
    
    private void txtCorreoPressed(java.awt.event.KeyEvent e) {
        if (e.getKeyCode() == e.VK_ENTER) {
            nuevoCliente.check_VIP.requestFocus();
        }
    }
    
    private void txtCheckVipPressed(java.awt.event.KeyEvent e) {
        if (e.getKeyCode() == e.VK_ENTER) {
            crearNuevoCliente();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == nuevoCliente.btn_crearNuevoCliente) {
            
            crearNuevoCliente();
            
        }        
    }
    
    private void crearNuevoCliente() {
        if (validarDatos()) {
            
            String nombre = nuevoCliente.txt_nombre.getText().trim();
            String correo = nuevoCliente.txt_correo.getText().trim();
            
            if (nuevoCliente.check_VIP.isSelected()) {
                ClienteVip nuevoClienteVip = new ClienteVip(nombre, correo, 10);
                serv.guardarCliente(nuevoClienteVip);
            } else {
                Cliente nuevoCliente = new Cliente(nombre, correo);
                serv.crearCliente(nuevoCliente);
                
            }
            
            limpiarCampos();
        }
    }
    
    private boolean validarDatos() {
        
        Color fondoDeCampos = new Color(55, 21, 8);
        
        Pattern expRegNombre = Pattern.compile("^[A-ZÁÉÍÓÚÑÜ][a-záéíóúñü]+(?: [A-ZÁÉÍÓÚÑÜ][a-záéíóúñü]+)*$");
        Matcher nombreEmpleadoMatcher = expRegNombre.matcher(nuevoCliente.txt_nombre.getText().trim());
        
        Pattern expRegCorreo = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
        Matcher correoEmpleadoMatcher = expRegCorreo.matcher(nuevoCliente.txt_correo.getText().trim());
        
        if (nuevoCliente.txt_nombre == null || nuevoCliente.txt_nombre.getText().trim().isEmpty() || nombreEmpleadoMatcher.matches() == false) {
            
            nuevoCliente.txt_nombre.setBackground(Color.RED);
            JOptionPane.showMessageDialog(null, "campo nombre y apellido vacio");
            return false;
            
        } else {
            nuevoCliente.txt_nombre.setBackground(fondoDeCampos);
        }
        
        if (nuevoCliente.txt_correo == null || nuevoCliente.txt_correo.getText().trim().isEmpty() || correoEmpleadoMatcher.matches() == false) {
            nuevoCliente.txt_correo.setBackground(Color.red);
            JOptionPane.showMessageDialog(null, "campo de correo electronico vacio");
            return false;
        } else {
            nuevoCliente.txt_correo.setBackground(fondoDeCampos);
        }
        
        return true;
    }
    
    private void limpiarCampos() {
        nuevoCliente.txt_nombre.setText("");
        nuevoCliente.txt_correo.setText("");
        nuevoCliente.check_VIP.setSelected(false);
    }
}

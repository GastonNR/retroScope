package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import view.Login;

public class LoginControlador implements ActionListener {

    public Login vistaLogin;
    private ControladorEmpleado ctrl_empleado = new ControladorEmpleado();
    private ControladorMenu ctrl_home;

    public LoginControlador() {

        this.vistaLogin = new Login();
        this.ctrl_empleado = new ControladorEmpleado();

        vistaLogin.setVisible(true);

        vistaLogin.btnIngresoLogin.addActionListener(this);

        vistaLogin.txt_idEmpleado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_idEmpleadoKeyPressed(evt);
            }
        });

        vistaLogin.txtPassEmpleado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPassEmpleadoKeyPressed(evt);
            }
        });
    }

    private void txt_idEmpleadoKeyPressed(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == evt.VK_ENTER) {
            vistaLogin.txtPassEmpleado.requestFocus();
        }
    }

    private void txtPassEmpleadoKeyPressed(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == evt.VK_ENTER) {
            autenticarCliente();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaLogin.btnIngresoLogin) {
            autenticarCliente();
        }
    }

    private void autenticarCliente() {

        if (!vistaLogin.txt_idEmpleado.getText().isEmpty() && !vistaLogin.txtPassEmpleado.getText().isEmpty()) {

            int id = Integer.parseInt(vistaLogin.txt_idEmpleado.getText().trim());
            char[] caracteresClave = vistaLogin.txtPassEmpleado.getPassword();
            String claveEmpleado = new String(caracteresClave);

            if (ctrl_empleado.validarCredenciales(id, claveEmpleado)) {

                vistaLogin.dispose();
                this.ctrl_home = new ControladorMenu();

            } else {
                JOptionPane.showMessageDialog(null, "Usuario y clave incorrectos.");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Ingrese sus credenciales...");
        }

    }

}

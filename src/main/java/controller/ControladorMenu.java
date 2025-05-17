package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.Internal_realizarVenta;
import view.Internal_verVentas;
import view.Menu;
import static view.Menu.jDesktopPane_menu;

public class ControladorMenu implements ActionListener {

    private Menu vistaMenu;

    public ControladorMenu() {
        
        this.vistaMenu = new Menu();
        vistaMenu.setVisible(true);

        vistaMenu.jMenuItem_agregar_nueva_pelicula.addActionListener(this);
        vistaMenu.jMenuItem_buscarVenta.addActionListener(this);
        vistaMenu.jMenuItem_crearFuncion.addActionListener(this);
        vistaMenu.jMenuItem_gestionarCliente.addActionListener(this);
        vistaMenu.jMenuItem_gestionarEmpleado.addActionListener(this);
        vistaMenu.jMenuItem_gestionarFuncion.addActionListener(this);
        vistaMenu.jMenuItem_gestionarPelicula.addActionListener(this);
        vistaMenu.jMenuItem_nuevaVenta.addActionListener(this);
        vistaMenu.jMenuItem_nuevoCliente.addActionListener(this);
        vistaMenu.jMenuItem_nuevoEmpleado.addActionListener(this);
        vistaMenu.jMenuItem_salirSesion.addActionListener(this);
        vistaMenu.jMenuItem_verSalas.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vistaMenu.jMenuItem_nuevoEmpleado) {

            this.mostrarInterNuevoEmpleado();

        } else if (e.getSource() == vistaMenu.jMenuItem_gestionarEmpleado) {

            this.mostrarInterGestorEmpleados();

        } else if (e.getSource() == vistaMenu.jMenuItem_nuevoCliente) {

            this.mostrarInterNuevoCliente();

        } else if (e.getSource() == vistaMenu.jMenuItem_gestionarCliente) {

            this.mostrarInterGestorCliente();

        } else if (e.getSource() == vistaMenu.jMenuItem_crearFuncion) {
            
            this.mostrarInterCrearFuncion();

        } else if (e.getSource() == vistaMenu.jMenuItem_gestionarFuncion) {
            
            this.mostrarInterGestionarFunciones();

        } else if (e.getSource() == vistaMenu.jMenuItem_nuevaVenta) {
            
            this.mostrarInterNuevaVenta();
            
        } else if (e.getSource() == vistaMenu.jMenuItem_buscarVenta) {

            this.mostrarInterVerVentas();
            
        } else if (e.getSource() == vistaMenu.jMenuItem_verSalas) {

            this.mostrarInterVerSalas();

        } else if (e.getSource() == vistaMenu.jMenuItem_agregar_nueva_pelicula) {

            this.mostrarInterAgregarPelicula();

        } else if (e.getSource() == vistaMenu.jMenuItem_gestionarPelicula) {

            this.mostrarInterGestionarPeliculas();

        } else if (e.getSource() == vistaMenu.jMenuItem_salirSesion) {
            
            vistaMenu.dispose();
            LoginControlador ctrl_login = new LoginControlador();

        }
    }

    private void mostrarInterNuevoEmpleado() {
        
        Ctrl_Inter_nuevoEmpleado ctrl_nuevoEmpleado = new Ctrl_Inter_nuevoEmpleado();
        jDesktopPane_menu.add(ctrl_nuevoEmpleado.nuevoEmpleado);

    }

    private void mostrarInterGestorEmpleados() {

        Ctrl_Inter_gestorEmpleado ctrl_gestorEmpleado = new Ctrl_Inter_gestorEmpleado();
        jDesktopPane_menu.add(ctrl_gestorEmpleado.gestorEmpleado);


    }

    private void mostrarInterNuevoCliente() {
        
        Ctrl_Inter_nuevoCliente ctrl_nuevoCliente = new Ctrl_Inter_nuevoCliente();
        jDesktopPane_menu.add(ctrl_nuevoCliente.nuevoCliente);

    }

    private void mostrarInterGestorCliente() {
        
        Ctrl_Inter_gestorCliente ctrl_gestorCliente = new Ctrl_Inter_gestorCliente();
        jDesktopPane_menu.add(ctrl_gestorCliente.gestorClientes);

    }

    private void mostrarInterAgregarPelicula() {

        Ctrl_Inter_agregarPelicula ctrl_nuevaPelicula = new Ctrl_Inter_agregarPelicula();
        jDesktopPane_menu.add(ctrl_nuevaPelicula.nuevaPelicula);

    }

    private void mostrarInterGestionarPeliculas() {

        Ctrl_Inter_gestorPeliculas ctrl_gestorPelicula = new Ctrl_Inter_gestorPeliculas();
        jDesktopPane_menu.add(ctrl_gestorPelicula.gestorPeliculas);

    }

    private void mostrarInterVerSalas() {
        
        Ctrl_Inter_verSalas ctrl_verSalas = new Ctrl_Inter_verSalas();
        jDesktopPane_menu.add(ctrl_verSalas.verSalas);


    }

    private void mostrarInterCrearFuncion() {
        
        Ctrl_Inter_crearFuncion ctrl_crearFuncion = new Ctrl_Inter_crearFuncion();
        jDesktopPane_menu.add(ctrl_crearFuncion.crearFuncion);
        
    }

    private void mostrarInterGestionarFunciones() {
        
        Ctrl_Inter_gestorFunciones ctrl_gestorFunciones = new Ctrl_Inter_gestorFunciones();
        jDesktopPane_menu.add(ctrl_gestorFunciones.gestorFunciones);
        
    }

    private void mostrarInterNuevaVenta() {
        
        Ctrl_Inter_realizarVenta ctrl_realizarVenta = new Ctrl_Inter_realizarVenta();
        jDesktopPane_menu.add(ctrl_realizarVenta.realizarVenta);
        
    }

    private void mostrarInterVerVentas() {
        
        Ctrl_Inter_verVentas ctrl_verVentas = new Ctrl_Inter_verVentas();
        jDesktopPane_menu.add(ctrl_verVentas.verVentas);
        
    }
}

package view;

import java.awt.Dimension;
import javax.swing.JDesktopPane;

public class Menu extends javax.swing.JFrame {
    
    public static JDesktopPane jDesktopPane_menu;
    
    public Menu() {
        initComponents();
        this.setSize(new Dimension(1200,700));
        this.setExtendedState(this.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        this.setTitle("RETROSCOPE - MENU");
        this.setLayout(null);
        jDesktopPane_menu = new JDesktopPane();
        
        int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
        this.jDesktopPane_menu.setBounds(0, 0, ancho, (alto - 110));
        this.add(jDesktopPane_menu);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem_nuevoEmpleado = new javax.swing.JMenuItem();
        jMenuItem_gestionarEmpleado = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem_nuevoCliente = new javax.swing.JMenuItem();
        jMenuItem_gestionarCliente = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem_crearFuncion = new javax.swing.JMenuItem();
        jMenuItem_gestionarFuncion = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem_nuevaVenta = new javax.swing.JMenuItem();
        jMenuItem_buscarVenta = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem_verSalas = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem_agregar_nueva_pelicula = new javax.swing.JMenuItem();
        jMenuItem_gestionarPelicula = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem_salirSesion = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jMenuBar1.setBackground(new java.awt.Color(55, 21, 8));
        jMenuBar1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jMenuBar1.setForeground(new java.awt.Color(0, 0, 0));
        jMenuBar1.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N

        jMenu1.setForeground(new java.awt.Color(255, 255, 255));
        jMenu1.setIcon(new javax.swing.ImageIcon("/home/nico-ruiz/Escritorio/Recurso Imagenes del Sistema/usuario.png")); // NOI18N
        jMenu1.setText("Empleados");
        jMenu1.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        jMenu1.setPreferredSize(new java.awt.Dimension(150, 50));

        jMenuItem_nuevoEmpleado.setBackground(new java.awt.Color(20, 32, 49));
        jMenuItem_nuevoEmpleado.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        jMenuItem_nuevoEmpleado.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem_nuevoEmpleado.setText("Nuevo empleado");
        jMenuItem_nuevoEmpleado.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jMenuItem_nuevoEmpleado.setBorderPainted(false);
        jMenuItem_nuevoEmpleado.setPreferredSize(new java.awt.Dimension(200, 30));
        jMenu1.add(jMenuItem_nuevoEmpleado);

        jMenuItem_gestionarEmpleado.setBackground(new java.awt.Color(20, 32, 49));
        jMenuItem_gestionarEmpleado.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        jMenuItem_gestionarEmpleado.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem_gestionarEmpleado.setText("Gestionar Empleados");
        jMenuItem_gestionarEmpleado.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jMenuItem_gestionarEmpleado.setBorderPainted(false);
        jMenuItem_gestionarEmpleado.setPreferredSize(new java.awt.Dimension(200, 30));
        jMenu1.add(jMenuItem_gestionarEmpleado);

        jMenuBar1.add(jMenu1);

        jMenu2.setForeground(new java.awt.Color(255, 255, 255));
        jMenu2.setIcon(new javax.swing.ImageIcon("/home/nico-ruiz/Escritorio/Recurso Imagenes del Sistema/cliente.png")); // NOI18N
        jMenu2.setText("Clientes");
        jMenu2.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        jMenu2.setPreferredSize(new java.awt.Dimension(150, 50));

        jMenuItem_nuevoCliente.setBackground(new java.awt.Color(20, 32, 49));
        jMenuItem_nuevoCliente.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        jMenuItem_nuevoCliente.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem_nuevoCliente.setText("Nuevo Cliente");
        jMenuItem_nuevoCliente.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jMenuItem_nuevoCliente.setBorderPainted(false);
        jMenuItem_nuevoCliente.setPreferredSize(new java.awt.Dimension(170, 30));
        jMenu2.add(jMenuItem_nuevoCliente);

        jMenuItem_gestionarCliente.setBackground(new java.awt.Color(20, 32, 49));
        jMenuItem_gestionarCliente.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        jMenuItem_gestionarCliente.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem_gestionarCliente.setText("Gestionar Clientes");
        jMenuItem_gestionarCliente.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jMenuItem_gestionarCliente.setBorderPainted(false);
        jMenuItem_gestionarCliente.setPreferredSize(new java.awt.Dimension(170, 30));
        jMenu2.add(jMenuItem_gestionarCliente);

        jMenuBar1.add(jMenu2);

        jMenu3.setForeground(new java.awt.Color(255, 255, 255));
        jMenu3.setIcon(new javax.swing.ImageIcon("/home/nico-ruiz/Escritorio/imagenesProyectoCine/iconoSalaYFuncion.png")); // NOI18N
        jMenu3.setText("Funciones");
        jMenu3.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        jMenu3.setPreferredSize(new java.awt.Dimension(150, 50));

        jMenuItem_crearFuncion.setBackground(new java.awt.Color(20, 32, 49));
        jMenuItem_crearFuncion.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        jMenuItem_crearFuncion.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem_crearFuncion.setText("Crear funcion");
        jMenuItem_crearFuncion.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jMenuItem_crearFuncion.setBorderPainted(false);
        jMenuItem_crearFuncion.setPreferredSize(new java.awt.Dimension(170, 30));
        jMenu3.add(jMenuItem_crearFuncion);

        jMenuItem_gestionarFuncion.setBackground(new java.awt.Color(20, 32, 49));
        jMenuItem_gestionarFuncion.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        jMenuItem_gestionarFuncion.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem_gestionarFuncion.setText("Gestionar funciones");
        jMenuItem_gestionarFuncion.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jMenuItem_gestionarFuncion.setBorderPainted(false);
        jMenuItem_gestionarFuncion.setPreferredSize(new java.awt.Dimension(170, 30));
        jMenu3.add(jMenuItem_gestionarFuncion);

        jMenuBar1.add(jMenu3);

        jMenu4.setForeground(new java.awt.Color(255, 255, 255));
        jMenu4.setIcon(new javax.swing.ImageIcon("/home/nico-ruiz/Escritorio/Recurso Imagenes del Sistema/carrito.png")); // NOI18N
        jMenu4.setText("Ventas");
        jMenu4.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        jMenu4.setPreferredSize(new java.awt.Dimension(150, 50));

        jMenuItem_nuevaVenta.setBackground(new java.awt.Color(20, 32, 49));
        jMenuItem_nuevaVenta.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        jMenuItem_nuevaVenta.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem_nuevaVenta.setText("Nueva Venta");
        jMenuItem_nuevaVenta.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jMenuItem_nuevaVenta.setPreferredSize(new java.awt.Dimension(150, 30));
        jMenu4.add(jMenuItem_nuevaVenta);

        jMenuItem_buscarVenta.setBackground(new java.awt.Color(20, 32, 49));
        jMenuItem_buscarVenta.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        jMenuItem_buscarVenta.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem_buscarVenta.setText("Buscar venta");
        jMenuItem_buscarVenta.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jMenuItem_buscarVenta.setPreferredSize(new java.awt.Dimension(150, 30));
        jMenu4.add(jMenuItem_buscarVenta);

        jMenuBar1.add(jMenu4);

        jMenu5.setForeground(new java.awt.Color(255, 255, 255));
        jMenu5.setIcon(new javax.swing.ImageIcon("/home/nico-ruiz/Escritorio/imagenesProyectoCine/salas.png")); // NOI18N
        jMenu5.setText("Salas");
        jMenu5.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        jMenu5.setPreferredSize(new java.awt.Dimension(150, 50));

        jMenuItem_verSalas.setBackground(new java.awt.Color(20, 32, 49));
        jMenuItem_verSalas.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        jMenuItem_verSalas.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem_verSalas.setText("Ver salas");
        jMenuItem_verSalas.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jMenuItem_verSalas.setBorderPainted(false);
        jMenuItem_verSalas.setPreferredSize(new java.awt.Dimension(150, 30));
        jMenuItem_verSalas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_verSalasActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem_verSalas);

        jMenuBar1.add(jMenu5);

        jMenu6.setForeground(new java.awt.Color(255, 255, 255));
        jMenu6.setIcon(new javax.swing.ImageIcon("/home/nico-ruiz/Escritorio/imagenesProyectoCine/pelicula.png")); // NOI18N
        jMenu6.setText("Peliculas");
        jMenu6.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        jMenu6.setPreferredSize(new java.awt.Dimension(150, 50));

        jMenuItem_agregar_nueva_pelicula.setBackground(new java.awt.Color(20, 32, 49));
        jMenuItem_agregar_nueva_pelicula.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        jMenuItem_agregar_nueva_pelicula.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem_agregar_nueva_pelicula.setText("Agregar nueva pelicula");
        jMenuItem_agregar_nueva_pelicula.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jMenuItem_agregar_nueva_pelicula.setBorderPainted(false);
        jMenuItem_agregar_nueva_pelicula.setPreferredSize(new java.awt.Dimension(200, 30));
        jMenu6.add(jMenuItem_agregar_nueva_pelicula);

        jMenuItem_gestionarPelicula.setBackground(new java.awt.Color(20, 32, 49));
        jMenuItem_gestionarPelicula.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        jMenuItem_gestionarPelicula.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem_gestionarPelicula.setText("Gestionar Peliculas");
        jMenuItem_gestionarPelicula.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jMenuItem_gestionarPelicula.setBorderPainted(false);
        jMenuItem_gestionarPelicula.setPreferredSize(new java.awt.Dimension(200, 30));
        jMenu6.add(jMenuItem_gestionarPelicula);

        jMenuBar1.add(jMenu6);

        jMenu7.setForeground(new java.awt.Color(255, 255, 255));
        jMenu7.setIcon(new javax.swing.ImageIcon("/home/nico-ruiz/Escritorio/Recurso Imagenes del Sistema/cerrar-sesion.png")); // NOI18N
        jMenu7.setText("Cerrar Sesion");
        jMenu7.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        jMenu7.setPreferredSize(new java.awt.Dimension(150, 50));

        jMenuItem_salirSesion.setBackground(new java.awt.Color(20, 32, 49));
        jMenuItem_salirSesion.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        jMenuItem_salirSesion.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem_salirSesion.setIcon(new javax.swing.ImageIcon("/home/nico-ruiz/Escritorio/Recurso Imagenes del Sistema/cerrar-sesion.png")); // NOI18N
        jMenuItem_salirSesion.setText("Salir");
        jMenuItem_salirSesion.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jMenuItem_salirSesion.setBorderPainted(false);
        jMenuItem_salirSesion.setPreferredSize(new java.awt.Dimension(150, 30));
        jMenu7.add(jMenuItem_salirSesion);

        jMenuBar1.add(jMenu7);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem_verSalasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_verSalasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem_verSalasActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    public javax.swing.JMenuItem jMenuItem_agregar_nueva_pelicula;
    public javax.swing.JMenuItem jMenuItem_buscarVenta;
    public javax.swing.JMenuItem jMenuItem_crearFuncion;
    public javax.swing.JMenuItem jMenuItem_gestionarCliente;
    public javax.swing.JMenuItem jMenuItem_gestionarEmpleado;
    public javax.swing.JMenuItem jMenuItem_gestionarFuncion;
    public javax.swing.JMenuItem jMenuItem_gestionarPelicula;
    public javax.swing.JMenuItem jMenuItem_nuevaVenta;
    public javax.swing.JMenuItem jMenuItem_nuevoCliente;
    public javax.swing.JMenuItem jMenuItem_nuevoEmpleado;
    public javax.swing.JMenuItem jMenuItem_salirSesion;
    public javax.swing.JMenuItem jMenuItem_verSalas;
    // End of variables declaration//GEN-END:variables
}

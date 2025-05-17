package view;

public class Login extends javax.swing.JFrame {
    
    public Login() {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("SISTEMA DE GESTION DE CINE - RETROSCOPE");
        this.setSize(621, 603);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        txt_idEmpleado_login = new javax.swing.JPanel();
        txt_idEmpleado = new javax.swing.JTextField();
        btnIngresoLogin = new javax.swing.JButton();
        lblTituloIngreso = new javax.swing.JLabel();
        txtPassEmpleado = new javax.swing.JPasswordField();
        lbl_contrasenia = new javax.swing.JLabel();
        lbl_idEmpleado = new javax.swing.JLabel();
        lblImagenMarqueteriaCine = new javax.swing.JLabel();
        Header = new javax.swing.JPanel();
        lbl_tituloRetroScope = new javax.swing.JLabel();
        lbl_subtitulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("RetroScope");
        setResizable(false);

        background.setBackground(new java.awt.Color(17, 19, 13));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_idEmpleado_login.setBackground(new java.awt.Color(20, 32, 49));

        txt_idEmpleado.setBackground(new java.awt.Color(55, 21, 8));
        txt_idEmpleado.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        txt_idEmpleado.setForeground(new java.awt.Color(255, 255, 255));
        txt_idEmpleado.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        btnIngresoLogin.setBackground(new java.awt.Color(55, 21, 8));
        btnIngresoLogin.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        btnIngresoLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnIngresoLogin.setText("Entrar");

        lblTituloIngreso.setFont(new java.awt.Font("Roboto Light", 0, 24)); // NOI18N
        lblTituloIngreso.setForeground(new java.awt.Color(255, 255, 255));
        lblTituloIngreso.setText("Ingreso Empleado");

        txtPassEmpleado.setBackground(new java.awt.Color(55, 21, 8));
        txtPassEmpleado.setForeground(new java.awt.Color(255, 255, 255));

        lbl_contrasenia.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        lbl_contrasenia.setForeground(new java.awt.Color(204, 204, 204));
        lbl_contrasenia.setText("Contraseña");

        lbl_idEmpleado.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        lbl_idEmpleado.setForeground(new java.awt.Color(204, 204, 204));
        lbl_idEmpleado.setText("Numero Id del Empleado");

        javax.swing.GroupLayout txt_idEmpleado_loginLayout = new javax.swing.GroupLayout(txt_idEmpleado_login);
        txt_idEmpleado_login.setLayout(txt_idEmpleado_loginLayout);
        txt_idEmpleado_loginLayout.setHorizontalGroup(
            txt_idEmpleado_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(txt_idEmpleado_loginLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(txt_idEmpleado_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(txt_idEmpleado_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(txt_idEmpleado_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_idEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_idEmpleado))
                        .addGroup(txt_idEmpleado_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_contrasenia)
                            .addComponent(txtPassEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnIngresoLogin)))
                    .addComponent(lblTituloIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        txt_idEmpleado_loginLayout.setVerticalGroup(
            txt_idEmpleado_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(txt_idEmpleado_loginLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(lblTituloIngreso)
                .addGap(26, 26, 26)
                .addComponent(lbl_idEmpleado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_idEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(lbl_contrasenia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPassEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(btnIngresoLogin)
                .addGap(55, 55, 55))
        );

        background.add(txt_idEmpleado_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, -1, -1));

        lblImagenMarqueteriaCine.setIcon(new javax.swing.ImageIcon("/home/nico-ruiz/Escritorio/imagenesProyectoCine/1d061ca755b7cf87ef246eef8749862c.png")); // NOI18N
        background.add(lblImagenMarqueteriaCine, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, 270, 560));

        Header.setBackground(new java.awt.Color(55, 21, 8));

        lbl_tituloRetroScope.setFont(new java.awt.Font("Roboto Light", 0, 36)); // NOI18N
        lbl_tituloRetroScope.setForeground(new java.awt.Color(204, 204, 204));
        lbl_tituloRetroScope.setText("RetroScope");

        lbl_subtitulo.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        lbl_subtitulo.setForeground(new java.awt.Color(204, 204, 204));
        lbl_subtitulo.setText("Sistema para cadena de cines");

        javax.swing.GroupLayout HeaderLayout = new javax.swing.GroupLayout(Header);
        Header.setLayout(HeaderLayout);
        HeaderLayout.setHorizontalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_subtitulo)
                    .addComponent(lbl_tituloRetroScope))
                .addContainerGap(413, Short.MAX_VALUE))
        );
        HeaderLayout.setVerticalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lbl_tituloRetroScope, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_subtitulo)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        background.add(Header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, 621, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, 603, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Header;
    private javax.swing.JPanel background;
    public javax.swing.JButton btnIngresoLogin;
    private javax.swing.JLabel lblImagenMarqueteriaCine;
    private javax.swing.JLabel lblTituloIngreso;
    private javax.swing.JLabel lbl_contrasenia;
    private javax.swing.JLabel lbl_idEmpleado;
    private javax.swing.JLabel lbl_subtitulo;
    private javax.swing.JLabel lbl_tituloRetroScope;
    public javax.swing.JPasswordField txtPassEmpleado;
    public javax.swing.JTextField txt_idEmpleado;
    private javax.swing.JPanel txt_idEmpleado_login;
    // End of variables declaration//GEN-END:variables

}

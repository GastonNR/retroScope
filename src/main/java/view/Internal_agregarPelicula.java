package view;

public class Internal_agregarPelicula extends javax.swing.JInternalFrame {

   
    public Internal_agregarPelicula() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        lbl_titulo = new javax.swing.JLabel();
        lbl_genero = new javax.swing.JLabel();
        txt_duracion = new javax.swing.JTextField();
        lbl_promocion = new javax.swing.JLabel();
        btn_agregarPelicula = new javax.swing.JButton();
        combo_promocion = new javax.swing.JComboBox<>();
        combo_genero = new javax.swing.JComboBox<>();
        combo_clasificacion = new javax.swing.JComboBox<>();
        lbl_duracion = new javax.swing.JLabel();
        txt_subtitulos = new javax.swing.JTextField();
        lbl_idioma = new javax.swing.JLabel();
        lbl_subtitulos = new javax.swing.JLabel();
        txt_idioma = new javax.swing.JTextField();
        txt_titulo = new javax.swing.JTextField();
        lbl_clasificaion1 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Nueva Pelicula");

        jPanel2.setBackground(new java.awt.Color(20, 32, 49));
        jPanel2.setPreferredSize(new java.awt.Dimension(500, 250));

        lbl_titulo.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        lbl_titulo.setForeground(new java.awt.Color(255, 255, 255));
        lbl_titulo.setText("Titulo del largometrage:");

        lbl_genero.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        lbl_genero.setForeground(new java.awt.Color(255, 255, 255));
        lbl_genero.setText("Genero:");

        txt_duracion.setBackground(new java.awt.Color(55, 21, 8));
        txt_duracion.setForeground(new java.awt.Color(255, 255, 255));
        txt_duracion.setPreferredSize(new java.awt.Dimension(200, 30));

        lbl_promocion.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        lbl_promocion.setForeground(new java.awt.Color(255, 255, 255));
        lbl_promocion.setText("Promocion:");

        btn_agregarPelicula.setBackground(new java.awt.Color(55, 21, 8));
        btn_agregarPelicula.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        btn_agregarPelicula.setForeground(new java.awt.Color(255, 255, 255));
        btn_agregarPelicula.setText("Agregar Pelicula");

        combo_promocion.setBackground(new java.awt.Color(55, 21, 8));
        combo_promocion.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        combo_promocion.setForeground(new java.awt.Color(255, 255, 255));
        combo_promocion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ninguna", "5%", "10%", "15%", "20%", "25%" }));

        combo_genero.setBackground(new java.awt.Color(55, 21, 8));
        combo_genero.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        combo_genero.setForeground(new java.awt.Color(255, 255, 255));
        combo_genero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "...", "ACCION", "AVENTURAS", "COMEDIA", "CIENCIA_FICCION", "FANTASIA", "DRAMA", "TERROR", "SUSPENSO", "MUSICAL", "ROMANCE", "FUTURISTA", "RELIGIOSAS", "CRIMEN", "POLICIACAS", "HISTORICAS", "OTRO..." }));

        combo_clasificacion.setBackground(new java.awt.Color(55, 21, 8));
        combo_clasificacion.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        combo_clasificacion.setForeground(new java.awt.Color(255, 255, 255));
        combo_clasificacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "...", "ATP", "SAM13", "SAM16", "TP", "7", "12", "16", "18", " " }));

        lbl_duracion.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        lbl_duracion.setForeground(new java.awt.Color(255, 255, 255));
        lbl_duracion.setText("Duracion:");

        txt_subtitulos.setBackground(new java.awt.Color(55, 21, 8));
        txt_subtitulos.setForeground(new java.awt.Color(255, 255, 255));
        txt_subtitulos.setPreferredSize(new java.awt.Dimension(200, 30));

        lbl_idioma.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        lbl_idioma.setForeground(new java.awt.Color(255, 255, 255));
        lbl_idioma.setText("Idioma:");

        lbl_subtitulos.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        lbl_subtitulos.setForeground(new java.awt.Color(255, 255, 255));
        lbl_subtitulos.setText("Subtitulos:");

        txt_idioma.setBackground(new java.awt.Color(55, 21, 8));
        txt_idioma.setForeground(new java.awt.Color(255, 255, 255));
        txt_idioma.setPreferredSize(new java.awt.Dimension(200, 30));

        txt_titulo.setBackground(new java.awt.Color(55, 21, 8));
        txt_titulo.setForeground(new java.awt.Color(255, 255, 255));
        txt_titulo.setPreferredSize(new java.awt.Dimension(200, 30));

        lbl_clasificaion1.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        lbl_clasificaion1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_clasificaion1.setText("Clasificacion:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl_genero)
                            .addComponent(lbl_titulo)
                            .addComponent(lbl_clasificaion1)
                            .addComponent(lbl_duracion)
                            .addComponent(lbl_idioma)
                            .addComponent(lbl_subtitulos)
                            .addComponent(lbl_promocion))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(combo_genero, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(combo_clasificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_duracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_idioma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_subtitulos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(combo_promocion, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(btn_agregarPelicula, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_titulo)
                    .addComponent(txt_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combo_genero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_genero))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combo_clasificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_clasificaion1))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_duracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_duracion))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_idioma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_idioma))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_subtitulos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_subtitulos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combo_promocion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_promocion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 138, Short.MAX_VALUE)
                .addComponent(btn_agregarPelicula)
                .addGap(84, 84, 84))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 458, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 614, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_agregarPelicula;
    public javax.swing.JComboBox<String> combo_clasificacion;
    public javax.swing.JComboBox<String> combo_genero;
    public javax.swing.JComboBox<String> combo_promocion;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbl_clasificaion1;
    private javax.swing.JLabel lbl_duracion;
    private javax.swing.JLabel lbl_genero;
    private javax.swing.JLabel lbl_idioma;
    private javax.swing.JLabel lbl_promocion;
    private javax.swing.JLabel lbl_subtitulos;
    private javax.swing.JLabel lbl_titulo;
    public javax.swing.JTextField txt_duracion;
    public javax.swing.JTextField txt_idioma;
    public javax.swing.JTextField txt_subtitulos;
    public javax.swing.JTextField txt_titulo;
    // End of variables declaration//GEN-END:variables
}

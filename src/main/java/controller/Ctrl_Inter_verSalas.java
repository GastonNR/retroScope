package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Sala;
import view.Internal_verSalas;
import model.Servicio;

public class Ctrl_Inter_verSalas implements ActionListener {

    public Internal_verSalas verSalas;
    private Servicio serv;
    
    public Ctrl_Inter_verSalas() {
        
        this.serv = new Servicio();
        this.verSalas = new Internal_verSalas();
        verSalas.setVisible(true);
        cargarTablaSalas();

        verSalas.btn_actualizar.addActionListener(this);

    }

    private void cargarTablaSalas() {
        List<Sala> salas = serv.obtenerTodasLasSalas();

        if (salas != null) {
            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("N° de Sala");
            modelo.addColumn("Tipo");
            modelo.addColumn("Precio");
            modelo.addColumn("Beneficios");

            for (Sala emp : salas) {

                if (emp.getTipo() == "VIP") {
                    modelo.addRow(new Object[]{emp.getNumero(), emp.getTipo(), emp.getPrecio(), "Asientos reclinables, servicio a la carta"});
                } else {
                    modelo.addRow(new Object[]{emp.getNumero(), emp.getTipo(), emp.getPrecio(), "Asientos estandar"});
                }
            }
            verSalas.table_salas.setModel(modelo);

        } else {
            JOptionPane.showMessageDialog(null, "Error al cargar los datos de las Salas");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == verSalas.btn_actualizar) {
            cargarTablaSalas();
        }
    }

}

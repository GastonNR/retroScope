package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.awt.event.KeyEvent.VK_ENTER;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import model.Cliente;
import model.Entrada;
import model.Funcion;
import model.Pago;
import model.TipoPago;
import model.Venta;
import view.Internal_realizarVenta;
import model.Servicio;


public class Ctrl_Inter_realizarVenta implements ActionListener{

    public Internal_realizarVenta realizarVenta = new Internal_realizarVenta();
    private Servicio serv;

    public Ctrl_Inter_realizarVenta() {
        
        this.serv = new Servicio();
        this.realizarVenta.setVisible(true);
        
        realizarVenta.btn_calcularPrecio.addActionListener(this);
        realizarVenta.btn_confirmar.addActionListener(this);
        realizarVenta.txt_idCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent event){
                idClientePressed(event);
            }
        });
        realizarVenta.txt_idEntrada.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent event){
                idEntradaPressed(event);
            }
        });
        realizarVenta.txt_idFuncion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent event){
                idFuncionPressed(event);
            }
        });
    }
    
    private void idClientePressed(java.awt.event.KeyEvent event){
        if(event.getKeyCode() == VK_ENTER){
            realizarVenta.txt_idEntrada.requestFocus();
        }
    }
    private void idEntradaPressed(java.awt.event.KeyEvent event){
        if(event.getKeyCode() == VK_ENTER){
            realizarVenta.txt_idFuncion.requestFocus();
        }
    }
    private void idFuncionPressed(java.awt.event.KeyEvent event){
        if(event.getKeyCode() == VK_ENTER){
            realizarVenta.combo_pago.requestFocus();
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == realizarVenta.btn_confirmar){
            guardarVenta();
        } else if(e.getSource() == realizarVenta.btn_calcularPrecio){
            calcularPrecio();
        }
    }

    private void guardarVenta() {
        if(validarDatos()){
            int idCliente = (int) realizarVenta.txt_idCliente.getValue();
            int idEntrada = (int) realizarVenta.txt_idEntrada.getValue();
            int idFuncion = (int) realizarVenta.txt_idFuncion.getValue();
            
            Cliente cliente = serv.buscarCliente(idCliente);
            Entrada entrada = serv.buscarEntrada(idEntrada);
            Funcion funcion = serv.buscarFuncion(idFuncion);
            Date FechaVenta = new Date();
            
            float precio = (float) serv.buscarFuncion(idFuncion).getSala().getPrecio();
            TipoPago tipoPago = Enum.valueOf(TipoPago.class, realizarVenta.combo_pago.getSelectedItem().toString());
            Pago pago = new Pago(precio, tipoPago);
            Venta venta = new Venta(cliente, pago, funcion, FechaVenta);
            
            serv.guardarVenta(venta);
            serv.venderEntrada(idEntrada);
            JOptionPane.showMessageDialog(null, "La venta ha sido guardada con exito.");
            
        } else {
            System.out.println("No se puede guardar la venta desde Ctrl_Inter_realizarVenta.");
        }
    }

    private boolean validarDatos() {
        
        Color fondoDeCampos = new Color(55, 21, 8);
        
        Pattern expRegId = Pattern.compile("^\\d+$");
        Matcher idClienteMatcher = expRegId.matcher((CharSequence) realizarVenta.txt_idCliente.getValue().toString());
        Matcher idEntradaMatcher = expRegId.matcher((CharSequence) realizarVenta.txt_idEntrada.getValue().toString());
        Matcher idFuncionMatcher = expRegId.matcher((CharSequence) realizarVenta.txt_idFuncion.getValue().toString());
        
        if(
            !idClienteMatcher.matches()
            || serv.buscarCliente((int) realizarVenta.txt_idCliente.getValue()) == null
            ){
            realizarVenta.txt_idCliente.setBackground(Color.RED);
            JOptionPane.showMessageDialog(null, "Ingrese el id del cliente.");
            return false;
        }
        if(
            !idEntradaMatcher.matches()
            || serv.buscarEntrada((int)realizarVenta.txt_idEntrada.getValue()) == null
            ){
            realizarVenta.txt_idEntrada.setBackground(Color.RED);
            JOptionPane.showMessageDialog(null, "Ingrese el identificador de la entrada");
            return false;
        }
        if(
            !idFuncionMatcher.matches()
            || serv.buscarFuncion((int)realizarVenta.txt_idFuncion.getValue()) == null
            ){
            realizarVenta.txt_idFuncion.setBackground(Color.RED);
            JOptionPane.showMessageDialog(null, "Ingrese el identificador de la funcion");
            return false;
        }
        return true;
    }

    private void calcularPrecio() {
       if(validarDatos()){
           int idEntrada = (int) realizarVenta.txt_idEntrada.getValue();
           Entrada entrada = serv.buscarEntrada(idEntrada);
           double precio = entrada.getPrecio();
           double interes = 0;
           
           switch(realizarVenta.combo_pago.getSelectedItem().toString()){
               case "EFECTIVO":
                   interes = 0;
                break;
               case "TARJETA_DE_CREDITO":
                   interes = 0.5;
                break;
               case "TARJETA_DE_DEBITO":
                   interes = 0.3;
                break;
               case "TRANSFERENCIA":
                    interes = 0.1;
                break;
               case "BILLETERA_VIRTUAL":
                   interes = 0.4;
                break;
               default:
                   interes = 0;
                break;   
           }
           
           double precioTotal = precio + (precio * interes);
           realizarVenta.txt_precio.setText("TOTAL: " + precioTotal);
       } 
    }
    
}

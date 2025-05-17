package model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.swing.JOptionPane;
import persistencia.ClienteVipJpaController;

@Entity
public class ClienteVip extends Cliente {

    @Basic
    protected float descuento;

    public ClienteVip() {
    }
    

    public ClienteVip(float descuento) {
        this.descuento = descuento;
    }

    public ClienteVip(String nombre, String correo, float descuento) {
        super(nombre, correo); 
        this.descuento = descuento;
    }


    public float getDescuento() {
        return descuento;
    }

    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }

    @Override
    public String toString() {
        return "ClienteVip{"
                + "descuento=" + descuento
                + '}';
    }
    
    public static void guardarCliente(ClienteVip cliente){
        ClienteVipJpaController ctr_jpa_cliente = new ClienteVipJpaController();
        
        try{
            
            ctr_jpa_cliente.create(cliente);
            JOptionPane.showMessageDialog(null, "Cliente guardado con exito");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al guardar el nuevo cliente.");
        }
    }
}

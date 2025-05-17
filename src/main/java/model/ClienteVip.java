package model;

import javax.persistence.Basic;
import javax.persistence.Entity;

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

}

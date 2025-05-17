package model;

import javax.persistence.Entity;
import javax.persistence.Basic;

@Entity
public class SalaVip extends Sala{
    @Basic
    protected String beneficios;

    public SalaVip() {
    }

    public SalaVip(int numero, double precio, String beneficios) {
        super(numero, precio);
        this.beneficios = beneficios;
    }

    public String getBeneficios() {
        return beneficios;
    }

    public void setBeneficios(String beneficios) {
        this.beneficios = beneficios;
    }
}

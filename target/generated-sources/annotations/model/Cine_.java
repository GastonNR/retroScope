package model;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Compra;
import model.Empleado;
import model.Pelicula;
import model.Sala;
import model.SalaVip;
import model.Venta;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2025-05-16T23:56:21", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Cine.class)
public class Cine_ { 

    public static volatile ListAttribute<Cine, Sala> salas;
    public static volatile ListAttribute<Cine, Compra> compras;
    public static volatile ListAttribute<Cine, Pelicula> peliculas;
    public static volatile ListAttribute<Cine, SalaVip> salaVips;
    public static volatile SingularAttribute<Cine, String> direccion;
    public static volatile ListAttribute<Cine, Venta> ventas;
    public static volatile ListAttribute<Cine, Empleado> empleados;
    public static volatile SingularAttribute<Cine, Integer> id;
    public static volatile SingularAttribute<Cine, String> nombre;

}
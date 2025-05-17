package model;

import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Entrada;
import model.Pelicula;
import model.Sala;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2025-05-16T23:56:21", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Funcion.class)
public class Funcion_ { 

    public static volatile SingularAttribute<Funcion, Pelicula> pelicula;
    public static volatile SingularAttribute<Funcion, Date> horario;
    public static volatile ListAttribute<Funcion, Entrada> entradas;
    public static volatile SingularAttribute<Funcion, Sala> sala;
    public static volatile SingularAttribute<Funcion, Integer> id;

}
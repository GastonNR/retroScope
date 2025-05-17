package model;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Funcion;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2025-05-16T23:56:21", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Sala.class)
public class Sala_ { 

    public static volatile SingularAttribute<Sala, Double> precio;
    public static volatile SingularAttribute<Sala, String> tipo;
    public static volatile SingularAttribute<Sala, Integer> numero;
    public static volatile ListAttribute<Sala, Funcion> funciones;

}
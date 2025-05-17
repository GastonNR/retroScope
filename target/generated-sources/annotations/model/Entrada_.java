package model;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Funcion;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2025-05-17T11:01:01", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Entrada.class)
public class Entrada_ { 

    public static volatile SingularAttribute<Entrada, Double> precio;
    public static volatile SingularAttribute<Entrada, Boolean> vendida;
    public static volatile SingularAttribute<Entrada, Integer> id;
    public static volatile SingularAttribute<Entrada, String> asiento;
    public static volatile SingularAttribute<Entrada, Funcion> funcion;

}
package model;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.TipoPago;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2025-05-17T11:01:01", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Pago.class)
public class Pago_ { 

    public static volatile SingularAttribute<Pago, TipoPago> tipo;
    public static volatile SingularAttribute<Pago, Float> monto;
    public static volatile SingularAttribute<Pago, Integer> id;

}
package model;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Clasificacion;
import model.Funcion;
import model.Genero;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2025-05-17T11:01:01", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Pelicula.class)
public class Pelicula_ { 

    public static volatile ListAttribute<Pelicula, Funcion> funciones;
    public static volatile SingularAttribute<Pelicula, Genero> genero;
    public static volatile SingularAttribute<Pelicula, String> titulo;
    public static volatile SingularAttribute<Pelicula, String> duracion;
    public static volatile SingularAttribute<Pelicula, String> idioma;
    public static volatile SingularAttribute<Pelicula, String> subtitulos;
    public static volatile SingularAttribute<Pelicula, Integer> idPelicula;
    public static volatile SingularAttribute<Pelicula, Clasificacion> clasificacion;

}
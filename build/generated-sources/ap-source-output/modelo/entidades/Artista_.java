package modelo.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.entidades.Album;
import modelo.entidades.Musica;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2020-07-10T18:48:13")
@StaticMetamodel(Artista.class)
public class Artista_ { 

    public static volatile ListAttribute<Artista, Musica> musicaList;
    public static volatile ListAttribute<Artista, Album> albumList;
    public static volatile SingularAttribute<Artista, Integer> id;
    public static volatile SingularAttribute<Artista, String> nombre;

}
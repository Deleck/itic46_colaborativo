package modelo.entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.entidades.Artista;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2020-07-10T18:48:13")
@StaticMetamodel(Album.class)
public class Album_ { 

    public static volatile SingularAttribute<Album, String> titulo;
    public static volatile SingularAttribute<Album, Integer> id;
    public static volatile SingularAttribute<Album, Artista> artistaid;
    public static volatile SingularAttribute<Album, Date> año;

}
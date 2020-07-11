package modelo.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.entidades.Artista;
import modelo.entidades.Perfil;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2020-07-10T18:48:13")
@StaticMetamodel(Musica.class)
public class Musica_ { 

    public static volatile SingularAttribute<Musica, Short> estatus;
    public static volatile SingularAttribute<Musica, String> musica;
    public static volatile SingularAttribute<Musica, Integer> id;
    public static volatile ListAttribute<Musica, Artista> artistaList;
    public static volatile ListAttribute<Musica, Perfil> perfilList;

}
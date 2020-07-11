package modelo.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.entidades.Musica;
import modelo.entidades.Ocupacion;
import modelo.entidades.Tecnologia;
import modelo.entidades.Usuario;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2020-07-10T18:48:13")
@StaticMetamodel(Perfil.class)
public class Perfil_ { 

    public static volatile SingularAttribute<Perfil, Ocupacion> ocupacionId;
    public static volatile SingularAttribute<Perfil, String> password;
    public static volatile ListAttribute<Perfil, Musica> musicaList;
    public static volatile SingularAttribute<Perfil, String> genero;
    public static volatile SingularAttribute<Perfil, Integer> id;
    public static volatile ListAttribute<Perfil, Tecnologia> tecnologiaList;
    public static volatile SingularAttribute<Perfil, String> comentarios;
    public static volatile SingularAttribute<Perfil, Usuario> usuarioId;

}
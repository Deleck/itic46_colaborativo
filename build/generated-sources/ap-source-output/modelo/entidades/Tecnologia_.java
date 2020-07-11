package modelo.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.entidades.Perfil;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2020-07-10T18:48:13")
@StaticMetamodel(Tecnologia.class)
public class Tecnologia_ { 

    public static volatile SingularAttribute<Tecnologia, String> tecnologia;
    public static volatile SingularAttribute<Tecnologia, Short> estatus;
    public static volatile SingularAttribute<Tecnologia, Integer> id;
    public static volatile ListAttribute<Tecnologia, Perfil> perfilList;

}
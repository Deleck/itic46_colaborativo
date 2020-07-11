package modelo.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.entidades.Perfil;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2020-07-10T18:48:13")
@StaticMetamodel(Ocupacion.class)
public class Ocupacion_ { 

    public static volatile SingularAttribute<Ocupacion, Short> estatus;
    public static volatile SingularAttribute<Ocupacion, String> ocupacion;
    public static volatile SingularAttribute<Ocupacion, Integer> id;
    public static volatile ListAttribute<Ocupacion, Perfil> perfilList;

}
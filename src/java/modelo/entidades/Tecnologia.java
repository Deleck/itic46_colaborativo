/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author alberto
 */
@Entity
@Table(name = "tecnologia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tecnologia.findAll", query = "SELECT t FROM Tecnologia t")
    , @NamedQuery(name = "Tecnologia.findById", query = "SELECT t FROM Tecnologia t WHERE t.id = :id")
    , @NamedQuery(name = "Tecnologia.findByTecnologia", query = "SELECT t FROM Tecnologia t WHERE t.tecnologia = :tecnologia")
    , @NamedQuery(name = "Tecnologia.findByEstatus", query = "SELECT t FROM Tecnologia t WHERE t.estatus = :estatus")})
public class Tecnologia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "tecnologia")
    private String tecnologia;
    @Column(name = "estatus")
    private Short estatus;
    @ManyToMany(mappedBy = "tecnologiaList")
    private List<Perfil> perfilList;

    public Tecnologia() {
    }

    public Tecnologia(Integer id) {
        this.id = id;
    }

    public Tecnologia(Integer id, String tecnologia) {
        this.id = id;
        this.tecnologia = tecnologia;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTecnologia() {
        return tecnologia;
    }

    public void setTecnologia(String tecnologia) {
        this.tecnologia = tecnologia;
    }

    public Short getEstatus() {
        return estatus;
    }

    public void setEstatus(Short estatus) {
        this.estatus = estatus;
    }

    @XmlTransient
    public List<Perfil> getPerfilList() {
        return perfilList;
    }

    public void setPerfilList(List<Perfil> perfilList) {
        this.perfilList = perfilList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tecnologia)) {
            return false;
        }
        Tecnologia other = (Tecnologia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidades.Tecnologia[ id=" + id + " ]";
    }
    
}

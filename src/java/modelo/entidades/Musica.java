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
@Table(name = "musica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Musica.findAll", query = "SELECT m FROM Musica m")
    , @NamedQuery(name = "Musica.findById", query = "SELECT m FROM Musica m WHERE m.id = :id")
    , @NamedQuery(name = "Musica.findByMusica", query = "SELECT m FROM Musica m WHERE m.musica = :musica")
    , @NamedQuery(name = "Musica.findByEstatus", query = "SELECT m FROM Musica m WHERE m.estatus = :estatus")})
public class Musica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "musica")
    private String musica;
    @Column(name = "estatus")
    private Short estatus;
    @ManyToMany(mappedBy = "musicaList")
    private List<Artista> artistaList;
//    @JoinTable(name = "musica_favorita", joinColumns = {
//        @JoinColumn(name = "musica_id", referencedColumnName = "id")}, inverseJoinColumns = {
//        @JoinColumn(name = "perfil_id", referencedColumnName = "id")})
//    @ManyToMany
    @ManyToMany(mappedBy = "musicaList")
    private List<Perfil> perfilList;

    public Musica() {
    }

    public Musica(Integer id) {
        this.id = id;
    }

    public Musica(Integer id, String musica) {
        this.id = id;
        this.musica = musica;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMusica() {
        return musica;
    }

    public void setMusica(String musica) {
        this.musica = musica;
    }

    public Short getEstatus() {
        return estatus;
    }

    public void setEstatus(Short estatus) {
        this.estatus = estatus;
    }

    @XmlTransient
    public List<Artista> getArtistaList() {
        return artistaList;
    }

    public void setArtistaList(List<Artista> artistaList) {
        this.artistaList = artistaList;
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
        if (!(object instanceof Musica)) {
            return false;
        }
        Musica other = (Musica) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidades.Musica[ id=" + id + " ]";
    }
    
}

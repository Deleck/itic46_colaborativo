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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "perfil")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Perfil.findAll", query = "SELECT p FROM Perfil p")
    , @NamedQuery(name = "Perfil.findById", query = "SELECT p FROM Perfil p WHERE p.id = :id")
    , @NamedQuery(name = "Perfil.findByPassword", query = "SELECT p FROM Perfil p WHERE p.password = :password")
    , @NamedQuery(name = "Perfil.findByGenero", query = "SELECT p FROM Perfil p WHERE p.genero = :genero")
    , @NamedQuery(name = "Perfil.findByComentarios", query = "SELECT p FROM Perfil p WHERE p.comentarios = :comentarios")})
public class Perfil implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @Column(name = "genero")
    private String genero;
    @Column(name = "comentarios")
    private String comentarios;
    @JoinTable(name = "tecnologia_internet", joinColumns = {
        @JoinColumn(name = "perfil_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "tecnologia_id", referencedColumnName = "id")})
    @ManyToMany
    private List<Tecnologia> tecnologiaList;
    //@ManyToMany(mappedBy = "perfilList")
    @JoinTable(name = "musica_favorita", joinColumns = {
        @JoinColumn(name = "perfil_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "musica_id", referencedColumnName = "id")})
    @ManyToMany
    private List<Musica> musicaList;
    @JoinColumn(name = "ocupacion_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Ocupacion ocupacionId;
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuario usuarioId;

    public Perfil() {
    }

    public Perfil(Integer id) {
        this.id = id;
    }

    public Perfil(Integer id, String password) {
        this.id = id;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    @XmlTransient
    public List<Tecnologia> getTecnologiaList() {
        return tecnologiaList;
    }

    public void setTecnologiaList(List<Tecnologia> tecnologiaList) {
        this.tecnologiaList = tecnologiaList;
    }

    @XmlTransient
    public List<Musica> getMusicaList() {
        return musicaList;
    }

    public void setMusicaList(List<Musica> musicaList) {
        this.musicaList = musicaList;
    }

    public Ocupacion getOcupacionId() {
        return ocupacionId;
    }

    public void setOcupacionId(Ocupacion ocupacionId) {
        this.ocupacionId = ocupacionId;
    }

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
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
        if (!(object instanceof Perfil)) {
            return false;
        }
        Perfil other = (Perfil) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidades.Perfil[ id=" + id + " ]";
    }
    
}

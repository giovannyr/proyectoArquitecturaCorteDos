/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniminuto.arqSw.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Itech
 */
@Entity
@Table(name = "foro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Foro.findAll", query = "SELECT f FROM Foro f"),
    @NamedQuery(name = "Foro.findById", query = "SELECT f FROM Foro f WHERE f.id = :id"),
    @NamedQuery(name = "Foro.findByFechaPublicacion", query = "SELECT f FROM Foro f WHERE f.fechaPublicacion = :fechaPublicacion")})
public class Foro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "TEMA")
    private String tema;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_PUBLICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPublicacion;
    @ManyToMany(mappedBy = "foroCollection")
    private Collection<Ciudad> ciudadCollection;
    @ManyToMany(mappedBy = "foroCollection")
    private Collection<Evento> eventoCollection;
    @JoinColumn(name = "USUARIO_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Usuario usuarioId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "foroId")
    private Collection<ParticipacionForo> participacionForoCollection;

    public Foro() {
    }

    public Foro(Integer id) {
        this.id = id;
    }

    public Foro(Integer id, String tema, Date fechaPublicacion) {
        this.id = id;
        this.tema = tema;
        this.fechaPublicacion = fechaPublicacion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    @XmlTransient
    public Collection<Ciudad> getCiudadCollection() {
        return ciudadCollection;
    }

    public void setCiudadCollection(Collection<Ciudad> ciudadCollection) {
        this.ciudadCollection = ciudadCollection;
    }

    @XmlTransient
    public Collection<Evento> getEventoCollection() {
        return eventoCollection;
    }

    public void setEventoCollection(Collection<Evento> eventoCollection) {
        this.eventoCollection = eventoCollection;
    }

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
    }

    @XmlTransient
    public Collection<ParticipacionForo> getParticipacionForoCollection() {
        return participacionForoCollection;
    }

    public void setParticipacionForoCollection(Collection<ParticipacionForo> participacionForoCollection) {
        this.participacionForoCollection = participacionForoCollection;
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
        if (!(object instanceof Foro)) {
            return false;
        }
        Foro other = (Foro) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.uniminuto.arqSw.entities.Foro[ id=" + id + " ]";
    }
    
}

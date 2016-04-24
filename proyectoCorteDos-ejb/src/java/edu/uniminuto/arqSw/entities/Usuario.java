/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniminuto.arqSw.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Itech
 */
@Entity
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findById", query = "SELECT u FROM Usuario u WHERE u.id = :id"),
    @NamedQuery(name = "Usuario.findByCedula", query = "SELECT u FROM Usuario u WHERE u.cedula = :cedula"),
    @NamedQuery(name = "Usuario.findByNombre", query = "SELECT u FROM Usuario u WHERE u.nombre = :nombre"),
    @NamedQuery(name = "Usuario.findByCorreo", query = "SELECT u FROM Usuario u WHERE u.correo = :correo"),
    @NamedQuery(name = "Usuario.findByRol", query = "SELECT u FROM Usuario u WHERE u.rol = :rol")})
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "CEDULA")
    private String cedula;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "CORREO")
    private String correo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ROL")
    private String rol;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioId")
    private Collection<Evento> eventoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioId")
    private Collection<Ciudad> ciudadCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioId")
    private Collection<Foro> foroCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioId")
    private Collection<Categoria> categoriaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioId")
    private Collection<Hotel> hotelCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioId")
    private Collection<ParticipacionForo> participacionForoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioId")
    private Collection<Itinerario> itinerarioCollection;

    public Usuario() {
    }

    public Usuario(Integer id) {
        this.id = id;
    }

    public Usuario(Integer id, String cedula, String nombre, String correo, String rol) {
        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;
        this.correo = correo;
        this.rol = rol;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @XmlTransient
    public Collection<Evento> getEventoCollection() {
        return eventoCollection;
    }

    public void setEventoCollection(Collection<Evento> eventoCollection) {
        this.eventoCollection = eventoCollection;
    }

    @XmlTransient
    public Collection<Ciudad> getCiudadCollection() {
        return ciudadCollection;
    }

    public void setCiudadCollection(Collection<Ciudad> ciudadCollection) {
        this.ciudadCollection = ciudadCollection;
    }

    @XmlTransient
    public Collection<Foro> getForoCollection() {
        return foroCollection;
    }

    public void setForoCollection(Collection<Foro> foroCollection) {
        this.foroCollection = foroCollection;
    }

    @XmlTransient
    public Collection<Categoria> getCategoriaCollection() {
        return categoriaCollection;
    }

    public void setCategoriaCollection(Collection<Categoria> categoriaCollection) {
        this.categoriaCollection = categoriaCollection;
    }

    @XmlTransient
    public Collection<Hotel> getHotelCollection() {
        return hotelCollection;
    }

    public void setHotelCollection(Collection<Hotel> hotelCollection) {
        this.hotelCollection = hotelCollection;
    }

    @XmlTransient
    public Collection<ParticipacionForo> getParticipacionForoCollection() {
        return participacionForoCollection;
    }

    public void setParticipacionForoCollection(Collection<ParticipacionForo> participacionForoCollection) {
        this.participacionForoCollection = participacionForoCollection;
    }

    @XmlTransient
    public Collection<Itinerario> getItinerarioCollection() {
        return itinerarioCollection;
    }

    public void setItinerarioCollection(Collection<Itinerario> itinerarioCollection) {
        this.itinerarioCollection = itinerarioCollection;
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
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.uniminuto.arqSw.entities.Usuario[ id=" + id + " ]";
    }
    
}

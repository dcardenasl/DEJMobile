/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * @author Centro de Trabajo
 */
@Entity
@Table(name = "minutos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Minutos.findAll", query = "SELECT m FROM Minutos m"),
    @NamedQuery(name = "Minutos.findByIdMinutos", query = "SELECT m FROM Minutos m WHERE m.idMinutos = :idMinutos"),
    @NamedQuery(name = "Minutos.findByDescripcion", query = "SELECT m FROM Minutos m WHERE m.descripcion = :descripcion"),
    @NamedQuery(name = "Minutos.findByPrecio", query = "SELECT m FROM Minutos m WHERE m.precio = :precio")})
public class Minutos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idMinutos")
    private Integer idMinutos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio")
    private int precio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "minutosidMinutos")
    private List<Solicitud> solicitudList;

    public Minutos() {
    }

    public Minutos(Integer idMinutos) {
        this.idMinutos = idMinutos;
    }

    public Minutos(Integer idMinutos, String descripcion, int precio) {
        this.idMinutos = idMinutos;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public Integer getIdMinutos() {
        return idMinutos;
    }

    public void setIdMinutos(Integer idMinutos) {
        this.idMinutos = idMinutos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @XmlTransient
    public List<Solicitud> getSolicitudList() {
        return solicitudList;
    }

    public void setSolicitudList(List<Solicitud> solicitudList) {
        this.solicitudList = solicitudList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMinutos != null ? idMinutos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Minutos)) {
            return false;
        }
        Minutos other = (Minutos) object;
        if ((this.idMinutos == null && other.idMinutos != null) || (this.idMinutos != null && !this.idMinutos.equals(other.idMinutos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojos.Minutos[ idMinutos=" + idMinutos + " ]";
    }
    
}

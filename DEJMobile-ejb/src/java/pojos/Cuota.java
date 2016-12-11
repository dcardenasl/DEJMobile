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
 * @author Centro de Trabajo
 */
@Entity
@Table(name = "cuota")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cuota.findAll", query = "SELECT c FROM Cuota c"),
    @NamedQuery(name = "Cuota.findByIdCuota", query = "SELECT c FROM Cuota c WHERE c.idCuota = :idCuota"),
    @NamedQuery(name = "Cuota.findByDescripcion", query = "SELECT c FROM Cuota c WHERE c.descripcion = :descripcion"),
    @NamedQuery(name = "Cuota.findByPrecio", query = "SELECT c FROM Cuota c WHERE c.precio = :precio")})
public class Cuota implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCuota")
    private Integer idCuota;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio")
    private int precio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cuotaidCuota")
    private List<Solicitud> solicitudList;

    public Cuota() {
    }

    public Cuota(Integer idCuota) {
        this.idCuota = idCuota;
    }

    public Cuota(Integer idCuota, String descripcion, int precio) {
        this.idCuota = idCuota;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public Integer getIdCuota() {
        return idCuota;
    }

    public void setIdCuota(Integer idCuota) {
        this.idCuota = idCuota;
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
        hash += (idCuota != null ? idCuota.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cuota)) {
            return false;
        }
        Cuota other = (Cuota) object;
        if ((this.idCuota == null && other.idCuota != null) || (this.idCuota != null && !this.idCuota.equals(other.idCuota))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojos.Cuota[ idCuota=" + idCuota + " ]";
    }
    
}

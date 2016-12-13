/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Centro de Trabajo
 */
@Entity
@Table(name = "solicitud")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Solicitud.findAll", query = "SELECT s FROM Solicitud s"),
    @NamedQuery(name = "Solicitud.findByCodigo", query = "SELECT s FROM Solicitud s WHERE s.codigo = :codigo"),
    @NamedQuery(name = "Solicitud.findByEntrega", query = "SELECT s FROM Solicitud s WHERE s.entrega = :entrega"),
    @NamedQuery(name = "Solicitud.findByTotal", query = "SELECT s FROM Solicitud s WHERE s.total = :total"),
    @NamedQuery(name = "Solicitud.findByFechaHora", query = "SELECT s FROM Solicitud s WHERE s.fechaHora = :fechaHora")})
public class Solicitud implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo")
    private Integer codigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "entrega")
    private boolean entrega;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total")
    private int total;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaHora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHora;
    @JoinColumn(name = "Cliente_rut", referencedColumnName = "rut")
    @ManyToOne(optional = false)
    private Cliente clienterut;
    @JoinColumn(name = "Cuota_idCuota", referencedColumnName = "idCuota")
    @ManyToOne(optional = false)
    private Cuota cuotaidCuota;
    @JoinColumn(name = "Minutos_idMinutos", referencedColumnName = "idMinutos")
    @ManyToOne(optional = false)
    private Minutos minutosidMinutos;

    public Solicitud() {
    }

    public Solicitud(Integer codigo) {
        this.codigo = codigo;
    }

    public Solicitud(Integer codigo, boolean entrega, int total, Date fechaHora) {
        this.codigo = codigo;
        this.entrega = entrega;
        this.total = total;
        this.fechaHora = fechaHora;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public boolean getEntrega() {
        return entrega;
    }

    public void setEntrega(boolean entrega) {
        this.entrega = entrega;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Cliente getClienterut() {
        return clienterut;
    }

    public void setClienterut(Cliente clienterut) {
        this.clienterut = clienterut;
    }

    public Cuota getCuotaidCuota() {
        return cuotaidCuota;
    }

    public void setCuotaidCuota(Cuota cuotaidCuota) {
        this.cuotaidCuota = cuotaidCuota;
    }

    public Minutos getMinutosidMinutos() {
        return minutosidMinutos;
    }

    public void setMinutosidMinutos(Minutos minutosidMinutos) {
        this.minutosidMinutos = minutosidMinutos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Solicitud)) {
            return false;
        }
        Solicitud other = (Solicitud) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojos.Solicitud[ codigo=" + codigo + " ]";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.inject.Named;
import java.io.Serializable;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import pojos.Cliente;
import pojos.Cuota;
import pojos.Minutos;
import pojos.Solicitud;
import services.ClienteFacadeLocal;
import services.CuotaFacadeLocal;
import services.MinutosFacadeLocal;
import services.SolicitudFacadeLocal;

/**
 *
 * @author Pelao
 */
@Named(value = "solicitudBean")
@ManagedBean
@SessionScoped
public class SolicitudBean implements Serializable {

    @EJB
    private ClienteFacadeLocal clienteFacade;

    @EJB
    private MinutosFacadeLocal minutosFacade;

    @EJB
    private CuotaFacadeLocal cuotaFacade;

    @EJB
    private SolicitudFacadeLocal solicitudFacade;

    /**
     * Creates a new instance of SolicitudBean
     */
    private int codigo;
    private boolean entrega;
    private int total;
    private Date fechaHora;

    private Solicitud solicitud;
    private Cliente cliente;
    private Cuota cuota;
    private Minutos minutos;

    private List<Solicitud> solicitudesMias;

    public SolicitudBean() {
        solicitud = new Solicitud();
        cliente = new Cliente();
        cuota = new Cuota();
        minutos = new Minutos();
    }

    public List<Solicitud> getSolicitudesMias() {
        return solicitudesMias;
    }

    public void setSolicitudesMias(List<Solicitud> solicitudesMias) {
        this.solicitudesMias = solicitudesMias;
    }

    public List<Cuota> getCuotas() {
        return cuotaFacade.findAll();
    }

    public List<Minutos> getMinutosList() {
        return minutosFacade.findAll();
    }

    public ClienteFacadeLocal getClienteFacade() {
        return clienteFacade;
    }

    public void setClienteFacade(ClienteFacadeLocal clienteFacade) {
        this.clienteFacade = clienteFacade;
    }

    public MinutosFacadeLocal getMinutosFacade() {
        return minutosFacade;
    }

    public void setMinutosFacade(MinutosFacadeLocal minutosFacade) {
        this.minutosFacade = minutosFacade;
    }

    public CuotaFacadeLocal getCuotaFacade() {
        return cuotaFacade;
    }

    public void setCuotaFacade(CuotaFacadeLocal cuotaFacade) {
        this.cuotaFacade = cuotaFacade;
    }

    public SolicitudFacadeLocal getSolicitudFacade() {
        return solicitudFacade;
    }

    public void setSolicitudFacade(SolicitudFacadeLocal solicitudFacade) {
        this.solicitudFacade = solicitudFacade;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public boolean isEntrega() {
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


    public Solicitud getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(Solicitud solicitud) {
        this.solicitud = solicitud;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cuota getCuota() {
        return cuota;
    }

    public void setCuota(Cuota cuota) {
        this.cuota = cuota;
    }

    public Minutos getMinutos() {
        return minutos;
    }

    public void setMinutos(Minutos minutos) {
        this.minutos = minutos;
    }

    public String crearSolicitud(int rutCliente) {
        try {
            Date date = new Date();
            Instant instant = Instant.ofEpochMilli(date.getTime());

            Solicitud s = new Solicitud();
            s.setEntrega(entrega);
            s.setTotal(this.sumarPrecios());
            s.setFechaHora(Date.from(instant));
            s.setClienterut(clienteFacade.find(rutCliente));
            s.setMinutosidMinutos(minutosFacade.find(minutos.getIdMinutos()));
            s.setCuotaidCuota(cuotaFacade.find(cuota.getIdCuota()));
            this.solicitudFacade.create(s);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Solicitud Agregada exitosamente!!!"));
            return "VerPlan";
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error, vuelva a intentarlo"));
            return "ConfirmarPlan";
        }

    }

    public String eliminar(Solicitud solicitud) {
        Solicitud s = solicitudFacade.find(solicitud.getCodigo());
        solicitudFacade.remove(s);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Solicitud Eliminada!!!"));
        return "VerPlan";
    }

    public String actualizar() {
        Date date = new Date();
        Instant instant = Instant.ofEpochMilli(date.getTime());
        
        Solicitud s = solicitudFacade.find(solicitud.getCodigo());
        s.setEntrega(entrega);
        s.setTotal(this.sumarPrecios());
        s.setFechaHora(Date.from(instant));
        s.setMinutosidMinutos(minutosFacade.find(minutos.getIdMinutos()));
        s.setCuotaidCuota(cuotaFacade.find(cuota.getIdCuota()));
        solicitudFacade.edit(s);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Solicitud actualizada!!!"));
        return "VerPlan";
    }

    public List<Solicitud> MisSolicitudes(int rut) {
        List<Solicitud> solicitudes = this.solicitudFacade.findAll();
        solicitudesMias = this.solicitudFacade.findAll();
        solicitudesMias.removeAll(solicitudesMias);
        for (Solicitud s : solicitudes) {
            if (s.getClienterut().getRut() == rut) {
                solicitudesMias.add(s);
            }
        }
        return solicitudesMias;
    }

    public void addMensaje(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public int sumarPrecios() {
        Cuota c = cuotaFacade.find(cuota.getIdCuota());
        Minutos m = minutosFacade.find(minutos.getIdMinutos());
        total = c.getPrecio() + m.getPrecio();
        return total;
    }

    public String descripcionCuota() {
        Cuota c = cuotaFacade.find(cuota.getIdCuota());
        return c.getDescripcion();
    }

    public String descripcionMinutos() {
        Minutos m = minutosFacade.find(minutos.getIdMinutos());
        return m.getDescripcion();
    }

    public Cliente esteCliente(int rut) {
        Cliente c = clienteFacade.find(rut);
        return c;
    }
}

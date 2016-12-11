/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.inject.Named;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
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
    private Cliente clienteRut;
    private Cuota cuota_idCuota;
    private Minutos minutos_idMinutos;
    private String mensaje;
    
    private int idMinutos;
    private int idCuota;

    private Solicitud solicitud;
    private Cliente cliente;
    private Cuota cuota;
    private Minutos minutos;

    public SolicitudBean() {
        solicitud = new Solicitud();
        cliente = new Cliente();
        cuota = new Cuota();
        minutos = new Minutos();
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

    public Cliente getClienteRut() {
        return clienteRut;
    }

    public void setClienteRut(Cliente clienteRut) {
        this.clienteRut = clienteRut;
    }

    public Cuota getCuota_idCuota() {
        return cuota_idCuota;
    }

    public void setCuota_idCuota(Cuota cuota_idCuota) {
        this.cuota_idCuota = cuota_idCuota;
    }

    public Minutos getMinutos_idMinutos() {
        return minutos_idMinutos;
    }

    public void setMinutos_idMinutos(Minutos minutos_idMinutos) {
        this.minutos_idMinutos = minutos_idMinutos;
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

    public String crearSolicitud(String rutCliente, int idMinutos, int idCuota) {
        Solicitud s = new Solicitud();
        s.setCodigo(codigo);
        s.setEntrega(entrega);
        s.setTotal(total);
        s.setFechaHora(this.obtenerDiayHora());
        s.setClienterut(clienteFacade.find(rutCliente));
        s.setMinutosidMinutos(minutosFacade.find(idMinutos));
        s.setCuotaidCuota(cuotaFacade.find(idCuota));
        this.solicitudFacade.create(s);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Solicitud Agregada exitosamente!!!"));
        return "SolicitudBean";
    }

    public String eliminar(Solicitud solicitud) {
        Solicitud s = solicitudFacade.find(solicitud.getCodigo());
        solicitudFacade.remove(s);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Solicitud Eliminada!!!"));
        return "SolicitudBean";
    }

    public String actualizar() {
        Solicitud s = solicitudFacade.find(solicitud.getCodigo());
        s.setEntrega(entrega);
        s.setTotal(total);
        s.setClienterut(clienteFacade.find(cliente.getRut()));
        s.setMinutosidMinutos(minutosFacade.find(minutos.getIdMinutos()));
        s.setCuotaidCuota(cuotaFacade.find(cuota.getIdCuota()));
        solicitudFacade.edit(s);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Solicitud actualizada!!!"));
        return "SolicitudBean";
    }

    public void entrega() {
        Cliente c = clienteFacade.find(cliente.getRut());
        if (entrega) {
            mensaje = c.getDireccion() + " n° " + c.getNumeracion();
        } else {
            mensaje = "Retirar en oficina";
        }
    }

    public Date obtenerDiayHora() {
        Date date = new Date();

        DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        hourdateFormat.format(date);
        return date;
        
    }
    
    public String Paso2(){
        
        return "ConfirmarPlan";
    }
}

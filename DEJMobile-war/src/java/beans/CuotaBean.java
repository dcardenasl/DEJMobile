package beans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import pojos.Cuota;
import services.CuotaFacadeLocal;

/**
 *
 * @author Centro de Trabajo
 */
@Named(value = "cuotaBean")
@SessionScoped
public class CuotaBean implements Serializable {

    @EJB
    private CuotaFacadeLocal cuotaFacade;

    /**
     * Creates a new instance of cuotaBean
     */
    private Map<String, String> cuotas;
    private int ID;
    private int precio;
    private String descripcion;
    private Cuota cuota;

    public CuotaBean() {
        cuota = new Cuota();

    }

    public Map<String, String> getCuotas() {
        cuotas = new HashMap<String, String>();
        cuotas.put(this.cuotaFacade.find(1).getDescripcion(), this.cuotaFacade.find(1).getDescripcion());
        cuotas.put(this.cuotaFacade.find(2).getDescripcion(), this.cuotaFacade.find(2).getDescripcion());
        cuotas.put(this.cuotaFacade.find(3).getDescripcion(), this.cuotaFacade.find(3).getDescripcion());
        return cuotas;
    }

    public CuotaFacadeLocal getCuotaFacade() {
        return cuotaFacade;
    }

    public void setCuotas(Map<String, String> cuotas) {
        this.cuotas = cuotas;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public Cuota getCuota() {
        return cuota;
    }

    public void setCuota(Cuota cuota) {
        this.cuota = cuota;
    }

    public String crear() {
        Cuota c = new Cuota();
        c.setDescripcion(descripcion);
        cuotas.put(descripcion, descripcion);
        c.setPrecio(precio);
        this.cuotaFacade.create(c);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Nueva cuota creada exitosamente!!!"));
        return "CuotaBean";
    }

    public String eliminar() {
        Cuota c = cuotaFacade.find(cuota.getIdCuota());
        cuotaFacade.remove(c);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cuota Eliminada!!!"));
        return "CuotaBean";
    }

    public String actualizar() {
        Cuota c = cuotaFacade.find(cuota.getIdCuota());
        c.setDescripcion(descripcion);
        c.setPrecio(precio);
        cuotaFacade.edit(c);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cuota actualizada!!!"));
        return "CuotaBean";
    }

}

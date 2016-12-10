/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.inject.Named;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import pojos.Cuota;
import services.CuotaFacadeLocal;

/**
 *
 * @author Pelao
 */
@Named(value = "cuotaBean")
@ManagedBean
@ViewScoped
public class CuotaBean {

    @EJB
    private CuotaFacadeLocal cuotaFacade;

    /**
     * Creates a new instance of CuotaBean
     */
    
    private Map<String, String> descripcion;
    private int ID;
    private int precio;
    private String nuevaDescripcion;
    
    private Cuota cuota;
    
    public CuotaBean() {
        cuota = new Cuota();
        descripcion = new HashMap<String, String>();
        descripcion.put("1 giga", "1 giga");
        descripcion.put("2 gigas", "2 gigas");
        descripcion.put("3 gigas", "3 gigas");
    }

    public CuotaFacadeLocal getCuotaFacade() {
        return cuotaFacade;
    }

    public void setCuotaFacade(CuotaFacadeLocal cuotaFacade) {
        this.cuotaFacade = cuotaFacade;
    }

    public Map<String, String> getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(Map<String, String> descripcion) {
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

    public String getNuevaDescripcion() {
        return nuevaDescripcion;
    }

    public void setNuevaDescripcion(String nuevaDescripcion) {
        this.nuevaDescripcion = nuevaDescripcion;
    }

    public Cuota getCuota() {
        return cuota;
    }

    public void setCuota(Cuota cuota) {
        this.cuota = cuota;
    }
    
    public String crear()
    {
        Cuota c = new Cuota();
        c.setIdCuota(ID);
        c.setDescripcion(nuevaDescripcion);
        descripcion.put(nuevaDescripcion, nuevaDescripcion);
        c.setPrecio(precio);
        this.cuotaFacade.create(c);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Nueva cuota creada exitosamente!!!"));
        return "CuotaBean";
    }
    
    public String eliminar()
    {
        Cuota c = cuotaFacade.find(cuota.getIdCuota());
        cuotaFacade.remove(c);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cuota Eliminada!!!"));
        return "CuotaBean";
    }
    
    public String actualizar()
    {
        Cuota c = cuotaFacade.find(cuota.getIdCuota());
        c.setDescripcion(nuevaDescripcion);
        c.setPrecio(precio);
        cuotaFacade.edit(c);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cuota actualizada!!!"));
        return "CuotaBean";
    }
    
}

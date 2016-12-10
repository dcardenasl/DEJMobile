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
import services.MinutosFacadeLocal;
import pojos.Minutos;

/**
 *
 * @author Pelao
 */
@Named(value = "minutosBean")
@ManagedBean
@ViewScoped
public class MinutosBean {

    @EJB
    private MinutosFacadeLocal minutosFacade;

    /**
     * Creates a new instance of MinutosBean
     */
  
    private Map<String, String> descripcion;
    private int ID;
    private int precio;
    private String nuevaDescripcion;
    
    private Minutos minutos;
    
    public MinutosBean() {
        minutos = new Minutos();
        descripcion = new HashMap<String, String>();
        descripcion.put("150 minutos", "150 minutos");
        descripcion.put("300 minutos", "300 minutos");
        descripcion.put("500 minutos", "500 minutos");
    }

    public MinutosFacadeLocal getMinutosFacade() {
        return minutosFacade;
    }

    public void setMinutosFacade(MinutosFacadeLocal minutosFacade) {
        this.minutosFacade = minutosFacade;
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

    public Minutos getMinutos() {
        return minutos;
    }

    public void setMinutos(Minutos minutos) {
        this.minutos = minutos;
    }

    public String getNuevaDescripcion() {
        return nuevaDescripcion;
    }

    public void setNuevaDescripcion(String nuevaDescripcion) {
        this.nuevaDescripcion = nuevaDescripcion;
    }
    
    
    
    public String crear()
    {
        Minutos m = new Minutos();
        m.setIdMinutos(ID);
        m.setDescripcion(nuevaDescripcion);
        descripcion.put(nuevaDescripcion, nuevaDescripcion);
        m.setPrecio(precio);
        this.minutosFacade.create(m);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Nueva cantidad de minutos creada exitosamente!!!"));
        return "MinutosBean";
    }
    
    public String eliminar()
    {
        Minutos m = minutosFacade.find(minutos.getIdMinutos());
        minutosFacade.remove(m);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cantidad de minutos Eliminada!!!"));
        return "MinutosBean";
    }
    
    public String actualizar()
    {
        Minutos m = minutosFacade.find(minutos.getIdMinutos());
        m.setDescripcion(nuevaDescripcion);
        m.setPrecio(precio);
        minutosFacade.edit(m);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cantidad de minutos actualizada!!!"));
        return "MinutosBean";
    }
    
}

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
    private Map<String, String> minutosMap;
    private int ID;
    private int precio;
    private String descripcion;

    private Minutos minutos;

    public MinutosBean() {
        minutos = new Minutos();
    }

    public MinutosFacadeLocal getMinutosFacade() {
        return minutosFacade;
    }

    public void setMinutosFacade(MinutosFacadeLocal minutosFacade) {
        this.minutosFacade = minutosFacade;
    }

    public Map<String, String> getMinutosMap() {
        minutosMap = new HashMap<String, String>();
        minutosMap.put(this.minutosFacade.find(1).getDescripcion(), this.minutosFacade.find(1).getDescripcion());
        minutosMap.put(this.minutosFacade.find(2).getDescripcion(), this.minutosFacade.find(2).getDescripcion());
        minutosMap.put(this.minutosFacade.find(3).getDescripcion(), this.minutosFacade.find(3).getDescripcion());
        return minutosMap;
    }

    public void setMinutosMap(Map<String, String> minutosMap) {
        this.minutosMap = minutosMap;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String crear() {
        Minutos m = new Minutos();
        m.setIdMinutos(ID);
        m.setDescripcion(descripcion);
        minutosMap.put(descripcion, descripcion);
        m.setPrecio(precio);
        this.minutosFacade.create(m);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Nueva cantidad de minutos creada exitosamente!!!"));
        return "MinutosBean";
    }

    public String eliminar() {
        Minutos m = minutosFacade.find(minutos.getIdMinutos());
        minutosFacade.remove(m);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cantidad de minutos Eliminada!!!"));
        return "MinutosBean";
    }

    public String actualizar() {
        Minutos m = minutosFacade.find(minutos.getIdMinutos());
        m.setDescripcion(descripcion);
        m.setPrecio(precio);
        minutosFacade.edit(m);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cantidad de minutos actualizada!!!"));
        return "MinutosBean";
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import pojos.Cliente;
import services.ClienteFacadeLocal;

/**
 *
 * @author Centro de Trabajo
 */
@Named(value = "clienteBean")
@SessionScoped
public class ClienteBean implements Serializable {

    @EJB
    private ClienteFacadeLocal clienteFacade;
    

    /**
     * Creates a new instance of ClienteBean
     */
    private int rut;
    private String clave;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String direccion;
    private int numeracion;
    private String comuna;
    private int telefono;

    private Cliente cliente;
    
    private ComunaBean comunaBean;

    public ClienteBean() {
        cliente = new Cliente();
    }

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getNumeracion() {
        return numeracion;
    }

    public void setNumeracion(int numeracion) {
        this.numeracion = numeracion;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public List<Cliente> getPasajeros() {
        return clienteFacade.findAll();
    }

    public void login() {
        Cliente c = clienteFacade.find(rut);

        if (rut != 0 && clave.equals(c.getClave())) {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("cliente", c);
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("faces/index.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(ClienteBean.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Datos incorrectos. Vuelva a intentarlo");
        }

    }

    public void verificarSesionCliente() {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            Cliente c = (Cliente) context.getExternalContext().getSessionMap().get("cliente");
            if (c == null) {
                context.getExternalContext().redirect("faces/logueo.xhtml");
            }
        } catch (Exception e) {
            //log
        }
    }

    public String cerrarSesion() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "index";
    }

    public String signIn()
    {
        Cliente c = new Cliente();
        c.setRut(rut);
        c.setClave(clave);
        c.setNombre(nombre);
        c.setApellidoPaterno(apellidoPaterno);
        c.setApellidoMaterno(apellidoMaterno);
        c.setDireccion(direccion);
        c.setNumeracion(numeracion);
        c.setComuna(comunaBean.getComuna());
        c.setTelefono(telefono);
        this.clienteFacade.create(c);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cliente creado exitosamente!!!"));
        return "ClienteBean";
    }
      
    
}

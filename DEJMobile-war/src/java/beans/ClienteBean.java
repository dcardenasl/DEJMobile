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
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.context.RequestContext;
import pojos.Cliente;
import services.ClienteFacadeLocal;
import org.apache.commons.codec.digest.DigestUtils;

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
    private Integer rut;
    private String dv;
    private String clave;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String direccion;
    private Integer numeracion;
    private String comuna;
    private Integer telefono;
    boolean loggedIn = false;
    private Cliente cliente;

    private ComunaBean comunaBean;

    public ClienteBean() {
        cliente = new Cliente();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Integer getRut() {
        return rut;
    }

    public void setRut(Integer rut) {
        this.rut = rut;
    }

    public String getDv() {
        return dv;
    }

    public void setDv(String dv) {
        this.dv = dv;
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

    public Integer getNumeracion() {
        return numeracion;
    }

    public void setNumeracion(Integer numeracion) {
        this.numeracion = numeracion;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public List<Cliente> getPasajeros() {
        return clienteFacade.findAll();
    }

    public Cliente getEsteCliente() {
        return clienteFacade.find(rut);
    }

    public boolean confirmarRut() {
        int count = 2, suma = 0, digitoCalculado;
        String digitoFinal;

        try {
            for (int i = String.valueOf(rut).length() - 1; i >= 0; i--) {
                char r = String.valueOf(rut).charAt(i); // '9'
                String n = String.valueOf(r);
                int numero = Integer.parseInt(n) * count;
                suma += numero;
                count++;
                if (count == 8) {
                    count = 2;
                }
            }
            digitoCalculado = 11 - suma % 11;
            if (digitoCalculado == 10) {
                digitoFinal = "K";
            } else if (digitoCalculado == 11) {
                digitoFinal = "0";
            } else {
                digitoFinal = String.valueOf(digitoCalculado);
            }

            if (!digitoFinal.equalsIgnoreCase(dv)) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("RUT NO VALIDO."));
                return false;
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("RUT INCORRECTO."));
            return false;
        }

        return true;
    }

    public void login(ActionEvent event) {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message = null;
        Cliente c = clienteFacade.find(rut);
        clave = DigestUtils.md5Hex(clave);

        if (c != null && clave != null && clave.equals(c.getClave()) && confirmarRut()) {
            loggedIn = true;
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", c.getNombre() + " " + c.getApellidoPaterno());
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("cliente", c);
            FacesContext.getCurrentInstance().addMessage(null, message);
            context.addCallbackParam("loggedIn", loggedIn);
            context.addCallbackParam("view", "index.xhtml");
        } else {
            loggedIn = false;
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "RUT o Clave no validas");
            FacesContext.getCurrentInstance().addMessage(null, message);
            context.addCallbackParam("view", "logueo.xhtml");
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

    public boolean verificarSesion() {
        FacesContext context = FacesContext.getCurrentInstance();
        Cliente c = (Cliente) context.getExternalContext().getSessionMap().get("cliente");
        if (c == null) {
            return false;
        } else {
            return true;
        }
    }

    public String cerrarSesion() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        loggedIn = false;
        return "logueo";
    }

    public String signIn() {
        try {
            String textoEncriptadoConMD5 = DigestUtils.md5Hex(clave);
            Cliente c = new Cliente();
            c.setRut(rut);
            c.setClave(textoEncriptadoConMD5);
            c.setNombre(nombre);
            c.setApellidoPaterno(apellidoPaterno);
            c.setApellidoMaterno(apellidoMaterno);
            c.setDireccion(direccion);
            c.setNumeracion(numeracion);
            c.setComuna(comuna);
            c.setTelefono(telefono);
            this.clienteFacade.create(c);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente creado exitosamente!!!", "Ingrese con su rut y clave"));
            return "logueo";
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR", "Vuelva a ingresar los datos"));
            return "logueo";
        }

    }

}

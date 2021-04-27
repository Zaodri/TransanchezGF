
package controllerView;

import controllerAbstract.CredencialEmpleFacadeAbst;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import com.mycompany.transanchezgf.persisJPA.CredencialEmple;

/**
 *
 * @author SAODRI
 */
@Named(value = "usuSess")
@SessionScoped
public class UsuarioSession implements Serializable {

    @EJB
    CredencialEmpleFacadeAbst credencialEmpleFacadeAbst;
    private CredencialEmple usuNuevo = new CredencialEmple();
    private CredencialEmple usuLog = new CredencialEmple();

    private String mesError = "";
    private String usuarioIn = "";
    private String claveIn = "";

    /**
     * Creates a new instance of UsusarioSession
     */
    public UsuarioSession() {
    }

    public void crearUsuario() {
        mesError = "";
        try {
            usuNuevo.setEstado(true);
            credencialEmpleFacadeAbst.create(usuNuevo);
            mesError = "m2";
        } catch (Exception e) {
            mesError = "m1";
        }
        usuNuevo = new CredencialEmple();
    }

    public void actualizarMisDatos() {
        mesError = "";
        try {
            credencialEmpleFacadeAbst.edit(usuLog);
            mesError = "m2";
        } catch (Exception e) {
            mesError = "m1";
        }
    }

    public List<CredencialEmple> todosUsuarios() {
        return credencialEmpleFacadeAbst.findAll();
    }

    public void validarUsuario() {
        try {
            usuLog = credencialEmpleFacadeAbst.validarCredEmple(usuarioIn, claveIn);
            if (usuLog != null) {
                if (usuLog.isEstado()) {
                    FacesContext fc = FacesContext.getCurrentInstance();
                    fc.getExternalContext().redirect("../administrador/indexAdmin.xhtml");
                } else {
                    mesError = "mAdmin";
                }

            } else {
                mesError = "mBad";
            }
        } catch (Exception e) {
            mesError = "mError";
        }
    }

    public CredencialEmple getUsuNuevo() {
        return usuNuevo;
    }

    public void setUsuNuevo(CredencialEmple usuNuevo) {
        this.usuNuevo = usuNuevo;
    }

    public String getMesError() {
        return mesError;
    }

    public void setMesError(String mesError) {
        this.mesError = mesError;

    }

    public String getClaveIn() {
        return claveIn;
    }

    public void setClaveIn(String claveIn) {
        this.claveIn = claveIn;
    }

    public String getUsuarioIn() {
        return usuarioIn;
    }

    public void setUsuarioIn(String usuarioIn) {
        this.usuarioIn = usuarioIn;
    }

    public CredencialEmple getUsuLog() {
        return usuLog;
    }

    public void setUsuLog(CredencialEmple usuLog) {
        this.usuLog = usuLog;
    }

}


package controllerView;

import com.mycompany.transanchezgf.persisJPA.CredencialEmple;
import controllerAbstract.CredencialEmpleFacadeAbst;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;


/**
 *
 * @author SAODRI
 */
@Named(value = "recupCont")
@SessionScoped
public class RecuperarContra implements Serializable{
    
    @EJB
    private CredencialEmpleFacadeAbst credencialEmpleFacadeAbst;
    private CredencialEmple recupUsuario = new CredencialEmple();

    private String mesError = "";
    private String recContra = "";
    private String email = "";

    public RecuperarContra() {
    }
    
    public void actuContras() {
        try {
            recupUsuario = credencialEmpleFacadeAbst.validarCredEmple(recContra, email);
            if (recupUsuario != null) {
                if (recupUsuario.isEstado()) {
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

    public CredencialEmple getRecupUsuario() {
        return recupUsuario;
    }

    public void setRecupUsuario(CredencialEmple recupUsuario) {
        this.recupUsuario = recupUsuario;
    }

    public String getMesError() {
        return mesError;
    }

    public void setMesError(String mesError) {
        this.mesError = mesError;
    }

    public String getRecContra() {
        return recContra;
    }

    public void setRecContra(String recContra) {
        this.recContra = recContra;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
    
    
}

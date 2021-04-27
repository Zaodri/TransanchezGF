package controllerAbstract;

import java.util.List;
import javax.ejb.Local;
import com.mycompany.transanchezgf.persisJPA.CredencialEmple;

/**
 *
 * @author SAODRI
 */
@Local
public interface CredencialEmpleFacadeAbst {

    void create(CredencialEmple usuario);

    void edit(CredencialEmple usuario);

    void remove(CredencialEmple usuario);

    CredencialEmple find(Object id);

    List<CredencialEmple> findAll();

    List<CredencialEmple> findRange(int[] range);

    int count();
    
    CredencialEmple validarCredEmple(String strUsuario, String claveIn);    
    
}

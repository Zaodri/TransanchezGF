
package controllerAbstract;

import java.util.List;
import javax.ejb.Local;
import com.mycompany.transanchezgf.persisJPA.Empleado;

/**
 *
 * @author SAODRI
 */
@Local
public interface EmpleadoFacadeAbst {

    void create(Empleado empleado);

    void edit(Empleado empleado);

    void remove(Empleado empleado);

    Empleado find(Object id);

    List<Empleado> findAll();

    List<Empleado> findRange(int[] range);

    int count();
    
}

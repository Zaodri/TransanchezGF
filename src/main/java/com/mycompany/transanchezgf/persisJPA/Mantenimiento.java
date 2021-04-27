
package com.mycompany.transanchezgf.persisJPA;

import java.io.Serializable;
import java.util.Collection;
//import javax.inject.Named;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
//import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
//import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
//import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author SAODRI
 */

@Entity
@Table(name = "mantenimiento")
/**@XmlRootElement*/
@NamedQueries({
    @NamedQuery(name = "Mantenimiento.findAll", query = "SELECT m FROM Mantenimiento m")
    , @NamedQuery(name = "Mantenimiento.findByIdMantenimiento", query = "SELECT m FROM Mantenimiento m WHERE m.idMantenimiento = :idMantenimiento")
    , @NamedQuery(name = "Mantenimiento.findByTipoMantenimiento", query = "SELECT m FROM Mantenimiento m WHERE m.tipoMantenimiento = :tipoMantenimiento")})

public class Mantenimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Mantenimiento")
    private Integer idMantenimiento;
    @Size(max = 45)
    @Column(name = "Tipo_Mantenimiento")
    private String tipoMantenimiento;
    @JoinColumn(name = "Vehiculo_Id_Vehiculo", referencedColumnName = "Id_Vehiculo")
    @ManyToOne(optional = false)
    private Vehiculo vehiculoIdVehiculo;
    @JoinColumn(name = "Id_emple_Solicitud", referencedColumnName = "id_Empleado")
    @OneToOne
    private Empleado idempleSolicitud;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mantenimientoidMantenimiento")
    private Collection<RepuestoAsignado> repuestoAsignadoCollection;

    public Mantenimiento() {
    }

    public Mantenimiento(Integer idMantenimiento) {
        this.idMantenimiento = idMantenimiento;
    }

    public Integer getIdMantenimiento() {
        return idMantenimiento;
    }

    public void setIdMantenimiento(Integer idMantenimiento) {
        this.idMantenimiento = idMantenimiento;
    }

    public String getTipoMantenimiento() {
        return tipoMantenimiento;
    }

    public void setTipoMantenimiento(String tipoMantenimiento) {
        this.tipoMantenimiento = tipoMantenimiento;
    }

    public Vehiculo getVehiculoIdVehiculo() {
        return vehiculoIdVehiculo;
    }

    public void setVehiculoIdVehiculo(Vehiculo vehiculoIdVehiculo) {
        this.vehiculoIdVehiculo = vehiculoIdVehiculo;
    }

    public Empleado getIdempleSolicitud() {
        return idempleSolicitud;
    }

    public void setIdempleSolicitud(Empleado idempleSolicitud) {
        this.idempleSolicitud = idempleSolicitud;
    }

    @XmlTransient
    public Collection<RepuestoAsignado> getRepuestoAsignadoCollection() {
        return repuestoAsignadoCollection;
    }

    public void setRepuestoAsignadoCollection(Collection<RepuestoAsignado> repuestoAsignadoCollection) {
        this.repuestoAsignadoCollection = repuestoAsignadoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMantenimiento != null ? idMantenimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mantenimiento)) {
            return false;
        }
        Mantenimiento other = (Mantenimiento) object;
        if ((this.idMantenimiento == null && other.idMantenimiento != null) || (this.idMantenimiento != null && !this.idMantenimiento.equals(other.idMantenimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistence.Mantenimiento[ idMantenimiento=" + idMantenimiento + " ]";
    }
    
}

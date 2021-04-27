
package com.mycompany.transanchezgf.persisJPA;

import java.io.Serializable;
//import java.util.Collection;
import java.util.Date;
//import javax.inject.Named;
import javax.persistence.Basic;
//import javax.persistence.CascadeType;
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
//import javax.persistence.OneToMany;
//import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;
//import javax.xml.bind.annotation.XmlRootElement;
//import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author SAODRI
 */
@Entity
@Table(name = "repuesto_asignado")
/**@XmlRootElement*/
@NamedQueries({
    @NamedQuery(name = "RepuestoAsignado.findAll", query = "SELECT r FROM RepuestoAsignado r")
    , @NamedQuery(name = "RepuestoAsignado.findByIdRepuestoasignado", query = "SELECT r FROM RepuestoAsignado r WHERE r.idRepuestoasignado = :idRepuestoasignado")
    , @NamedQuery(name = "RepuestoAsignado.findByFecha", query = "SELECT r FROM RepuestoAsignado r WHERE r.fecha = :fecha")})

public class RepuestoAsignado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdRepuesto_asignado")
    private Integer idRepuestoasignado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "Mantenimiento_id_Mantenimiento", referencedColumnName = "id_Mantenimiento")
    @ManyToOne(optional = false)
    private Mantenimiento mantenimientoidMantenimiento;
    @JoinColumn(name = "Repuesto_Id_Repuesto", referencedColumnName = "id_Repuesto")
    @ManyToOne(optional = false)
    private Repuesto repuestoIdRepuesto;

    public RepuestoAsignado() {
    }

    public RepuestoAsignado(Integer idRepuestoasignado) {
        this.idRepuestoasignado = idRepuestoasignado;
    }

    public RepuestoAsignado(Integer idRepuestoasignado, Date fecha) {
        this.idRepuestoasignado = idRepuestoasignado;
        this.fecha = fecha;
    }

    public Integer getIdRepuestoasignado() {
        return idRepuestoasignado;
    }

    public void setIdRepuestoasignado(Integer idRepuestoasignado) {
        this.idRepuestoasignado = idRepuestoasignado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Mantenimiento getMantenimientoidMantenimiento() {
        return mantenimientoidMantenimiento;
    }

    public void setMantenimientoidMantenimiento(Mantenimiento mantenimientoidMantenimiento) {
        this.mantenimientoidMantenimiento = mantenimientoidMantenimiento;
    }

    public Repuesto getRepuestoIdRepuesto() {
        return repuestoIdRepuesto;
    }

    public void setRepuestoIdRepuesto(Repuesto repuestoIdRepuesto) {
        this.repuestoIdRepuesto = repuestoIdRepuesto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRepuestoasignado != null ? idRepuestoasignado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RepuestoAsignado)) {
            return false;
        }
        RepuestoAsignado other = (RepuestoAsignado) object;
        if ((this.idRepuestoasignado == null && other.idRepuestoasignado != null) || (this.idRepuestoasignado != null && !this.idRepuestoasignado.equals(other.idRepuestoasignado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistence.RepuestoAsignado[ idRepuestoasignado=" + idRepuestoasignado + " ]";
    }
    
}

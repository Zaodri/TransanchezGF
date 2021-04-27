
package com.mycompany.transanchezgf.persisJPA;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.inject.Named;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author SAODRI
 */
@Entity
@Table(name = "reporte_de_ruta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReporteDeRuta.findAll", query = "SELECT r FROM ReporteDeRuta r")
    , @NamedQuery(name = "ReporteDeRuta.findByIdReporteRuta", query = "SELECT r FROM ReporteDeRuta r WHERE r.idReporteRuta = :idReporteRuta")
    , @NamedQuery(name = "ReporteDeRuta.findByFecha", query = "SELECT r FROM ReporteDeRuta r WHERE r.fecha = :fecha")})

public class ReporteDeRuta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_Reporte_Ruta")
    private Integer idReporteRuta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "Vehiculo_Id_Vehiculo", referencedColumnName = "Id_Vehiculo")
    @ManyToOne(optional = false)
    private Vehiculo vehiculoIdVehiculo;
    @JoinColumn(name = "Ruta_Id_Ruta", referencedColumnName = "Id_Ruta")
    @ManyToOne(optional = false)
    private Ruta rutaIdRuta;
    @JoinColumn(name = "Empleado_Id_Empleado", referencedColumnName = "id_Empleado")
    @ManyToOne(optional = false)
    private Empleado empleadoIdEmpleado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reporteDeRutaIdReporteRuta")
    private Collection<Entrega> entregaCollection;

    public ReporteDeRuta() {
    }

    public ReporteDeRuta(Integer idReporteRuta) {
        this.idReporteRuta = idReporteRuta;
    }

    public ReporteDeRuta(Integer idReporteRuta, Date fecha) {
        this.idReporteRuta = idReporteRuta;
        this.fecha = fecha;
    }

    public Integer getIdReporteRuta() {
        return idReporteRuta;
    }

    public void setIdReporteRuta(Integer idReporteRuta) {
        this.idReporteRuta = idReporteRuta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Vehiculo getVehiculoIdVehiculo() {
        return vehiculoIdVehiculo;
    }

    public void setVehiculoIdVehiculo(Vehiculo vehiculoIdVehiculo) {
        this.vehiculoIdVehiculo = vehiculoIdVehiculo;
    }

    public Ruta getRutaIdRuta() {
        return rutaIdRuta;
    }

    public void setRutaIdRuta(Ruta rutaIdRuta) {
        this.rutaIdRuta = rutaIdRuta;
    }

    public Empleado getEmpleadoIdEmpleado() {
        return empleadoIdEmpleado;
    }

    public void setEmpleadoIdEmpleado(Empleado empleadoIdEmpleado) {
        this.empleadoIdEmpleado = empleadoIdEmpleado;
    }

    @XmlTransient
    public Collection<Entrega> getEntregaCollection() {
        return entregaCollection;
    }

    public void setEntregaCollection(Collection<Entrega> entregaCollection) {
        this.entregaCollection = entregaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReporteRuta != null ? idReporteRuta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReporteDeRuta)) {
            return false;
        }
        ReporteDeRuta other = (ReporteDeRuta) object;
        if ((this.idReporteRuta == null && other.idReporteRuta != null) || (this.idReporteRuta != null && !this.idReporteRuta.equals(other.idReporteRuta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistence.ReporteDeRuta[ idReporteRuta=" + idReporteRuta + " ]";
    }
    
}

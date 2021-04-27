
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
@Table(name = "entrega")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Entrega.findAll", query = "SELECT e FROM Entrega e")
    , @NamedQuery(name = "Entrega.findByIdEntrega", query = "SELECT e FROM Entrega e WHERE e.idEntrega = :idEntrega")
    , @NamedQuery(name = "Entrega.findByFechaEntrega", query = "SELECT e FROM Entrega e WHERE e.fechaEntrega = :fechaEntrega")})

public class Entrega implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_Entrega")
    private Integer idEntrega;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fecha_Entrega")
    @Temporal(TemporalType.DATE)
    private Date fechaEntrega;
    @JoinColumn(name = "Reporte_De_Ruta_Id_Reporte_Ruta", referencedColumnName = "Id_Reporte_Ruta")
    @ManyToOne(optional = false)
    private ReporteDeRuta reporteDeRutaIdReporteRuta;
    @JoinColumn(name = "Cliente_Id_Cliente", referencedColumnName = "Id_Cliente")
    @ManyToOne(optional = false)
    private Cliente clienteIdCliente;

    public Entrega() {
    }

    public Entrega(Integer idEntrega) {
        this.idEntrega = idEntrega;
    }

    public Entrega(Integer idEntrega, Date fechaEntrega) {
        this.idEntrega = idEntrega;
        this.fechaEntrega = fechaEntrega;
    }

    public Integer getIdEntrega() {
        return idEntrega;
    }

    public void setIdEntrega(Integer idEntrega) {
        this.idEntrega = idEntrega;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public ReporteDeRuta getReporteDeRutaIdReporteRuta() {
        return reporteDeRutaIdReporteRuta;
    }

    public void setReporteDeRutaIdReporteRuta(ReporteDeRuta reporteDeRutaIdReporteRuta) {
        this.reporteDeRutaIdReporteRuta = reporteDeRutaIdReporteRuta;
    }

    public Cliente getClienteIdCliente() {
        return clienteIdCliente;
    }

    public void setClienteIdCliente(Cliente clienteIdCliente) {
        this.clienteIdCliente = clienteIdCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEntrega != null ? idEntrega.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entrega)) {
            return false;
        }
        Entrega other = (Entrega) object;
        if ((this.idEntrega == null && other.idEntrega != null) || (this.idEntrega != null && !this.idEntrega.equals(other.idEntrega))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistence.Entrega[ idEntrega=" + idEntrega + " ]";
    }
    
}

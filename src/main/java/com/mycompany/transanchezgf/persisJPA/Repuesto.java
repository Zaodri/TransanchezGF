
package com.mycompany.transanchezgf.persisJPA;

import java.io.Serializable;
import java.util.Collection;
//import java.util.Date;
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
//import javax.persistence.OneToOne;
import javax.persistence.Table;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author SAODRI
 */
@Entity
@Table(name = "repuesto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Repuesto.findAll", query = "SELECT r FROM Repuesto r")
    , @NamedQuery(name = "Repuesto.findByIdRepuesto", query = "SELECT r FROM Repuesto r WHERE r.idRepuesto = :idRepuesto")
    , @NamedQuery(name = "Repuesto.findByNombreRepuesto", query = "SELECT r FROM Repuesto r WHERE r.nombreRepuesto = :nombreRepuesto")
    , @NamedQuery(name = "Repuesto.findByCantidad", query = "SELECT r FROM Repuesto r WHERE r.cantidad = :cantidad")})

public class Repuesto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Repuesto")
    private Integer idRepuesto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Nombre_Repuesto")
    private String nombreRepuesto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Cantidad")
    private int cantidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "repuestoIdRepuesto")
    private Collection<RepuestoAsignado> repuestoAsignadoCollection;
    @JoinColumn(name = "Proveedor_Id_Proveedor", referencedColumnName = "Id_Proveedor")
    @ManyToOne(optional = false)
    private Proveedor proveedorIdProveedor;

    public Repuesto() {
    }

    public Repuesto(Integer idRepuesto) {
        this.idRepuesto = idRepuesto;
    }

    public Repuesto(Integer idRepuesto, String nombreRepuesto, int cantidad) {
        this.idRepuesto = idRepuesto;
        this.nombreRepuesto = nombreRepuesto;
        this.cantidad = cantidad;
    }

    public Integer getIdRepuesto() {
        return idRepuesto;
    }

    public void setIdRepuesto(Integer idRepuesto) {
        this.idRepuesto = idRepuesto;
    }

    public String getNombreRepuesto() {
        return nombreRepuesto;
    }

    public void setNombreRepuesto(String nombreRepuesto) {
        this.nombreRepuesto = nombreRepuesto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @XmlTransient
    public Collection<RepuestoAsignado> getRepuestoAsignadoCollection() {
        return repuestoAsignadoCollection;
    }

    public void setRepuestoAsignadoCollection(Collection<RepuestoAsignado> repuestoAsignadoCollection) {
        this.repuestoAsignadoCollection = repuestoAsignadoCollection;
    }

    public Proveedor getProveedorIdProveedor() {
        return proveedorIdProveedor;
    }

    public void setProveedorIdProveedor(Proveedor proveedorIdProveedor) {
        this.proveedorIdProveedor = proveedorIdProveedor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRepuesto != null ? idRepuesto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Repuesto)) {
            return false;
        }
        Repuesto other = (Repuesto) object;
        if ((this.idRepuesto == null && other.idRepuesto != null) || (this.idRepuesto != null && !this.idRepuesto.equals(other.idRepuesto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistence.Repuesto[ idRepuesto=" + idRepuesto + " ]";
    }
    
}


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
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
//import javax.persistence.ManyToMany;
//import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
//import javax.persistence.OneToOne;
import javax.persistence.Table;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
//import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author SAODRI
 */
@Entity
@Table(name = "proveedor")
/**@XmlRootElement*/
@NamedQueries({
    @NamedQuery(name = "Proveedor.findAll", query = "SELECT p FROM Proveedor p")
    , @NamedQuery(name = "Proveedor.findByIdProveedor", query = "SELECT p FROM Proveedor p WHERE p.idProveedor = :idProveedor")
    , @NamedQuery(name = "Proveedor.findByCodIdentifica", query = "SELECT p FROM Proveedor p WHERE p.codIdentifica = :codIdentifica")
    , @NamedQuery(name = "Proveedor.findByNombres", query = "SELECT p FROM Proveedor p WHERE p.nombres = :nombres")
    , @NamedQuery(name = "Proveedor.findByPrimerApellido", query = "SELECT p FROM Proveedor p WHERE p.primerApellido = :primerApellido")
    , @NamedQuery(name = "Proveedor.findBySegundoApellido", query = "SELECT p FROM Proveedor p WHERE p.segundoApellido = :segundoApellido")})

public class Proveedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_Proveedor")
    private Integer idProveedor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "Cod_Identifica")
    private String codIdentifica;
    @Size(max = 45)
    @Column(name = "Nombres")
    private String nombres;
    @Size(max = 20)
    @Column(name = "Primer_Apellido")
    private String primerApellido;
    @Size(max = 20)
    @Column(name = "Segundo_Apellido")
    private String segundoApellido;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proveedorIdProveedor")
    private Collection<ContactoDeProveedor> contactoDeProveedorCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proveedorIdProveedor")
    private Collection<Repuesto> repuestoCollection;

    public Proveedor() {
    }

    public Proveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }

    public Proveedor(Integer idProveedor, String codIdentifica) {
        this.idProveedor = idProveedor;
        this.codIdentifica = codIdentifica;
    }

    public Integer getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getCodIdentifica() {
        return codIdentifica;
    }

    public void setCodIdentifica(String codIdentifica) {
        this.codIdentifica = codIdentifica;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    @XmlTransient
    public Collection<ContactoDeProveedor> getContactoDeProveedorCollection() {
        return contactoDeProveedorCollection;
    }

    public void setContactoDeProveedorCollection(Collection<ContactoDeProveedor> contactoDeProveedorCollection) {
        this.contactoDeProveedorCollection = contactoDeProveedorCollection;
    }

    @XmlTransient
    public Collection<Repuesto> getRepuestoCollection() {
        return repuestoCollection;
    }

    public void setRepuestoCollection(Collection<Repuesto> repuestoCollection) {
        this.repuestoCollection = repuestoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProveedor != null ? idProveedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proveedor)) {
            return false;
        }
        Proveedor other = (Proveedor) object;
        if ((this.idProveedor == null && other.idProveedor != null) || (this.idProveedor != null && !this.idProveedor.equals(other.idProveedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistence.Proveedor[ idProveedor=" + idProveedor + " ]";
    }
    
}

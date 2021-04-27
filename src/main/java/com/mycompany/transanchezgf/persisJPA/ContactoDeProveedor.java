
package com.mycompany.transanchezgf.persisJPA;

import java.io.Serializable;
//import java.util.Collection;
//import java.util.Date;
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
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;
//import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
//import javax.xml.bind.annotation.XmlRootElement;
//import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author SAODRI
 */
@Entity
@Table(name = "contacto_de_proveedor")
/**@XmlRootElement */
@NamedQueries({
    @NamedQuery(name = "ContactoDeProveedor.findAll", query = "SELECT c FROM ContactoDeProveedor c")
    , @NamedQuery(name = "ContactoDeProveedor.findByIdcontactoProveedor", query = "SELECT c FROM ContactoDeProveedor c WHERE c.idcontactoProveedor = :idcontactoProveedor")
    , @NamedQuery(name = "ContactoDeProveedor.findByTelefono", query = "SELECT c FROM ContactoDeProveedor c WHERE c.telefono = :telefono")
    , @NamedQuery(name = "ContactoDeProveedor.findByDireccion", query = "SELECT c FROM ContactoDeProveedor c WHERE c.direccion = :direccion")
    , @NamedQuery(name = "ContactoDeProveedor.findByEmail", query = "SELECT c FROM ContactoDeProveedor c WHERE c.email = :email")})

public class ContactoDeProveedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_contacto_Proveedor")
    private Integer idcontactoProveedor;
    @Column(name = "Telefono")
    private Integer telefono;
    @Size(max = 127)
    @Column(name = "Direccion")
    private String direccion;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 127)
    @Column(name = "E_mail")
    private String email;
    @JoinColumn(name = "Proveedor_Id_Proveedor", referencedColumnName = "Id_Proveedor")
    @ManyToOne(optional = false)
    private Proveedor proveedorIdProveedor;

    public ContactoDeProveedor() {
    }

    public ContactoDeProveedor(Integer idcontactoProveedor) {
        this.idcontactoProveedor = idcontactoProveedor;
    }

    public Integer getIdcontactoProveedor() {
        return idcontactoProveedor;
    }

    public void setIdcontactoProveedor(Integer idcontactoProveedor) {
        this.idcontactoProveedor = idcontactoProveedor;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        hash += (idcontactoProveedor != null ? idcontactoProveedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContactoDeProveedor)) {
            return false;
        }
        ContactoDeProveedor other = (ContactoDeProveedor) object;
        if ((this.idcontactoProveedor == null && other.idcontactoProveedor != null) || (this.idcontactoProveedor != null && !this.idcontactoProveedor.equals(other.idcontactoProveedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistence.ContactoDeProveedor[ idcontactoProveedor=" + idcontactoProveedor + " ]";
    }
    
}

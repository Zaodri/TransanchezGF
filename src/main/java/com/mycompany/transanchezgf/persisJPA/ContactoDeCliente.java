
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
@Table(name = "contacto_de_cliente")
/**@XmlRootElement*/
@NamedQueries({
    @NamedQuery(name = "ContactoDeCliente.findAll", query = "SELECT c FROM ContactoDeCliente c")
    , @NamedQuery(name = "ContactoDeCliente.findByIdContactoCiente", query = "SELECT c FROM ContactoDeCliente c WHERE c.idContactoCiente = :idContactoCiente")
    , @NamedQuery(name = "ContactoDeCliente.findByTelefono", query = "SELECT c FROM ContactoDeCliente c WHERE c.telefono = :telefono")
    , @NamedQuery(name = "ContactoDeCliente.findByDireccion", query = "SELECT c FROM ContactoDeCliente c WHERE c.direccion = :direccion")
    , @NamedQuery(name = "ContactoDeCliente.findByEmail", query = "SELECT c FROM ContactoDeCliente c WHERE c.email = :email")})

public class ContactoDeCliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_Contacto_Ciente")
    private Integer idContactoCiente;
    @Column(name = "Telefono")
    private Integer telefono;
    @Size(max = 127)
    @Column(name = "Direccion")
    private String direccion;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 127)
    @Column(name = "E_mail")
    private String email;
    @JoinColumn(name = "Cliente_Id_Cliente", referencedColumnName = "Id_Cliente")
    @ManyToOne(optional = false)
    private Cliente clienteIdCliente;

    public ContactoDeCliente() {
    }

    public ContactoDeCliente(Integer idContactoCiente) {
        this.idContactoCiente = idContactoCiente;
    }

    public Integer getIdContactoCiente() {
        return idContactoCiente;
    }

    public void setIdContactoCiente(Integer idContactoCiente) {
        this.idContactoCiente = idContactoCiente;
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

    public Cliente getClienteIdCliente() {
        return clienteIdCliente;
    }

    public void setClienteIdCliente(Cliente clienteIdCliente) {
        this.clienteIdCliente = clienteIdCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idContactoCiente != null ? idContactoCiente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContactoDeCliente)) {
            return false;
        }
        ContactoDeCliente other = (ContactoDeCliente) object;
        if ((this.idContactoCiente == null && other.idContactoCiente != null) || (this.idContactoCiente != null && !this.idContactoCiente.equals(other.idContactoCiente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistence.ContactoDeCliente[ idContactoCiente=" + idContactoCiente + " ]";
    }
    
}

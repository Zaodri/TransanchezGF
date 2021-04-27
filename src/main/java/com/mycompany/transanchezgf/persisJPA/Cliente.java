
package com.mycompany.transanchezgf.persisJPA;

import java.io.Serializable;
import java.util.Collection;
//import java.util.Date;
import javax.inject.Named;
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
@Table(name = "cliente")
@Named("tranForeign")
/** @XmlRootElement*/
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c")
    , @NamedQuery(name = "Cliente.findByIdCliente", query = "SELECT c FROM Cliente c WHERE c.idCliente = :idCliente")
    , @NamedQuery(name = "Cliente.findByCodIdentifica", query = "SELECT c FROM Cliente c WHERE c.codIdentifica = :codIdentifica")
    , @NamedQuery(name = "Cliente.findByNombres", query = "SELECT c FROM Cliente c WHERE c.nombres = :nombres")
    , @NamedQuery(name = "Cliente.findByPrimerApellido", query = "SELECT c FROM Cliente c WHERE c.primerApellido = :primerApellido")
    , @NamedQuery(name = "Cliente.findBySegundoApellido", query = "SELECT c FROM Cliente c WHERE c.segundoApellido = :segundoApellido")})

public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_Cliente")
    private Integer idCliente;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clienteIdCliente")
    private Collection<Entrega> entregaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clienteIdCliente")
    private Collection<ContactoDeCliente> contactoDeClienteCollection;

    public Cliente() {
    }

    public Cliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Cliente(Integer idCliente, String codIdentifica) {
        this.idCliente = idCliente;
        this.codIdentifica = codIdentifica;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
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
    public Collection<Entrega> getEntregaCollection() {
        return entregaCollection;
    }

    public void setEntregaCollection(Collection<Entrega> entregaCollection) {
        this.entregaCollection = entregaCollection;
    }

    @XmlTransient
    public Collection<ContactoDeCliente> getContactoDeClienteCollection() {
        return contactoDeClienteCollection;
    }

    public void setContactoDeClienteCollection(Collection<ContactoDeCliente> contactoDeClienteCollection) {
        this.contactoDeClienteCollection = contactoDeClienteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCliente != null ? idCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.idCliente == null && other.idCliente != null) || (this.idCliente != null && !this.idCliente.equals(other.idCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + ", codIdentifica=" + codIdentifica + ", nombres=" + nombres + ", primerApellido=" + primerApellido + ", segundoApellido=" + segundoApellido + ", entregaCollection=" + entregaCollection + ", contactoDeClienteCollection=" + contactoDeClienteCollection + '}';
    }   
    
}

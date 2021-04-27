
package com.mycompany.transanchezgf.persisJPA;

import java.io.Serializable;
//import java.util.Collection;
//import javax.inject.Named;
import javax.persistence.Basic;
//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
//import javax.persistence.ManyToMany;
//import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
//import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
//import javax.xml.bind.annotation.XmlRootElement;
//import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author SAODRI
 */
@Entity
@Table(name = "credencial_emple")
/**@XmlRootElement*/
@NamedQueries({
    @NamedQuery(name = "CredencialEmple.findAll", query = "SELECT c FROM CredencialEmple c")
    , @NamedQuery(name = "CredencialEmple.findByIdEmple", query = "SELECT c FROM CredencialEmple c WHERE c.idEmple = :idEmple")
    , @NamedQuery(name = "CredencialEmple.findByUsuario", query = "SELECT c FROM CredencialEmple c WHERE c.usuario = :usuario")
    , @NamedQuery(name = "CredencialEmple.findByPassword", query = "SELECT c FROM CredencialEmple c WHERE c.password = :password")
    , @NamedQuery(name = "CredencialEmple.findByDefaultPass", query = "SELECT c FROM CredencialEmple c WHERE c.defaultPass = :defaultPass")})
public class CredencialEmple implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_emple")
    private Integer idEmple;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "usuario")
    private String usuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Column(name = "default_pass")
    private boolean defaultPass;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private boolean estado;
    @JoinColumn(name = "id_emple", referencedColumnName = "id_Empleado", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Empleado empleado;

    public CredencialEmple() {
    }

    public CredencialEmple(Integer idEmple) {
        this.idEmple = idEmple;
    }

    public CredencialEmple(Integer idEmple, String usuario, String password, boolean defaultPass) {
        this.idEmple = idEmple;
        this.usuario = usuario;
        this.password = password;
        this.defaultPass = defaultPass;
    }

    public Integer getIdEmple() {
        return idEmple;
    }

    public void setIdEmple(Integer idEmple) {
        this.idEmple = idEmple;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getDefaultPass() {
        return defaultPass;
    }

    public void setDefaultPass(boolean defaultPass) {
        this.defaultPass = defaultPass;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmple != null ? idEmple.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CredencialEmple)) {
            return false;
        }
        CredencialEmple other = (CredencialEmple) object;
        if ((this.idEmple == null && other.idEmple != null) || (this.idEmple != null && !this.idEmple.equals(other.idEmple))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistence.CredencialEmple[ idEmple=" + idEmple + " ]";
    }
    
}

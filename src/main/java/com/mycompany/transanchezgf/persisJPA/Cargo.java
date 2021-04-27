
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
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
//import javax.persistence.ManyToMany;
//import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
//import javax.persistence.OneToOne;
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
@Table(name = "cargo")
/**@XmlRootElement*/
@NamedQueries({
    @NamedQuery(name = "Cargo.findAll", query = "SELECT c FROM Cargo c")
    , @NamedQuery(name = "Cargo.findByIdCargo", query = "SELECT c FROM Cargo c WHERE c.idCargo = :idCargo")
    , @NamedQuery(name = "Cargo.findByNombreCargo", query = "SELECT c FROM Cargo c WHERE c.nombreCargo = :nombreCargo")
    , @NamedQuery(name = "Cargo.findBySueldo", query = "SELECT c FROM Cargo c WHERE c.sueldo = :sueldo")
    , @NamedQuery(name = "Cargo.findByNivelAcademico", query = "SELECT c FROM Cargo c WHERE c.nivelAcademico = :nivelAcademico")
    , @NamedQuery(name = "Cargo.findByExperiencia", query = "SELECT c FROM Cargo c WHERE c.experiencia = :experiencia")})

public class Cargo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// campo autoIncrementable
    @Basic(optional = false)
    @Column(name = "Id_Cargo")
    private Integer idCargo;
    @Size(max = 45)
    @Column(name = "Nombre_Cargo")
    private String nombreCargo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Sueldo")
    private Double sueldo;
    @Size(max = 45)
    @Column(name = "Nivel_Academico")
    private String nivelAcademico;
    @Size(max = 45)
    @Column(name = "Experiencia")
    private String experiencia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cargoIdCargo")
    private Collection<Empleado> empleadoCollection;

    public Cargo() {
    }

    public Cargo(Integer idCargo) {
        this.idCargo = idCargo;
    }

    public Integer getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(Integer idCargo) {
        this.idCargo = idCargo;
    }

    public String getNombreCargo() {
        return nombreCargo;
    }

    public void setNombreCargo(String nombreCargo) {
        this.nombreCargo = nombreCargo;
    }

    public Double getSueldo() {
        return sueldo;
    }

    public void setSueldo(Double sueldo) {
        this.sueldo = sueldo;
    }

    public String getNivelAcademico() {
        return nivelAcademico;
    }

    public void setNivelAcademico(String nivelAcademico) {
        this.nivelAcademico = nivelAcademico;
    }

    public String getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

    @XmlTransient
    public Collection<Empleado> getEmpleadoCollection() {
        return empleadoCollection;
    }

    public void setEmpleadoCollection(Collection<Empleado> empleadoCollection) {
        this.empleadoCollection = empleadoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCargo != null ? idCargo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cargo)) {
            return false;
        }
        Cargo other = (Cargo) object;
        if ((this.idCargo == null && other.idCargo != null) || (this.idCargo != null && !this.idCargo.equals(other.idCargo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistence.Cargo[ idCargo=" + idCargo + " ]";
    }
    
}

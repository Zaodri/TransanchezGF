
package com.mycompany.transanchezgf.persisJPA;

import java.io.Serializable;
import java.util.Collection;
import javax.inject.Named;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
//import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author SAODRI
 */
    
@Entity
@Named("tranPerson")
@Table(name = "empleado")
/**@XmlRootElement*/
@NamedQueries({
    @NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM Empleado e")
    , @NamedQuery(name = "Empleado.findByIdEmpleado", query = "SELECT e FROM Empleado e WHERE e.idEmpleado = :idEmpleado")
    , @NamedQuery(name = "Empleado.findByCodIdentifica", query = "SELECT e FROM Empleado e WHERE e.codIdentifica = :codIdentifica")
    , @NamedQuery(name = "Empleado.findByNombres", query = "SELECT e FROM Empleado e WHERE e.nombres = :nombres")
    , @NamedQuery(name = "Empleado.findByPrimerApellido", query = "SELECT e FROM Empleado e WHERE e.primerApellido = :primerApellido")
    , @NamedQuery(name = "Empleado.findBySegundoApellido", query = "SELECT e FROM Empleado e WHERE e.segundoApellido = :segundoApellido")
    , @NamedQuery(name = "Empleado.findByTelefono", query = "SELECT e FROM Empleado e WHERE e.telefono = :telefono")
    , @NamedQuery(name = "Empleado.findByDireccion", query = "SELECT e FROM Empleado e WHERE e.direccion = :direccion")
    , @NamedQuery(name = "Empleado.findByEmail", query = "SELECT e FROM Empleado e WHERE e.email = :email")
    , @NamedQuery(name = "Empleado.findByTipoEmpleado", query = "SELECT e FROM Empleado e WHERE e.tipoEmpleado = :tipoEmpleado")})

public class Empleado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Empleado")
    private Integer idEmpleado;
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
    @Column(name = "telefono")
    private Integer telefono;
    @Size(max = 127)
    @Column(name = "Direccion")
    private String direccion;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 127)
    @Column(name = "E_mail")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Tipo_Empleado")
    private int tipoEmpleado;
    @OneToOne(mappedBy = "idempleSolicitud")
    private Mantenimiento mantenimiento;
    @JoinColumn(name = "Cargo_Id_Cargo", referencedColumnName = "Id_Cargo")
    @ManyToOne(optional = false)
    private Cargo cargoIdCargo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleadoIdEmpleado")
    private Collection<ReporteDeRuta> reporteDeRutaCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "empleado")
    private CredencialEmple credencialEmple;

    public Empleado() {
    }

    public Empleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Empleado(Integer idEmpleado, String codIdentifica, int tipoEmpleado) {
        this.idEmpleado = idEmpleado;
        this.codIdentifica = codIdentifica;
        this.tipoEmpleado = tipoEmpleado;
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
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

    public int getTipoEmpleado() {
        return tipoEmpleado;
    }

    public void setTipoEmpleado(int tipoEmpleado) {
        this.tipoEmpleado = tipoEmpleado;
    }

    public Mantenimiento getMantenimiento() {
        return mantenimiento;
    }

    public void setMantenimiento(Mantenimiento mantenimiento) {
        this.mantenimiento = mantenimiento;
    }

    public Cargo getCargoIdCargo() {
        return cargoIdCargo;
    }

    public void setCargoIdCargo(Cargo cargoIdCargo) {
        this.cargoIdCargo = cargoIdCargo;
    }

    @XmlTransient
    public Collection<ReporteDeRuta> getReporteDeRutaCollection() {
        return reporteDeRutaCollection;
    }

    public void setReporteDeRutaCollection(Collection<ReporteDeRuta> reporteDeRutaCollection) {
        this.reporteDeRutaCollection = reporteDeRutaCollection;
    }

    public CredencialEmple getCredencialEmple() {
        return credencialEmple;
    }

    public void setCredencialEmple(CredencialEmple credencialEmple) {
        this.credencialEmple = credencialEmple;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmpleado != null ? idEmpleado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((this.idEmpleado == null && other.idEmpleado != null) || (this.idEmpleado != null && !this.idEmpleado.equals(other.idEmpleado))) {
            return false;
        }
        return true;
    }


    @Override
    public String toString() {
        return "Empleado{" + "idEmpleado=" + idEmpleado + ", codIdentifica=" + codIdentifica + ", nombres=" + nombres + ", primerApellido=" + primerApellido + ", segundoApellido=" + segundoApellido + ", telefono=" + telefono + ", direccion=" + direccion + ", email=" + email + ", tipoEmpleado=" + tipoEmpleado + ", mantenimiento=" + mantenimiento + ", cargoIdCargo=" + cargoIdCargo + ", reporteDeRutaCollection=" + reporteDeRutaCollection + ", credencialEmple=" + credencialEmple + '}';
    }
}

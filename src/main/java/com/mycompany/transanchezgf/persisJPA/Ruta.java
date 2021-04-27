
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
//import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
//import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author SAODRI
 */
@Entity
@Table(name = "ruta")
/**@XmlRootElement*/
@NamedQueries({
    @NamedQuery(name = "Ruta.findAll", query = "SELECT r FROM Ruta r")
    , @NamedQuery(name = "Ruta.findByIdRuta", query = "SELECT r FROM Ruta r WHERE r.idRuta = :idRuta")
    , @NamedQuery(name = "Ruta.findByOrigen", query = "SELECT r FROM Ruta r WHERE r.origen = :origen")
    , @NamedQuery(name = "Ruta.findByDestino", query = "SELECT r FROM Ruta r WHERE r.destino = :destino")})
public class Ruta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_Ruta")
    private Integer idRuta;
    @Size(max = 255)
    @Column(name = "Origen")
    private String origen;
    @Size(max = 255)
    @Column(name = "Destino")
    private String destino;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rutaIdRuta")
    private Collection<ReporteDeRuta> reporteDeRutaCollection;

    public Ruta() {
    }

    public Ruta(Integer idRuta) {
        this.idRuta = idRuta;
    }

    public Integer getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(Integer idRuta) {
        this.idRuta = idRuta;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    @XmlTransient
    public Collection<ReporteDeRuta> getReporteDeRutaCollection() {
        return reporteDeRutaCollection;
    }

    public void setReporteDeRutaCollection(Collection<ReporteDeRuta> reporteDeRutaCollection) {
        this.reporteDeRutaCollection = reporteDeRutaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRuta != null ? idRuta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ruta)) {
            return false;
        }
        Ruta other = (Ruta) object;
        if ((this.idRuta == null && other.idRuta != null) || (this.idRuta != null && !this.idRuta.equals(other.idRuta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistence.Ruta[ idRuta=" + idRuta + " ]";
    }
    
}

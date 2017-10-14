/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "EVENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Evento.findAll", query = "SELECT e FROM Evento e")
    , @NamedQuery(name = "Evento.findByIdevento", query = "SELECT e FROM Evento e WHERE e.idevento = :idevento")
    , @NamedQuery(name = "Evento.findByTema", query = "SELECT e FROM Evento e WHERE e.tema = :tema")
    , @NamedQuery(name = "Evento.findByFechainicio", query = "SELECT e FROM Evento e WHERE e.fechainicio = :fechainicio")
    , @NamedQuery(name = "Evento.findByFechafin", query = "SELECT e FROM Evento e WHERE e.fechafin = :fechafin")})
public class Evento implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "IDEVENTO")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private BigDecimal idevento;
    @Basic(optional = false)
    @Column(name = "TEMA")
    private String tema;
    @Basic(optional = false)
    @Column(name = "FECHAINICIO")
    @Temporal(TemporalType.DATE)
    private Date fechainicio;
    @Basic(optional = false)
    @Column(name = "FECHAFIN")
    @Temporal(TemporalType.DATE)
    private Date fechafin;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eventoIdevento")
    private List<Submision> submisionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eventoIdevento")
    private List<Usuario> usuarioList;

    public Evento() {
    }

    public Evento(BigDecimal idevento) {
        this.idevento = idevento;
    }

    public Evento(BigDecimal idevento, String tema, Date fechainicio, Date fechafin) {
        this.idevento = idevento;
        this.tema = tema;
        this.fechainicio = fechainicio;
        this.fechafin = fechafin;
    }

    public BigDecimal getIdevento() {
        return idevento;
    }

    public void setIdevento(BigDecimal idevento) {
        this.idevento = idevento;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public Date getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

    public Date getFechafin() {
        return fechafin;
    }

    public void setFechafin(Date fechafin) {
        this.fechafin = fechafin;
    }

    @XmlTransient
    public List<Submision> getSubmisionList() {
        return submisionList;
    }

    public void setSubmisionList(List<Submision> submisionList) {
        this.submisionList = submisionList;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idevento != null ? idevento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Evento)) {
            return false;
        }
        Evento other = (Evento) object;
        if ((this.idevento == null && other.idevento != null) || (this.idevento != null && !this.idevento.equals(other.idevento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Evento[ idevento=" + idevento + " ]";
    }
    
}

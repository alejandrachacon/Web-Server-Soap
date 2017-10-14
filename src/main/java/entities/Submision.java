/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "SUBMISION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Submision.findAll", query = "SELECT s FROM Submision s")
//    , @NamedQuery(name = "Submision.findByArticuloIdarticulo", query = "SELECT s FROM Submision s WHERE s.articuloIdarticulo = :articuloIdarticulo")
    , @NamedQuery(name = "Submision.findByIdsubmision", query = "SELECT s FROM Submision s WHERE s.idsubmision = :idsubmision")
    , @NamedQuery(name = "Submision.findByEstado", query = "SELECT s FROM Submision s WHERE s.estado = :estado")
    , @NamedQuery(name = "Submision.findByFechasubida", query = "SELECT s FROM Submision s WHERE s.fechasubida = :fechasubida")})
public class Submision implements Serializable {

    private static final long serialVersionUID = 1L;
//    @Basic(optional = false)
//    @Column(name = "ARTICULO_IDARTICULO")
//    private BigInteger articuloIdarticulo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "IDSUBMISION")
    private BigDecimal idsubmision;
    @Basic(optional = false)
    @Column(name = "ESTADO")
    private String estado;
    @Basic(optional = false)
    @Column(name = "FECHASUBIDA")
    @Temporal(TemporalType.DATE)
    private Date fechasubida;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "submisionIdsubmision")
    private List<Revision> revisionList;
    @JoinColumn(name = "ARTICULO_IDARTICULO2", referencedColumnName = "IDARTICULO")
    @ManyToOne(optional = false)
    private Articulo articuloIdarticulo2;
    @JoinColumn(name = "EVENTO_IDEVENTO", referencedColumnName = "IDEVENTO")
    @ManyToOne(optional = false)
    private Evento eventoIdevento;
    @JoinColumn(name = "USUARIO_IDUSUARIO", referencedColumnName = "IDUSUARIO")
    @ManyToOne(optional = false)
    private Usuario usuarioIdusuario;

    public Submision() {
    }

    public Submision(BigDecimal idsubmision) {
        this.idsubmision = idsubmision;
    }

    public Submision(BigDecimal idsubmision, BigInteger articuloIdarticulo, String estado, Date fechasubida) {
        this.idsubmision = idsubmision;
//        this.articuloIdarticulo = articuloIdarticulo;
        this.estado = estado;
        this.fechasubida = fechasubida;
    }

//    public BigInteger getArticuloIdarticulo() {
//        return articuloIdarticulo;
//    }
//
//    public void setArticuloIdarticulo(BigInteger articuloIdarticulo) {
//        this.articuloIdarticulo = articuloIdarticulo;
//    }

    public BigDecimal getIdsubmision() {
        return idsubmision;
    }

    public void setIdsubmision(BigDecimal idsubmision) {
        this.idsubmision = idsubmision;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechasubida() {
        return fechasubida;
    }

    public void setFechasubida(Date fechasubida) {
        this.fechasubida = fechasubida;
    }

    @XmlTransient
    public List<Revision> getRevisionList() {
        return revisionList;
    }

    public void setRevisionList(List<Revision> revisionList) {
        this.revisionList = revisionList;
    }

    public Articulo getArticuloIdarticulo2() {
        return articuloIdarticulo2;
    }

    public void setArticuloIdarticulo2(Articulo articuloIdarticulo2) {
        this.articuloIdarticulo2 = articuloIdarticulo2;
    }

    public Evento getEventoIdevento() {
        return eventoIdevento;
    }

    public void setEventoIdevento(Evento eventoIdevento) {
        this.eventoIdevento = eventoIdevento;
    }

    public Usuario getUsuarioIdusuario() {
        return usuarioIdusuario;
    }

    public void setUsuarioIdusuario(Usuario usuarioIdusuario) {
        this.usuarioIdusuario = usuarioIdusuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsubmision != null ? idsubmision.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Submision)) {
            return false;
        }
        Submision other = (Submision) object;
        if ((this.idsubmision == null && other.idsubmision != null) || (this.idsubmision != null && !this.idsubmision.equals(other.idsubmision))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Submision[ idsubmision=" + idsubmision + " ]";
    }
    
}

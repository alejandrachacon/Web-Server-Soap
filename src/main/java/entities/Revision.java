/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "REVISION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Revision.findAll", query = "SELECT r FROM Revision r")
    , @NamedQuery(name = "Revision.findByIdrevision", query = "SELECT r FROM Revision r WHERE r.idrevision = :idrevision")
    , @NamedQuery(name = "Revision.findByCalificacion", query = "SELECT r FROM Revision r WHERE r.calificacion = :calificacion")
    , @NamedQuery(name = "Revision.findByComentarios", query = "SELECT r FROM Revision r WHERE r.comentarios = :comentarios")})
public class Revision implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "IDREVISION")
    private BigDecimal idrevision;
    @Basic(optional = false)
    @Column(name = "CALIFICACION")
    private Integer calificacion;
    @Column(name = "COMENTARIOS")
    private String comentarios;
    @JoinColumn(name = "SUBMISION_IDSUBMISION", referencedColumnName = "IDSUBMISION")
    @ManyToOne(optional = false)
    private Submision submisionIdsubmision;
    @JoinColumn(name = "USUARIO_IDUSUARIO", referencedColumnName = "IDUSUARIO")
    @ManyToOne(optional = false)
    private Usuario usuarioIdusuario;

    public Revision() {
    }

    public Revision(BigDecimal idrevision) {
        this.idrevision = idrevision;
    }

    public Revision(BigDecimal idrevision, Integer calificacion) {
        this.idrevision = idrevision;
        this.calificacion = calificacion;
    }

    public BigDecimal getIdrevision() {
        return idrevision;
    }

    public void setIdrevision(BigDecimal idrevision) {
        this.idrevision = idrevision;
    }

    public Integer getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public Submision getSubmisionIdsubmision() {
        return submisionIdsubmision;
    }

    public void setSubmisionIdsubmision(Submision submisionIdsubmision) {
        this.submisionIdsubmision = submisionIdsubmision;
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
        hash += (idrevision != null ? idrevision.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Revision)) {
            return false;
        }
        Revision other = (Revision) object;
        if ((this.idrevision == null && other.idrevision != null) || (this.idrevision != null && !this.idrevision.equals(other.idrevision))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Revision[ idrevision=" + idrevision + " ]";
    }
    
}

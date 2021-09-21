/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package konrad.entity;

import java.io.Serializable;
import java.util.Collection;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name = "asunto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Asunto.findAll", query = "SELECT a FROM Asunto a"),
    @NamedQuery(name = "Asunto.findByCodAsunto", query = "SELECT a FROM Asunto a WHERE a.codAsunto = :codAsunto"),
    @NamedQuery(name = "Asunto.findByTitulo", query = "SELECT a FROM Asunto a WHERE a.titulo = :titulo")})
public class Asunto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_asunto")
    private Integer codAsunto;
    @Basic(optional = false)
    @Column(name = "titulo")
    private String titulo;

    public Asunto() {
    }

    public Asunto(Integer codAsunto) {
        this.codAsunto = codAsunto;
    }

    public Asunto(Integer codAsunto, String titulo) {
        this.codAsunto = codAsunto;
        this.titulo = titulo;
    }

    public Integer getCodAsunto() {
        return codAsunto;
    }

    public void setCodAsunto(Integer codAsunto) {
        this.codAsunto = codAsunto;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codAsunto != null ? codAsunto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asunto)) {
            return false;
        }
        Asunto other = (Asunto) object;
        if ((this.codAsunto == null && other.codAsunto != null) || (this.codAsunto != null && !this.codAsunto.equals(other.codAsunto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "konrad.entity.Asunto[ codAsunto=" + codAsunto + " ]";
    }

}

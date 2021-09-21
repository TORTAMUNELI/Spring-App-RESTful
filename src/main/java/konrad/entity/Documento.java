/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package konrad.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name = "documento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Documento.findAll", query = "SELECT d FROM Documento d"),
    @NamedQuery(name = "Documento.findByCodDocumento", query = "SELECT d FROM Documento d WHERE d.codDocumento = :codDocumento"),
    @NamedQuery(name = "Documento.findByNombre", query = "SELECT d FROM Documento d WHERE d.nombre = :nombre"),
    @NamedQuery(name = "Documento.findByFechaDocumento", query = "SELECT d FROM Documento d WHERE d.fechaDocumento = :fechaDocumento"),
    @NamedQuery(name = "Documento.findByFechaRadicado", query = "SELECT d FROM Documento d WHERE d.fechaRadicado = :fechaRadicado"),
    @NamedQuery(name = "Documento.findByComentarios", query = "SELECT d FROM Documento d WHERE d.comentarios = :comentarios"),
    @NamedQuery(name = "Documento.findByOrigen", query = "SELECT d FROM Documento d WHERE d.origen = :origen"),
    @NamedQuery(name = "Documento.findByEstado", query = "SELECT d FROM Documento d WHERE d.estado = :estado"),
    @NamedQuery(name = "Documento.findByAnexo", query = "SELECT d FROM Documento d WHERE d.anexo = :anexo")})
public class Documento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_documento")
    private Integer codDocumento;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "fecha_documento")
    @Temporal(TemporalType.DATE)
    private Date fechaDocumento;
    @Column(name = "fecha_radicado")
    @Temporal(TemporalType.DATE)
    private Date fechaRadicado;
    @Column(name = "comentarios")
    private String comentarios;
    @Basic(optional = false)
    @Column(name = "origen")
    private String origen;
    @Basic(optional = false)
    @Column(name = "estado")
    private boolean estado;
    @Column(name = "anexo")
    private String anexo;
    @JoinColumn(name = "cod_asunto", referencedColumnName = "cod_asunto")
    @ManyToOne(optional = false)
    private Asunto codAsunto;
    @JoinColumn(name = "cod_destinatario", referencedColumnName = "cod_usuario")
    @ManyToOne(optional = false)
    private Usuario codDestinatario;
    @JoinColumn(name = "cod_remitente", referencedColumnName = "cod_usuario")
    @ManyToOne(optional = false)
    private Usuario codRemitente;

    public Documento() {
    }

    public Documento(Integer codDocumento) {
        this.codDocumento = codDocumento;
    }

    public Documento(Integer codDocumento, String nombre, Date fechaDocumento, String origen, boolean estado) {
        this.codDocumento = codDocumento;
        this.nombre = nombre;
        this.fechaDocumento = fechaDocumento;
        this.origen = origen;
        this.estado = estado;
    }

    public Integer getCodDocumento() {
        return codDocumento;
    }

    public void setCodDocumento(Integer codDocumento) {
        this.codDocumento = codDocumento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaDocumento() {
        return fechaDocumento;
    }

    public void setFechaDocumento(Date fechaDocumento) {
        this.fechaDocumento = fechaDocumento;
    }

    public Date getFechaRadicado() {
        return fechaRadicado;
    }

    public void setFechaRadicado(Date fechaRadicado) {
        this.fechaRadicado = fechaRadicado;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getAnexo() {
        return anexo;
    }

    public void setAnexo(String anexo) {
        this.anexo = anexo;
    }

    public Asunto getCodAsunto() {
        return codAsunto;
    }

    public void setCodAsunto(Asunto codAsunto) {
        this.codAsunto = codAsunto;
    }

    public Usuario getCodDestinatario() {
        return codDestinatario;
    }

    public void setCodDestinatario(Usuario codDestinatario) {
        this.codDestinatario = codDestinatario;
    }

    public Usuario getCodRemitente() {
        return codRemitente;
    }

    public void setCodRemitente(Usuario codRemitente) {
        this.codRemitente = codRemitente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codDocumento != null ? codDocumento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Documento)) {
            return false;
        }
        Documento other = (Documento) object;
        if ((this.codDocumento == null && other.codDocumento != null) || (this.codDocumento != null && !this.codDocumento.equals(other.codDocumento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "konrad.entity.Documento[ codDocumento=" + codDocumento + " ]";
    }
    
}

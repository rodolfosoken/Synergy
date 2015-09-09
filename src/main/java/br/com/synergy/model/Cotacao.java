package br.com.synergy.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "cotacao", catalog = "sistema_gestao")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Cotacao implements java.io.Serializable {


	private static final long serialVersionUID = 1L;
	private Long idcotacao;
	private Date dataInicio;
	private Date dataTermino;
	private Date dataPrevisao;
	private String descricao;
	private Boolean concluida;
	private Boolean comprado;
	private Usuario usuario;
	private Usuario responsavel;

	public Cotacao() {
	}

	public Cotacao(String descricao) {
		this.descricao = descricao;
	}


	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idcotacao", unique = true, nullable = false)
	public Long getIdcotacao() {
		return this.idcotacao;
	}


	public void setIdcotacao(Long idcotacao) {
		this.idcotacao = idcotacao;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "data_inicio")
	public Date getDataInicio() {
		return this.dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	@Column(name = "data_termino")
	public Date getDataTermino() {
		return this.dataTermino;
	}

	public void setDataTermino(Date dataTermino) {
		this.dataTermino = dataTermino;
	}

	@Column(name="data_previsao")
	public Date getDataPrevisao() {
		return dataPrevisao;
	}
	
	public void setDataPrevisao(Date dataPrevisao) {
		this.dataPrevisao = dataPrevisao;
	}

	@Column(name = "descricao", nullable = false, length = 45)
	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Column(name = "concluida")
	public Boolean getConcluida() {
		return this.concluida;
	}

	public void setConcluida(Boolean concluida) {
		this.concluida = concluida;
	}

	@Column(name="comprado")
	public Boolean getComprado() {
		return comprado;
	}

	public void setComprado(Boolean comprado) {
		this.comprado = comprado;
	}

	@OneToOne
	@JoinColumn(name="usuario_idusuario")
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@OneToOne
	@JoinColumn(name = "usuario_responsavel", nullable = false)
	public Usuario getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Usuario responsavel) {
		this.responsavel = responsavel;
	}

	
	


}

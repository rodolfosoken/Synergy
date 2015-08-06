package br.com.synergy.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "cotacao", catalog = "sistema_gestao")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Cotacao implements java.io.Serializable {

	private Long idcotacao;
	private String responsavel;
	private Date dataInicio;
	private String dataTermino;
	private String descricao;
	private Boolean concluida;

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

	@Column(name = "responsavel")
	public String getResponsavel() {
		return this.responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "data_inicio", length = 10)
	public Date getDataInicio() {
		return this.dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	@Column(name = "data_termino", length = 45)
	public String getDataTermino() {
		return this.dataTermino;
	}

	public void setDataTermino(String dataTermino) {
		this.dataTermino = dataTermino;
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


}

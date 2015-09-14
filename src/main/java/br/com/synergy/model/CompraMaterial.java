package br.com.synergy.model;


import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "compra_material", catalog = "sistema_gestao")
public class CompraMaterial implements java.io.Serializable {


	private static final long serialVersionUID = 1L;
	private Long idcompraMaterial;
	private Pep pep;
	private Boolean okPrazo;
	private Boolean okEspec;
	private Boolean okVisita;
	private Boolean okAssist;
	private Date dataAquisicao;
	private Double preco;
	private CotacaoMaterial cotacaoMaterial;
	private ParticipanteMaterial participante;

	public CompraMaterial() {
	}


	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idcompra_material", unique = true, nullable = false)
	public Long getIdcompraMaterial() {
		return this.idcompraMaterial;
	}

	public void setIdcompraMaterial(Long idcompraMaterial) {
		this.idcompraMaterial = idcompraMaterial;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "pep_idpep", referencedColumnName = "idpep", nullable = false)
	public Pep getPep() {
		return this.pep;
	}

	public void setPep(Pep pep) {
		this.pep = pep;
	}

	@Column(name = "ok_prazo")
	public Boolean getOkPrazo() {
		return this.okPrazo;
	}

	public void setOkPrazo(Boolean okPrazo) {
		this.okPrazo = okPrazo;
	}

	@Column(name = "ok_espec")
	public Boolean getOkEspec() {
		return this.okEspec;
	}

	public void setOkEspec(Boolean okEspec) {
		this.okEspec = okEspec;
	}

	@Column(name = "ok_visita")
	public Boolean getOkVisita() {
		return this.okVisita;
	}

	public void setOkVisita(Boolean okVisita) {
		this.okVisita = okVisita;
	}

	@Column(name = "ok_assist")
	public Boolean getOkAssist() {
		return this.okAssist;
	}

	public void setOkAssist(Boolean okAssist) {
		this.okAssist = okAssist;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "data_aquisicao", length = 10)
	public Date getDataAquisicao() {
		return this.dataAquisicao;
	}

	public void setDataAquisicao(Date dataAquisicao) {
		this.dataAquisicao = dataAquisicao;
	}

	@Column(name = "preco", precision = 22, scale = 0)
	public Double getPreco() {
		return this.preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	@OneToOne(mappedBy="compraMaterial")
	public CotacaoMaterial getCotacaoMaterial() {
		return cotacaoMaterial;
	}


	public void setCotacaoMaterial(CotacaoMaterial cotacaoMaterial) {
		this.cotacaoMaterial = cotacaoMaterial;
	}

	@NotNull
	@OneToOne
	@JoinColumn(name="idparticipante")
	public ParticipanteMaterial getParticipante() {
		return participante;
	}


	public void setParticipante(ParticipanteMaterial participante) {
		this.participante = participante;
	}
	
	
	

}

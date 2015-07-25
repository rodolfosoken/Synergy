package br.com.synergy.model;

// Generated 25/07/2015 13:37:07 by Hibernate Tools 4.3.1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * FornecimentoMaterial generated by hbm2java
 */
@Entity
@Table(name = "fornecimento_material", catalog = "sistema_gestao")
public class FornecimentoMaterial implements java.io.Serializable {

	private Integer idfornecimentoMaterial;
	private CotacaoMaterial cotacaoMaterial;
	private Pep pep;
	private Boolean okPrazo;
	private Boolean okEspec;
	private Boolean okVisita;
	private Boolean okAssist;
	private Date data;

	public FornecimentoMaterial() {
	}

	public FornecimentoMaterial(CotacaoMaterial cotacaoMaterial, Pep pep) {
		this.cotacaoMaterial = cotacaoMaterial;
		this.pep = pep;
	}

	public FornecimentoMaterial(CotacaoMaterial cotacaoMaterial, Pep pep,
			Boolean okPrazo, Boolean okEspec, Boolean okVisita,
			Boolean okAssist, Date data) {
		this.cotacaoMaterial = cotacaoMaterial;
		this.pep = pep;
		this.okPrazo = okPrazo;
		this.okEspec = okEspec;
		this.okVisita = okVisita;
		this.okAssist = okAssist;
		this.data = data;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idfornecimento_material", unique = true, nullable = false)
	public Integer getIdfornecimentoMaterial() {
		return this.idfornecimentoMaterial;
	}

	public void setIdfornecimentoMaterial(Integer idfornecimentoMaterial) {
		this.idfornecimentoMaterial = idfornecimentoMaterial;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cotacao_material_idcotacao", nullable = false)
	public CotacaoMaterial getCotacaoMaterial() {
		return this.cotacaoMaterial;
	}

	public void setCotacaoMaterial(CotacaoMaterial cotacaoMaterial) {
		this.cotacaoMaterial = cotacaoMaterial;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "pep_idpep", referencedColumnName = "idpep", nullable = false),
			@JoinColumn(name = "pep_Conta_idConta", referencedColumnName = "Conta_idConta", nullable = false) })
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
	@Column(name = "data", length = 10)
	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}

}

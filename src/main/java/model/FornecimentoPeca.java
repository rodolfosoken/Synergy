package model;

// Generated 23/07/2015 04:16:30 by Hibernate Tools 4.3.1

import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * FornecimentoPeca generated by hbm2java
 */
@Entity
@Table(name = "fornecimento_peca", catalog = "sistema_gestao")
public class FornecimentoPeca implements java.io.Serializable {

	private FornecimentoPecaId id;
	private CotacaoPeca cotacaoPeca;
	private Boolean okPrazo;
	private Boolean okEspec;
	private Boolean okVisita;
	private Boolean okAssist;
	private Date data;
	private String pep;

	public FornecimentoPeca() {
	}

	public FornecimentoPeca(FornecimentoPecaId id, CotacaoPeca cotacaoPeca) {
		this.id = id;
		this.cotacaoPeca = cotacaoPeca;
	}

	public FornecimentoPeca(FornecimentoPecaId id, CotacaoPeca cotacaoPeca,
			Boolean okPrazo, Boolean okEspec, Boolean okVisita,
			Boolean okAssist, Date data, String pep) {
		this.id = id;
		this.cotacaoPeca = cotacaoPeca;
		this.okPrazo = okPrazo;
		this.okEspec = okEspec;
		this.okVisita = okVisita;
		this.okAssist = okAssist;
		this.data = data;
		this.pep = pep;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "idfornecimentoPeca", column = @Column(name = "idfornecimento_peca", nullable = false)),
			@AttributeOverride(name = "cotacaoPecaIdcotacao", column = @Column(name = "cotacao_peca_idcotacao", nullable = false)) })
	public FornecimentoPecaId getId() {
		return this.id;
	}

	public void setId(FornecimentoPecaId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cotacao_peca_idcotacao", nullable = false, insertable = false, updatable = false)
	public CotacaoPeca getCotacaoPeca() {
		return this.cotacaoPeca;
	}

	public void setCotacaoPeca(CotacaoPeca cotacaoPeca) {
		this.cotacaoPeca = cotacaoPeca;
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

	@Column(name = "pep")
	public String getPep() {
		return this.pep;
	}

	public void setPep(String pep) {
		this.pep = pep;
	}

}

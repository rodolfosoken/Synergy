package br.com.synergy.model;


import static javax.persistence.GenerationType.IDENTITY;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;


@Entity
@Table(name = "conjunto", catalog = "sistema_gestao")
public class Conjunto implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Long idconjunto;
	private String pnLess;
	private String desc;
	private String upcFna;
	private String fnaDesc;
	private List<Montagem> montagems = new ArrayList<Montagem>(0);
	private List<Projeto> projetos = new ArrayList<Projeto>(0);
	private List<Ferramenta> ferramentas = new ArrayList<Ferramenta>();
	private List<Peca> pecas = new ArrayList<Peca>();
	private List<RiskAssesment> riskAssesments = new ArrayList<RiskAssesment>(0);

	public Conjunto() {
	}

	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idconjunto", unique = true, nullable = false)
	public Long getIdconjunto() {
		return this.idconjunto;
	}

	public void setIdconjunto(Long idconjunto) {
		this.idconjunto = idconjunto;
	}
	
	@NotNull
	@NotBlank
	@Column(name = "pn", nullable = false)
	public String getPnLess() {
		return this.pnLess;
	}

	public void setPnLess(String pnLess) {
		this.pnLess = pnLess;
	}
	
	@NotNull
	@NotBlank
	@Column(name = "descricao")
	public String getDesc() {
		return this.desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Column(name = "upc_fna")
	public String getUpcFna() {
		return this.upcFna;
	}

	public void setUpcFna(String upcFna) {
		this.upcFna = upcFna;
	}

	@Column(name = "fna_descricao")
	public String getFnaDesc() {
		return this.fnaDesc;
	}

	public void setFnaDesc(String fnaDesc) {
		this.fnaDesc = fnaDesc;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "conjunto", cascade = CascadeType.ALL)
	public List<Montagem> getMontagems() {
		return this.montagems;
	}

	public void setMontagems(List<Montagem> montagems) {
		this.montagems = montagems;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "projeto_has_conjunto", catalog = "sistema_gestao", joinColumns = { @JoinColumn(name = "conjunto_idconjunto", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "projeto_idprojeto", nullable = false, updatable = false) })
	public List<Projeto> getProjetos() {
		return this.projetos;
	}

	public void setProjetos(List<Projeto> projetos) {
		this.projetos = projetos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "conjunto")
	public List<RiskAssesment> getRiskAssesments() {
		return this.riskAssesments;
	}

	public void setRiskAssesments(List<RiskAssesment> riskAssesments) {
		this.riskAssesments = riskAssesments;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "conjunto_has_ferramenta", catalog = "sistema_gestao", joinColumns = { @JoinColumn(name = "conjunto_idconjunto", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "ferramenta_idferramenta", nullable = false, updatable = false) })
	public List<Ferramenta> getFerramentas() {
		return ferramentas;
	}


	public void setFerramentas(List<Ferramenta> ferramentas) {
		this.ferramentas = ferramentas;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "conjunto_has_peca", catalog = "sistema_gestao", joinColumns = { @JoinColumn(name = "conjunto_idconjunto", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "peca_idpeca", nullable = false, updatable = false) })
	public List<Peca> getPecas() {
		return pecas;
	}


	public void setPecas(List<Peca> pecas) {
		this.pecas = pecas;
	}
	
	

}

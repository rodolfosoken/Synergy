package br.com.synergy.model;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.CascadeType;
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
	private Set<Montagem> montagems = new HashSet<Montagem>(0);
	private Set<Projeto> projetos = new HashSet<Projeto>(0);
	private Set<RiskAssesment> riskAssesments = new HashSet<RiskAssesment>(0);

	public Conjunto() {
	}

	public Conjunto(String pnLess) {
		this.pnLess = pnLess;
	}

	public Conjunto(String pnLess, String desc, String upcFna, String fnaDesc,
			Set<Montagem> montagems, Set<Projeto> projetos,
			Set<RiskAssesment> riskAssesments) {
		this.pnLess = pnLess;
		this.desc = desc;
		this.upcFna = upcFna;
		this.fnaDesc = fnaDesc;
		this.montagems = montagems;
		this.projetos = projetos;
		this.riskAssesments = riskAssesments;
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
	public Set<Montagem> getMontagems() {
		return this.montagems;
	}

	public void setMontagems(Set<Montagem> montagems) {
		this.montagems = montagems;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "projeto_has_conjunto", catalog = "sistema_gestao", joinColumns = { @JoinColumn(name = "conjunto_idconjunto", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "projeto_idprojeto", nullable = false, updatable = false) })
	public Set<Projeto> getProjetos() {
		return this.projetos;
	}

	public void setProjetos(Set<Projeto> projetos) {
		this.projetos = projetos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "conjunto")
	public Set<RiskAssesment> getRiskAssesments() {
		return this.riskAssesments;
	}

	public void setRiskAssesments(Set<RiskAssesment> riskAssesments) {
		this.riskAssesments = riskAssesments;
	}

}

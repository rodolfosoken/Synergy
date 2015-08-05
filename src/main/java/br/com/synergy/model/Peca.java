package br.com.synergy.model;


import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name = "peca", catalog = "sistema_gestao")
public class Peca implements java.io.Serializable {


	private static final long serialVersionUID = 1L;
	private Long idpeca;
	private Material material;
	private String pnLess;
	private String partName;
	private String desc;
	private String upcFna;
	private Set<Montagem> montagems = new HashSet<Montagem>(0);
	private Set<CotacaoPeca> cotacaoPecas = new HashSet<CotacaoPeca>(0);

	public Peca() {
	}

	public Peca(Material material) {
		this.material = material;
	}

	public Peca(Material material, String pnLess, String partName, String desc,
			String upcFna, Set<Montagem> montagems,
			Set<CotacaoPeca> cotacaoPecas) {
		this.material = material;
		this.pnLess = pnLess;
		this.partName = partName;
		this.desc = desc;
		this.upcFna = upcFna;
		this.montagems = montagems;
		this.cotacaoPecas = cotacaoPecas;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idpeca", unique = true, nullable = false)
	public Long getIdpeca() {
		return this.idpeca;
	}

	public void setIdpeca(Long idpeca) {
		this.idpeca = idpeca;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "material_idmaterial", nullable = false)
	public Material getMaterial() {
		return this.material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	@NotEmpty
	@Column(name = "pn")
	public String getPnLess() {
		return this.pnLess;
	}

	public void setPnLess(String pnLess) {
		this.pnLess = pnLess;
	}

	@NotEmpty
	@Column(name = "part_name")
	public String getPartName() {
		return this.partName;
	}

	public void setPartName(String partName) {
		this.partName = partName;
	}

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

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "montagem_has_peca", catalog = "sistema_gestao", joinColumns = { @JoinColumn(name = "peca_idpeca", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "montagem_idmontagem", nullable = false, updatable = false) })
	public Set<Montagem> getMontagems() {
		return this.montagems;
	}

	public void setMontagems(Set<Montagem> montagems) {
		this.montagems = montagems;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "cotacao_peca_has_peca", catalog = "sistema_gestao", joinColumns = { @JoinColumn(name = "peca_idpeca", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "cotacao_peca_idcotacao", nullable = false, updatable = false) })
	public Set<CotacaoPeca> getCotacaoPecas() {
		return this.cotacaoPecas;
	}

	public void setCotacaoPecas(Set<CotacaoPeca> cotacaoPecas) {
		this.cotacaoPecas = cotacaoPecas;
	}

}

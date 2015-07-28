package br.com.synergy.model;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name = "ferramenta", catalog = "sistema_gestao")
public class Ferramenta implements java.io.Serializable {


	private static final long serialVersionUID = 1L;
	private Long idferramenta;
	private CotacaoFerramenta cotacaoFerramenta;
	private String idEquipament;
	private String nome;
	private Double length;
	private Double height;
	private Double width;
	private Double partPerHour;
	private String utilidade;
	private Integer cycle;
	private Double areaStack;
	private Double area;
	private Integer maxStack;
	private String desc;
	private Set<Montagem> montagems = new HashSet<Montagem>(0);

	public Ferramenta() {
	}

	public Ferramenta(CotacaoFerramenta cotacaoFerramenta, String idEquipament) {
		this.cotacaoFerramenta = cotacaoFerramenta;
		this.idEquipament = idEquipament;
	}

	public Ferramenta(CotacaoFerramenta cotacaoFerramenta, String idEquipament,
			String nome, Double length, Double height, Double width,
			Double partPerHour, String utilidade, Integer cycle,
			Double areaStack, Double area, Integer maxStack, String desc,
			Set<Montagem> montagems) {
		this.cotacaoFerramenta = cotacaoFerramenta;
		this.idEquipament = idEquipament;
		this.nome = nome;
		this.length = length;
		this.height = height;
		this.width = width;
		this.partPerHour = partPerHour;
		this.utilidade = utilidade;
		this.cycle = cycle;
		this.areaStack = areaStack;
		this.area = area;
		this.maxStack = maxStack;
		this.desc = desc;
		this.montagems = montagems;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idferramenta", unique = true, nullable = false)
	public Long getIdferramenta() {
		return this.idferramenta;
	}

	public void setIdferramenta(Long idferramenta) {
		this.idferramenta = idferramenta;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cotacao_ferramenta_idcotacao", nullable = false)
	public CotacaoFerramenta getCotacaoFerramenta() {
		return this.cotacaoFerramenta;
	}

	public void setCotacaoFerramenta(CotacaoFerramenta cotacaoFerramenta) {
		this.cotacaoFerramenta = cotacaoFerramenta;
	}

	@NotEmpty
	@Column(name = "id_equipament", nullable = false)
	public String getIdEquipament() {
		return this.idEquipament;
	}

	public void setIdEquipament(String idEquipament) {
		this.idEquipament = idEquipament;
	}

	@Column(name = "nome")
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name = "length", precision = 22, scale = 0)
	public Double getLength() {
		return this.length;
	}

	public void setLength(Double length) {
		this.length = length;
	}

	@Column(name = "height", precision = 22, scale = 0)
	public Double getHeight() {
		return this.height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	@Column(name = "width", precision = 22, scale = 0)
	public Double getWidth() {
		return this.width;
	}

	public void setWidth(Double width) {
		this.width = width;
	}

	@Column(name = "part_per_hour", precision = 22, scale = 0)
	public Double getPartPerHour() {
		return this.partPerHour;
	}

	public void setPartPerHour(Double partPerHour) {
		this.partPerHour = partPerHour;
	}

	@Column(name = "utilidade")
	public String getUtilidade() {
		return this.utilidade;
	}

	public void setUtilidade(String utilidade) {
		this.utilidade = utilidade;
	}

	@Column(name = "cycle")
	public Integer getCycle() {
		return this.cycle;
	}

	public void setCycle(Integer cycle) {
		this.cycle = cycle;
	}

	@Column(name = "area_stack", precision = 22, scale = 0)
	public Double getAreaStack() {
		return this.areaStack;
	}

	public void setAreaStack(Double areaStack) {
		this.areaStack = areaStack;
	}

	@Column(name = "area", precision = 22, scale = 0)
	public Double getArea() {
		return this.area;
	}

	public void setArea(Double area) {
		this.area = area;
	}

	@Column(name = "max_stack")
	public Integer getMaxStack() {
		return this.maxStack;
	}

	public void setMaxStack(Integer maxStack) {
		this.maxStack = maxStack;
	}

	@Column(name = "descricao")
	public String getDesc() {
		return this.desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "montagem_has_ferramenta", catalog = "sistema_gestao", joinColumns = { @JoinColumn(name = "ferramenta_idferramenta", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "montagem_idmontagem", nullable = false, updatable = false) })
	public Set<Montagem> getMontagems() {
		return this.montagems;
	}

	public void setMontagems(Set<Montagem> montagems) {
		this.montagems = montagems;
	}

}

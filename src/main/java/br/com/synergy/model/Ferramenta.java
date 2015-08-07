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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ferramenta", catalog = "sistema_gestao")
public class Ferramenta implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long idferramenta;
	private ParticipanteFerramenta participanteFerramenta;
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
	private String descricao;
	private Double valor;
	private Set<Montagem> montagems = new HashSet<Montagem>(0);
	private Set<CompraFerramenta> compraFerramentas = new HashSet<CompraFerramenta>(
			0);

	public Ferramenta() {
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
	@JoinColumn(name = "idparticipante_ferramenta", nullable = false)
	public ParticipanteFerramenta getParticipanteFerramenta() {
		return this.participanteFerramenta;
	}

	public void setParticipanteFerramenta(
			ParticipanteFerramenta participanteFerramenta) {
		this.participanteFerramenta = participanteFerramenta;
	}

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
	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@Column(name="valor")
	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ferramenta")
	public Set<Montagem> getMontagems() {
		return this.montagems;
	}

	public void setMontagems(Set<Montagem> montagems) {
		this.montagems = montagems;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ferramenta")
	public Set<CompraFerramenta> getCompraFerramentas() {
		return this.compraFerramentas;
	}

	public void setCompraFerramentas(Set<CompraFerramenta> compraFerramentas) {
		this.compraFerramentas = compraFerramentas;
	}

}

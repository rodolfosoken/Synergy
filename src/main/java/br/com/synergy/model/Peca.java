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
@Table(name = "peca", catalog = "sistema_gestao")
public class Peca implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Long idpeca;
	private ParticipantePeca participantePeca;
	private Material material;
	private String pn;
	private String partName;
	private String descricao;
	private String upcFna;
	private Double valor;
	private Set<CompraPeca> compraPecas = new HashSet<CompraPeca>(0);
	private Set<Montagem> montagems = new HashSet<Montagem>(0);

	public Peca() {
	}

	public Peca(Material material) {
		this.material = material;
	}

	public Peca(ParticipantePeca participantePeca, Material material,
			String pn, String partName, String descricao, String upcFna,
			Set<CompraPeca> compraPecas, Set<Montagem> montagems) {
		this.participantePeca = participantePeca;
		this.material = material;
		this.pn = pn;
		this.partName = partName;
		this.descricao = descricao;
		this.upcFna = upcFna;
		this.compraPecas = compraPecas;
		this.montagems = montagems;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "participante_peca_idparticipante_peca")
	public ParticipantePeca getParticipantePeca() {
		return this.participantePeca;
	}

	public void setParticipantePeca(ParticipantePeca participantePeca) {
		this.participantePeca = participantePeca;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "material_idmaterial", nullable = false)
	public Material getMaterial() {
		return this.material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	@Column(name = "pn")
	public String getPn() {
		return this.pn;
	}

	public void setPn(String pn) {
		this.pn = pn;
	}

	@Column(name = "part_name")
	public String getPartName() {
		return this.partName;
	}

	public void setPartName(String partName) {
		this.partName = partName;
	}

	@Column(name = "descricao")
	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Column(name = "upc_fna")
	public String getUpcFna() {
		return this.upcFna;
	}

	public void setUpcFna(String upcFna) {
		this.upcFna = upcFna;
	}
	
	@Column(name="valor")
	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "peca")
	public Set<CompraPeca> getCompraPecas() {
		return this.compraPecas;
	}

	public void setCompraPecas(Set<CompraPeca> compraPecas) {
		this.compraPecas = compraPecas;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "peca")
	public Set<Montagem> getMontagems() {
		return this.montagems;
	}

	public void setMontagems(Set<Montagem> montagems) {
		this.montagems = montagems;
	}

}

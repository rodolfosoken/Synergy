package br.com.synergy.model;

// Generated 23/07/2015 04:16:30 by Hibernate Tools 4.3.1

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
import javax.persistence.Table;

/**
 * FornecedorPeca generated by hbm2java
 */
@Entity
@Table(name = "fornecedor_peca", catalog = "sistema_gestao")
public class FornecedorPeca implements java.io.Serializable {

	private Long idfornecedorPeca;
	private String cnpj;
	private String nome;
	private String contato;
	private String email;
	private String linkSharepoint;
	private String obs;
	private String celular;
	private String telefone;
	private String site;
	private String logradouro;
	private String numero;
	private String bairro;
	private String cep;
	private String estado;
	private String complemento;
	private Set<CotacaoPeca> cotacaoPecas = new HashSet<CotacaoPeca>(0);

	public FornecedorPeca() {
	}

	public FornecedorPeca(String cnpj) {
		this.cnpj = cnpj;
	}

	public FornecedorPeca(String cnpj, String nome, String contato,
			String email, String linkSharepoint, String obs, String celular,
			String telefone, String site, String logradouro, String numero,
			String bairro, String cep, String estado, String complemento,
			Set<CotacaoPeca> cotacaoPecas) {
		this.cnpj = cnpj;
		this.nome = nome;
		this.contato = contato;
		this.email = email;
		this.linkSharepoint = linkSharepoint;
		this.obs = obs;
		this.celular = celular;
		this.telefone = telefone;
		this.site = site;
		this.logradouro = logradouro;
		this.numero = numero;
		this.bairro = bairro;
		this.cep = cep;
		this.estado = estado;
		this.complemento = complemento;
		this.cotacaoPecas = cotacaoPecas;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idfornecedor_peca", unique = true, nullable = false)
	public Long getIdfornecedorPeca() {
		return this.idfornecedorPeca;
	}

	public void setIdfornecedorPeca(Long idfornecedorPeca) {
		this.idfornecedorPeca = idfornecedorPeca;
	}

	@Column(name = "cnpj", nullable = false, length = 18)
	public String getCnpj() {
		return this.cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	@Column(name = "nome")
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name = "contato")
	public String getContato() {
		return this.contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	@Column(name = "email")
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "link_sharepoint")
	public String getLinkSharepoint() {
		return this.linkSharepoint;
	}

	public void setLinkSharepoint(String linkSharepoint) {
		this.linkSharepoint = linkSharepoint;
	}

	@Column(name = "obs")
	public String getObs() {
		return this.obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	@Column(name = "celular", length = 45)
	public String getCelular() {
		return this.celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	@Column(name = "telefone", length = 45)
	public String getTelefone() {
		return this.telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Column(name = "site")
	public String getSite() {
		return this.site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	@Column(name = "logradouro")
	public String getLogradouro() {
		return this.logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	@Column(name = "numero", length = 45)
	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	@Column(name = "bairro")
	public String getBairro() {
		return this.bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	@Column(name = "cep", length = 8)
	public String getCep() {
		return this.cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	@Column(name = "estado", length = 45)
	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Column(name = "complemento")
	public String getComplemento() {
		return this.complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "cotacao_peca_has_fornecedor_peca", catalog = "sistema_gestao", joinColumns = { @JoinColumn(name = "fornecedor_peca_idfornecedor_peca", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "cotacao_peca_idcotacao", nullable = false, updatable = false) })
	public Set<CotacaoPeca> getCotacaoPecas() {
		return this.cotacaoPecas;
	}

	public void setCotacaoPecas(Set<CotacaoPeca> cotacaoPecas) {
		this.cotacaoPecas = cotacaoPecas;
	}

}

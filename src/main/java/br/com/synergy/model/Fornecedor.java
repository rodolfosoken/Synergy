package br.com.synergy.model;


import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CNPJ;


@Entity
@Table(name = "fornecedor", catalog = "sistema_gestao")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TIPO_FORNECEDOR", discriminatorType=DiscriminatorType.STRING)
public abstract class Fornecedor implements java.io.Serializable {


	private static final long serialVersionUID = 1L;
	private Long idfornecedor;
	private String cnpj;
	private String nome;
	private String contato;
	private String cargo;
	private String email;
	private String linkSharepoint;
	private String obs;
	private String celular;
	private String telefone;
	private String site;
	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro;
	private String cep;
	private String estado;
	private String tipoFornecedor;


	public Fornecedor() {
	}


	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idfornecedor", unique = true, nullable = false)
	public Long getIdfornecedor() {
		return this.idfornecedor;
	}

	public void setIdfornecedor(Long idfornecedor) {
		this.idfornecedor = idfornecedor;
	}
	
	@CNPJ
	@NotNull
	@Column(name = "cnpj", nullable = false, length = 18, unique=true)
	public String getCnpj() {
		return this.cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	@NotNull
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

	@Column(name = "cargo")
	public String getCargo() {
		return this.cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
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

	@Column(name = "complemento")
	public String getComplemento() {
		return this.complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
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

	@Column(name = "TIPO_FORNECEDOR", nullable = false, length = 45, insertable=false, updatable=false)
	public String getTipoFornecedor() {
		return this.tipoFornecedor;
	}

	public void setTipoFornecedor(String tipoFornecedor) {
		this.tipoFornecedor = tipoFornecedor;
	}

}

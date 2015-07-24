package br.com.synergy.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "fornecedor", catalog = "sistema_gestao")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TIPO_FORNECEDOR", discriminatorType=DiscriminatorType.STRING)
public abstract class Fornecedor{

	private static final long serialVersionUID = 1L;

	private FornecedorId id;
	private Endereco endereco;
	private String cnpj;
	private String nome;
	private String contato;
	private String email;
	private String linkSharepoint;
	private String obs;
	private String celular;
	private String telefone;
	private String site;
	private String complemento;
	private String tipoFornecedor;

	public Fornecedor() {
	}

	public Fornecedor(FornecedorId id, Endereco endereco, String cnpj,
			String tipoFornecedor) {
		this.id = id;
		this.endereco = endereco;
		this.cnpj = cnpj;
		this.tipoFornecedor = tipoFornecedor;
	}

	public Fornecedor(FornecedorId id, Endereco endereco, String cnpj,
			String nome, String contato, String email, String linkSharepoint,
			String obs, String celular, String telefone, String site,
			String complemento, String tipoFornecedor) {
		this.id = id;
		this.endereco = endereco;
		this.cnpj = cnpj;
		this.nome = nome;
		this.contato = contato;
		this.email = email;
		this.linkSharepoint = linkSharepoint;
		this.obs = obs;
		this.celular = celular;
		this.telefone = telefone;
		this.site = site;
		this.complemento = complemento;
		this.tipoFornecedor = tipoFornecedor;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "idfornecedor", column = @Column(name = "idfornecedor", nullable = false)),
			@AttributeOverride(name = "enderecoIdendereco", column = @Column(name = "endereco_idendereco", nullable = false)) })
	public FornecedorId getId() {
		return this.id;
	}

	public void setId(FornecedorId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "endereco_idendereco", nullable = false, insertable = false, updatable = false)
	public Endereco getEndereco() {
		return this.endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
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

	@Column(name = "complemento")
	public String getComplemento() {
		return this.complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	@Column(name = "TIPO_FORNECEDOR", nullable = false, length = 45)
	public String getTipoFornecedor() {
		return this.tipoFornecedor;
	}

	public void setTipoFornecedor(String tipoFornecedor) {
		this.tipoFornecedor = tipoFornecedor;
	}


}

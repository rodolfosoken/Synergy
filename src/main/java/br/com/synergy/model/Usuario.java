package br.com.synergy.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="usuario", catalog = "sistema_gestao")
public class Usuario implements Serializable{
	

	private static final long serialVersionUID = 1L;
	private Long id;
	private String nome;
	private String sobrenome;
	private String email;
	private String senha;
	private Integer registro;
	private String idGm;
	private List<Cargo> cargos;

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idusuario", unique=true, nullable = false)
	public Long getId() {
		return id;
	}
	public void setId(Long id){
		this.id = id;
	}
	
	@Column(name = "nome")
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Column(name = "sobrenome")
	public String getSobrenome() {
		return this.sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	
	@Column(name = "email")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name="senha")
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	@Column(name = "registro")
	public Integer getRegistro() {
		return this.registro;
	}

	public void setRegistro(Integer registro) {
		this.registro = registro;
	}
	
	@Column(name = "id")
	public String getIdGm() {
		return this.idGm;
	}

	public void setIdGm(String idGm) {
		this.idGm = idGm;
	}
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="usuario_has_cargo", joinColumns= @JoinColumn(name="usuario_idusuario"),
	inverseJoinColumns=@JoinColumn(name="cargo_idcargo"))
	public List<Cargo> getCargos() {
		return cargos;
	}
	public void setCargos(List<Cargo> cargos) {
		this.cargos = cargos;
	}

		

}

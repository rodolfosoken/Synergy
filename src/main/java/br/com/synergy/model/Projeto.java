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
import javax.persistence.Table;


@Entity
@Table(name = "projeto", catalog = "sistema_gestao")
public class Projeto implements java.io.Serializable {


	private static final long serialVersionUID = 1L;
	private Long idprojeto;
	private String nome;
	private Set<Conjunto> conjuntos = new HashSet<Conjunto>(0);

	public Projeto() {
	}

	public Projeto(String nome, Set<Conjunto> conjuntos) {
		this.nome = nome;
		this.conjuntos = conjuntos;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idprojeto", unique = true, nullable = false)
	public Long getIdprojeto() {
		return this.idprojeto;
	}

	public void setIdprojeto(Long idprojeto) {
		this.idprojeto = idprojeto;
	}

	@Column(name = "nome")
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "projeto_has_conjunto", catalog = "sistema_gestao", joinColumns = { @JoinColumn(name = "projeto_idprojeto", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "conjunto_idconjunto", nullable = false, updatable = false) })
	public Set<Conjunto> getConjuntos() {
		return this.conjuntos;
	}

	public void setConjuntos(Set<Conjunto> conjuntos) {
		this.conjuntos = conjuntos;
	}

}

package br.com.synergy.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.ArrayList;
import java.util.List;

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

@Entity
@Table(name = "montagem", catalog = "sistema_gestao")
public class Montagem implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Long idmontagem;
	private Conjunto conjunto;
	private List<ComponenteFerramenta> componenteFerramentas = new ArrayList<ComponenteFerramenta>(
			0);
	private List<ComponentePeca> componentePecas = new ArrayList<ComponentePeca>(0);

	public Montagem() {
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idmontagem", unique = true, nullable = false)
	public Long getIdmontagem() {
		return this.idmontagem;
	}

	public void setIdmontagem(Long idmontagem) {
		this.idmontagem = idmontagem;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "conjunto_idconjunto", nullable = false)
	public Conjunto getConjunto() {
		return this.conjunto;
	}

	public void setConjunto(Conjunto conjunto) {
		this.conjunto = conjunto;
	}
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "montagem_has_componente_ferramenta", catalog = "sistema_gestao", joinColumns = { @JoinColumn(name = "montagem_idmontagem", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "componente_ferramenta_idcomponente_ferramenta", nullable = false, updatable = false) })
	public List<ComponenteFerramenta> getComponenteFerramentas() {
		return this.componenteFerramentas;
	}

	public void setComponenteFerramentas(
			List<ComponenteFerramenta> componenteFerramentas) {
		this.componenteFerramentas = componenteFerramentas;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "montagem_has_componente_peca", catalog = "sistema_gestao", joinColumns = { @JoinColumn(name = "montagem_idmontagem", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "componente_peca_idcomponente_peca", nullable = false, updatable = false) })
	public List<ComponentePeca> getComponentePecas() {
		return this.componentePecas;
	}

	public void setComponentePecas(List<ComponentePeca> componentePecas) {
		this.componentePecas = componentePecas;
	}

}

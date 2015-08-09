package br.com.synergy.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "montagem", catalog = "sistema_gestao")
public class Montagem implements java.io.Serializable {


	private static final long serialVersionUID = 1L;
	private Long idmontagem;
	private Ferramenta ferramenta;
	private Peca peca;
	private Conjunto conjunto;

	public Montagem() {
	}

	public Montagem(Ferramenta ferramenta, Peca peca, Conjunto conjunto) {
		this.ferramenta = ferramenta;
		this.peca = peca;
		this.conjunto = conjunto;
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
	@JoinColumn(name = "ferramenta_idferramenta", nullable = false)
	public Ferramenta getFerramenta() {
		return this.ferramenta;
	}

	public void setFerramenta(Ferramenta ferramenta) {
		this.ferramenta = ferramenta;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "peca_idpeca", nullable = false)
	public Peca getPeca() {
		return this.peca;
	}

	public void setPeca(Peca peca) {
		this.peca = peca;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "conjunto_idconjunto", nullable = false)
	public Conjunto getConjunto() {
		return this.conjunto;
	}

	public void setConjunto(Conjunto conjunto) {
		this.conjunto = conjunto;
	}

}

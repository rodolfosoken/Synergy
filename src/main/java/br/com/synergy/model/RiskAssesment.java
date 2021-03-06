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
@Table(name = "risk_assesment", catalog = "sistema_gestao")
public class RiskAssesment implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Long idRiskAssesment;
	private Conjunto conjunto;
	private String riskAssesmentcol;
	private Set<Pfmea> pfmeas = new HashSet<Pfmea>(0);

	public RiskAssesment() {
	}

	public RiskAssesment(Conjunto conjunto) {
		this.conjunto = conjunto;
	}

	public RiskAssesment(Conjunto conjunto, String riskAssesmentcol,
			Set<Pfmea> pfmeas) {
		this.conjunto = conjunto;
		this.riskAssesmentcol = riskAssesmentcol;
		this.pfmeas = pfmeas;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_risk_assesment", unique = true, nullable = false)
	public Long getIdRiskAssesment() {
		return this.idRiskAssesment;
	}

	public void setIdRiskAssesment(Long idRiskAssesment) {
		this.idRiskAssesment = idRiskAssesment;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "conjunto_idconjunto", nullable = false)
	public Conjunto getConjunto() {
		return this.conjunto;
	}

	public void setConjunto(Conjunto conjunto) {
		this.conjunto = conjunto;
	}

	@Column(name = "risk_assesmentcol")
	public String getRiskAssesmentcol() {
		return this.riskAssesmentcol;
	}

	public void setRiskAssesmentcol(String riskAssesmentcol) {
		this.riskAssesmentcol = riskAssesmentcol;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "riskAssesment")
	public Set<Pfmea> getPfmeas() {
		return this.pfmeas;
	}

	public void setPfmeas(Set<Pfmea> pfmeas) {
		this.pfmeas = pfmeas;
	}

}

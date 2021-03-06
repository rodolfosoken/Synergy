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
@Table(name = "pfmea", catalog = "sistema_gestao")
public class Pfmea implements java.io.Serializable {


	private static final long serialVersionUID = 1L;
	private Long idPfmea;
	private RiskAssesment riskAssesment;
	private String responsavel;
	private String link;

	public Pfmea() {
	}

	public Pfmea(RiskAssesment riskAssesment) {
		this.riskAssesment = riskAssesment;
	}

	public Pfmea(RiskAssesment riskAssesment, String responsavel, String link) {
		this.riskAssesment = riskAssesment;
		this.responsavel = responsavel;
		this.link = link;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_pfmea", unique = true, nullable = false)
	public Long getIdPfmea() {
		return this.idPfmea;
	}

	public void setIdPfmea(Long idPfmea) {
		this.idPfmea = idPfmea;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "risk_assesment_id_risk_assesment", nullable = false)
	public RiskAssesment getRiskAssesment() {
		return this.riskAssesment;
	}

	public void setRiskAssesment(RiskAssesment riskAssesment) {
		this.riskAssesment = riskAssesment;
	}

	@Column(name = "responsavel")
	public String getResponsavel() {
		return this.responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	@Column(name = "link")
	public String getLink() {
		return this.link;
	}

	public void setLink(String link) {
		this.link = link;
	}

}

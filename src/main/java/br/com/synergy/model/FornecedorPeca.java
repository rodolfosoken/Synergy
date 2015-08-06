package br.com.synergy.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("PECA")
public class FornecedorPeca extends Fornecedor implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Set<ParticipantePeca> participantes = new HashSet<ParticipantePeca>(0);

	public FornecedorPeca() {
	}

	public FornecedorPeca(String cnpj) {
		this.setCnpj(cnpj);
	}
	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fornecedor")
	public Set<ParticipantePeca> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(Set<ParticipantePeca> participantes) {
		this.participantes = participantes;
	}



}

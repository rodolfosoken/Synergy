package br.com.synergy.model;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;


@Entity
@DiscriminatorValue("FERRAMENTA")
public class FornecedorFerramenta extends Fornecedor implements java.io.Serializable {


	
	private static final long serialVersionUID = 1L;	
	private Set<ParticipanteFerramenta> participanteFerramentas = new HashSet<ParticipanteFerramenta>(
			0);

	public FornecedorFerramenta() {

	}

	public FornecedorFerramenta(String cnpj) {
		this.setCnpj(cnpj);
	}


	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fornecedor")
	public Set<ParticipanteFerramenta> getParticipanteFerramentas() {
		return this.participanteFerramentas;
	}

	public void setParticipanteFerramentas(
			Set<ParticipanteFerramenta> participanteFerramentas) {
		this.participanteFerramentas = participanteFerramentas;
	}

}

package br.com.synergy.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("PECA")
public class FornecedorPeca extends Fornecedor implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	public FornecedorPeca() {
	}

	public FornecedorPeca(String cnpj) {
		this.setCnpj(cnpj);
	}
	
	


}

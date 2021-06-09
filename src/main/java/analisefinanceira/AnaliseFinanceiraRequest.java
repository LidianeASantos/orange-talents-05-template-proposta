package analisefinanceira;

import javax.validation.constraints.NotBlank;

import validations.CPFouCNPJ;

public class AnaliseFinanceiraRequest {

	 @NotBlank
	 @CPFouCNPJ
	 private String documento;

	 @NotBlank
	 private String nome;

	 @NotBlank
	 private String idProposta;

	 public AnaliseFinanceiraRequest(@NotBlank String documento, @NotBlank String nome, @NotBlank String idProposta) {
	      this.documento = documento;
	      this.nome = nome;
	      this.idProposta = idProposta;
	    }

	public String getDocumento() {
		return documento;
	}

	public String getNome() {
		return nome;
	}

	public String getIdProposta() {
		return idProposta;
	}

	 
}

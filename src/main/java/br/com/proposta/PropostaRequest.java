package br.com.proposta;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import validations.CPFouCNPJ;

public class PropostaRequest {
	
	
	@NotBlank
	private String nome;
	
	@NotBlank
	@Email
	private String email;
	
	@NotBlank
	private String endereco;
	
	@NotNull
	@Positive
	private BigDecimal salarioBruto;
	
	@NotBlank
	//@CPFouCNPJ
	private String documento;
	
	
	public PropostaRequest(@NotBlank @CPFouCNPJ String documento,
          	@NotBlank @Email String email,
            @NotBlank String nome,
            @NotBlank String endereco,
            @NotNull @Positive BigDecimal salarioBruto) {
		this.documento = documento;
		this.email = email;
		this.nome = nome;
		this.endereco = endereco;
		this.salarioBruto = salarioBruto;
}
	
	public Proposta toModel() {
		return new Proposta(
				this.documento, this.email, this.nome, this.endereco, this.salarioBruto);
	}
	
	 public String getDocumento() {
	        return documento;
	    }

	@Override
    public String toString() {
        return "PropostaRequest{" +
                "documento='" + documento + '\'' +
                ", email='" + email + '\'' +
                ", nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", salarioBruto=" + salarioBruto +
                '}';
    }


}

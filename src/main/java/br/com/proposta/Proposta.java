package br.com.proposta;


import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import validations.CPFouCNPJ;

@Entity
public class Proposta {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String nome;
	
	@NotBlank
	@Email
	@Column(nullable = false)
	private String email;
	
	@NotBlank
	@Column(nullable = false)
	private String endereco;
	
	@NotNull
	@Positive
	@Column(nullable = false)
	private BigDecimal salarioBruto;
	
	@NotBlank
	@Column(nullable = false)
	@CPFouCNPJ
	private String documento;


	
	 @Deprecated
	    public Proposta() {
	    }

	    public Proposta(@NotBlank @CPFouCNPJ String documento,
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
	
	    public Long getId() {
	        return id;
	    }
}



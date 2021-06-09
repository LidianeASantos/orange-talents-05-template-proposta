package br.com.proposta;


import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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

	 public enum StatusProposta {
	        ELEGIVEL, NAO_ELEGIVEL
	    }
	
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
	
	 @Enumerated(EnumType.STRING)
	 private StatusProposta status;


	
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
	    
	    public void setStatus(StatusProposta status) {
	        this.status = status;
	    }

	    @Override
	    public String toString() {
	        return "Proposta{" +
	                "id=" + id +
	                ", documento='" + documento + '\'' +
	                ", email='" + email + '\'' +
	                ", nome='" + nome + '\'' +
	                ", endereco='" + endereco + '\'' +
	                ", salarioBruto=" + salarioBruto +
	                ", status=" + status +
	                '}';
	    }
}



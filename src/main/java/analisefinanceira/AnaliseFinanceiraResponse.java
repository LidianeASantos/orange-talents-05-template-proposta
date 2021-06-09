package analisefinanceira;


public class AnaliseFinanceiraResponse {

	 private String documento;
	 private String nome;
	 private String resultadoSolicitacao;
	 private String idProposta;

	 @Deprecated
	 public AnaliseFinanceiraResponse() {
	    }

	 public AnaliseFinanceiraResponse(String documento, String nome, String resultadoSolicitacao, String idProposta) {
	      this.documento = documento;
	      this.nome = nome;
	      this.resultadoSolicitacao = resultadoSolicitacao;
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


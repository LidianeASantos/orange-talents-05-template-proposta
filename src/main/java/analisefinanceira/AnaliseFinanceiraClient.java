package analisefinanceira;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "analiseDeSolicitacao", url = "${zup.analise_financeira.url}")
public interface AnaliseFinanceiraClient {
	
	 @RequestMapping(method = RequestMethod.POST, value = "/solicitacao")
	 AnaliseFinanceiraResponse analisar(AnaliseFinanceiraRequest request);

}

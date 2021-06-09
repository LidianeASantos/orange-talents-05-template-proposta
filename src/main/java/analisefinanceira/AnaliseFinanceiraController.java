package analisefinanceira;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import feign.FeignException;

@RestController
public class AnaliseFinanceiraController {

	 @Autowired
	 private AnaliseFinanceiraClient analiseFinanceiraClient;

	    @PostMapping(value = "/analise")
	    public ResponseEntity<?> analisarProposta(@RequestBody @Valid AnaliseFinanceiraRequest request)
	           throws JsonMappingException, JsonProcessingException {

	        try {
	            AnaliseFinanceiraResponse resposta = analiseFinanceiraClient.analisar(request);
	            return ResponseEntity.ok().body(resposta);
	        } catch (FeignException e) {
	            if (e.status() == HttpStatus.UNPROCESSABLE_ENTITY.value()) {
	                AnaliseFinanceiraResponse resposta = new ObjectMapper().readValue(e.contentUTF8(),
	                    AnaliseFinanceiraResponse.class);
	                return ResponseEntity.status(e.status()).body(resposta);
	            } else {
	                return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("Serviço de análise indisponível");
	            }
	        }
	    }
}

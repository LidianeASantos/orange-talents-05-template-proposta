package br.com.proposta;


import java.net.URI;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import exceptions.ApiErrorException;




@RestController
@RequestMapping("/proposta")
public class PropostaController {
	
	@Autowired
	private PropostaRepository propostaRepository;
	
		
	@PostMapping
    @Transactional
    public ResponseEntity<?> cadastra(@RequestBody @Valid PropostaRequest request,
           UriComponentsBuilder uriComponentsBuilder) {

		 if(documentoJaExiste(request.getDocumento())){
	            throw new ApiErrorException(HttpStatus.UNPROCESSABLE_ENTITY, "Não é permitido mais de uma proposta para um mesmo solicitante");
	        }

        Proposta proposta = request.toModel();
        propostaRepository.save(proposta);

        URI uri = uriComponentsBuilder.path("/propostas/{id}").buildAndExpand(proposta.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
	
	private boolean documentoJaExiste(String documento) {
	        return propostaRepository.findByDocumento(documento).isPresent();
}

	
}
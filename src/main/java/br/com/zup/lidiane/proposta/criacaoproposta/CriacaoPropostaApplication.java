package br.com.zup.lidiane.proposta.criacaoproposta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class CriacaoPropostaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CriacaoPropostaApplication.class, args);
	}

}

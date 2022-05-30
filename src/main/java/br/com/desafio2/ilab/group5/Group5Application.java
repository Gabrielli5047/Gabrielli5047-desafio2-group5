package br.com.desafio2.ilab.group5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class Group5Application {

	public static void main(String[] args) {
		SpringApplication.run(Group5Application.class, args);
	}

}

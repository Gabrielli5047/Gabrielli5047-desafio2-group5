package br.com.desafio2.ilab.group5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import br.com.desafio2.ilab.group5.security.Token;
import br.com.desafio2.ilab.group5.service.IAdministradorService;
import br.com.desafio2.ilab.group5.dto.AdministradorLoginDTO;

@RestController
@CrossOrigin("*")
public class LoginController {

	@Autowired
	private IAdministradorService service;

	@PostMapping("/login")
	public ResponseEntity<?> realizarLogin(@RequestBody AdministradorLoginDTO dadosLogin) {
		Token token = service.gerarTokenEntregador(dadosLogin);

		if (token != null) {
			return ResponseEntity.ok(token);
		}

		return ResponseEntity.status(401).body("Acesso Negado");

	}
}

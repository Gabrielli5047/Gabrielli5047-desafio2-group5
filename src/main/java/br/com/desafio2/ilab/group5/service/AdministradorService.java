package br.com.desafio2.ilab.group5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import br.com.desafio2.ilab.group5.dao.AdministradorDAO;
import br.com.desafio2.ilab.group5.dto.AdministradorLoginDTO;
import br.com.desafio2.ilab.group5.model.Administrador;
import br.com.desafio2.ilab.group5.security.Encrypt;
import br.com.desafio2.ilab.group5.security.Token;
import br.com.desafio2.ilab.group5.security.TokenUtils;

@Component
@Primary
public class AdministradorService implements IAdministradorService{

    @Autowired
    private AdministradorDAO dao;
    
    @Override
	public Token gerarTokenEntregador(AdministradorLoginDTO dadosLogin) {
		try {
			Administrador user = dao.findByEmail(dadosLogin.getEmail());
			if (user != null) {

				String senhaLogin = Encrypt.encrypt(dadosLogin.getSenha());

				if (user.getSenha().equals(dadosLogin.getSenha())) {
					return new Token(TokenUtils.createToken(user));
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}
}

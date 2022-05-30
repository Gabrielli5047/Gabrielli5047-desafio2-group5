package br.com.desafio2.ilab.group5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import br.com.desafio2.ilab.group5.dao.AdministratorDAO;
import br.com.desafio2.ilab.group5.dto.AdministratorLoginDTO;
import br.com.desafio2.ilab.group5.model.Administrator;
// import br.com.desafio2.ilab.group5.security.Encrypt;
import br.com.desafio2.ilab.group5.security.Token;
import br.com.desafio2.ilab.group5.security.TokenUtils;

@Component
@Primary
public class AdministratorService implements IAdministratorService{

    @Autowired
    private AdministratorDAO dao;
    
    @Override
	public Token gerarTokenAdministrador(AdministratorLoginDTO dadosLogin) {
		try {
			Administrator user = dao.findByEmail(dadosLogin.getEmail());
			if (user != null) {

				// String senhaLogin = Encrypt.encrypt(dadosLogin.getSenha());

				if (user.getPassword().equals(dadosLogin.getSenha())) {
					return new Token(TokenUtils.createToken(user));
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

	@Override
	public Administrator addAdministrator(Administrator newAdm) {
		Administrator newAd = dao.save(newAdm);
		return newAd;
	}
}

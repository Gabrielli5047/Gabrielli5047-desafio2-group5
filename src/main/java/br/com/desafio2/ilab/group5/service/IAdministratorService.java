package br.com.desafio2.ilab.group5.service;

import br.com.desafio2.ilab.group5.dto.AdministratorLoginDTO;
import br.com.desafio2.ilab.group5.model.Administrator;
import br.com.desafio2.ilab.group5.security.Token;

public interface IAdministratorService {
    
    public Token gerarTokenAdministrador(AdministratorLoginDTO dadosLogin);
    
    public Administrator addAdministrator(Administrator newAdm);

}

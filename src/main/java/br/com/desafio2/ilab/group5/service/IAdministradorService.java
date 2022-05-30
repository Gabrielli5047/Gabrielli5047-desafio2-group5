package br.com.desafio2.ilab.group5.service;

import br.com.desafio2.ilab.group5.dto.AdministradorLoginDTO;
import br.com.desafio2.ilab.group5.security.Token;

public interface IAdministradorService {
    
    public Token gerarTokenAdministrador(AdministradorLoginDTO dadosLogin);

}

package br.com.desafio2.ilab.group5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio2.ilab.group5.model.Administrator;
import br.com.desafio2.ilab.group5.service.IAdministratorService;

@RestController
public class AdministratorController {
    
    @Autowired
    private IAdministratorService service;

    @PostMapping("/administrator")
    public Administrator addAdministrator(@RequestBody Administrator adm){
        return service.addAdministrator(adm);
    }


}

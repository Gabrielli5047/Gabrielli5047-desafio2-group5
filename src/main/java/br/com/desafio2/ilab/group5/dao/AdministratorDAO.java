package br.com.desafio2.ilab.group5.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.desafio2.ilab.group5.model.Administrator;

public interface AdministratorDAO extends CrudRepository<Administrator, Integer> {

	public Administrator findByEmail(String email);

}
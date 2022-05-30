package br.com.desafio2.ilab.group5.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.desafio2.ilab.group5.model.Administrador;

public interface AdministradorDAO extends CrudRepository<Administrador, Integer> {

	public Administrador findByEmail(String email);

}
package com.MarcosPiv.api_rest_basica.model.dao;

import com.MarcosPiv.api_rest_basica.model.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

//CrudRepository proporciona métodos genéricos predefinidos para las operaciones básicas de manipulación de datos (metodos CRUD)
//solo usar cuando hay que hacer metodos CRUD
//cuando es un sistema grande y tenemos miles de productos hay que paginar y se usa PagingAndSortingRepository
public interface ClienteDao extends CrudRepository<Cliente, Integer> {

}

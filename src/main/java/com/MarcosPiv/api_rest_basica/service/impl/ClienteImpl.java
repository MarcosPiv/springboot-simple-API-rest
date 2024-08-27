package com.MarcosPiv.api_rest_basica.service.impl;

import com.MarcosPiv.api_rest_basica.model.dao.ClienteDao;
import com.MarcosPiv.api_rest_basica.model.entity.Cliente;
import com.MarcosPiv.api_rest_basica.service.ICliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//implemetamos la interfaz
@Service //la marcamos como servicio. La clase ClienteImpl es un servicio que contiene lógica de negocio y será administrado por Spring.
public class ClienteImpl implements ICliente {

    @Autowired //inyecciones de dependencia: Se utiliza para inyectar automáticamente una instancia de una dependencia en el contenedor de Spring.
    private ClienteDao clienteDao;

    //Guarda un nuevo cliente o actualiza un cliente existente en la BD.
    @Transactional//indica que el metodo o la clase donde se aplica debe ejecutarse dentro de una transacción.
    //Una transacción es una secuencia de operaciones que se tratan como una única unidad de trabajo,
    //lo que significa que todas las operaciones dentro de la transacción deben completarse con éxito; de lo contrario, ninguna operación debe tener efecto en la BD
    @Override
    public Cliente save(Cliente cliente) {
        return clienteDao.save(cliente);
    }

    //Busca y recupera un cliente específico de la BD utilizando su ID.
    @Transactional (readOnly = true)//al consultar lo especificamos que solo sea lectura
    @Override
    public Cliente findById(Integer id) {
        return clienteDao.findById(id).orElse(null); //Si el cliente se encuentra, lo devuelve; de lo contrario, devuelve null.
    }

    //Elimina un cliente específico de la BD
    @Transactional
    @Override
    public void delete(Cliente cliente) {
        clienteDao.delete(cliente);
    }
}

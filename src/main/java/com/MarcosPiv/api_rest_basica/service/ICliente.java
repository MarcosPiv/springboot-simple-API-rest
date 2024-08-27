package com.MarcosPiv.api_rest_basica.service;

import com.MarcosPiv.api_rest_basica.model.entity.Cliente;

public interface ICliente {
    //SAVE: sirve tanto para crear una nueva entidad como para actualizar una existente.
    //Crear una Nueva Entidad: Si la entidad no tiene un ID (o el ID es null), el metodo save insertará un nuevo registro en la base de datos.
    //Actualizar una Entidad Existente: Si la entidad tiene un ID que ya existe en la BD el metodo save actualizará el registro correspondiente con los nuevos valores.
    Cliente save(Cliente cliente); //recibe Cliente y al guardar retorna los datos del cliente guardado

    Cliente findById(Integer id);//busca y devuelve un objeto Cliente de la BD utilizando su ID.

    void delete(Cliente cliente);//elimina la entidad pasada como argumento

}

package com.MarcosPiv.api_rest_basica.controller;

import com.MarcosPiv.api_rest_basica.model.entity.Cliente;
import com.MarcosPiv.api_rest_basica.service.ICliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController //sirve para crear servicios RESTful -> lo que significa que está diseñada para manejar solicitudes HTTP y devolver respuestas en formato JSON o XML
@RequestMapping("/api/v1")//Indica que cualquier solicitud HTTP que coincida con la ruta especificada debe ser manejada por los métodos de esa clase que tengan rutas adicionales definidas.
//todas las rutas dentro de ese controlador estarán precedidas por /api/v1
public class ClienteController {

    @Autowired
    private ICliente clienteService;

    @PostMapping("cliente")
    @ResponseStatus(HttpStatus.CREATED)//se usa cuando es estatico
    public Cliente create(@RequestBody Cliente cliente) {
        return clienteService.save(cliente);
    }

    @PutMapping("cliente")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente update(@RequestBody Cliente cliente) {
        return clienteService.save(cliente);
    }

    @DeleteMapping("cliente/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        Map<String,Object> response = new HashMap<>();
        try{
            Cliente clienteDelete = clienteService.findById(id);
            clienteService.delete(clienteDelete);
            return new ResponseEntity<>(clienteDelete, HttpStatus.NO_CONTENT);
        }catch(DataAccessException ex){
            response.put("mensaje", ex.getMessage());
            response.put("cliente", null);

            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("cliente/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Cliente showById(@PathVariable Integer id) {
        return clienteService.findById(id);

    }
}

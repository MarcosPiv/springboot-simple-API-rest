package com.MarcosPiv.api_rest_basica.controller;

import com.MarcosPiv.api_rest_basica.model.dto.ClienteDto;
import com.MarcosPiv.api_rest_basica.model.entity.Cliente;
import com.MarcosPiv.api_rest_basica.model.payload.MensajeResponse;
import com.MarcosPiv.api_rest_basica.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //sirve para crear servicios RESTful -> lo que significa que está diseñada para manejar solicitudes HTTP y devolver respuestas en formato JSON o XML
@RequestMapping("/api/v1")//Indica que cualquier solicitud HTTP que coincida con la ruta especificada debe ser manejada por los métodos de esa clase que tengan rutas adicionales definidas.
//todas las rutas dentro de ese controlador estarán precedidas por /api/v1
public class ClienteController {

    @Autowired
    private IClienteService clienteService;

    @GetMapping("clientes")
    public ResponseEntity<?> showAll() {
        List<Cliente> getList = clienteService.findAll();
        if(getList == null) {
            return new ResponseEntity<>(MensajeResponse.builder()
                    .mensaje("No hay registros")
                    .object(null)
                    .build(), HttpStatus.OK);
        }
        return new ResponseEntity<>(MensajeResponse.builder()
                .mensaje("Consulta Exitosa")
                .object(getList)
                .build(), HttpStatus.OK);
    }

    @PostMapping("cliente")
    public ResponseEntity<?> create(@RequestBody ClienteDto clienteDto) {
        Cliente clienteSave = null;
        try {
            clienteSave = clienteService.save(clienteDto);
            clienteDto = ClienteDto.builder()
                    .id(clienteSave.getId())
                    .nombre(clienteSave.getNombre() )
                    .apellido(clienteSave.getApellido())
                    .correo(clienteSave.getCorreo())
                    .registro(clienteSave.getRegistro())
                    .build();
            return new ResponseEntity<>(MensajeResponse.builder()
                    .mensaje("Guardado correctamente")
                    .object(clienteDto)
                    .build()
                    , HttpStatus.CREATED);
        } catch (DataAccessException exDt) {
            return new ResponseEntity<>(
                    MensajeResponse.builder()
                            .mensaje(exDt.getMessage())
                            .object(null)
                            .build()
                    , HttpStatus.METHOD_NOT_ALLOWED);
        }
    }


    @PutMapping("cliente/{id}")
    public ResponseEntity<?> update(@RequestBody ClienteDto clienteDto, @PathVariable Integer id) {
        Cliente clienteUpdate = null;
        try {
            if(clienteService.existsById(id)) {
                clienteDto.setId(id);
                clienteUpdate = clienteService.save(clienteDto);
                clienteDto = ClienteDto.builder()
                        .id(clienteUpdate.getId())
                        .nombre(clienteUpdate.getNombre())
                        .apellido(clienteUpdate.getApellido())
                        .registro(clienteUpdate.getRegistro())
                        .correo(clienteUpdate.getCorreo())
                        .build();
                return new ResponseEntity<>(MensajeResponse.builder()
                        .mensaje("Guardado correctamente")
                        .object(clienteDto)
                        .build(), HttpStatus.CREATED);
            } else{
                return new ResponseEntity<>(MensajeResponse.builder()
                        .mensaje("El registro que intenta actualizar no se encuentra registrado")
                        .object(null)
                        .build(), HttpStatus.NOT_FOUND);
            }
        } catch (DataAccessException ex) {
            return new ResponseEntity<>(MensajeResponse.builder()
                    .mensaje(ex.getMessage())
                    .object(null)
                    .build(), HttpStatus.METHOD_NOT_ALLOWED);
        }
    }

    @DeleteMapping("cliente/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
            Cliente clienteDelete = clienteService.findById(id);
            clienteService.delete(clienteDelete);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Sin contenido al eliminar correctamente
        } catch (DataAccessException ex) {
            return new ResponseEntity<>(MensajeResponse.builder()
                    .mensaje(ex.getMessage())
                    .object(null)
                    .build(), HttpStatus.METHOD_NOT_ALLOWED);
        }
    }

    @GetMapping("cliente/{id}")
    public ResponseEntity<?> showById(@PathVariable Integer id) {
        Cliente cliente = clienteService.findById(id);

        if(cliente == null) {
            return new ResponseEntity<>(MensajeResponse.builder()
                    .mensaje("El registro que intenta buscar no existe")
                    .object(null)
                    .build(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(MensajeResponse.builder()
                .mensaje("Consulta Exitosa")
                .object(ClienteDto.builder()
                        .id(cliente.getId())
                        .nombre(cliente.getNombre())
                        .apellido(cliente.getApellido())
                        .registro(cliente.getRegistro())
                        .correo(cliente.getCorreo())
                        .build())
                .build(), HttpStatus.OK);
    }
}

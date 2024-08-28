package com.MarcosPiv.api_rest_basica.model.dto;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Data
@ToString
@Builder

//el dto funciona como un espejo de la entidad Cliente,
//las entidades no se deben exponer como respuesta en los body, para eso estan los dto
public class ClienteDto implements Serializable {

    private Integer id;
    private String nombre;
    private String apellido;
    private String correo;
    private Date registro;

}

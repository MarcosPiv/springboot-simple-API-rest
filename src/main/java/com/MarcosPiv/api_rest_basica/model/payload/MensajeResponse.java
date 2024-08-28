package com.MarcosPiv.api_rest_basica.model.payload;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Data
@ToString
@Builder

public class MensajeResponse implements Serializable {
    private String mensaje;
    private Object object;

}

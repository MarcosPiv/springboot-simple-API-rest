package com.MarcosPiv.api_rest_basica.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

//lombok -> me genera TODOO desde los contructores a los setters y getters y mas
@Data //me genera los getters y setters
@AllArgsConstructor //me genera el constructor
@NoArgsConstructor //constructor vacio
@ToString
@Builder

@Entity //definimos la clase como una entidad
@Table(name = "clientes") //definimos a donde hace referencia la clase
public class Cliente implements Serializable {
    @Id //el id de la tabla es el atributo id
    @Column(name = "id_cliente") //hace referencia a id_cliente
    @GeneratedValue(strategy = GenerationType.IDENTITY) //esto es para definir valor del id será generado automáticamente por la BD
    private Integer id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "correo")
    private String correo;
    @Column(name = "fecha_registro")
    private Date registro;




}

package com.example.finalarqui.application.dto;


import com.example.finalarqui.domain.entities.Vehiculo;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RespuestaRegistro extends Respuesta{

    @JsonProperty("dato")
    Vehiculo data;
}

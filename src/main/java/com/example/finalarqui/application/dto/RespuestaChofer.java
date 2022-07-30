package com.example.finalarqui.application.dto;

import com.example.finalarqui.domain.entities.Chofer;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class RespuestaChofer extends Respuesta{
    @JsonProperty("dato")
    Chofer data;
}

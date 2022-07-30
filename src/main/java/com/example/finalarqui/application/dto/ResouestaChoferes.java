package com.example.finalarqui.application.dto;

import com.example.finalarqui.domain.entities.Chofer;
import com.example.finalarqui.domain.entities.Vehiculo;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class ResouestaChoferes extends Respuesta {

    @JsonProperty("datos")
    List<Chofer> data;
}

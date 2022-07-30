package com.example.finalarqui.domain.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Vehiculo {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @JsonProperty("id")
    private Integer id;

    private String fechaSalida;

    private String horaSalida;

    private String placa;

    @ManyToOne

    @JoinColumn(name = "id_chofer", nullable = false, foreignKey = @ForeignKey(name = "FK_chofer_vehiculo"))
    private Chofer chofer;



}

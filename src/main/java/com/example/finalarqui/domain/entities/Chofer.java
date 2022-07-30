package com.example.finalarqui.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@Table(name= "choferes")
@Entity
@ToString
public class Chofer {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @JsonProperty("idChofer")
    @Column(name = "idChofer")
    private Integer idChofer;

    @Column (name = "nombre")
    @JsonProperty("nombre")
    private String nombre;

    @Column (name = "apellido")
    @JsonProperty("apellido")
    private String apellido;

    @OneToMany(mappedBy ="chofer", cascade ={CascadeType.ALL})
@JsonIgnore
    private List<Vehiculo> vehiculo;

}

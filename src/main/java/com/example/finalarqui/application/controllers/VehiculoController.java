package com.example.finalarqui.application.controllers;


import com.example.finalarqui.application.dto.RespuestaRegistro;
import com.example.finalarqui.application.dto.RespuestaRegistros;
import com.example.finalarqui.domain.entities.Vehiculo;
import com.example.finalarqui.domain.services.VehiculoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {

    private final VehiculoService vehiculoService;

    public VehiculoController(VehiculoService vehiculoService) {
        this.vehiculoService = vehiculoService;
    }

    @PostMapping(consumes = {"application/json"}, produces = {"application/json"})
    public ResponseEntity<RespuestaRegistro> crearRegistro(@RequestBody Vehiculo vehiculo) {
        RespuestaRegistro resRegistro = new RespuestaRegistro();
        try {
            resRegistro.setSatisfactorio(true);
            resRegistro.setCodigo("200");
            resRegistro.setMensaje("Registro satisfactorio");

            Vehiculo nuevoVehiculo = vehiculoService.crearRegistroV(vehiculo);

            resRegistro.setData(nuevoVehiculo);

            return new ResponseEntity<>(resRegistro, HttpStatus.OK);
        } catch (Exception e) {
            resRegistro.setSatisfactorio(false);
            resRegistro.setCodigo("100");
            resRegistro.setMensaje("Muy mal" + e.getMessage());
            return new ResponseEntity<>(resRegistro, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<RespuestaRegistros> listarRegistros(){
        RespuestaRegistros resRegistros = new RespuestaRegistros();
        try{
            resRegistros.setSatisfactorio(true);
            resRegistros.setCodigo("200");
            resRegistros.setMensaje("OK");

            List<Vehiculo> v = vehiculoService.listarRegistros();
            resRegistros.setData(v);

            return new ResponseEntity<>(resRegistros, HttpStatus.OK);
        } catch (Exception e){
            resRegistros.setSatisfactorio(false);
            resRegistros.setCodigo("500");
            resRegistros.setMensaje("No se pudo listar"+ e.getMessage());
            return new ResponseEntity<>(resRegistros, HttpStatus.BAD_REQUEST);
        }
    }

}
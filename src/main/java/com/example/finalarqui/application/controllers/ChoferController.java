package com.example.finalarqui.application.controllers;


import com.example.finalarqui.application.dto.ResouestaChoferes;
import com.example.finalarqui.application.dto.RespuestaChofer;
import com.example.finalarqui.domain.entities.Chofer;
import com.example.finalarqui.domain.services.ChoferService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/choferes")
public class ChoferController {

    private final ChoferService choferService;

    public ChoferController(ChoferService choferService) {
        this.choferService = choferService;
    }

    @PostMapping(consumes = {"application/json"}, produces = {"application/json"})
    public ResponseEntity<RespuestaChofer> crearChofer(@RequestBody Chofer chofer) {
        RespuestaChofer resChofer = new RespuestaChofer();
        try {
            resChofer.setSatisfactorio(true);
            resChofer.setCodigo("200");
            resChofer.setMensaje("Registro satisfactorio");

            Chofer nuevoChofer = choferService.crearChofer(chofer);

            resChofer.setData(nuevoChofer);

            return new ResponseEntity<>(resChofer, HttpStatus.OK);
        } catch (Exception e) {
            resChofer.setSatisfactorio(false);
            resChofer.setCodigo("100");
            resChofer.setMensaje("Muy mal" + e.getMessage());
            return new ResponseEntity<>(resChofer, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<ResouestaChoferes> listarChoferes(){
        ResouestaChoferes resRegistros = new ResouestaChoferes();
        try{
            resRegistros.setSatisfactorio(true);
            resRegistros.setCodigo("200");
            resRegistros.setMensaje("OK");

            List<Chofer> v = choferService.listarChofer();
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

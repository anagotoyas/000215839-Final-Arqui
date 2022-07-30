package com.example.finalarqui.domain.services;

import com.example.finalarqui.domain.entities.Chofer;
import com.example.finalarqui.domain.entities.Vehiculo;

import java.util.List;

public interface ChoferService {

    Chofer crearChofer (Chofer c);



    List<Chofer> listarChofer();
}

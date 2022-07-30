package com.example.finalarqui.domain.services;

import com.example.finalarqui.domain.entities.Vehiculo;

import java.util.List;

public interface VehiculoService {

    Vehiculo crearRegistroV (Vehiculo v);

    Vehiculo modificarRegistroV (Vehiculo v);

    void eliminarRegistroV (Integer id);

    List<Vehiculo> listarRegistros();

    Vehiculo obtenerRegistro (Integer id);

}

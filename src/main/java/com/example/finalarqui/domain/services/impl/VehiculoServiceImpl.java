package com.example.finalarqui.domain.services.impl;

import com.example.finalarqui.domain.entities.Vehiculo;
import com.example.finalarqui.domain.services.VehiculoService;
import com.example.finalarqui.infrastructure.repositories.VehiculoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculoServiceImpl implements VehiculoService {

    private final VehiculoRepository vehiculoRepository;

    public VehiculoServiceImpl(VehiculoRepository vehiculoRepository) {
        this.vehiculoRepository = vehiculoRepository;
    }

    @Override
    public Vehiculo crearRegistroV(Vehiculo v) {
        return vehiculoRepository.save(v);
    }

    @Override
    public Vehiculo modificarRegistroV(Vehiculo v) {
        return vehiculoRepository.save(v);
    }

    @Override
    public void eliminarRegistroV(Integer id) {
        vehiculoRepository.deleteById(id);
    }

    @Override
    public List<Vehiculo> listarRegistros() {
        return vehiculoRepository.findAll();
    }

    @Override
    public Vehiculo obtenerRegistro(Integer id) {
        return vehiculoRepository.findById(id).orElse(new Vehiculo());
    }
}

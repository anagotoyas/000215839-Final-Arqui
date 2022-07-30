package com.example.finalarqui.domain.services.impl;


import com.example.finalarqui.domain.entities.Chofer;
import com.example.finalarqui.domain.services.ChoferService;
import com.example.finalarqui.infrastructure.repositories.ChoferRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChoferServiceImpl implements ChoferService {

    private ChoferRepository choferRepository;

    public ChoferServiceImpl(ChoferRepository choferRepository) {
        this.choferRepository = choferRepository;
    }

    @Override
    public Chofer crearChofer(Chofer c) {
        return choferRepository.save(c);
    }

    @Override
    public List<Chofer> listarChofer() {
        return choferRepository.findAll();
    }
}

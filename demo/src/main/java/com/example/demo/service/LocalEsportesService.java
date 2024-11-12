package com.example.demo.service;

import com.example.demo.entity.LocalEsportes;
import com.example.demo.repository.LocalEsportesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocalEsportesService {

    @Autowired
    private LocalEsportesRepository localEsportesRepository;

    // Buscar todos os locais esportivos
    public List<LocalEsportes> findAllLocalEsportes() {
        return localEsportesRepository.findAll();
    }

    // Buscar local esportivo por ID
    public Optional<LocalEsportes> findLocalEsportesById(Long id) {
        return localEsportesRepository.findById(id);
    }

    // Salvar um novo local esportivo
    public LocalEsportes saveLocalEsportes(LocalEsportes localEsportes) {
        return localEsportesRepository.save(localEsportes);
    }

    // Excluir um local esportivo
    public void deleteLocalEsportes(Long id) {
        localEsportesRepository.deleteById(id);
    }

    // Buscar locais esportivos por dono (proprietário)
    public List<LocalEsportes> findLocalEsportesByDono(Long donoId) {
        return localEsportesRepository.findByDonoId(donoId);
    }
}

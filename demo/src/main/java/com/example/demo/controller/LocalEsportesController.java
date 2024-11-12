package com.example.demo.controller;

import com.example.demo.entity.LocalEsportes;
import com.example.demo.service.LocalEsportesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/locais")
public class LocalEsportesController {

    @Autowired
    private LocalEsportesService localEsportesService;

    // Buscar todos os locais esportivos
    @GetMapping
    public List<LocalEsportes> getAllLocalEsportes() {
        return localEsportesService.findAllLocalEsportes();
    }

    // Buscar local esportivo por ID
    @GetMapping("/{id}")
    public ResponseEntity<LocalEsportes> getLocalEsportesById(@PathVariable Long id) {
        return localEsportesService.findLocalEsportesById(id)
                .map(localEsportes -> new ResponseEntity<>(localEsportes, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Criar novo local esportivo
    @PostMapping
    public ResponseEntity<LocalEsportes> createLocalEsportes(@RequestBody LocalEsportes localEsportes) {
        LocalEsportes newLocal = localEsportesService.saveLocalEsportes(localEsportes);
        return new ResponseEntity<>(newLocal, HttpStatus.CREATED);
    }

    // Atualizar um local esportivo
    @PutMapping("/{id}")
    public ResponseEntity<LocalEsportes> updateLocalEsportes(@PathVariable Long id, @RequestBody LocalEsportes localEsportes) {
        try {
            LocalEsportes updatedLocal = localEsportesService.saveLocalEsportes(localEsportes);
            return new ResponseEntity<>(updatedLocal, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Excluir um local esportivo
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLocalEsportes(@PathVariable Long id) {
        localEsportesService.deleteLocalEsportes(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Buscar locais esportivos por dono (proprietário)
    @GetMapping("/dono/{donoId}")
    public List<LocalEsportes> getLocaisPorDono(@PathVariable Long donoId) {
        return localEsportesService.findLocalEsportesByDono(donoId);
    }
}

package com.example.demo.controller;

import com.example.demo.entity.LocalEsportes;
import com.example.demo.service.LocalEsportesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/local-esportes")
public class LocalEsportesController {

    @Autowired
    private LocalEsportesService localEsportesService;

    // Buscar todos os locais esportivos
    @GetMapping
    public List<LocalEsportes> getAllLocalEsportes() {
        return localEsportesService.findAllLocalEsportes();
    }

    // Buscar um local esportivo pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<LocalEsportes> getLocalEsportesById(@PathVariable Long id) {
        return localEsportesService.findLocalEsportesById(id)
                .map(local -> new ResponseEntity<>(local, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

        // Criar novo local esportivo
    //@PostMapping
    //public ResponseEntity<LocalEsportes> createLocalEsportes(@RequestBody LocalEsportes localEsportes) {
    //    LocalEsportes newLocal = localEsportesService.saveLocalEsportes(localEsportes);
    //    return new ResponseEntity<>(newLocal, HttpStatus.CREATED);
    //}

    // Criar um novo local esportivo
    @PostMapping
    public LocalEsportes createLocalEsportes(@RequestBody LocalEsportes localEsportes) {
        return localEsportesService.saveLocalEsportes(localEsportes);
    }

    // Deletar um local esportivo pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLocalEsportes(@PathVariable Long id) {
        localEsportesService.deleteLocalEsportes(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Buscar locais esportivos por ID do dono
    @GetMapping("/dono/{donoId}")
    public List<LocalEsportes> getLocalEsportesByDonoId(@PathVariable Long donoId) {
        return localEsportesService.findByDonoId(donoId);
    }
}



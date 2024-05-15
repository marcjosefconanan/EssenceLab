package com.team3.essence.lavib.essence_lab.controllers;

import com.team3.essence.lavib.essence_lab.entities.Negozio;
import com.team3.essence.lavib.essence_lab.services.NegozioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping ("/negozio")
public class NegozioController {
    @Autowired
    private NegozioService negozioService;
    @PostMapping("/create")
    public ResponseEntity<Negozio> addNegozio(@RequestBody Negozio negozio){
        Negozio negozioAdded = negozioService.addNegozio(negozio);
        return ResponseEntity.ok().body(negozioAdded);
    }
    @GetMapping ("/readAll")
    public ResponseEntity<List<Negozio>> getAllNegozio (){
        List<Negozio> negozioView = negozioService.getAllNegozio();
        return ResponseEntity.ok().body(negozioView);
    }
    @GetMapping ("/readSingle/{id}")
    public ResponseEntity<Negozio> getNegozioId (@PathVariable Long id){
        Optional<Negozio> negozioOptional = negozioService.getNegozioId(id);
        if (negozioOptional.isPresent()){
            return ResponseEntity.ok().body(negozioOptional.get());
        }
        return ResponseEntity.notFound().build();
    }
    @PutMapping ("/update/{id}")
    public ResponseEntity<Negozio> updateNegozio (@PathVariable Long id, @RequestBody Negozio negozio){
        Optional <Negozio> negozioToUpdate = negozioService.updateNegozio(id, negozio);
        if (negozioToUpdate.isPresent()){
            return ResponseEntity.ok().body(negozioToUpdate.get());
        }
        return ResponseEntity.notFound().build();
    }
    @PutMapping ("/delete/{id}")
    public ResponseEntity<Negozio> deleteNegozio(@PathVariable Long id){
        Optional <Negozio> deleteNegozio = negozioService.deleteteNegozioById(id);
        if (deleteNegozio.isPresent()){
            return ResponseEntity.ok().body(deleteNegozio.get());
        }
        return ResponseEntity.notFound().build();
    }
    @GetMapping ("/readInactive")
    public ResponseEntity<List<Negozio>> findByInactive (){
        Optional<List<Negozio>> listNegozi = negozioService.getByRecordStatusInactive();
        if (listNegozi.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(listNegozi.get());
    }
}
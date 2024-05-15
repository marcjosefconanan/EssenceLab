package com.team3.essence.lavib.essence_lab.controllers;

import com.team3.essence.lavib.essence_lab.entities.Essenza;
import com.team3.essence.lavib.essence_lab.services.EssenzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/essenza")
public class EssenzaController {
    @Autowired
    private EssenzaService essenzaService;
    @PostMapping("/create")
    public ResponseEntity<Essenza> addEssenza(@RequestBody Essenza essenza){
        Essenza essenzaAdded = essenzaService.addEssenza(essenza);
       return ResponseEntity.ok().body(essenzaAdded);
    }
    @GetMapping("/readAll")
    public ResponseEntity<List<Essenza>> getListaEssenza(){
        List<Essenza> essenzaView = essenzaService.getAllEssenze();
        return ResponseEntity.ok().body(essenzaView);
    }
    @GetMapping("/readSingle/{id}")
    public ResponseEntity<Essenza> getEssenzaId(@PathVariable Long id){
        Optional<Essenza> essenzaOptional = essenzaService.getEssenzaId(id);
        if(essenzaOptional.isPresent()){
            return ResponseEntity.ok().body(essenzaOptional.get());
        }
      return ResponseEntity.notFound().build();
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Essenza> updateEssenza(@PathVariable Long id,@RequestBody Essenza essenza){
        Optional<Essenza> essenzaUpdate = essenzaService.updateEssenzaId(id,essenza);
        if(essenzaUpdate.isPresent()){
            return ResponseEntity.ok().body(essenzaUpdate.get());
        }
        return ResponseEntity.notFound().build();
    }
    @PutMapping("/delete/{id}")
    public ResponseEntity<Essenza> deleteEssenzaById(@PathVariable Long id) {
        Optional<Essenza> essenzaOptional = essenzaService.deleteEssenzaById(id);
        if (essenzaOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(essenzaOptional.get());
    }
    @GetMapping("/readInactive")
    public ResponseEntity<List<Essenza>> findByInactive(){
        Optional<List<Essenza>> listEssenze = essenzaService.getByRecordStatusInactive();
        if (listEssenze.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(listEssenze.get());
    }
}

package com.team3.essence.lavib.essence_lab.controllers;



import com.team3.essence.lavib.essence_lab.entities.Carrello;
import com.team3.essence.lavib.essence_lab.services.CarrelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Carrello")
public class CarrelloController {
    @Autowired
    private CarrelloService carrelloService;
    @PostMapping("/create")
    public ResponseEntity<Carrello> postCarrello(@RequestBody Carrello carrello) {
        Carrello carrelloAdded = carrelloService.addCarrello(carrello);
        return ResponseEntity.ok().body(carrelloAdded);
    }
    @GetMapping("/readAll")
    public ResponseEntity<List<Carrello>> getAllCarrelli() {
        List<Carrello> carrelloView = carrelloService.getCarrelli();
        return ResponseEntity.ok().body(carrelloView);
    }
    @GetMapping("/readSingle/{id}")
    public ResponseEntity<Carrello> getCarrello(@PathVariable Long id) {
        Optional<Carrello> carrelloOptional = carrelloService.getCarrello(id);
        if (carrelloOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(carrelloOptional.get());
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Carrello> updateCarrello(
            @PathVariable Long id,
            @RequestBody Carrello carrello) {
        Optional<Carrello> carrelloOptional = carrelloService.updateCarrello(carrello, id);
        if (carrelloOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(carrelloOptional.get());
    }
    @PutMapping("/delete/{id}")
    public ResponseEntity<Carrello> deleteCarrelloById(@PathVariable Long id) {
        Optional<Carrello> carrelloOptional = carrelloService.deleteCarrelloById(id);
        if (carrelloOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(carrelloOptional.get());
    }
    @GetMapping("/readInactive")
    public ResponseEntity<List<Carrello>> findByInactive(){
        Optional<List<Carrello>> listCarrello = carrelloService.getByRecordStatusInactive();
        if (listCarrello.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(listCarrello.get());
    }
    @PutMapping("/totalPrice/{id}")
    public ResponseEntity<Carrello> totalPrice(@PathVariable Long id){
        Optional<Carrello> carrello = carrelloService.calcoloPrezzoTotale(id);
        if (carrello.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(carrello.get());
    }
}

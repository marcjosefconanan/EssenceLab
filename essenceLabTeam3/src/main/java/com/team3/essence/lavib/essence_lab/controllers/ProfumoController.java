package com.team3.essence.lavib.essence_lab.controllers;

import com.team3.essence.lavib.essence_lab.Enum.EnumMarcaProfumo;
import com.team3.essence.lavib.essence_lab.entities.Profumo;
import com.team3.essence.lavib.essence_lab.services.ProfumoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/profumo")
public class ProfumoController {
    @Autowired
    private ProfumoService profumoService;
    @PostMapping("/create")
    public ResponseEntity<Profumo> addProfumo(@RequestBody Profumo profumo) {
        Profumo profumoAdded = profumoService.addProfumo(profumo);
        return ResponseEntity.ok().body(profumoAdded);
    }
    @GetMapping("/readAll")
    public ResponseEntity<List<Profumo>> getListaProfumo() {
        List<Profumo> profumoView = profumoService.getAllProfumi();
        return ResponseEntity.ok().body(profumoView);
    }
    @GetMapping("/readSingle/{id}")
    public ResponseEntity<Profumo> getProfumoId(@PathVariable Long id) {
        Optional<Profumo> profumoOptional = profumoService.getProfumoId(id);
        if (profumoOptional.isPresent()) {
            return ResponseEntity.ok().body(profumoOptional.get());
        }
        return ResponseEntity.notFound().build();
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Profumo> updateProfumo(@PathVariable Long id, @RequestBody Profumo profumo) {
        Optional<Profumo> profumoToUpdate = profumoService.updateProfumoId(id, profumo);
        if (profumoToUpdate.isPresent()) {
            return ResponseEntity.ok().body(profumoToUpdate.get());
        }
        return ResponseEntity.notFound().build();
    }
    @PutMapping("/delete/{id}")
    public ResponseEntity<Profumo> deleteProfumo(@PathVariable Long id) {
        Optional<Profumo> deactiveProfumo = profumoService.deleteProfumoById(id);
        if (deactiveProfumo.isPresent()) {
            return ResponseEntity.ok().body(deactiveProfumo.get());
        }
        return ResponseEntity.notFound().build();
    }
    @GetMapping("/readInactive")
    public ResponseEntity<List<Profumo>> findByInactive() {
        Optional<List<Profumo>> listaProfumi = profumoService.getByRecordStatusInactive();
        if (listaProfumi.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(listaProfumi.get());
    }
    @GetMapping("/readByPrice/{min}/{max}")
    public ResponseEntity<List<Profumo>> findByPriza(@PathVariable Double min, @PathVariable Double max){
        List<Profumo> profumoList = profumoService.getByRangePrice(min, max);
        return ResponseEntity.ok().body(profumoList);
    }
    @GetMapping("/readByMarca")
    public ResponseEntity<List<Profumo>> readByMarca(@RequestParam EnumMarcaProfumo enumMarcaProfumo){
        List<Profumo> profumi= profumoService.getByMarca(enumMarcaProfumo);
        return ResponseEntity.ok().body(profumi);
    }
}

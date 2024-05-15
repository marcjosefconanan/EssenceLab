package com.team3.essence.lavib.essence_lab.controllers;



import com.team3.essence.lavib.essence_lab.entities.Cliente;
import com.team3.essence.lavib.essence_lab.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;
    @PostMapping("/create")
    public ResponseEntity<Cliente> postCliente(@RequestBody Cliente clienteToAdd) {
        Cliente clienteAdded = clienteService.addCliente(clienteToAdd);
        return ResponseEntity.ok().body(clienteAdded);
    }
    @GetMapping("/readAll")
    public ResponseEntity<List<Cliente>> getAllClienti() {
        List<Cliente> clienteView = clienteService.getAllCliente();
        return ResponseEntity.ok().body(clienteView);
    }
    @GetMapping("/readSingle/{id}")
    public ResponseEntity<Cliente> getCliente(@PathVariable Long id) {
        Optional<Cliente> clienteOptional = clienteService.getCliente(id);
        if (clienteOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(clienteOptional.get());
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Cliente> updateCliente(
            @PathVariable Long id,
            @RequestBody Cliente cliente) {
        Optional<Cliente> clienteOptional = clienteService.updateCliente(cliente, id);
        if (clienteOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(clienteOptional.get());
    }
    @PutMapping("/delete/{id}")
    public ResponseEntity<Cliente> deleteClienteById(@PathVariable Long id) {
        Optional<Cliente> clienteOptional = clienteService.deleteClienteById(id);
        if (clienteOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(clienteOptional.get());
    }
    @GetMapping("/readInactive")
    public ResponseEntity<List<Cliente>> findByInactive(){
        Optional<List<Cliente>> listClient = clienteService.getByRecordStatusInactive();
        if (listClient.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(listClient.get());
    }
    @GetMapping("/readMaggiorenni")
    public ResponseEntity<List<Cliente>> findByMaggiorenni(){
        Optional<List<Cliente>> listOptional = clienteService.getClientiMaggiorenni();
        if (listOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(listOptional.get());
    }
    @GetMapping("/readMinorenni")
    public ResponseEntity<List<Cliente>> findByMinorenni(){
        Optional<List<Cliente>> listOptional = clienteService.getClientiMinorenni();
        if (listOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(listOptional.get());
    }
}
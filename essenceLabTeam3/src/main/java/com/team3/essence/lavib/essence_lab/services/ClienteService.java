package com.team3.essence.lavib.essence_lab.services;


import com.team3.essence.lavib.essence_lab.Enum.RecordStatusEnum;
import com.team3.essence.lavib.essence_lab.entities.Cliente;
import com.team3.essence.lavib.essence_lab.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    /**
     *
     * @param clienteToAdd
     * @return Salva l'oggetto e lo ritorna;
     */
    public Cliente addCliente(Cliente clienteToAdd) {
        return clienteRepository.save(clienteToAdd);
    }

    /**
     *
     * @return mostra la lista di tutti i clienti;
     */
    public List<Cliente> getAllCliente(){
       return clienteRepository.findAllActiveCliente();
    }

    /**
     *
     * @param id
     * @return mostra il cliente cercato tramite id;
     */
    public Optional<Cliente> getCliente(Long id) {
        return clienteRepository.findById(id);
    }

    /**
     *
     * @param cliente
     * @param id
     * @return cerca il cliente tramite l'id, lo aggiorna e lo
     *         mostra aggiornato o se non è presente mostra un oggetto vuoto
     */
    public Optional<Cliente> updateCliente(Cliente cliente, Long id) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        if (clienteOptional.isPresent()) {
            clienteOptional.get().setNome(cliente.getNome());
            clienteOptional.get().setCognome(cliente.getCognome());
            clienteOptional.get().setEmail(cliente.getEmail());
            clienteOptional.get().setCodiceFiscale(cliente.getCodiceFiscale());
            clienteOptional.get().setEta(cliente.getEta());
            clienteOptional.get().setGenere(cliente.getGenere());
            clienteOptional.get().setIndirizzo(cliente.getIndirizzo());
            clienteOptional.get().setCarrello(cliente.getCarrello());
            Cliente clienteUpdated = clienteRepository.save(clienteOptional.get());
            return Optional.of(clienteUpdated);
        } else {
            return Optional.empty();
        }
    }

    /**
     *
     * @param id
     * @return il recordStatusEnum del cliente inattivo
     */
    public Optional<Cliente> deleteClienteById(Long id) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        if (clienteOptional.isPresent()) {
            clienteOptional.get().setRecordStatusEnum(RecordStatusEnum.I);
            clienteRepository.save(clienteOptional.get());
        } else {
            return Optional.empty();
        }
        return clienteOptional;
    }

    /**
     *
     * @param id
     * @return il recordStatusEnum del cliente attivo
     */
    public Optional<Cliente> activeClienteById(Long id) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        if (clienteOptional.isPresent()) {
            clienteOptional.get().setRecordStatusEnum(RecordStatusEnum.A);
        } else {
            return Optional.empty();
        }
        return clienteOptional;
    }

    /**
     *
     * @return tutti i clienti inattivi
     */
    public Optional<List<Cliente>> getByRecordStatusInactive(){
        Optional<List<Cliente>> listClient = Optional.ofNullable(clienteRepository.findByRecordStatusEnum(RecordStatusEnum.I));
        return listClient;
    }

    /**
     *
     * @return tutti i clienti maggiorenni
     */
    public Optional<List<Cliente>> getClientiMaggiorenni(){
        Optional<List<Cliente>> clienti = Optional.ofNullable(clienteRepository.findByEtaMaggiorenne());
        if(clienti.isPresent()){
            return clienti;
        }else return Optional.empty();
    }

    /**
     *
     * @return tutti i clienti minorenni
     */
    public Optional<List<Cliente>> getClientiMinorenni(){
        Optional<List<Cliente>> clienti = Optional.ofNullable(clienteRepository.findByEtaMinorenne());
        if(clienti.isPresent()){
            return clienti;
        }else return Optional.empty();
    }

}
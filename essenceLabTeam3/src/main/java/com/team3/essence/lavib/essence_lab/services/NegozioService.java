package com.team3.essence.lavib.essence_lab.services;

import com.team3.essence.lavib.essence_lab.Enum.RecordStatusEnum;
import com.team3.essence.lavib.essence_lab.entities.Negozio;
import com.team3.essence.lavib.essence_lab.repositories.NegozioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NegozioService {
    @Autowired
    private NegozioRepository negozioRepository;

    /**
     *
     * @param negozio
     * @return Salva l'oggetto e lo ritorna;
     */
    public Negozio addNegozio(Negozio negozio) {
        return negozioRepository.save(negozio);
    }

    /**
     *
     * @return mostra la lista di tutti i negozi;
     */
    public List<Negozio> getAllNegozio() {
        return negozioRepository.findAllActiveNegozio();
    }

    /**
     *
     * @param id
     * @return mostra il negozio cercato tramite id;
     */
    public Optional<Negozio> getNegozioId(Long id) {
        return negozioRepository.findById(id);
    }

    /**
     *
     * @param negozio
     * @param id
     * @return cerca il negozio tramite l'id, lo aggiorna e lo
     *         mostra aggiornato o se non è presente mostra un oggetto vuoto
     */
    public Optional<Negozio> updateNegozio(Long id, Negozio negozio) {
        Optional<Negozio> updateNegozio = negozioRepository.findById(id);
        if (updateNegozio.isPresent()) {
            updateNegozio.get().setIndirizzo(negozio.getIndirizzo());
            updateNegozio.get().setNome(negozio.getNome());
            updateNegozio.get().setLuogo(negozio.getLuogo());
            updateNegozio.get().setPartitaIva(negozio.getPartitaIva());
            updateNegozio.get().setProfumi(negozio.getProfumi());
            Negozio negozioUpdate = negozioRepository.save(updateNegozio.get());
            return Optional.of(negozioUpdate);
        } else {
            return Optional.empty();
        }
    }

    /**
     *
     * @param id
     * @return il recordStatusEnum del negozio attivo
     */
    public Optional<Negozio> deleteteNegozioById(Long id) {
        Optional<Negozio> negozioOptional = negozioRepository.findById(id);
        if (negozioOptional.isPresent()) {
            negozioOptional.get().setRecordStatusEnum(RecordStatusEnum.I);
            negozioRepository.save(negozioOptional.get());
        } else {
            return Optional.empty();
        }
        return negozioOptional;
    }
    /**
     *
     * @param id
     * @return il recordStatusEnum diventa attivo
     */
    public Optional<Negozio> activeNegozioById(Long id) {
        Optional<Negozio> negozioOptional = negozioRepository.findById(id);
        if (negozioOptional.isPresent()) {
            negozioOptional.get().setRecordStatusEnum(RecordStatusEnum.A);
        } else {
            return Optional.empty();
        }
        return negozioOptional;
    }

    /**
     *
     * @return tutti i negozi inattivi
     */
    public Optional<List<Negozio>> getByRecordStatusInactive(){
        Optional<List<Negozio>> listNegozi = Optional.ofNullable(negozioRepository.findByRecordStatusEnum(RecordStatusEnum.I));
        return listNegozi;
    }
}

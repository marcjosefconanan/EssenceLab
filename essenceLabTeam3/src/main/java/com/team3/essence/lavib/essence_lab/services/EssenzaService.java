package com.team3.essence.lavib.essence_lab.services;

import com.team3.essence.lavib.essence_lab.Enum.RecordStatusEnum;
import com.team3.essence.lavib.essence_lab.entities.Essenza;
import com.team3.essence.lavib.essence_lab.repositories.EssenzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class EssenzaService {
    @Autowired
    private EssenzaRepository essenzaRepository;

    /**
     *
     * @param essenza
     * @return Salva l'oggetto e lo ritorna;
     */
    public Essenza addEssenza(Essenza essenza){
        return essenzaRepository.save(essenza);
    }

    /**
     *
     * @return mostra la lista di tutte le essenze;
     */
    public List<Essenza> getAllEssenze(){
        return essenzaRepository.findAllActiveEssenza();
    }

    /**
     *
     * @param id
     * @return mostra l'essenza cercata tramite id;
     */
    public Optional<Essenza> getEssenzaId(Long id){
        return essenzaRepository.findById(id);
    }

    /**
     *
     * @param essenza
     * @param id
     * @return cerca l'essenza tramite l'id, la aggiorna e la
     *         mostra aggiornata o se non è presente mostra un oggetto vuoto
     */
    public Optional<Essenza> updateEssenzaId(Long id,Essenza essenza){
        Optional<Essenza> updateEssenza = essenzaRepository.findById(id);
        if(updateEssenza.isPresent()){
            updateEssenza.get().setAllergeni(essenza.getAllergeni());
            updateEssenza.get().setDescrizione(essenza.getDescrizione());
            updateEssenza.get().setNome(essenza.getNome());
            updateEssenza.get().setIngredienti(essenza.getIngredienti());
            updateEssenza.get().setPrezzo(essenza.getPrezzo());
            updateEssenza.get().setProfumo(essenza.getProfumo());
            updateEssenza.get().setEnumTipoEssenza(essenza.getEnumTipoEssenza());
            Essenza essenzaUpdate = essenzaRepository.save(updateEssenza.get());
            return Optional.of(essenzaUpdate);
        }else{
            return Optional.empty();
        }
    }

    /**
     *
     * @param id
     * @return il recordStatusEnum dell'essenza inattiva
     */
    public Optional<Essenza> deleteEssenzaById(Long id) {
        Optional<Essenza> essenzaOptional = essenzaRepository.findById(id);
        if (essenzaOptional.isPresent()) {
            essenzaOptional.get().setRecordStatusEnum(RecordStatusEnum.I);
            essenzaRepository.save(essenzaOptional.get());
        } else {
            return Optional.empty();
        }
        return essenzaOptional;
    }

    /**
     *
     * @param id
     * @return il recordStatusEnum diventa attivo
     */
    public Optional<Essenza> activeEssenzaById(Long id) {
        Optional<Essenza> essenzaOptional = essenzaRepository.findById(id);
        if (essenzaOptional.isPresent()) {
            essenzaOptional.get().setRecordStatusEnum(RecordStatusEnum.A);
        } else {
            return Optional.empty();
        }
        return essenzaOptional;
    }

    /**
     *
     * @return tutte le essenze inattive
     */
    public Optional<List<Essenza>> getByRecordStatusInactive(){
        Optional<List<Essenza>> listEssenze = Optional.ofNullable(essenzaRepository.findByRecordStatusEnum(RecordStatusEnum.I));
        return listEssenze;
    }

}

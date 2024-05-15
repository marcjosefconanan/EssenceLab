package com.team3.essence.lavib.essence_lab.services;

import com.team3.essence.lavib.essence_lab.Enum.EnumMarcaProfumo;
import com.team3.essence.lavib.essence_lab.Enum.RecordStatusEnum;
import com.team3.essence.lavib.essence_lab.entities.Profumo;
import com.team3.essence.lavib.essence_lab.repositories.ProfumoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProfumoService {
    @Autowired
    private ProfumoRepository profumoRepository;

    /**
     * @param profumo
     * @return Salva l'oggetto e lo ritorna;
     */
    public Profumo addProfumo(Profumo profumo) {
        Profumo profumoToSave = profumoRepository.save(profumo);
        return profumoToSave;
    }

    /**
     * @return mostra la lista di tutti i profumi;
     */
    public List<Profumo> getAllProfumi() {
        return profumoRepository.findAllActiveProfumi();
    }

    /**
     * @param id
     * @return mostra il profumo cercato tramite id;
     */
    public Optional<Profumo> getProfumoId(Long id) {
        return profumoRepository.findById(id);
    }

    /**
     * @param profumoToUpdate
     * @param id
     * @return cerca il profumo tramite l'id, lo aggiorna e lo
     * mostra aggiornato o se non è presente mostra un oggetto vuoto
     */
    public Optional<Profumo> updateProfumoId(Long id, Profumo profumoToUpdate) {
        Optional<Profumo> profumoUpdate = profumoRepository.findById(id);
        if (profumoUpdate.isPresent()) {
            profumoUpdate.get().setAllergeni(profumoToUpdate.getAllergeni());
            profumoUpdate.get().setDescrizione(profumoToUpdate.getDescrizione());
            profumoUpdate.get().setIngredienti(profumoToUpdate.getIngredienti());
            profumoUpdate.get().setNome(profumoToUpdate.getNome());
            profumoUpdate.get().setPrezzo(profumoToUpdate.getPrezzo());
            profumoUpdate.get().setEnumMarcaProfumo(profumoToUpdate.getEnumMarcaProfumo());
            profumoUpdate.get().setEnumTipoProfumo(profumoToUpdate.getEnumTipoProfumo());
            profumoUpdate.get().setEssenze(profumoToUpdate.getEssenze());
            profumoUpdate.get().setNegozio(profumoToUpdate.getNegozio());
            profumoUpdate.get().setCarrello(profumoToUpdate.getCarrello());
            profumoUpdate.get().setEnumCategoriaProfumo(profumoToUpdate.getEnumCategoriaProfumo());
            Profumo profumoUpdated = profumoRepository.save(profumoUpdate.get());
            return Optional.of(profumoUpdated);
        } else {
            return Optional.empty();
        }
    }

    /**
     * @param id
     * @return il recordStatusEnum del profumo inattivo
     */
    public Optional<Profumo> deleteProfumoById(Long id) {
        Optional<Profumo> profumoOptional = profumoRepository.findById(id);
        if (profumoOptional.isPresent()) {
            profumoOptional.get().setRecordStatusEnum(RecordStatusEnum.I);
            profumoRepository.save(profumoOptional.get());
        } else {
            return Optional.empty();
        }
        return profumoOptional;
    }

    /**
     * @param id
     * @return il recordStatusEnum del profumo attivo
     */
    public Optional<Profumo> activeProfumopById(Long id) {
        Optional<Profumo> profumoOptional = profumoRepository.findById(id);
        if (profumoOptional.isPresent()) {
            profumoOptional.get().setRecordStatusEnum(RecordStatusEnum.A);
        } else {
            return Optional.empty();
        }
        return profumoOptional;
    }

    /**
     * @return lista profumi con recordstatus attivo
     */
    public Optional<List<Profumo>> getByRecordStatusActive() {
        Optional<List<Profumo>> listaProfumi = Optional.ofNullable(profumoRepository.findByRecordStatusEnum(RecordStatusEnum.A));
        return listaProfumi;
    }

    /**
     * @return tutti i profumi inattivi
     */
    public Optional<List<Profumo>> getByRecordStatusInactive() {
        Optional<List<Profumo>> listProfumi = Optional.ofNullable(profumoRepository.findByRecordStatusEnum(RecordStatusEnum.I));
        return listProfumi;
    }

    /**
     * @param min
     * @param max
     * @return tutti i profumi nel range di prezzo
     */
    public List<Profumo> getByRangePrice(Double min, Double max) {
        List<Profumo> profumi = profumoRepository.findAllActiveProfumi();
        List<Profumo> listaDiAppoggio = new ArrayList<>();
        for (Profumo p : profumi) {
            if (p.getPrezzo() <= max && p.getPrezzo() >= min) {
                listaDiAppoggio.add(p);
            }
        }
        return listaDiAppoggio;
    }

    /**
     *
     * @param enumMarcaProfumo
     * @return tutti i profumi con la marca inserita
     */
    public List<Profumo> getByMarca(EnumMarcaProfumo enumMarcaProfumo) {
        List<Profumo> profumi = profumoRepository.findByEnumMarcaProfumo(enumMarcaProfumo);
        return profumi;
    }
}

package com.team3.essence.lavib.essence_lab.repositories;

import com.team3.essence.lavib.essence_lab.Enum.EnumMarcaProfumo;
import com.team3.essence.lavib.essence_lab.Enum.RecordStatusEnum;
import com.team3.essence.lavib.essence_lab.entities.Cliente;
import com.team3.essence.lavib.essence_lab.entities.Profumo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProfumoRepository extends JpaRepository<Profumo, Long> {
    List<Profumo> findByRecordStatusEnum(RecordStatusEnum recordStatusEnum);
    @Query(value = "SELECT * FROM profumo where profumo.record_status = 'A'", nativeQuery = true)
    List<Profumo> findAllActiveProfumi();
    @Query(value = "SELECT * FROM profumo where profumo.id = :id and profumo.record_status = 'A'", nativeQuery = true)
    Optional<Profumo> findActiveProfumiById(@Param("id") Long id);


    List<Profumo> findByEnumMarcaProfumo(EnumMarcaProfumo enumMarcaProfumo);
}

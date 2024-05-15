package com.team3.essence.lavib.essence_lab.repositories;

import com.team3.essence.lavib.essence_lab.Enum.RecordStatusEnum;
import com.team3.essence.lavib.essence_lab.entities.Essenza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EssenzaRepository extends JpaRepository<Essenza, Long> {
    List<Essenza> findByRecordStatusEnum(RecordStatusEnum recordStatusEnum);
    @Query(value="SELECT * FROM essenza where essenza.record_status = 'A'", nativeQuery = true)
    List<Essenza> findAllActiveEssenza();
    @Query (value="SELECT * FROM essenza where essenza.id = :id and essenza.record_status = 'A'", nativeQuery = true)
    Optional<Essenza> findActiveEssenzaById(@Param("id") Long id);

}

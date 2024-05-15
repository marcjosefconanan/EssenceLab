package com.team3.essence.lavib.essence_lab.repositories;

import com.team3.essence.lavib.essence_lab.Enum.RecordStatusEnum;
import com.team3.essence.lavib.essence_lab.entities.Negozio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NegozioRepository extends JpaRepository<Negozio, Long> {
    List<Negozio> findByRecordStatusEnum(RecordStatusEnum recordStatus);
    @Query(value="SELECT * FROM negozio where negozio.record_status = 'A'", nativeQuery = true)
    List<Negozio> findAllActiveNegozio();
    @Query (value="SELECT * FROM negozio where negozio.id = :id and negozio.record_status = 'A'", nativeQuery = true)
    Optional<Negozio> findActiveNegozioById(@Param("id") Long id);
}
package com.team3.essence.lavib.essence_lab.repositories;

import com.team3.essence.lavib.essence_lab.Enum.RecordStatusEnum;
import com.team3.essence.lavib.essence_lab.entities.Carrello;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface CarrelloRepository extends JpaRepository<Carrello, Long> {
    List<Carrello> findByRecordStatusEnum(RecordStatusEnum recordStatusEnum);
    @Query(value="SELECT * FROM carrello where carrello.record_status = 'A'", nativeQuery = true)
    List<Carrello> findAllActiveCarrelli();
    @Query (value="SELECT * FROM carrello where carrello.id = :id and carrello.record_status = 'A'", nativeQuery = true)
    Optional<Carrello> findActiveCarrelliById(@Param("id") Long id);
}

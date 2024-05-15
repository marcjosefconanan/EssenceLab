package com.team3.essence.lavib.essence_lab.repositories;

import com.team3.essence.lavib.essence_lab.Enum.RecordStatusEnum;
import com.team3.essence.lavib.essence_lab.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    List<Cliente> findByRecordStatusEnum(RecordStatusEnum recordStatusEnum);
    @Query(value="SELECT * FROM cliente where cliente.record_status = 'A'", nativeQuery = true)
    List<Cliente> findAllActiveCliente();
    @Query (value="SELECT * FROM cliente where cliente.id = :id and cliente.record_status = 'A'", nativeQuery = true)
    Optional<Cliente> findActiveClienteById(@Param("id") Long id);
    @Query (value ="SELECT * FROM cliente where cliente.eta >= '18'", nativeQuery = true)
    List<Cliente> findByEtaMaggiorenne();
    @Query (value ="SELECT * FROM cliente where cliente.eta < '18'", nativeQuery = true)
    List<Cliente> findByEtaMinorenne();
}


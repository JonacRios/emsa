package com.emsa.client.repository;

import com.emsa.client.model.Person;
import com.emsa.client.model.EnergyRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface IEnergyRequestRepository extends JpaRepository<EnergyRequest, Long> {
    List<EnergyRequest> findByApplicant(Person applicant);
    EnergyRequest findByProcessId(String processId);
    EnergyRequest findFirstByOrderByRequestDateDesc();
}
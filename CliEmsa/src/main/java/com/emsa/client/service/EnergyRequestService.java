package com.emsa.client.service;

import com.emsa.client.model.Person;
import com.emsa.client.model.EnergyRequest;

import java.util.List;

public interface EnergyRequestService {
    List<EnergyRequest> getAllEnergyRequest();
    void createEnergyRequest(EnergyRequest EnergyRequest);
    void updateEnergyRequest(Long id, EnergyRequest EnergyRequest);
    void deleteEnergyRequest(Long id);
    List<EnergyRequest> findEnergyByPerson(Person person);
    EnergyRequest getPersonRequestByProcessId(String processId);
    EnergyRequest findFirstByOrderByRequestDateDesc();
}
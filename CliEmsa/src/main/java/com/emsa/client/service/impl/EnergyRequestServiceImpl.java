package com.emsa.client.service.impl;
import com.emsa.client.model.Person;
import com.emsa.client.model.EnergyRequest;
import com.emsa.client.repository.IEnergyRequestRepository;
import com.emsa.client.service.EnergyRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EnergyRequestServiceImpl implements EnergyRequestService {
    private final IEnergyRequestRepository EnergyRequestRepository;

    public List<EnergyRequest> getAllEnergyRequest() {
        return EnergyRequestRepository.findAll();
    }

    public void createEnergyRequest(EnergyRequest energyRequest) {
        EnergyRequestRepository.save(energyRequest);
    }

    public void updateEnergyRequest(Long id, EnergyRequest energyRequest) {
        if (EnergyRequestRepository.existsById(id)) {
            energyRequest.setCodRequest(id);
            EnergyRequestRepository.save(energyRequest);
        }
    }

    public void deleteEnergyRequest(Long id) {
        EnergyRequestRepository.deleteById(id);
    }

    public List<EnergyRequest> findEnergyByPerson(Person person) {
        return EnergyRequestRepository.findByApplicant(person);
    }

    public EnergyRequest getEnergyRequestByProcessId(String processId) {
        return EnergyRequestRepository.findByProcessId(processId);
    }

    public EnergyRequest findFirstByOrderByRequestDateDesc() {
        return EnergyRequestRepository.findFirstByOrderByRequestDateDesc();
    }

    public EnergyRequest getPersonRequestByProcessId(String processId) {
        return EnergyRequestRepository.findByProcessId(processId);
    }
}
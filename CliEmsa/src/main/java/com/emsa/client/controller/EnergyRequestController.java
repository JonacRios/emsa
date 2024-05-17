package com.emsa.client.controller;

import com.emsa.client.dto.EnergyInfoDTO;
import com.emsa.client.model.Person;
import com.emsa.client.model.EnergyRequest;
import com.emsa.client.service.impl.EnergyRequestServiceImpl;
import com.emsa.client.service.impl.PersonServiceImpl;
import com.emsa.client.service.impl.Person_LleForSol;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import com.emsa.client.util.RequestStatus;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/energy_request")
public class EnergyRequestController {
    private final EnergyRequestServiceImpl energyRequestService;
    private final PersonServiceImpl personService;
    private final Person_LleForSol marriedCoupleService;

    @GetMapping("/")
    public List<EnergyRequest> getAllEnergyRequests() {
        return energyRequestService.getAllEnergyRequest();
    }

    @GetMapping("/{personId}")
    public ResponseEntity<List<EnergyRequest>> findEnergyRequestsByPerson(@PathVariable String personId) {
        try {
            Person person = personService.getPersonById(personId);
            List<EnergyRequest> energyRequests = energyRequestService.findEnergyByPerson(person);
            return ResponseEntity.ok(energyRequests);
        } catch (jakarta.persistence.EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/create")
    public RedirectView createEnergyRequest(@ModelAttribute EnergyInfoDTO energyInfoDTO,
                                            RedirectAttributes redirectAttributes) throws IOException {
        Person person = energyInfoDTO.getPerson();
       
        if (person == null) {
            throw new IllegalArgumentException("No persons provided in the request");
        }
        personService.createPerson(person);
        EnergyRequest energyRequest = new EnergyRequest();
        energyRequest.setProcessId(energyInfoDTO.getProcessId());
        energyRequest.setBarrio(energyInfoDTO.getBarrio());
        energyRequest.setStatus(RequestStatus.DRAFT.toString());
        energyRequest.setTipo(energyInfoDTO.getTipo());
        energyRequest.setMedidor(energyInfoDTO.getMedidor());
        energyRequest.setEstrato(energyInfoDTO.getEstrato());
        energyRequest.setServicio(energyInfoDTO.getServicio());
        energyRequest.setRequestDate(LocalDateTime.now());
        energyRequest.setCountReviewCR(0L);
        energyRequest.setApplicant(person);
        energyRequestService.createEnergyRequest(energyRequest);
        energyInfoDTO.setApplicantPersonId(person.getId());
        redirectAttributes.addAttribute("personId", person.getId());

        List<EnergyRequest> updateEnergy = energyRequestService.findEnergyByPerson(person);
        energyInfoDTO.setCodRequest(updateEnergy.get(0).getCodRequest());
        String processId = marriedCoupleService.startProcessInstance(energyInfoDTO);
        System.out.println("***** PROCESS IDD: "+processId);
        for (EnergyRequest request : updateEnergy) {
            if ("DRAFT".equals(request.getStatus())) {
                request.setProcessId(processId);
                energyRequestService.updateEnergyRequest(request.getCodRequest(), request);
            }
        }

        return new RedirectView("/view-energy");
    }

    @PostMapping("/update/{id}")
    public RedirectView updateenergyRequest(@ModelAttribute("energyInfoDTO") EnergyInfoDTO energyInfoDTO) {
        Person person = energyInfoDTO.getPerson();
        
        // Actualizar la información de la persona
        personService.updatePerson(person.getId(), person);
    
        // Obtener la solicitud de crédito relacionada con la persona
        List<EnergyRequest> energyRequests = energyRequestService.findEnergyByPerson(person);
        
        // Asegurar que hay una solicitud de crédito disponible
        if (!energyRequests.isEmpty()) {
            EnergyRequest energyRequest = energyRequests.get(0);
    
            energyRequest.setStatus(RequestStatus.DRAFT.toString());
            energyRequest.setRequestDate(LocalDateTime.now());
            energyRequest.setBarrio(energyInfoDTO.getBarrio());
            energyRequest.setCountReviewCR(marriedCoupleService.getCountReview(energyRequest.getProcessId()));
    
            energyRequestService.updateEnergyRequest(energyRequest.getCodRequest(), energyRequest);
    
            String result = marriedCoupleService.updateProcessVariables(energyRequest.getProcessId(), energyRequest);
    
            return new RedirectView("/view-credit?personId="+result);
        } else {
            // Si no se encuentra ninguna solicitud de crédito, redirigir a alguna página de error o inicio
            return new RedirectView("/home");
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEnergyRequest(@PathVariable Long id) {
        energyRequestService.deleteEnergyRequest(id);
    }

    @GetMapping("/findbyid/{processId}")
    public EnergyRequest getEnergyRequestByProcessId(@PathVariable String processId) {
        return energyRequestService.getEnergyRequestByProcessId(processId);
    }

    @GetMapping("/latest-energy-request")
    public EnergyRequest getLatestEnergyRequest() {
        return energyRequestService.findFirstByOrderByRequestDateDesc();
    }
}

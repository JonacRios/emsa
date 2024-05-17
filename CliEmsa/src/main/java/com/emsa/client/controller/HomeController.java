package com.emsa.client.controller;

import com.emsa.client.model.Person;
import com.emsa.client.model.EnergyRequest;
import com.emsa.client.service.impl.EnergyRequestServiceImpl;
import com.emsa.client.service.impl.PersonServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final EnergyRequestServiceImpl energyRequestService;
    private final PersonServiceImpl personService;

    @GetMapping({"/home", ""})
    public String mainView(Model model) {
        model.addAttribute("titulo", "Bienvenidos a la página principal");
        return "inicio";
    }

    @GetMapping("/register-energy")
    public String registerInfoFormView(Model model){
        Person person = new Person(); 

        model.addAttribute("person", person);
        model.addAttribute("energyInfo", new EnergyRequest());

        return "views/energyForm";
    }

    @GetMapping("/view-energy")
    public String registerEnergyView(@RequestParam(name = "personId", required = false) String personId, Model model){
        if (personId == null) {
            EnergyRequest energyRequest = energyRequestService.findFirstByOrderByRequestDateDesc();
            personId = energyRequest.getApplicant().getId();
        }
        Person person = personService.getPersonById(personId);
        List<EnergyRequest> energyRequests = energyRequestService.findEnergyByPerson(person);

        model.addAttribute("person", person);
        model.addAttribute("energyRequests", energyRequests);

        return "views/listEnergy";
    }
}
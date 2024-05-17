package com.emsa.client.controller;

import com.emsa.client.dto.EnergyInfoDTO;
import com.emsa.client.service.impl.Person_LleForSol;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProcessController {
    private final Person_LleForSol personService;

    public ProcessController(Person_LleForSol personService) {
        this.personService = personService;
    }

    @PostMapping("/startProcess")
    public String startProcessInstance(@ModelAttribute EnergyInfoDTO energyInfoDTO) {
        this.personService.startProcessInstance(energyInfoDTO);
        return "redirect:/view-energy";
    }

    @GetMapping("/complete")
    public String completeTask(@RequestParam(name = "taskId") String taskId) {
        System.out.println("Llego aqui ruta buena");
        String resultado = this.personService.completeTask(taskId);
        return "redirect:/view-energy?personId="+resultado;
    }

    @GetMapping("/message-event")
    public String messageEvent(@RequestParam(name = "taskId") String taskId){
        System.out.println("Llego aqui ruta mala");
        personService.messageEvent(taskId);
        return "redirect:/view-energy";
    }
} 


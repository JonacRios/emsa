package com.emsa;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class rechazarSolicitud implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String descripcion = (String) delegateExecution.getVariable("descripcion");

        if(descripcion == null) {
            System.out.println("Solicitd rechazada por negacion de tarifa");
        }else{
            System.out.println("Solicitd rechazada: \n" + descripcion);
        }
    }
}

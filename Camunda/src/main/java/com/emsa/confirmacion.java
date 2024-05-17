package com.emsa;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class confirmacion implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String fechaTentativa = (String) delegateExecution.getVariable("fechaTentativa");
        String tecnico = (String) delegateExecution.getVariable("tecnico");
        String auxiliar = (String) delegateExecution.getVariable("auxiliar");
        String seguridad = (String) delegateExecution.getVariable("seguridad");

        System.out.println("++++++++++++++++++++++++++++++++++++++");
        System.out.println("La fecha de instalacion sera el dia: " + fechaTentativa);
        System.out.println("El nombre del tecnico es: " + tecnico);
        if(auxiliar != null){
            System.out.println("El nombre del auxiliar es: " + auxiliar);
        }
        if(seguridad != null){
            System.out.println("El nombre del seguridad es: " + seguridad);
        }
        System.out.println("++++++++++++++++++++++++++++++++++++++");
    }
}

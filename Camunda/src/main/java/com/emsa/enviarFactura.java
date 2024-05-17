package com.emsa;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class enviarFactura implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String tipoFac = (String) delegateExecution.getVariable("tipoFac");
        String consumo = (String) delegateExecution.getVariable("consumo");
        boolean checkMedidor = (boolean) delegateExecution.getVariable("checkMedidor");
        boolean checkInstalacion = (boolean) delegateExecution.getVariable("checkInstalacion");

        System.out.println("****************************************");
        System.out.println("***********Enviando factura*************");
        System.out.println("****************************************");

        System.out.println("****************************************");
        System.out.println(tipoFac);
        System.out.println("Consumo: " + consumo);
        if(checkMedidor){
            String medidor = (String) delegateExecution.getVariable("medidor");
            System.out.println("Medidor: "+medidor);
        }
        if(checkInstalacion){
            String instalacion = (String) delegateExecution.getVariable("instalacion");
            System.out.println("Instalacion: "+instalacion);
        }
    }
}

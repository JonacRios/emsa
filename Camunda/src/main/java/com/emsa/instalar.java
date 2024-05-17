package com.emsa;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class instalar implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        System.out.println("******************************************");
        System.out.println("***********Instalando servicio************");
        System.out.println("******************************************");
    }
}

package com.emsa;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class enviarTarifa implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String ruta = "Tarifas";
        String tarifa = (String) delegateExecution.getVariable("tarifasResultado");
        String nombre = (String) delegateExecution.getVariable("nombre");
        String barrio = (String) delegateExecution.getVariable("barrio");
        String adicional = (String) delegateExecution.getVariable("adicional");
        String archivo = nombre + ".txt";

        String rutaCompleta = ruta + File.separator + archivo;
        File file = new File(rutaCompleta);

        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write("Nombre: " + nombre + "\n");
            bw.write("Barrio: " + barrio + "\n");
            bw.write("Tarifa: " + tarifa + "\n");
            bw.write("Adicionales: " + adicional + "\n");

            bw.close();
        } catch (Exception e) {
            System.err.println("Error al escribir en el archivo " + e.getMessage());
        }
    }
}

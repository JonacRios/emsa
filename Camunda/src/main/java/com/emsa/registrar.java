package com.emsa;

import com.emsa.models.Usuario;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class registrar implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String id = (String) delegateExecution.getVariable("id");
        String nombre = (String) delegateExecution.getVariable("nombre");
        String numero = (String) delegateExecution.getVariable("numero");
        String direccion = (String) delegateExecution.getVariable("direccion");
        String barrio = (String) delegateExecution.getVariable("barrio");
        String estrato = (String) delegateExecution.getVariable("estrato");
        String tipo = (String) delegateExecution.getVariable("tipo");

        String archivo = "Usuarios\\usuarios.txt";
        Usuario nuevoUsuario = new Usuario(id, tipo, estrato, barrio, direccion, numero, nombre);
        System.out.println(nuevoUsuario.toString());

        List<Usuario> listaUsuarios = leerUsuarios(archivo);
        listaUsuarios.add(nuevoUsuario);
        escribirUsuarios(archivo, listaUsuarios);

        System.out.println("Usuario registrado");
    }

     private static List<Usuario> leerUsuarios(String archivoUsuarios) {
        List<Usuario> usuarios = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(archivoUsuarios);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            usuarios = (List<Usuario>) ois.readObject();
        } catch (IOException | ClassNotFoundException ignored) {

        }
         return usuarios;
    }

    private static void escribirUsuarios(String archivoUsuarios, List<Usuario> usuarios) {
        try (FileOutputStream fos = new FileOutputStream(archivoUsuarios);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(usuarios);
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e);
        }
    }
}

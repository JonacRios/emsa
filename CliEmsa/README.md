# Guía de Uso - Instalación de Cliente Energía EMSA
Este repositorio contiene el código fuente y los archivos necesarios para la implementación del servicio de instalación de Cliente Energía EMSA. El servicio se conecta el proceso de negocio de Emsa e inicia la instancia desde una vista del cliente.

Este es el link del repositorio publico https://github.com/JonacRios/Emsa/Cliente

## Requisitos Previos 

- Java 21 o una versión superior debe estar instalada en su sistema.
- Maven 3.9.6
- Tener Spring Boot instalado
- Tener el proceso  de Energia Emsa corriendo o ejecutado, para ser mas exacto tener este repositorio https://github.com/JonacRios/Emsa/Camunda en ejecucion.

## Pasos de Instalación

1. **Descarga del Proyecto:**
   - Clone o descargue el proyecto desde el repositorio.
2. **Descompresión del Archivo:**
   - En caso de haber desargado los archivos, descomprima el archivo descargado en el directorio deseado.

3. **Apertura en el Editor:**
   - Abra el proyecto en su IDE preferido. Se recomienda IntelliJ IDEA para una mejor experiencia de desarrollo o visual Studio Code.
4. **Configurar la base de datos H2:**
   - Buscar archivo que esta en CliEmsa/src/main/resource/aplication.properties
   - Editar con sus datos lo siguiente:
      - spring.datasource.url=jdbc:h2:file:C:/Users/FlyterGT/test
      - spring.datasource.username=sa
      - spring.datasource.password=
    - Tambien puede acceder a la base de datos h2 desde http://localhost:8080/h2-console
    - Cualquier problema con la base de datos H2 ver su documentacion 
5. **Ejecución del Programa:**
   - Ejecute el programa desde su IDE, en la parte superior derecha seleccione la opcion para correr el programa identificada con un triangulo que apunta hacia el lateral derecho o presione las teclas "Mayús + F10". La otra opcion seria  ir directamente a CliEmsa/src/main/java/Com/emsa/client/EmsaApplication.java y ejecutarlo desde alli. 
5. **Inicio del Servicio:**
   - Una vez realizado esto en la parte inferiro se le abrira una consola la cual indicara que el programa esta corriendo.

6. **Registrar un cliente:**
   - Ir a la ruta http://localhost:8081/register-energy
   En el momento que se le da save, se iniciara automaticamente una instancia en camunda, obvio esto solo funcionara si y solo si el proceso de negocio de camunda esta desplegado.
![image](https://github.com/JonacRios/emsa/blob/master/CliEmsa/src/main/resources/capturas/1.PNG)
7. **Ver inicio de instancia en Camunda:**
    - Una vez guardado la solicitud esta pasara automaticamente a camunda, quien recibira toda la informacion e iniciara una instancia.
    - ![image](https://github.com/JonacRios/emsa/blob/master/CliEmsa/src/main/resources/capturas/2.PNG)
    - Asi se miraria la instancia creada en camunda
    - ![image](https://github.com/JonacRios/emsa/blob/master/CliEmsa/src/main/resources/capturas/3.PNG)
    - Asi se miraria el cliente una vez creada la instancia y enviado los datos
    - ![image](https://github.com/JonacRios/emsa/blob/master/CliEmsa/src/main/resources/capturas/3.PNG)
    
7. **Confirmar el formulario:**
    - Una vez terminado de llenar todo, se le da confirmar y este enviara la confirmacion al camunda y completara automaticamente la tarea, asi.
    - ![image](https://github.com/JonacRios/emsa/blob/master/CliEmsa/src/main/resources/capturas/4.PNG)
    - ![image](https://github.com/JonacRios/emsa/blob/master/CliEmsa/src/main/resources/capturas/5.PNG)   
    -  Asi se miraria en el camunda
    - ![image](https://github.com/JonacRios/emsa/blob/master/CliEmsa/src/main/resources/capturas/5.PNG)   
    Una vez completada la tarea
    Sigue el flujo de negocio para que el servicio al cliente continue con la solicitud.


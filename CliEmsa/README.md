# Guía de Uso - Instalación de Cliente Energía EMSA

Este repositorio contiene el código fuente y los archivos necesarios para la implementación del servicio de instalación del Cliente Energía EMSA. El servicio se conecta al proceso de negocio de Emsa e inicia la instancia desde una vista del cliente.

Este es el enlace del repositorio público: [https://github.com/JonacRios/Emsa/Cliente](https://github.com/JonacRios/Emsa/Cliente)

## Requisitos Previos 

- Java 11 o una versión superior debe estar instalada en su sistema.
- Maven 3.9.6
- Tener Spring Boot instalado
- Tener el proceso de Energía Emsa corriendo o ejecutado. Para ser más exacto, tener este repositorio [https://github.com/JonacRios/Emsa/Camunda](https://github.com/JonacRios/Emsa/Camunda) en ejecución.

## Pasos de Instalación

1. **Descarga del Proyecto:**
   - Clone o descargue el proyecto desde el repositorio.

2. **Descompresión del Archivo:**
   - En caso de haber descargado los archivos, descomprima el archivo descargado en el directorio deseado.

3. **Apertura en el Editor:**
   - Abra el proyecto en su IDE preferido. Se recomienda IntelliJ IDEA para una mejor experiencia de desarrollo o Visual Studio Code.

4. **Configuración de la base de datos H2:**
   - Busque el archivo que está en `CliEmsa/src/main/resource/application.properties`.
   - Edite con sus datos lo siguiente:
      - `spring.datasource.url=jdbc:h2:file:C:/Users/FlyterGT/test`
      - `spring.datasource.username=sa`
      - `spring.datasource.password=`
    - También puede acceder a la base de datos H2 desde [http://localhost:8080/h2-console](http://localhost:8080/h2-console).
    - Cualquier problema con la base de datos H2 ver su documentación.

5. **Ejecución del Programa:**
   - Ejecute el programa desde su IDE, en la parte superior derecha seleccione la opción para correr el programa identificada con un triángulo que apunta hacia el lateral derecho o presione las teclas "Mayús + F10". La otra opción sería ir directamente a `CliEmsa/src/main/java/com/emsa/client/EmsaApplication.java` y ejecutarlo desde allí. 

6. **Inicio del Servicio:**
   - Una vez realizado esto, en la parte inferior se le abrirá una consola que indicará que el programa está corriendo.

7. **Registro de un cliente:**
   - Ir a la ruta [http://localhost:8081/register-energy](http://localhost:8081/register-energy).
   - Al guardar, se iniciará automáticamente una instancia en Camunda. Esto solo funcionará si el proceso de negocio de Camunda está desplegado.
   ![image](https://github.com/JonacRios/emsa/blob/master/CliEmsa/src/main/resources/capturas/1.PNG)

8. **Visualización de la instancia en Camunda:**
    - Una vez guardada la solicitud, esta pasará automáticamente a Camunda, quien recibirá toda la información e iniciará una instancia.
    - ![image](https://github.com/JonacRios/emsa/blob/master/CliEmsa/src/main/resources/capturas/3.PNG)
    - Así se miraría la instancia creada en Camunda
    - ![image](https://github.com/JonacRios/emsa/blob/master/CliEmsa/src/main/resources/capturas/2.PNG)
    - Así se miraría el cliente una vez creada la instancia y enviado los datos
    - ![image](https://github.com/JonacRios/emsa/blob/master/CliEmsa/src/main/resources/capturas/3.PNG)
    
9. **Confirmación del formulario:**
    - Una vez terminado de llenar todo, se le da confirmar y este enviará la confirmación a Camunda y completará automáticamente la tarea, así.
    - ![image](https://github.com/JonacRios/emsa/blob/master/CliEmsa/src/main/resources/capturas/4.PNG)  
    -  Así se miraría en el Camunda
    - ![image](https://github.com/JonacRios/emsa/blob/master/CliEmsa/src/main/resources/capturas/5.PNG)   
    Una vez completada la tarea
    Sigue el flujo de negocio para que el servicio al cliente continúe con la solicitud como se muestra en el README del proyecto Camunda.


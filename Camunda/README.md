# Guía de Uso - Instalación de Energía EMSA

Este repositorio contiene el código fuente y los archivos necesarios para la implementación del servicio de instalación de energía del EMSA. El servicio está modelado con Camunda BPM y se implementa con Spring Boot.

Este es el link del repositorio publico https://github.com/JonacRios/Software2
## Requisitos Previos


- Java 17 o una versión superior debe estar instalada en su sistema.
- Camunda BPM Run 7 debe estar configurado y ejecutándose en su entorno de desarrollo.

## Pasos de Instalación

1. **Descarga del Proyecto:**
   - Clone o descargue el proyecto desde el repositorio.

2. **Descompresión del Archivo:**
   - Descomprima el archivo descargado en el directorio deseado.

3. **Apertura en el Editor:**
   - Abra el proyecto en su IDE preferido. Se recomienda IntelliJ IDEA para una mejor experiencia de desarrollo.

     ![image](https://github.com/HermesMartinezZ/emsa/assets/98378769/812cdc92-1d66-4c1b-a0f5-586f737c17ed)

   - una vez dentro del programa, dirijase a la parte superior derecha donde encontrara la opcion "open" para abrir un nuevo projecto, haga click izquierdo sobre esta.

     ![image](https://github.com/HermesMartinezZ/emsa/assets/98378769/ef9a10b7-6fc1-4918-82d3-e5c90e0769da)

   - se le abrira una nueva ventana donde debe seleccionar el archivo que descargo y descomprimio en la ubicacion que usted lo guardó.

     ![image](https://github.com/HermesMartinezZ/emsa/assets/98378769/3326e08f-789b-4310-a3b3-b32b55985143)


4. **Ejecución del Programa:**
   - Ejecute el programa desde su IDE, en la parte superior derecha seleccione la opcion para correr el programa identificada con un triangulo que apunta hacia el lateral derecho o presione las teclas "Mayús + F10".
  
   ![image](https://github.com/HermesMartinezZ/emsa/assets/98378769/0ec5f791-093a-4f26-8da7-0959b96814e7)


5. **Inicio del Servicio:**
   - Una vez realizado esto en la parte inferiro se le abrira una consola la cual indicara que el programa esta corriendo, como se indica acontinuacion.

   ![image](https://github.com/HermesMartinezZ/emsa/assets/98378769/4355b722-078f-4aab-9058-2fbf4b796a2d)

6. **Acceso al Servicio:**
   - Una vez que el servicio esté en funcionamiento acceda al servicio mediante la siguiente dirección: [http://localhost:8080/camunda/app/tasklist/default/#/login](http://localhost:8080/camunda/app/tasklist/default/#/login).
   
7. **Ejecutar el Worker:**
    - Ejecutamos el archivo en una terminal de coomandos, el cual se llama validation.js, el cual esta en la carpeta "Software2/src/Worker"  . Lo ejecutamos colocando en la terminal el siguiente comando, "node ./valitation.js" 
   
8. **Inicio de Sesión:**
   - Una vez alli se le abrira una ventana como la siguiente.
  
     ![image](https://github.com/HermesMartinezZ/emsa/assets/98378769/68316ffa-f16e-4bcc-9491-2f6b757bcc9e)

   - Ingrese al servicio utilizando las siguientes credenciales:
     - Usuario: admin
     - Contraseña: admin

## Uso del Servicio

Una vez dentro del programa, siga estos pasos:

1. **Inicio del Proceso:**
   - 1.1 En la pestaña superior derecha, seleccione "Start Process"
  
     ![image](https://github.com/HermesMartinezZ/emsa/assets/98378769/2e102db6-9de7-4312-b313-393ff9d13799)

   - 1.2 Despues elija el proceso "EMSA" en la ventana desplegable.
  
     ![image](https://github.com/HermesMartinezZ/emsa/assets/98378769/807aaa62-0272-4eb7-8318-e79f566750fa)

   - 1.3 Ingrese los datos solicitados y haga clic en "Start".
  
     ![image](https://github.com/HermesMartinezZ/emsa/assets/98378769/f335ff68-c207-49f7-acbf-96842b120409)

      
2. **Verificación de Documentación:**
   - 2.1 Recargue la página y seleccione la opción "All Tasks" en el lateral izquierdo.
   - 2.2 Seleccione el proceso a utilizar y reclámelo dando click en "claim". Este paso se debe realizar con cada uno de los procesos.
  
     ![image](https://github.com/HermesMartinezZ/emsa/assets/98378769/60918d2c-1387-4a55-9c65-76ef44f36c88)

   - 2.3 En este caso el task a seleccionar es "Verificar Documentación - EMSA"
   - 2.4 Complete el formulario según sea necesario si no se tiene todos los requisitos solicitados en este se procedera a ir a la opcion 2.5,

      ![image](https://github.com/HermesMartinezZ/emsa/assets/98378769/c3f7cc51-b914-4058-be10-618ce99c5ced)

   - En cambio si se tiene todo se pasa al punto 3.

     ![image](https://github.com/HermesMartinezZ/emsa/assets/98378769/b850905d-9cb1-4de9-a479-69035a759805)
     
   - 2.5 **Rechazar solicitud:**
   - a continuacion se debe realizar el paso 2.2 y rellenar la informacion solicitada para luego completarla.
  
     ![image](https://github.com/HermesMartinezZ/emsa/assets/98378769/00af1e79-64d2-4758-ae31-997424bc6326)

   - En la consola del Intellij IDEA aparecera el mensaje "solicitud rechazada" mas el motivo de porque se rechazo esta.
  
     ![image](https://github.com/HermesMartinezZ/emsa/assets/98378769/123e27d8-3b25-49b6-847a-f298e4e0b092)

    - Finalizando el proceso. Si se desea seuir se debe empezar de nuevo desde el paso 1
     
4. **Recibir Respuesta del Cliente:**
   - Repita el proceso del paso anterior 2.2 para la tarea "Recibir Respuesta del Cliente".
  
     ![image](https://github.com/HermesMartinezZ/emsa/assets/98378769/588144d4-91bf-453a-ab04-4a34a2aaa6a1)

5. **Mostrar Términos y Condiciones:**
   - Repita el proceso para la tarea "Mostrar Términos y Condiciones".

     ![image](https://github.com/HermesMartinezZ/emsa/assets/98378769/d335c2e0-885e-4551-a64e-6955a10d8611)

6. **Firmar el Contrato:**
   - Repita el proceso para la tarea "Firmar el Contrato".
  
     ![image](https://github.com/HermesMartinezZ/emsa/assets/98378769/e35bccb8-2f3b-46fd-ab6f-e2900426d9d3)

7. **Asignar Fecha Tentativa:**
   - Ingrese una fecha y hora tentativa y complete la tarea.

     ![image](https://github.com/HermesMartinezZ/emsa/assets/98378769/340e29b0-7744-448a-bb8c-a9fa561a0c45)

8. **Verificar Disponibilidad del Técnico:**
   - Repita el proceso para las tareas "Verificar Disponibilidad del Técnico" y "Verificar si el Cliente Acepta la Fecha", si alguno de los dos no esta de acuerdo se deborvera al punto 6.
  
   - 7.1 Verificar Disponibilidad del Técnico:
  
     ![image](https://github.com/HermesMartinezZ/emsa/assets/98378769/ca619486-3817-4ec4-8787-fd1a09680866)

   - 7.1 Verificar si el Cliente Acepta la Fecha:
  
     ![image](https://github.com/HermesMartinezZ/emsa/assets/98378769/397f1a15-d2c5-4262-88b3-9b0db709def3)

9. **Verificar Materiales:**
   - Repita el proceso para la tarea "Verificar Materiales".
  
     ![image](https://github.com/HermesMartinezZ/emsa/assets/98378769/185e8dd2-cfc9-43d0-bf0f-2ef83e2dcbc3)

10. **Asignar Técnico Eléctrico:**
   - Ingrese el nombre del técnico asignado y complete la tarea.
  
     ![image](https://github.com/HermesMartinezZ/emsa/assets/98378769/28985b91-23e6-424d-b55f-c849a69d66b8)

Una vez completado el proceso, la instalación del servicio comenzará automáticamente. Espere hasta que en la consola de IntelliJ IDEA vea el mensaje indicando que el servicio se está instalando. Luego, vuelva al navegador, recargue la página y seleccione la tarea

   ![image](https://github.com/HermesMartinezZ/emsa/assets/98378769/780dbbd0-f2a7-4d17-8ac1-0f00f1a712c0)

10. **Registrar en el Sistema lo Realizado y Complicaciones:**
    - Después de completar todas las tareas anteriores, seleccione la nueva tarea "Registrar en el Sistema lo Realizado y Complicaciones" y complete el formulario.

      ![image](https://github.com/HermesMartinezZ/emsa/assets/98378769/640c73a6-f5b0-477a-9165-d6e90c305fb4)

11. **Determinar Costo de la Factura:**
    - Ingrese los valores para determinar el costo de la factura y complete la tarea.
   
      ![image](https://github.com/HermesMartinezZ/emsa/assets/98378769/681b423a-6b50-442e-bc54-6cba295393db)

12. **Proceso Completado**
    - Por ultimo se enviara la factura al cliente y en la consola del Intellij IDEA saldra el siguiente mensaje:
   
      ![image](https://github.com/HermesMartinezZ/emsa/assets/98378769/fe01d834-ee33-42d1-9e94-eb52059036d4)


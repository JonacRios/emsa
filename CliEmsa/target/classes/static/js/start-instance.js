function enviarFilaConEstadoDraft() {
    // Obtén todas las filas de la tabla
    var filas = document.querySelectorAll('#energyTable tbody tr');
    console.log("Llego aqui");
    // Itera a través de las filas y busca la fila con estado "DRAFT"
    for (var i = 0; i < filas.length; i++) {
        var estado = filas[i].querySelector('td:last-child span').textContent.trim();
        if (estado === "DRAFT") {
            // Encuentra la fila con estado "DRAFT", obtén los datos y envíalos al controlador
            var taskId = filas[i].querySelector('td:first-child span').textContent.trim();
            // Verificar el valor de la penúltima columna (penúltimo td) en la última fila
            var lastColumnValue = filas[i].querySelector("td:nth-last-child(2) span").textContent;

            // Console log para verificar los valores obtenidos
            console.log("Estado: " + estado);
            console.log("Task ID: " + taskId);
            console.log("Valor de la penúltima columna: " + lastColumnValue);

            // Crear un formulario oculto y agregar los datos a enviar
            var form = document.getElementById('routing');

                form.action = "/complete";
           

            // Después de obtener los valores
            document.getElementById('taskId').value = taskId;

            // Enviar el formulario
            form.submit();

            // Marcar que se envió el formulario
            formularioEnviado = true;
        }
    }
    console.log("Formulario enviado: " + formularioEnviado);
    if (formularioEnviado) {
        alert("¡Envío exitoso! La solicitud se ha enviado correctamente.");
    } else {
        alert("Error: No se pudo enviar la solicitud. Por favor, intenta nuevamente.");
    }
}

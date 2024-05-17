import { Client, Variables, logger } from "camunda-external-task-client-js"

const config = {
    baseUrl: "http://localhost:8080/engine-rest",
    use: logger
}

const client = new Client(config);

console.log("Worker de validación de documentos iniciado");

client.subscribe("validarDocumentos", async function ({ task, taskService }) {
    const autorizacion = task.variables.get("autorizacion");
    const estratificacion = task.variables.get("estratificacion");
    const recibo = task.variables.get("recibo");
    const tecnico = task.variables.get("tecnico");
    const tarjeta = task.variables.get("tarjeta");
    const viabilidad = task.variables.get("viabilidad");
    const certificacion = task.variables.get("certificacion");

    console.log("Validando documentos...");

    let validation = false;
    if (autorizacion == true && estratificacion == true && recibo == true && tecnico == true && tarjeta == true && viabilidad == true && certificacion == true) {
        validation = true;
        console.log("Documentación completa");
    }else{
        console.log("Documentación incompleta");
    }
    
    console.log("Documentos validados");

    const processVariables = new Variables();
    processVariables.set("validation", validation);

    console.log("Completando tarea de validación de documentos");
await taskService.complete(task, processVariables);
});

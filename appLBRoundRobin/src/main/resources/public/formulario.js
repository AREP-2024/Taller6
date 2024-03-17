
function guardar(){
    let inputmensaje = document.getElementById("mensaje");
    let endPoint = "/log?parametro=" + inputmensaje.value;
    let llamado = llamarAPI(endPoint);
    llamado.then((resultado)=>{
        let divrespuesta = document.getElementById("respuesta");
        divrespuesta.innerHTML = resultado;

    });

}

async function llamarAPI(endPoint){
    return await fetch(window.location.origin+endPoint)
        .then((response)=>{
            if(!response.ok){
                throw new Error();
            }
            return response.text();
        })

        .catch((error)=> alert(error));

}



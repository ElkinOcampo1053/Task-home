const registro = () => {
    var ErrorInformacion = false;
    var Mensaje = "";

    const username = document.getElementById("floatingInput").value;
    const email = document.getElementById("floatingCorreo").value;
    const password = document.getElementById("floatingPassword").value;
    const confirmarpassword = document.getElementById("floatingConfirmarPassword").value;

    if (username == "") {
        ErrorInformacion =true;

        Mensaje ="El NOMBRE DEL USUARIO es requerido";
    }
    if (email == "") {
        
        if (ErrorInformacion)
        {
            Mensaje = Mensaje + ", "
        }

        ErrorInformacion =true;
        Mensaje =Mensaje + "El CORREO ELECTRONICO es requerido";
    }
    if (password == "") {

        if (ErrorInformacion)
        {
            Mensaje = Mensaje + ", "
        }

        ErrorInformacion =true;
        Mensaje =Mensaje +"La CONTRASEÑA es requerida";
    }
    if (confirmarpassword == "") {

        if (ErrorInformacion)
        {
            Mensaje = Mensaje + ", "
        }

        ErrorInformacion =true;
        Mensaje =Mensaje +"La CONTRASEÑA de confirmacion es requerida";
    }

    if (password != confirmarpassword) {

        if (ErrorInformacion)
        {
            Mensaje = Mensaje + ", "
        }

        ErrorInformacion =true;
        sMensaje =Mensaje +"Las CONTRASEÑAS no coinciden";
    }

    if (ErrorInformacion== true)
    {
        showError(Mensaje);
        return;
    }

    const body = {
        "email": email
    };
    postTovalidateCorreo(body);


};

const postTovalidateCorreo = async (bodyObject) => {
    const url = "/api/registro";
    const response = await fetch(url, {
        method: "POST",
        body: JSON.stringify(bodyObject),
        headers: {
            "Content-Type": "application/json"
        }
    });

    if (response.ok) {
        const message = "El correo Electronico, ya se encuentra en uso, favor cambie de corrreo" ;
        showError(message);
    } else {
        //const message = await response.text();

        
        const message = "Correo Creado correctamente" ;
        showError(message);
    }
};

const showError = (message) => {
    alert(message, "danger");
}

const alert = (message, type) => {
    document.getElementById("errorBox").innerHTML = [
        `<div class="alert alert-${type} alert-dismissible" role="alert">`,
        `   <div>${message}</div>`,
        '   <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>',
        '</div>'
    ].join('')
}


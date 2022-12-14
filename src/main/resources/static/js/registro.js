const registro = () => {
    var ErrorInformacion = false;
    var Mensaje = "";

    var username = document.getElementById('nombre_usuario').value;
    var email = document.getElementById('email').value;
    var password = document.getElementById('password').value;
    var fechanac = document.getElementById('fecha_nacimiento').value;
    var idgrupo = document.getElementById('id_grupo_familiar').value;
    var tiempo = document.getElementById('tiempo_disponibilidad').value;

    if (tiempo =="")
    {
        ErrorInformacion = true;
        Mensaje = "El TIEMPO no puede estar vacio"
    }
    else
    {
        if (!isNumeric(tiempo)){
            ErrorInformacion = true;
            Mensaje = "El TIEMPO deben ser numerico"
        }
    }

    if (idgrupo =="")
    {
        ErrorInformacion = true;
        Mensaje = "El ID GRUPO no puede estar vacio"
    }
    else
    {
        if (!isNumeric(tiempo)){
            ErrorInformacion = true;
            Mensaje = "El TIEMPO DISP debe ser numerico"
        }
    }

    if (fechanac =="")
    {
        ErrorInformacion = true;
        Mensaje = "La FECHA DE NACIMIENTO no puede estar vacia"
    }

    if (email =="")
    {
        ErrorInformacion = true;
        Mensaje = "El CORREO ELECECTRONICO no puede estar vacio"
    }

    if (password =="")
    {
        ErrorInformacion = true;
        Mensaje = "La CONTRASEÑA no puede estar vacia"
    }

    if (username =="")
    {
        ErrorInformacion = true;
        Mensaje = "El NOMBRE USUARIO no puede estar vacio"
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
    const email = document.getElementById("email").value;

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
        
        Mensaje = ""
        showError(mensaje);
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

function habilitarboton(){
    var username = document.getElementById('nombre_usuario').value;
    var email = document.getElementById('email').value;
    var password = document.getElementById('password').value;
    var fechanac = document.getElementById('fecha_nacimiento').value;
    var idgrupo = document.getElementById('id_grupo_familiar').value;
    var tiempo = document.getElementById('tiempo_disponibilidad').value;

    if (!username=="" && !email=="" && !password=="" && !fechanac=="" && !idgrupo=="" && !tiempo=="") {
        document.getElementById('submitButton').disabled = false;
    } else {
        document.getElementById('submitButton').disabled = true;
    }
 
    
}

function isNumeric(val) {
    return /^-?\d+$/.test(val);
}
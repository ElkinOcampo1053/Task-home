const login = () => {
    var ErrorInformacion = false;
    var Mensaje = "";

    const email = document.getElementById("floatingInput").value;
    const password = document.getElementById("floatingPassword").value;
    var correoincorrecto =  document.getElementById("emailincorrecto").innerText ;
    var passwordincorrecto =  document.getElementById("passwordincorrecto").innerText ;

    if (email == "") {
        ErrorInformacion =true;
        Mensaje = Mensaje +  correoincorrecto + " \n";
    }
    if (password == "") {
        if (ErrorInformacion)
        {
            Mensaje = Mensaje + ", "
        }
        ErrorInformacion =true;
        Mensaje = Mensaje + passwordincorrecto + " \n";
    }

    if (ErrorInformacion== true)
    {
        showError(Mensaje);
        return;
    }
    
    const body = {
        "email": email,
        "password": password,
    };
    postToEmail(body);


};

const postToEmail = async (bodyObject) => {

    var menbienvenido =  document.getElementById("menbienvenido").innerText ;
    var mencredencialinvalida =  document.getElementById("mencredencialincorrecta").innerText ;

    const url = "/api/login";
    const response = await fetch(url, {
        method: "POST",
        body: JSON.stringify(bodyObject),
        headers: {
            "Content-Type": "application/json"
        }
    });

    if (response.ok) {
        const email = await response.json();
        
        localStorage.setItem("loggedUser", JSON.stringify(email));
        
        alert(menbienvenido + " " + email.email + " !", "success");
        
        await new Promise(r => setTimeout(r, 2000));

        window.location.href = "/principal";
    } else {
        //const message = await response.text();
        showError(mencredencialinvalida);
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


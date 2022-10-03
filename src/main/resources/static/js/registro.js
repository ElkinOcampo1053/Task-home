const registro = () => {
    const username = document.getElementById("floatingInput").value;
    const correo = document.getElementById("floatingCorreo").value;
    const password = document.getElementById("floatingPassword").value;
    const confirmarpassword = document.getElementById("floatingConfirmarPassword").value;

    if (username == "") {
        showError("El NOMBRE DEL USUARIO es requerido");
        return;
    }
    if (correo == "") {
        showError("El CORREO ELECTRONICO es requerido");
        return;
    }
    if (password == "") {
        showError("La CONTRASEÑA es requerida");
        return;
    }
    if (confirmarpassword == "") {
        showError("La CONTRASEÑA de confirmacion es requerida");
        return;
    }
    if (password != confirmarpassword) {
        showError("Las CONTRASEÑAS  no coinciden");
        return;
    }

    const body = {
        "username": username,
        "password": password
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
        const user = await response.json();

        localStorage.setItem("loggedUser", JSON.stringify(user));
        
        alert("Bienvenido "+user.username+"!", "success");
        
        await new Promise(r => setTimeout(r, 2000));

        window.location.href = "/principal";
    } else {
        const message = await response.text();
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

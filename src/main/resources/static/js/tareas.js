
function visualizarTareas(){
    if (document.getElementById('ListTareas').style.display == 'block')
    {
      document.getElementById('ListTareas').style.display = 'none';
    }
    else
    {
      document.getElementById('ListTareas').style.display = 'block';
    }
}

const ValidarInfo = () => {
  var ErrorInformacion = false;
  var Mensaje = "";

  var FechaEstimada = document.getElementById('fecha_estimada_ejecucion').value;
  var HoraEstimada = document.getElementById('hora_estimada_ejecucion').value;
  var IdTarea = document.getElementById('id_tarea').value;
  var IdUsuario = document.getElementById('id_usuario').value;
  var Idgrupo = document.getElementById('id_grupo_familiar').value;
  var Observaciones = document.getElementById('observaciones').value;
  var FechaFinalziacion = document.getElementById('fecha_finalizacion').value;
  var HoraFinalizacion = document.getElementById('hora_finalizacion').value;

  if (HoraFinalizacion =="")
  {
      ErrorInformacion = true;
      Mensaje = "LA HORA DE FINALIZACION no puede estar vacio"
  }
  else
  {
      if (!isNumeric(HoraFinalizacion)){
          ErrorInformacion = true;
          Mensaje = "LA HORA DE FINALIZACION debe ser numerico"
      }
  }

  if (FechaFinalziacion =="")
  {
      ErrorInformacion = true;
      Mensaje = "LA FECHA DE FINALIZACION no puede estar vacio"
  }
  else
  {
      if (!isNumeric(FechaFinalziacion)){
          ErrorInformacion = true;
          Mensaje = "LA FECHA DE FINALIZACION debe ser numerico"
      }
  }

  if (Observaciones =="")
  {
      ErrorInformacion = true;
      Mensaje = "EL DETALLE DE LA ACTIVIDAD no puede estar vacia"
  }

  if (Idgrupo =="")
  {
      ErrorInformacion = true;
      Mensaje = "El GRUPO no puede estar vacio"
  }else
  {
      if (!isNumeric(Idgrupo))
      {
          ErrorInformacion = true;
          Mensaje = "El GRUPO debe ser numerico"
      }
  }

  if (IdUsuario =="")
  {
      ErrorInformacion = true;
      Mensaje = "EL ID USUARIO no puede estar vacia"
  }

  if (HoraEstimada =="")
  {
      ErrorInformacion = true;
      Mensaje = "LA HORA ESTIMADA no puede estar vacio"
  }

  if (IdTarea =="")
  {
      ErrorInformacion = true;
      Mensaje = "EL ID TAREA no puede estar vacio"
  }

  if (FechaEstimada =="")
  {
      ErrorInformacion = true;
      Mensaje = "LA FECHA ESTIMADA no puede estar vacio"
  }

  if (ErrorInformacion== true)
  {
      showError(Mensaje);
      return;
  }

};

function isNumeric(val) {
  return /^-?\d+$/.test(val);
}

const showError = (message) => {
  document.getElementById('mensajeError').innerHTML = message ;
}

function habilitarboton(){
  var FechaEstimada = document.getElementById('fecha_estimada_ejecucion').value;
  var HoraEstimada = document.getElementById('hora_estimada_ejecucion').value;
  var IdTarea = document.getElementById('id_tarea').value;
  var IdUsuario = document.getElementById('id_usuario').value;
  var Idgrupo = document.getElementById('id_grupo_familiar').value;
  var Observaciones = document.getElementById('observaciones').value;
  var FechaFinalziacion = document.getElementById('fecha_finalizacion').value;
  var HoraFinalizacion = document.getElementById('hora_finalizacion').value;

  if (!FechaEstimada=="" && !HoraEstimada=="" && !IdTarea=="" && !IdUsuario=="" && !Idgrupo=="" && !Observaciones=="" && !FechaFinalziacion=="" && !HoraFinalizacion=="") {
      document.getElementById('submitButton').disabled = false;
  } else {
      document.getElementById('submitButton').disabled = true;
  }

  
}
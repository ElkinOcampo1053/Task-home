let tareas =[
    {Detalle: "Hacer ejercicio", HoraInicial: "7:00", HoraFinal:"8:00", Estado:"Finalizado" },
    {Detalle: "Sacar al Perro", HoraInicial: "8:00", HoraFinal:"9:00", Estado:"Finalizado" },
    {Detalle: "Sacudir", HoraInicial: "9:30", HoraFinal:"10:30", Estado:"Finalizado" },
    {Detalle: "Barrer", HoraInicial: "10:30", HoraFinal:"11:00", Estado:"Finalizado" },
    {Detalle: "Trapear", HoraInicial: "11:00", HoraFinal:"11:30", Estado:"Finalizado" },
    {Detalle: "Hacer el almuerzo", HoraInicial: "11:30", HoraFinal:"13:00", Estado:"Finalizado" }
];

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
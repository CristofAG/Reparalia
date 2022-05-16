//URL DEL MOCK GENERADO
var URL = 'http://reparinnova.mocklab.io/';
var URLAPI = 'http://localhost:8080/';
//Variable donde se accede al mapa y poder hacer modificaciones
map;
$(document).ready(function () {
    $('#botonModal').click();
    getLocation();
});
var latitud;
var longitud;

var paginasInteres = [
    {
        urlPagina: "https://manoalaobra.co/5-cosas-que-no-sabias-del-mundo-de-la-carpinteria-alucinante/",
        titulo: "5 cosas que no sabías de la carpintería",
        subtitulo: "¡Alucinante!",
        textoCuerpo: "El trabajo con madera es una de las actividades más ingeniosas y creativas, este oficio es uno de los primeros y más antiguos del mundo ¿lo sabías?"
    },
    {
        urlPagina: "https://decarpinteria.net/puedo-crear-un-taller-de-carpinteria-en-casa/",
        titulo: "¿Se puede crear un taller de carpintería en casa?",
        subtitulo: "¡Aquí te explicamos cómo!",
        textoCuerpo: "En este artículo te mostraremos algunas ventajas y desventajas que representa crear tu propio taller de carpintería en tu casa."
    },
    {
        urlPagina: "https://www.arqhys.com/arquitectura/plomeria-fontaneria.html",
        titulo: "Plomería o Fontanería",
        subtitulo: "¿Qué es?",
        textoCuerpo: "En este enlace aprenderás más acerca de este oficio de trabajar con tubos, tuberías y accesorios de plomería."
    },
    {
        urlPagina: "https://www.teknei.com/2021/11/09/que-es-y-que-utilidad-tiene-la-ingenieria-de-software/",
        titulo: "¿Qué es y qué utilidad tiene la Ingeniería de Software?",
        subtitulo: "Aprendamos más sobre esto",
        textoCuerpo: "Una disciplina formada por un conjunto de métodos, herramientas y técnicas que se utilizan en el desarrollo de programas informáticos, más conocidos como softwares."
    }
];

function getLocation() {
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(function (posicion) {
            latitud = posicion.coords.latitude;
            longitud = posicion.coords.longitude;
            console.log("Latitud: " + latitud + "\nLongitud: " + longitud);
            llamaApiServicios();
            getInfoSesion();

            //Dibujando el mapa con leaflet con centro en la ubicación del usuario
            map = L.map('map', {
                center: [latitud, longitud],
                zoom: 15
            });

            L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
                attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
            }).addTo(map);

            //Generar un marcador de color diferente para la ubicación del usuario
            var iconOptions = {
                iconUrl: './img/marker.png',
                iconSize: [40, 40]
            }

            var iconUbiActual = L.icon(iconOptions);

            L.marker([latitud, longitud], {
                title: 'Ubicación actual',
                icon: iconUbiActual
            }).addTo(map).bindPopup('Usted se encuentra aquí');

        });
    } else {
        $('#modalTexto').append('Tu navegador no soporta geolocalización :(');
    }
}

function llamaApiServicios() {
    //Configurando headers de la petición para hablar con la API
    $.ajaxSetup({
        headers: {
            'Accept': 'application/json'
        }
    });

    $.get(URLAPI + "v1/servicios", function (respuestaServicios, statusText, xhr) {
        //console.log("Respuesta del llamado a los servicios");
        //console.log(respuestaServicios);
        var indiceServ = 0;
        $("#spanServicio").append(respuestaServicios["listaServicios"][0].nombre);
        setInterval(() => {
            $("#spanServicio").empty();
            if (indiceServ < respuestaServicios["listaServicios"].length) {
                $("#spanServicio").append(respuestaServicios["listaServicios"][indiceServ].nombre);
                indiceServ++;
            } else {
                indiceServ = 0;
                $("#spanServicio").append("¡Muchos servicios más próximamente!")
            }
        }, 3000);
    })

    //Creación de las cartas debajo del mapa
    for (let i = 0; i < paginasInteres.length; i++) {
        $("#listaS").append("<div class='card text-center' style='border: 1px solid #222222; width: 18rem; margin: 10px 15px; box-shadow: 5px 7px 5px rgba(136, 136, 136, 0.2);'><div class='card-body'><h5 class='card-title'>" +
            paginasInteres[i].titulo +
            "</h5><h6 class='card-subtitle mb-2 text-muted'>" +
            paginasInteres[i].subtitulo +
            "</h6><p class='card-text'>" +
            paginasInteres[i].textoCuerpo +
            "</p><a href='" + paginasInteres[i].urlPagina + "' class='card-link' target='_blank' style='text-decoration: none;'>Ir al sitio <i class='bi bi-box-arrow-up-right'></i></a></div></div>");
    }

    //Petición a la API para obtener los datos de los empleados que ofrecen servicios
    $.get(URLAPI + "v1/empleados", function (respuestaEmpleados, statusText, xhr) {
        if (xhr.status == 200) {
            var punto1 = L.latLng(latitud, longitud);

            //console.log(respuestaEmpleados);

            for (let i = 0; i < respuestaEmpleados['listaEmpleados'].length; i++) {
                const element = respuestaEmpleados['listaEmpleados'][i];

                let punto2 = L.latLng(element['ubicacion'][0], element['ubicacion'][1]);
                let distancia = Math.round(punto1.distanceTo(punto2));

                L.marker([element['ubicacion'][0], element['ubicacion'][1]], {
                    title: 'Servicio ' + (i + 1)
                }).addTo(map).bindPopup('<strong>Nombre: </strong>' + element.nombre +
                    '<br><strong>Servicio: </strong>' + element.servicio +
                    //'<br><strong>Teléfono: </strong>' + element.telefono +
                    '<br><strong>Distancia a tu ubicación: </strong>' + distancia + "m<br><form action='reserva-servicio.html' id='formReserva' name='formReserva' method='get'><input type='hidden' name='idEmp' value='" + element.id +
                    "'><input type='hidden' name='nombreEmp' value='" + element.nombre +
                    "'><input type='hidden' name='servicioEmp' id='servicioEmp' value='" + element.servicio +
                    "'><input type='hidden' name='telefonoEmp' id='telefonoEmp' value='" + element.telefono +
                    "'><input type='hidden' name='latEmp' id='latEmp' value='" + element.ubicacion[0] +
                    "'><input type='hidden' name='lonEmp' id='lonEmp' value='" + element.ubicacion[1] +
                    "'><input type='submit' value='Reservar Servicio' style='width: 125px; background: none; border: none; text-decoration: underline; cursor: pointer; color: blue;'></form>");
            }
        } else {
            console.log('error: ' + statusText + ', ' + xhr.status);
        }
    })
}

function getInfoSesion() {
    var nombreU = sessionStorage.getItem("nombreUsuario");
    if (nombreU != null || nombreU != undefined) {
        $("#navegador").append("<span id='menuPerfil' style='color: aqua;' onClick='muestraMenu();'><i class='bi bi-person-circle'></i> " + nombreU + " </span>");
        $("#registroLink").remove();
    } else {
        console.warn("No se pudo obtener el nombre del usuario...");
    }
}

function muestraMenu() {
    console.log("Hola!");
}
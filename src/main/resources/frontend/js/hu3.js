//URL DEL MOCK GENERADO
var URL = 'https://reparacionesinnova.mocklab.io/';
//var URLAPI = 'http://localhost:8080/';
var URLAPI = window.location.protocol + "//" + window.location.host + "/";
$(document).ready(function () {

    $("#registro").click(function () {
        registrar();
    });
 
});

const nombre = document.getElementById("nombres")
const telefono = document.getElementById("telefono")
const correo =  document.getElementById("correo")
const pass = document.getElementById("contrasena")
let valido = false

function registrar() {

    let regexEmail = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/

    if (!$(nombre).val() || !$(telefono).val() || !$(correo).val() || !$(pass).val()) {
        alert('Debes llenar todos los campos');    
    }else{
        if(!regexEmail.test(correo.value)){
           alert('Formato de correo no valido'); 
           document.getElementById("correo").value = "";
        }else{
            if(pass.value.length < 8){
                alert('La contraseña es demasiado corta debe tener un mínimo de 8 digitos');
                document.getElementById("contrasena").value = ""; 
            }else{
                if(isNaN(telefono.value)){
                    alert('Debe ingresar un número de teléfono');
                    document.getElementById("telefono").value = "";
                }else{
                    if(telefono.value.length == 10){
                        valido = true
                    }else{
                        alert('El número teléfonico debe de ser de 10 digitos');
                        document.getElementById("telefono").value = ""; 
                    }
                }
            }
        }  
    }

    if(valido){

        if (document.getElementById("terminos").checked){
            getLocation();
        }else{
            alert('Debes aceptar los terminos y condiciones');
        }
    }  
} //fin registrar()

function getLocation() {
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(function (posicion) {
            latitud = posicion.coords.latitude;
            longitud = posicion.coords.longitude;
            console.log("Latitud: " + latitud + "\nLongitud: " + longitud);
            var arrUbicacion = [latitud,longitud];
            
            var t = telefono.value;
            console.log(typeof(t));

            var cuerpo = {
                ubicacion: arrUbicacion,
                nombre: nombre.value,
                telefono: telefono.value,
                correo: correo.value,
                contrasena: pass.value
            }
            
            var cuerpoJson = JSON.stringify(cuerpo);
            
            

             $.ajax({
                type: 'post',           
                url: URLAPI + 'v1/usuarios',           
                data: cuerpoJson,
                contentType: 'application/json',
                headers: {
                    'Accept': 'application/json'
                },
                traditional: true,       
                success: function (respuestaUsuario, statusText, xhr) {
                    
                    if (xhr.status == 201) {
                        console.log(xhr);
                        //swal( "El usuario se agrego exitosamente" ,  "" ,  "success" );
                        swal({
                            title: "El usuario se agrego exitosamente",
                            text: "",
                            icon: "success",
                            button: "Continuar"
                        }).then(function() {
                            document.getElementById("nombres").value = "";
                            document.getElementById("telefono").value = "";
                            document.getElementById("correo").value = "";
                            document.getElementById("contrasena").value = ""; 
                            document.getElementById("terminos").checked = false;
                            getInfoSesion(xhr);
                        });
                        

                    } else {
                        swal( "Usuario no agregado" ,  "El usuario ya existe" ,  "error" );
                        //console.log('error: ' + statusText + ', ' + xhr.status);
                    }
                }
               });

        });
    } else {
        $('#modalTexto').append('Tu navegador no soporta geolocalización :(');
    }
}//fin getLocation()

function getInfoSesion(xhr) {

    sessionStorage.setItem("idUsuario", xhr.responseJSON.id);
    sessionStorage.setItem("nombreUsuario", xhr.responseJSON.nombre);
    sessionStorage.setItem("telefonoUsuario", xhr.responseJSON.telefono);
    sessionStorage.setItem("correoUsuario", xhr.responseJSON.correo);
    sessionStorage.setItem("contrasenaUsuario", xhr.responseJSON.contrasena);
    sessionStorage.setItem("latitudUsuario", xhr.responseJSON.ubicacion[0]);
    sessionStorage.setItem("longitudUsuario", xhr.responseJSON.ubicacion[1]);

    $("#registrado").append("<span id='menuPerfil' style='color: aqua;' onClick='muestraMenu();'><i class='bi bi-person-circle'></i> " + sessionStorage.getItem("nombreUsuario") + " </span>");
    $("#registroLink").remove();
    window.location.href= 'index.html';
    //window.location = "index.html";
}
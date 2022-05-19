/**
 * Archivo JS de la HU-04 que lleva el control de 
 * reservación de servicios
 * @author Cristofer Alvarado
 */

/**
 * Obtenemos los datos del empleado del formulario escondido
 */
const urlParametros = new URLSearchParams(window.location.search);

var datosEmpleado = [];

costo = 0.0;
precioF = 0.0;

$(document).ready(function () {
    getInfoSesion();
    getInfoFormulario();
    getInfoPago();
});

function getInfoFormulario() {
    //Aquí vamos a guardar los datos del empleado
    urlParametros.forEach((value, key) => {
        datosEmpleado.push(value);
    });
    //Imprimimos los datos del empleado a reservar
    //console.log("El empleado a contratar es: ");
    console.log(datosEmpleado);

    costo = Math.random() * (500 - 250) + 250;
    precioF = round(costo);

    $("#nombreE").append(datosEmpleado[1]);
    $("#servicioE").append(datosEmpleado[2]);
    $("#telefonoE").append(datosEmpleado[3]);
    $("#costoS").append("$" + precioF + " MXN");
    document.getElementById("imagenEmpleado").src = './img/' + datosEmpleado[0] + '.jpg';
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

function round(num) {
    var m = Number((Math.abs(num) * 100).toPrecision(15));
    return Math.round(m) / 100 * Math.sign(num);
}

function getInfoPago() {
    paypal.Buttons({
        // Sets up the transaction when a payment button is clicked
        createOrder: (data, actions) => {
            return actions.order.create({
                purchase_units: [{
                    amount: {
                        value: precioF // Can also reference a variable or function
                    }
                }]
            });
        },
        // Finalize the transaction after payer approval
        onApprove: (data, actions) => {
            return actions.order.capture().then(function (orderData) {
                // Successful capture! For dev/demo purposes:
                console.log('Capture result', orderData, JSON.stringify(orderData, null, 2));
                const transaction = orderData.purchase_units[0].payments.captures[0];
                //alert(`Transaction ${transaction.status}: ${transaction.id}\n\nSee console for all available details`);
                //$("#contenedor-exitoso").append("<br><p>"+transaction.status+": "+transaction.id+"</p><br>");
                //$("#contenedor-exitoso").append("<p>Se abríra una nueva página que te llevará a WhatsApp para contactar con el empleado...</p>");
                Swal.fire({
                    icon: "success",
                    title: "¡Tu orden ha sido tomada correctamente!",
                    text: "El número de orden es: " + transaction.id,
                    showConfirmButton: true
                }).then(() => {
                    Swal.fire({
                        icon: "info",
                        title: "Abriendo una nueva página...",
                        text: "Se abrirá una nueva ventana donde podrá contactar por WhatsApp al empleado que solicitó."
                    }).then(() => {
                        console.log("Abriendo página de WhatsApp...");
                        window.open("https://wa.me/" + datosEmpleado[3], "_blank");
                        setTimeout(() => {
                            location.href = "index.html";
                        }, 500);
                    })
                })

                // When ready to go live, remove the alert and show a success message within this page. For example:
                // const element = document.getElementById('paypal-button-container');
                // element.innerHTML = '<h3>Thank you for your payment!</h3>';
                // Or go to another URL:  actions.redirect('thank_you.html');
            });
        }
    }).render('#paypal-button-container');
}
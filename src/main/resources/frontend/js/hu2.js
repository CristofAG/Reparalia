
$(document).ready(function(){

    //link para consultar
    //const getServicios= 'http://localhost:8080/v1/servicios';
    const getServicios = window.location.protocol + "//" +window.location.host + "/v1/servicios";
    console.log("URL DE PRUEBA PARA AWS: " + getServicios);
    let resultado;//va a guardar la consulta para no volver a hacer mas get
    //const getEmpleados= 'http://localhost:8080/v1/empleados';
    const getEmpleados = window.location.protocol + "//" +window.location.host + "/v1/empleados";
    let resultadoEmpleados;

    var map;

    if(sessionStorage.getItem("nombreUsuario")!=null){
      $("#registrado").append("<span id='menuPerfil' style='color: aqua;' onClick='muestraMenu();'><i class='bi bi-person-circle'></i> " + sessionStorage.getItem("nombreUsuario") + " </span>");
      $("#registroLink").remove();
    }
    

    

   
    //es necesario configuar el header si no no funciona la peticion
    $.ajaxSetup({
      headers: {
          'Accept': 'application/json'
      }
    });
    //realizamos la peticion
    $.get(getServicios, function(data){
      muestraServicios(data);
      resultado=data;//guardamos los datos de la consulta para no realizar mas 
      //console.log(resultado);
    });

    $.get(getEmpleados,function(data){
      resultadoEmpleados= data;
    });
    
    
    
    function muestraServicios(respuesta){

      //borramos el contenido del div para que no de dupliquen los servicios
      $('#tarjetas').empty();
      for(i=0; i<respuesta.listaServicios.length; i++){
          let servicio= respuesta.listaServicios[i];
            
          //creamos la tarjeta y la agregamos al div del html con el append
          $('#tarjetas').append($('<div class="servicio"><a href="reserva-servicio.html" id="'+servicio.nombre+'" class="text-decoration-none" data-bs-toggle="modal" data-bs-target="#modalConfirmation"><div class="servicio mt-5 bg-dark py-5 card text-white "><img src="./images/0'+i+'.jpg" alt="imagenPruebaPagina" class="card-img-top card-image"><h2 class="card-title fs-2 ">'+servicio.nombre+'</h1><p class=" fs-5  ">'+servicio.Descripcion+'</p> </div></a></div>'));
          
          $("#"+servicio.nombre).click(function(){
            if(sessionStorage.getItem("nombreUsuario")==null){
              alert('Debes registrarte primero');
              window.location.href='registro.html';
            }
            else{
              const servicioPedido= servicio.nombre;
              let empleadosFiltrados=[];
              //for para hacer una lista con los empleados dedicados al servicio pedido
              for(let k = 0 ; k<resultadoEmpleados.listaEmpleados.length; k++){
                let verificaEmp= resultadoEmpleados.listaEmpleados[k];
                if(verificaEmp.servicio== servicioPedido){
                  empleadosFiltrados.push(verificaEmp);
                }
              }
              if(empleadosFiltrados.length>0){
                let empleadoCercano, distancia;
                let empleado= empleadosFiltrados[0];
                let ubiEmpleado= empleado.ubicacion;
    
                let punto1 = L.latLng(sessionStorage.getItem('latitudUsuario'), sessionStorage.getItem("longitudUsuario"));
                let punto2= L.latLng(ubiEmpleado[0],ubiEmpleado[1]);
        
                distancia= Math.round(punto1.distanceTo(punto2));
                empleadoCercano= empleado;
                console.log(distancia);
                //for para comparar las distancias mas cortas
                for(let j=1; j<empleadosFiltrados.length; j++){
                  empleado= empleadosFiltrados[j];
                  ubiEmpleado= empleado.ubicacion;
                  punto2= L.latLng(ubiEmpleado[0],ubiEmpleado[1]);
                  distancia2= Math.round(punto1.distanceTo(punto2));
                  console.log(distancia2);
                  if(distancia2<distancia){
                    distancia= distancia2;
                    empleadoCercano= empleado
                  }
                  
                }
                console.log("distancia mas corta "+ distancia+ " empleado " + empleadoCercano.nombre);

                //muestra Nomber de trabajador
                $("#nombreEmpleado").empty();
                $("#nombreEmpleado").append('<div class="spinner-border" role="status"></div>');
                //spinner para darle un aspecto mas fluido 
                setTimeout(() => {   
                  $("#nombreEmpleado").empty();

                  $("#nombreEmpleado").append("Nombre: "+empleadoCercano.nombre +"<br>a: "+ distancia+"m");
                  
                  //forma para mandar info del empleado/*
                  $("#formaEmpleado").empty();
                  $("#formaEmpleado").append("<form action='reserva-servicio.html' id='formReserva' name='formReserva' method='get'><input type='hidden' name='idEmp' value='" + empleadoCercano.id +
                  "'><input type='hidden' name='nombreEmp' value='" + empleadoCercano.nombre +
                  "'><input type='hidden' name='servicioEmp' id='servicioEmp' value='" + empleadoCercano.servicio +
                  "'><input type='hidden' name='telefonoEmp' id='telefonoEmp' value='" + empleadoCercano.telefono +
                  "'><input type='hidden' name='latEmp' id='latEmp' value='" + empleadoCercano.ubicacion[0] +
                  "'><input type='hidden' name='lonEmp' id='lonEmp' value='" + empleadoCercano.ubicacion[1] +
                  "'><input type='submit'  value='Confirmar' class='form-control btn btn-dark'> </form>");
                }, 1000);
              }//fin if lista tiene elementos*/
              else{

                $("#nombreEmpleado").empty();
                $("#formaEmpleado").empty();
                $("#nombreEmpleado").append("No hay trabajadores disponibles :( ");
              }
            }
            
          });
                
      }
      
    }

    //funcion de busqueda
    $("#campoBusqueda").keyup(function(){
      let palabra= document.querySelector("#campoBusqueda").value;
      $('#tarjetas').empty();//borra tambien el evento on click por lo que hay que volver a generarlo 
      for(i=0; i<resultado.listaServicios.length; i++){
        //pasamos las palabras a minusculas para que no importe como se introduzcan el programa las encuentre
        if(resultado.listaServicios[i].nombre.toLowerCase().includes(palabra.toLowerCase())){
          let servicio= resultado.listaServicios[i];
    
          //creamos la tarjeta y la agregamos al div del html con el append
          $('#tarjetas').append($('<div class="servicio"><a href="reserva-servicio.html" id="'+servicio.nombre+'" class="text-decoration-none" data-bs-toggle="modal" data-bs-target="#modalConfirmation"><div class="servicio mt-5 bg-dark py-5 card text-white "><img src="./images/0'+i+'.jpg" alt="imagenPruebaPagina" class="card-img-top card-image"><h2 class="card-title fs-2 ">'+servicio.nombre+'</h1><p class=" fs-5  ">'+servicio.Descripcion+'</p> </div></a></div>'));


          //se agrega aqui tambien ya que al borrar el elemento se borra tambien el evento
          $("#"+servicio.nombre).click(function(){
            const servicioPedido= servicio.nombre;
            let empleadosFiltrados=[];
            if(sessionStorage.getItem("nombreUsuario")==null){
              alert('Debes registrarte primero');
              window.location.href='registro.html';
            }
            else{
              //for para hacer una lista con los empleados dedicados al servicio pedido
              for(let k = 0 ; k<resultadoEmpleados.listaEmpleados.length; k++){
                let verificaEmp= resultadoEmpleados.listaEmpleados[k];
                if(verificaEmp.servicio== servicioPedido){
                  empleadosFiltrados.push(verificaEmp);
                }
              }
              if(empleadosFiltrados.length>0){
                let empleadoCercano, distancia;
                let empleado= empleadosFiltrados[0];
                let ubiEmpleado= empleado.ubicacion;
    
                let punto1 = L.latLng(19.427572,-98.87886);
                let punto2= L.latLng(ubiEmpleado[0],ubiEmpleado[1]);
        
                distancia= Math.round(punto1.distanceTo(punto2));
                empleadoCercano= empleado;
                console.log(distancia);
                //for para comparar las distancias mas cortas
                for(let j=1; j<empleadosFiltrados.length; j++){
                  empleado= empleadosFiltrados[j];
                  ubiEmpleado= empleado.ubicacion;
                  punto2= L.latLng(ubiEmpleado[0],ubiEmpleado[1]);
                  distancia2= Math.round(punto1.distanceTo(punto2));
                  console.log(distancia2);
                  if(distancia2<distancia){
                    distancia= distancia2;
                    empleadoCercano= empleado
                  }
                  
                }
                console.log("distancia mas corta "+ distancia+ " empleado " + empleadoCercano.nombre);

                //muestra Nomber de trabajador
                $("#nombreEmpleado").empty();
                $("#nombreEmpleado").append('<div class="spinner-border" role="status"></div>');
                //spinner para darle un aspecto mas fluido 
                setTimeout(() => {   
                  $("#nombreEmpleado").empty();

                  $("#nombreEmpleado").append("Nombre: "+empleadoCercano.nombre +"<br>a: "+ distancia+"m");
                  
                  //forma para mandar info del empleado/*
                  $("#formaEmpleado").empty();
                  $("#formaEmpleado").append("<form action='reserva-servicio.html' id='formReserva' name='formReserva' method='get'><input type='hidden' name='idEmp' value='" + empleadoCercano.id +
                  "'><input type='hidden' name='nombreEmp' value='" + empleadoCercano.nombre +
                  "'><input type='hidden' name='servicioEmp' id='servicioEmp' value='" + empleadoCercano.servicio +
                  "'><input type='hidden' name='telefonoEmp' id='telefonoEmp' value='" + empleadoCercano.telefono +
                  "'><input type='hidden' name='latEmp' id='latEmp' value='" + empleadoCercano.ubicacion[0] +
                  "'><input type='hidden' name='lonEmp' id='lonEmp' value='" + empleadoCercano.ubicacion[1] +
                  "'><input type='submit'  value='Confirmar' class='form-control btn btn-dark'> </form>");
                }, 1000);
              }//fin if lista tiene elementos*/
              else{

                $("#nombreEmpleado").empty();
                $("#formaEmpleado").empty();
                $("#nombreEmpleado").append("No hay trabajadores disponibles :( ");
              }
            }
            
          });

        }
      } 
       
    });

    
});
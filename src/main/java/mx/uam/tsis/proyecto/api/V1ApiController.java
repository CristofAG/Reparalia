package mx.uam.tsis.proyecto.api;

import mx.uam.tsis.proyecto.api.dto.EmpleadoDto;
import mx.uam.tsis.proyecto.api.dto.ListaEmpleadosDto;
import mx.uam.tsis.proyecto.api.dto.ListaServiciosDto;
import mx.uam.tsis.proyecto.api.dto.ListaUsuariosDto;
import mx.uam.tsis.proyecto.api.dto.ServicioDto;
import mx.uam.tsis.proyecto.api.dto.UsuarioDto;
import mx.uam.tsis.proyecto.negocio.EmpleadoService;
import mx.uam.tsis.proyecto.negocio.ServicioService;
import mx.uam.tsis.proyecto.negocio.UsuarioService;
import mx.uam.tsis.proyecto.negocio.modelo.Empleado;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-05-04T20:52:40.169-05:00[America/Mexico_City]")
@RestController
@CrossOrigin(origins="*")
public class V1ApiController implements V1Api {

    private static final Logger log = LoggerFactory.getLogger(V1ApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    
    @Autowired
    private EmpleadoService empleadoService;
    
    @Autowired
    ServicioService servicioService;
    
    @Autowired
    UsuarioService usuarioService;

    @org.springframework.beans.factory.annotation.Autowired
    public V1ApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<?> v1EmpleadosGet() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                //return new ResponseEntity<ListaEmpleadosDto>(objectMapper.readValue("{\r\n  \"listaEmpleados\" : [ {\r\n    \"ubicacion\" : [ 0.8008281904610115 ],\r\n    \"servicio\" : \"Carpinteria\",\r\n    \"contrasena\" : \"4567\",\r\n    \"id\" : 1,\r\n    \"telefono\" : \"5512246687\",\r\n    \"nombre\" : \"Juan\"\r\n  }, {\r\n    \"ubicacion\" : [ 0.8008281904610115 ],\r\n    \"servicio\" : \"Carpinteria\",\r\n    \"contrasena\" : \"4567\",\r\n    \"id\" : 1,\r\n    \"telefono\" : \"5512246687\",\r\n    \"nombre\" : \"Juan\"\r\n  } ]\r\n}", ListaEmpleadosDto.class), HttpStatus.NOT_IMPLEMENTED);
            	ListaEmpleadosDto dto = empleadoService.retrieveAll();
            	return ResponseEntity
            			.status(HttpStatus.OK)
            			.header("Content-Type", "application/json")
            			.body(dto);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<ListaEmpleadosDto>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<ListaEmpleadosDto>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<EmpleadoDto> v1EmpleadosIdDelete(@Parameter(in = ParameterIn.PATH, description = "id del Empleado", required=true, schema=@Schema()) @PathVariable("id") Integer id) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<EmpleadoDto>(objectMapper.readValue("{\r\n  \"ubicacion\" : [ 0.8008281904610115 ],\r\n  \"servicio\" : \"Carpinteria\",\r\n  \"contrasena\" : \"4567\",\r\n  \"id\" : 1,\r\n  \"telefono\" : \"5512246687\",\r\n  \"nombre\" : \"Juan\"\r\n}", EmpleadoDto.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<EmpleadoDto>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<EmpleadoDto>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<?> v1EmpleadosIdGet(@Parameter(in = ParameterIn.PATH, description = "id del empleado", required=true, schema=@Schema()) @PathVariable("id") Integer id) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                //return new ResponseEntity<EmpleadoDto>(objectMapper.readValue("{\r\n  \"ubicacion\" : [ 0.8008281904610115 ],\r\n  \"servicio\" : \"Carpinteria\",\r\n  \"contrasena\" : \"4567\",\r\n  \"id\" : 1,\r\n  \"telefono\" : \"5512246687\",\r\n  \"nombre\" : \"Juan\"\r\n}", EmpleadoDto.class), HttpStatus.NOT_IMPLEMENTED);
            	EmpleadoDto dto = empleadoService.getById(id);
            	log.info("Obteniendo al empleado: Nombre=" +dto.getNombre()+ ", id="+dto.getId());
            	return ResponseEntity
            			.status(HttpStatus.OK)
            			.header("Content-Type", "application/json")
            			.body(dto);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<EmpleadoDto>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<EmpleadoDto>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<EmpleadoDto> v1EmpleadosIdPatch(@Parameter(in = ParameterIn.PATH, description = "id del empleado", required=true, schema=@Schema()) @PathVariable("id") Integer id,@Parameter(in = ParameterIn.DEFAULT, description = "", schema=@Schema()) @Valid @RequestBody EmpleadoDto body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<EmpleadoDto>(objectMapper.readValue("{\r\n  \"ubicacion\" : [ 0.8008281904610115 ],\r\n  \"servicio\" : \"Carpinteria\",\r\n  \"contrasena\" : \"4567\",\r\n  \"id\" : 1,\r\n  \"telefono\" : \"5512246687\",\r\n  \"nombre\" : \"Juan\"\r\n}", EmpleadoDto.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<EmpleadoDto>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<EmpleadoDto>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<EmpleadoDto> v1EmpleadosPost(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody EmpleadoDto body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                //return new ResponseEntity<EmpleadoDto>(objectMapper.readValue("{\r\n  \"ubicacion\" : [ 0.8008281904610115 ],\r\n  \"servicio\" : \"Carpinteria\",\r\n  \"contrasena\" : \"4567\",\r\n  \"id\" : 1,\r\n  \"telefono\" : \"5512246687\",\r\n  \"nombre\" : \"Juan\"\r\n}", EmpleadoDto.class), HttpStatus.NOT_IMPLEMENTED);
            	EmpleadoDto dtoE = empleadoService.create(body);
            	return ResponseEntity
            			.status(HttpStatus.CREATED)
            			.header("Location", "/v1/empleados/"+dtoE.getId())
            			.body(dtoE);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<EmpleadoDto>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<EmpleadoDto>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ListaServiciosDto> v1ServiciosGet() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                //return new ResponseEntity<ListaServiciosDto>(objectMapper.readValue("{\r\n  \"listaServicios\" : [ {\r\n    \"Descripcion\" : \"Solución a problemas de tuberías\",\r\n    \"id\" : 1,\r\n    \"nombre\" : \"Plomeria\"\r\n  }, {\r\n    \"Descripcion\" : \"Solución a problemas de tuberías\",\r\n    \"id\" : 1,\r\n    \"nombre\" : \"Plomeria\"\r\n  } ]\r\n}", ListaServiciosDto.class), HttpStatus.NOT_IMPLEMENTED);
            	ListaServiciosDto dto = servicioService.retrieveAll();
            	return ResponseEntity
            			.status(HttpStatus.OK)
            			.header("Content-Type", "application/json")
            			.body(dto);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<ListaServiciosDto>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<ListaServiciosDto>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<EmpleadoDto> v1ServiciosIdDelete(@Parameter(in = ParameterIn.PATH, description = "id del Empleado", required=true, schema=@Schema()) @PathVariable("id") Integer id) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<EmpleadoDto>(objectMapper.readValue("{\r\n  \"ubicacion\" : [ 0.8008281904610115 ],\r\n  \"servicio\" : \"Carpinteria\",\r\n  \"contrasena\" : \"4567\",\r\n  \"id\" : 1,\r\n  \"telefono\" : \"5512246687\",\r\n  \"nombre\" : \"Juan\"\r\n}", EmpleadoDto.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<EmpleadoDto>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<EmpleadoDto>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ServicioDto> v1ServiciosIdPatch(@Parameter(in = ParameterIn.PATH, description = "id del servicio", required=true, schema=@Schema()) @PathVariable("id") Integer id,@Parameter(in = ParameterIn.DEFAULT, description = "", schema=@Schema()) @Valid @RequestBody ServicioDto body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<ServicioDto>(objectMapper.readValue("{\r\n  \"Descripcion\" : \"Solución a problemas de tuberías\",\r\n  \"id\" : 1,\r\n  \"nombre\" : \"Plomeria\"\r\n}", ServicioDto.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<ServicioDto>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<ServicioDto>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ServicioDto> v1ServiciosPost(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody ServicioDto body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                //return new ResponseEntity<ServicioDto>(objectMapper.readValue("{\r\n  \"Descripcion\" : \"Solución a problemas de tuberías\",\r\n  \"id\" : 1,\r\n  \"nombre\" : \"Plomeria\"\r\n}", ServicioDto.class), HttpStatus.NOT_IMPLEMENTED);
            	ServicioDto dtoS = servicioService.create(body);
            	return ResponseEntity
            			.status(HttpStatus.CREATED)
            			.header("Location", "/v1/servicios/"+dtoS.getId())
            			.body(dtoS);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<ServicioDto>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<ServicioDto>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ListaUsuariosDto> v1UsuariosGet() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                //return new ResponseEntity<ListaUsuariosDto>(objectMapper.readValue("{\r\n  \"listaUsuarios\" : [ {\r\n    \"ubicacion\" : [ 0.8008281904610115 ],\r\n    \"correo\" : \"antonio@mail.com\",\r\n    \"contrasena\" : \"1234\",\r\n    \"id\" : 1,\r\n    \"telefono\" : \"5512246687\",\r\n    \"nombre\" : \"Antonio\"\r\n  }, {\r\n    \"ubicacion\" : [ 0.8008281904610115 ],\r\n    \"correo\" : \"antonio@mail.com\",\r\n    \"contrasena\" : \"1234\",\r\n    \"id\" : 1,\r\n    \"telefono\" : \"5512246687\",\r\n    \"nombre\" : \"Antonio\"\r\n  } ]\r\n}", ListaUsuariosDto.class), HttpStatus.NOT_IMPLEMENTED);
               ListaUsuariosDto dto= usuarioService.retrieveAll();
               return ResponseEntity
            		   .status(HttpStatus.OK)
            		   .header("Content-Type", "application/json")
           			   .body(dto);
            		   
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<ListaUsuariosDto>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<ListaUsuariosDto>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<UsuarioDto> v1UsuariosIdDelete(@Parameter(in = ParameterIn.PATH, description = "id del usuario", required=true, schema=@Schema()) @PathVariable("id") Integer id) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<UsuarioDto>(objectMapper.readValue("{\r\n  \"ubicacion\" : [ 0.8008281904610115 ],\r\n  \"correo\" : \"antonio@mail.com\",\r\n  \"contrasena\" : \"1234\",\r\n  \"id\" : 1,\r\n  \"telefono\" : \"5512246687\",\r\n  \"nombre\" : \"Antonio\"\r\n}", UsuarioDto.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<UsuarioDto>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<UsuarioDto>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<UsuarioDto> v1UsuariosIdGet(@Parameter(in = ParameterIn.PATH, description = "id del usuario", required=true, schema=@Schema()) @PathVariable("id") Integer id) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                //return new ResponseEntity<UsuarioDto>(objectMapper.readValue("{\r\n  \"ubicacion\" : [ 0.8008281904610115 ],\r\n  \"correo\" : \"antonio@mail.com\",\r\n  \"contrasena\" : \"1234\",\r\n  \"id\" : 1,\r\n  \"telefono\" : \"5512246687\",\r\n  \"nombre\" : \"Antonio\"\r\n}", UsuarioDto.class), HttpStatus.NOT_IMPLEMENTED);
            	UsuarioDto dto = usuarioService.getById(id);
            	log.info("Obteniendo al usuario: Nombre=" +dto.getNombre()+ ", id="+dto.getId());
            	return ResponseEntity
            			.status(HttpStatus.OK)
            			.header("Content-Type", "application/json")
            			.body(dto);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<UsuarioDto>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<UsuarioDto>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<UsuarioDto> v1UsuariosIdPatch(@Parameter(in = ParameterIn.PATH, description = "id del usuario", required=true, schema=@Schema()) @PathVariable("id") Integer id,@Parameter(in = ParameterIn.DEFAULT, description = "", schema=@Schema()) @Valid @RequestBody UsuarioDto body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<UsuarioDto>(objectMapper.readValue("{\r\n  \"ubicacion\" : [ 0.8008281904610115 ],\r\n  \"correo\" : \"antonio@mail.com\",\r\n  \"contrasena\" : \"1234\",\r\n  \"id\" : 1,\r\n  \"telefono\" : \"5512246687\",\r\n  \"nombre\" : \"Antonio\"\r\n}", UsuarioDto.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<UsuarioDto>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<UsuarioDto>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<UsuarioDto> v1UsuariosPost(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody UsuarioDto body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                //return new ResponseEntity<UsuarioDto>(objectMapper.readValue("{\r\n  \"ubicacion\" : [ 0.8008281904610115 ],\r\n  \"correo\" : \"antonio@mail.com\",\r\n  \"contrasena\" : \"1234\",\r\n  \"id\" : 1,\r\n  \"telefono\" : \"5512246687\",\r\n  \"nombre\" : \"Antonio\"\r\n}", UsuarioDto.class), HttpStatus.NOT_IMPLEMENTED);
            	UsuarioDto dtoU = usuarioService.create(body);
            	return ResponseEntity
            			.status(HttpStatus.CREATED)
            			.header("Location", "/v1/usuarios/"+dtoU.getId())
            			.body(dtoU);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<UsuarioDto>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<UsuarioDto>(HttpStatus.NOT_IMPLEMENTED);
    }

}

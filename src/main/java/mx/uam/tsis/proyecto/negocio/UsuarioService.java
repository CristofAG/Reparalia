package mx.uam.tsis.proyecto.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.uam.tsis.proyecto.api.dto.UsuarioDto;
import mx.uam.tsis.proyecto.datos.UsuarioRepository;
import mx.uam.tsis.proyecto.negocio.modelo.Usuario;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	
	public UsuarioDto create(UsuarioDto usuarioDto) {
		
		Usuario u = Usuario.builder()
				.nombre(usuarioDto.getNombre())
				.telefono(usuarioDto.getTelefono())
				.correo(usuarioDto.getCorreo())
				//.ubicacion(usuarioDto.getUbicacion())
				.contrasena(usuarioDto.getContrasena())
				.build();
		
		u = usuarioRepository.save(u);
		
		//Generamos el dto de Usuario que será regresado
		UsuarioDto dto = UsuarioDto.builder()
				.id(u.getId())
				.nombre(u.getNombre())
				.telefono(u.getTelefono())
				.correo(u.getCorreo())
				//.ubicacion(u.getUbicacion())
				.ubicacion(null)
				.contrasena(u.getContrasena())
				.build();
		
		return dto;
	}
}

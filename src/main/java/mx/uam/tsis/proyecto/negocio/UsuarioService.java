package mx.uam.tsis.proyecto.negocio;

import java.util.Iterator;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.uam.tsis.proyecto.api.dto.ListaUsuariosDto;
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
				.ubicacion(usuarioDto.getUbicacion())
				.contrasena(usuarioDto.getContrasena())
				.build();
		
		u = usuarioRepository.save(u);
		//Generamos el dto de Usuario que será regresado
		UsuarioDto dto = UsuarioDto.builder()
				.id(u.getId())
				.nombre(u.getNombre())
				.telefono(u.getTelefono())
				.correo(u.getCorreo())
				.ubicacion(u.getUbicacion())
				.contrasena(u.getContrasena())
				.build();
		
		return dto;
	}
	
	public ListaUsuariosDto retrieveAll() {
		Iterable <Usuario> listaRepo = usuarioRepository.findAll();
		ListaUsuariosDto dto = new ListaUsuariosDto();
		Usuario iteraUsuario;
		UsuarioDto auxDto;
		Iterator<Usuario> it = listaRepo.iterator();
		while(it.hasNext()) {
			iteraUsuario = it.next();
			auxDto = UsuarioDto.builder()
					.id(iteraUsuario.getId())
					.nombre(iteraUsuario.getNombre())
					.telefono(iteraUsuario.getTelefono())
					.correo(iteraUsuario.getCorreo())
					.ubicacion(iteraUsuario.getUbicacion())
					.ubicacion(iteraUsuario.getUbicacion())
					.contrasena(iteraUsuario.getContrasena())
					.build();
			dto.addListaUsuariosItem(auxDto);
		}
		return dto;
	}
	
	public UsuarioDto getById(Integer id) {
		
		Optional <Usuario> usuarioOpt = usuarioRepository.findById(id);
		UsuarioDto dto = UsuarioDto.builder()
				.id(usuarioOpt.get().getId())
				.nombre(usuarioOpt.get().getNombre())
				.telefono(usuarioOpt.get().getTelefono())
				.correo(usuarioOpt.get().getCorreo())
				.ubicacion(usuarioOpt.get().getUbicacion())
				.ubicacion(usuarioOpt.get().getUbicacion())
				.contrasena(usuarioOpt.get().getContrasena())
				.build();
		return dto;
	}
}

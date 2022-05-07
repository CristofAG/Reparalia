package mx.uam.tsis.proyecto.negocio;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.tools.sjavac.Log;

import mx.uam.tsis.proyecto.api.dto.EmpleadoDto;
import mx.uam.tsis.proyecto.api.dto.ListaEmpleadosDto;
import mx.uam.tsis.proyecto.datos.EmpleadoRepository;
import mx.uam.tsis.proyecto.negocio.modelo.Empleado;

/*
 * 
 * Servicio de empleados para peticiones.
 * @author Cristofer Alvarado
 * 
 * */

@Service
public class EmpleadoService {
	
	@Autowired
	EmpleadoRepository empleadoRepository;
	
	public EmpleadoDto create(EmpleadoDto empleadoDto) {
		
		Empleado e = Empleado.builder()
				.nombre(empleadoDto.getNombre())
				.contrasena(empleadoDto.getContrasena())
				.servicio(empleadoDto.getServicio())
				.telefono(empleadoDto.getTelefono())
				.ubicacion(empleadoDto.getUbicacion())
				.build();
		
		e = empleadoRepository.save(e);
		
		//Generamos el dto que será regresado
		EmpleadoDto dto = EmpleadoDto.builder()
				.id(e.getId())
				.nombre(e.getNombre())
				.contrasena(e.getContrasena())
				.servicio(e.getServicio())
				.telefono(e.getTelefono())
				.ubicacion(e.getUbicacion())
				.build();
				
		return dto;
	}
	
	public ListaEmpleadosDto retrieveAll() {
		Iterable <Empleado> listaRepo = empleadoRepository.findAll();
		ListaEmpleadosDto dto = new ListaEmpleadosDto();
		Empleado iteraEmpleado;
		EmpleadoDto auxDto;
		Iterator<Empleado> it = listaRepo.iterator();
		while(it.hasNext()) {
			iteraEmpleado = it.next();
			auxDto = EmpleadoDto.builder()
					.id(iteraEmpleado.getId())
					.nombre(iteraEmpleado.getNombre())
					.contrasena(iteraEmpleado.getContrasena())
					.servicio(iteraEmpleado.getServicio())
					.telefono(iteraEmpleado.getTelefono())
					.ubicacion(iteraEmpleado.getUbicacion())
					.build();
			dto.addListaEmpleadosItem(auxDto);
		}
		return dto;
	}
	
	public EmpleadoDto getById(Integer id) {
		
		Optional <Empleado> empleadoOpt = empleadoRepository.findById(id);
		EmpleadoDto dto = EmpleadoDto.builder()
				.id(empleadoOpt.get().getId())
				.nombre(empleadoOpt.get().getNombre())
				.contrasena(empleadoOpt.get().getContrasena())
				.servicio(empleadoOpt.get().getServicio())
				.telefono(empleadoOpt.get().getTelefono())
				.ubicacion(empleadoOpt.get().getUbicacion())
				.build();
		return dto;
	}
}

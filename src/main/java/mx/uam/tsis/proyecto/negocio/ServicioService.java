package mx.uam.tsis.proyecto.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.uam.tsis.proyecto.api.dto.ServicioDto;
import mx.uam.tsis.proyecto.datos.ServicioRepository;
import mx.uam.tsis.proyecto.negocio.modelo.Servicio;

@Service
public class ServicioService {

	@Autowired
	ServicioRepository servicioRepository;
	
	public ServicioDto create(ServicioDto servicioDto) {
		
		Servicio s = Servicio.builder()
				.nombre(servicioDto.getNombre())
				.descripcion(servicioDto.getDescripcion())
				.build();
		
		s = servicioRepository.save(s);
		
		//Generamos el dto de Servicio que será regresado
		ServicioDto dto = ServicioDto.builder()
				.id(s.getId())
				.nombre(s.getNombre())
				.descripcion(s.getDescripcion())
				.build();
		
		return dto;
	}
}

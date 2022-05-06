package mx.uam.tsis.proyecto.negocio.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity // Indica que hay que persistir en BD
@EqualsAndHashCode
public class Servicio {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String nombre;
	
	private String descripcion;
}

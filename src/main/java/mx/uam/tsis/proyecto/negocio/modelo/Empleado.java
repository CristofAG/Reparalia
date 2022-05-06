package mx.uam.tsis.proyecto.negocio.modelo;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
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
public class Empleado {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String nombre;
	
	@ElementCollection
	private List<Float> ubicacion;
	//private float[] ubicacion = new float[2];
	
	private String telefono;
	
	private String servicio;
	
	private String contrasena;
	
}

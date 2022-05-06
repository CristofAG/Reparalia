package mx.uam.tsis.proyecto.datos;

import org.springframework.data.repository.CrudRepository;
import mx.uam.tsis.proyecto.negocio.modelo.Empleado;

public interface EmpleadoRepository extends CrudRepository<Empleado, Integer>{

}

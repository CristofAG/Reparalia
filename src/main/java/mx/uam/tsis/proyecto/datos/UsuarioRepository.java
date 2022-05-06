package mx.uam.tsis.proyecto.datos;

import org.springframework.data.repository.CrudRepository;

import mx.uam.tsis.proyecto.negocio.modelo.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer>{

}

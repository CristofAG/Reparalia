package mx.uam.tsis.proyecto;

import mx.uam.tsis.proyecto.configuration.LocalDateConverter;
import mx.uam.tsis.proyecto.configuration.LocalDateTimeConverter;
import mx.uam.tsis.proyecto.datos.EmpleadoRepository;
import mx.uam.tsis.proyecto.datos.ServicioRepository;
import mx.uam.tsis.proyecto.datos.UsuarioRepository;
import mx.uam.tsis.proyecto.negocio.modelo.Empleado;
import mx.uam.tsis.proyecto.negocio.modelo.Servicio;
import mx.uam.tsis.proyecto.negocio.modelo.Usuario;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.oas.annotations.EnableOpenApi;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@EnableOpenApi
@ComponentScan(basePackages = { "mx.uam.tsis.proyecto", "mx.uam.tsis.proyecto.api" , "mx.uam.tsis.proyecto.configuration"})
public class Swagger2SpringBoot implements CommandLineRunner {

	@Autowired
	EmpleadoRepository empleadoRepository;
	
	@Autowired
	ServicioRepository servicioRepository;
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
    @Override
    public void run(String... arg0) throws Exception {
        if (arg0.length > 0 && arg0[0].equals("exitcode")) {
            throw new ExitException();
        }
    }

    public static void main(String[] args) throws Exception {
        new SpringApplication(Swagger2SpringBoot.class).run(args);
    }

    @Configuration
    static class CustomDateConfig extends WebMvcConfigurerAdapter {
        @Override
        public void addFormatters(FormatterRegistry registry) {
            registry.addConverter(new LocalDateConverter("yyyy-MM-dd"));
            registry.addConverter(new LocalDateTimeConverter("yyyy-MM-dd'T'HH:mm:ss.SSS"));
        }
    }

    class ExitException extends RuntimeException implements ExitCodeGenerator {
        private static final long serialVersionUID = 1L;

        @Override
        public int getExitCode() {
            return 10;
        }

    }
    
    @PostConstruct
    public void iniciaBD() {
    	
    	//Inicializando la BD con los empleados
    	List<Float> ubiEmpleado1 = new ArrayList<Float>();
    	ubiEmpleado1.add((float) 19.428198);
    	ubiEmpleado1.add((float) -98.877453);
    	Empleado empleado1 = new Empleado(1, "Roberto Gómez", ubiEmpleado1, "5587983211", "Carpintería", "1234");
    	empleadoRepository.save(empleado1);
    	
    	List<Float> ubiEmpleado2 = new ArrayList<Float>();
    	ubiEmpleado2.add((float) 19.427572);
    	ubiEmpleado2.add((float) -98.878857);
    	Empleado empleado2 = new Empleado(2, "Carmen Salinas", ubiEmpleado2, "5598348721", "Plomería", "2345");
    	empleadoRepository.save(empleado2);
    	
    	List<Float> ubiEmpleado3 = new ArrayList<Float>();
    	ubiEmpleado3.add((float) 19.426036);
    	ubiEmpleado3.add((float) -98.887769);
    	Empleado empleado3 = new Empleado(3, "Vicente Fernández", ubiEmpleado3, "5576382183", "Carpintería", "5555");
    	empleadoRepository.save(empleado3);
    	
    	List<Float> ubiEmpleado4 = new ArrayList<Float>();
    	ubiEmpleado4.add((float) 19.424101);
    	ubiEmpleado4.add((float) -98.883182);
    	Empleado empleado4 = new Empleado(4, "Alfredo Martínez", ubiEmpleado4, "1306255993", "Plomería", "OCeVelu5Vutr");
    	empleadoRepository.save(empleado4);
    	
    	List<Float> ubiEmpleado5 = new ArrayList<Float>();
    	ubiEmpleado5.add((float) 19.421754);
    	ubiEmpleado5.add((float) -98.887227);
    	Empleado empleado5 = new Empleado(5, "Kennie Rodríguez", ubiEmpleado5, "7975552484", "Carpintería", "ZlztqSW");
    	empleadoRepository.save(empleado5);
    	
    	//Iniciando servicios en la BD
    	Servicio servicio1 = new Servicio(1, "Plomería", "Solución a problemas de tuberías");
    	servicioRepository.save(servicio1);
    	
    	Servicio servicio2 = new Servicio(2, "Albañilería", "Crea la casa de tus sueños");
    	servicioRepository.save(servicio2);
    	
    	Servicio servicio3 = new Servicio(3, "Pintura", "Haz realidad tus ideas");
    	servicioRepository.save(servicio3);
    	
    	Servicio servicio4 = new Servicio(4, "Carpintería", "¡Creación de muebles a medida y más!");
    	servicioRepository.save(servicio4);
    	
    	//Iniciando la BD con algunos usuarios
    	List<Float> ubiUsuario1 = new ArrayList<Float>();
    	ubiUsuario1.add((float) 19.4282224);
    	ubiUsuario1.add((float) -98.8792526);
    	Usuario usuario1 = new Usuario(1, "Cristofer Alvarado", "9832436127", "chiripa900@gmail.com", ubiUsuario1, "BC6lIQ8L3");
    	usuarioRepository.save(usuario1);
    }
    
}

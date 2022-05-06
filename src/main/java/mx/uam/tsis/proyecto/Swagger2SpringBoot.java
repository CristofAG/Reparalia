package mx.uam.tsis.proyecto;

import mx.uam.tsis.proyecto.configuration.LocalDateConverter;
import mx.uam.tsis.proyecto.configuration.LocalDateTimeConverter;
import mx.uam.tsis.proyecto.datos.EmpleadoRepository;
import mx.uam.tsis.proyecto.negocio.modelo.Empleado;

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
    	Empleado empleado1 = new Empleado(1, "Cristofer A.", ubiEmpleado1, "5587983211", "Carpintería", "1234");
    	empleadoRepository.save(empleado1);
    	
    	List<Float> ubiEmpleado2 = new ArrayList<Float>();
    	ubiEmpleado2.add((float) 19.427572);
    	ubiEmpleado2.add((float) -98.878857);
    	Empleado empleado2 = new Empleado(2, "Carmen Salinas", ubiEmpleado2, "5598348721", "Plomería", "2345");
    	empleadoRepository.save(empleado2);
    	
    	List<Float> ubiEmpleado3 = new ArrayList<Float>();
    	ubiEmpleado3.add((float) 19.23456);
    	ubiEmpleado3.add((float) -98.2342323);
    	Empleado empleado3 = new Empleado(3, "Vicente Fernández", ubiEmpleado3, "5576382183", "Carpintería", "5555");
    	empleadoRepository.save(empleado3);
    	
    	/*List<Float> ubiEmpleado4 = new ArrayList<Float>();
    	ubiEmpleado4.add((float) );*/
    }
    
}

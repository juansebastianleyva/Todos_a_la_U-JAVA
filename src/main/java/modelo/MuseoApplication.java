package modelo;



import controlador.Controlador;
import java.util.List;
import java.util.Optional;
import modelo.RepositorioMuseo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import vista.Vista;
import vista.Vista;


@SpringBootApplication
public class MuseoApplication {
        
        @Autowired
        RepositorioMuseo repositorio;
    
	public static void main(String[] args) {
		//SpringApplication.run(MuseoApplication.class, args);
                
            SpringApplicationBuilder builder = new SpringApplicationBuilder(MuseoApplication.class);
            builder.headless(false);
            ConfigurableApplicationContext context = builder.run(args);    
	}

        @Bean
        ApplicationRunner applicationRunner (){
            return args -> {
          
            final Log logger = LogFactory.getLog(getClass()); 
            
            Controlador controlador = new Controlador(repositorio, new Vista());
            
            /*logger.info(controlador.listar());
            Museo m = Museo.crearMuseo("Museo Panela", "Tolima");
            controlador.crear(m);
            logger.info(controlador.buscar(1L));
            logger.info(controlador.listar());
            controlador.eliminar(controlador.buscar(5L));
 
            Museo museoDeArte = Museo.crearMuseo("Museo de Arte", "Bogotá");
            Museo museoDelCafe = Museo.crearMuseo("Museo del Café", "Medellín");
            Museo museoNacional = Museo.crearMuseo("Museo de Nacional", "Cali");
            Museo museoDeBotero = Museo.crearMuseo("Museo de Botero", "Tunja");
                   
            // Agregamos los dos registros a la base de datos
            repositorio.save(museoDeArte);
            repositorio.save(museoDelCafe);
            repositorio.save(museoNacional);
            repositorio.save(museoDeBotero);
           
                 
            // Listar Museo
            
            List<Museo> resultado = (List<Museo>) repositorio.findAll();
            logger.info(resultado);
            
            logger.info("Listar Personas: " + repositorio.findAll());

            
            
            // Contar registros en la BD
            
            logger.info("Cantidad de museos: " + repositorio.count());
            logger.info("Persona id:1 " + repositorio.findById(1L).get());
            
            Museo resultado1 = repositorio.findById(1L).get();

            logger.info(resultado1 + "ddd");
                
            /*
            // Buscar persona con idPersona = 1
            logger.info("Persona id:1 " + repositorio.findById(1L).get());
           
            // Actualizar persona con idPersona = 2
            // Primero buscamos la persona que deseamos actualizar
            Persona persona3 = repositorio.findById(2L).get();
            
            // Actualizamos los atributos del objeto
            persona3.setNombre("Carlos");
            persona3.setApellido("Díaz");
            persona3.setCiudad("Cali");
            persona3.setProfesion("Abogado");
            
            // Actualizamos en BD
            repositorio.save(persona3);
            logger.info("Listar Personas: " + repositorio.findAll());


            // Eliminar persona con idPersona = 1
            repositorio.deleteById(1L);
            logger.info("Listar Personas: " + repositorio.findAll());
*/
            };

    }
}
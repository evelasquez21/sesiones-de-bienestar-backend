package gt.edu.umg.programacion2.proyectoFinal.sesionDeBienestar;

import java.math.BigInteger;
import java.time.LocalDate;
import models.Usuario;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SesionDeBienestarApplication {

	public static void main(String[] args) {
		SpringApplication.run(SesionDeBienestarApplication.class, args);
                
                // Prueba de creacion de usuario
                Usuario u1 = new Usuario("svelasqueze21@gmail.com", "123", BigInteger.valueOf(3030207170108L), "Eduardo Steve Velasquez Gomez", "KM22 ctra. Ciudad Quetzal", LocalDate.of(2005, 3, 14), 37099950);
                System.out.println(u1.toString());
	}

}

package org.una.tramites_aeropuerto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.una.tramites_aeropuerto.reports.ConeccionReporte;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@EnableSwagger2
@SpringBootApplication
public class TramitesAeropuertoApplication {

	public static void main(String[] args) {
                
		SpringApplication.run(TramitesAeropuertoApplication.class, args);
               
	}

}

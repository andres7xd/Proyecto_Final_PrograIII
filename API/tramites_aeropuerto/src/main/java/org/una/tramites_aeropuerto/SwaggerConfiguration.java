/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites_aeropuerto;

import java.util.Collections;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 *
 * @author andre
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(
                        RequestHandlerSelectors
                                .basePackage("org.una.tramites_aeropuerto.controllers"))
                .paths(PathSelectors.regex("/.*"))
                .build()
                .apiInfo(apiInfo())
                .tags(new Tag("Usuarios", "Entidad de Usuarios"),
                        new Tag("Marcas_horario", "Entidad Marcas_horario"),
                        new Tag("Roles", "Entidad Roles"),
                        new Tag("Notificaciones", "Entidad Notificaciones"),
                        new Tag("Imagenes", "Entidad Imagenes")
                );
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Tramites de Aeropuerto",
                "Rest API About Aeropuerto",
                "Versi�n:2.1.0",
                "https://google.com",
                new Contact("UNA Sede Regi�n Brunca", "https://srb.una.ac.cr/index.php/es/", "decanatosrb@una.cr") {
        },
                "Apache-2.0", "http://www.apache.org/licenses/LICENSE-2.0", Collections.emptyList()
        );
    }
    
}

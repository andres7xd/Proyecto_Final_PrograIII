/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites_aeropuerto;

import java.util.Collections;
import static java.util.Collections.singletonList;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;

/**
 *
 * @author andre
 */
//@Configuration
//@EnableSwagger2
public class SwaggerConfiguration {
//    @Bean
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .securitySchemes(singletonList(new ApiKey("JWT", AUTHORIZATION, HEADER.name())))
//                .securityContexts(singletonList(
//                        SecurityContext.builder()
//                                .securityReferences(
//                                        singletonList(SecurityReference.builder()
//                                                .reference("JWT")
//                                                .scopes(new AuthorizationScope[0])
//                                                .build()
//                                        )
//                                )
//                                .build())
//                )
//                .select()
//                .apis(
//                        RequestHandlerSelectors
//                                .basePackage("org.una.tramites.controllers"))
//                .paths(PathSelectors.regex("/.*"))
//                .build()
//                .apiInfo(apiInfo())
//                .tags(new Tag("Seguridad", "Metodos de Seguridad"),
//                        new Tag("Usuarios", "Entidad de Usuarios"),
//                        new Tag("Transacciones", "Entidad Transaccion"),
//                        new Tag("Departamentos", "Entidad Departamentos"),
//                        new Tag("Permisos", "Entidad Permisos"),
//                        new Tag("Permisos_Otorgados", "Entidad Permisos Otorgados"),
//                        new Tag("Tramites_Tipos", "Entidad Tipos de tramites"),
//                        new Tag("Variaciones", "Entidad Tipos de variaciones"),
//                        new Tag("Requisitos", "Entidad Tipos de requisitos")
//                );
//
//    }
//
//    private ApiInfo apiInfo() {
//        return new ApiInfo(
//                "Tr�mites Municipales",
//                "Rest API sobre Tr�mites Municipales.",
//                "Versi�n:2.1.0",
//                "https://google.com",
//                new Contact("UNA Sede Regi�n Brunca", "https://srb.una.ac.cr/index.php/es/", "decanatosrb@una.cr") {
//        },
//                 "Apache-2.0", "http://www.apache.org/licenses/LICENSE-2.0", Collections.emptyList()
//        );
//    }
}

package com.example.project.project_e;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.parameters.Parameter;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI openNewtonApi(){
        return new OpenAPI()
        .info(new Info()
        .title("Surachart Limrattanaphun")
        .description("API Backend")
        .version("1.0")
        );
    }

    private Parameter createHeaderParameter() {
        return new Parameter()
                .name("Your-Header")  // กำหนดชื่อของ header
                .description("Description of Your-Header")  // กำหนดคำอธิบายของ header
                .in("header")  // ระบุว่าเป็น header parameter
                .required(true)  // ระบุว่า header เป็น required หรือไม่
                .schema(new io.swagger.v3.oas.models.media.StringSchema())  // ระบุ schema ของ header
                .example("your-value");  // กำหนดค่าตัวอย่างของ header
    }


}

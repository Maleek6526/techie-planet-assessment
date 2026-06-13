package com.assessment.student_scores.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI studentScoresOpenApi() {
        return new OpenAPI()
            .info(new Info()
                .title("Student Scores API")
                .version("1.0")
                .description("API for submitting student scores and viewing score reports "
                    + "with mean, median, and mode statistics."));
    }
}
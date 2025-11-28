package com.bidket.common.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Bidket API",
                description = "신발 경매 및 입찰 시스템 API 명세",
                version = "v1",
                contact = @Contact(
                        name = "Team Bidket"
                )
        )
)
public class OpenApiConfig {

    // 전체 서비스 공통 그룹
    @Bean
    public GroupedOpenApi allApis() {
        return GroupedOpenApi.builder()
                .group("bidket-all")
                .pathsToMatch("/**")
                .build();
    }
}
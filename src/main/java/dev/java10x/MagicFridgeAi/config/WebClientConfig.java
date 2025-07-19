package dev.java10x.MagicFridgeAi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
    @Value("${open.api.url}")
    private String openApiUrl;

    @Bean
    public WebClient webClient (WebClient.Builder builder){
        return builder.baseUrl(openApiUrl).build();
    }
}

package io.github.syakuis.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

@Configuration(proxyBeanMethods = false)
public class WebMvcConfiguration extends AbstractWebMvcConfiguration {
    public WebMvcConfiguration(ObjectMapper objectMapper) {
        super(objectMapper);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/api-docs/**").addResourceLocations("classpath:/static/api-docs/");
    }
}

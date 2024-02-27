package org.demo.config;

import org.demo.serialization.converter.YamlJackson2HttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private static final MediaType MEDIA_TYPE_APPLICATION_YML = MediaType.valueOf("application/x-yaml");
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        //WebMvcConfigurer.super.configureContentNegotiation(configurer);

        // https://www.baeldung.com/spring-mvc-content-negotiation-json.xml
        // Via EXTENSION. http://localhost:8080/api/person/v1.xml DEPRECATED on SpringBoot 2

        // Via Query Param. http://localhost:8080/api/person/v1?mediaType=xml

        //WebMvcConfigurer.super.configureContentNegotiation(configurer;
        /*configurer.favorParameter(true)
                .parameterName("mediaType")
                .ignoreAcceptHeader(true)
                .useRegisteredExtensionsOnly(false)
                .defaultContentType(MediaType.APPLICATION_JSON)
                    .mediaType("json", MediaType.APPLICATION_JSON)
                    .mediaType("xml", MediaType.APPLICATION_XML);*/

        // Via HEADER  Param. http://localhost:8080/api/person/v1?mediaType=xml

        configurer.favorParameter(false)
                .ignoreAcceptHeader(false)
                .useRegisteredExtensionsOnly(false)
                .defaultContentType(MediaType.APPLICATION_JSON)
                .mediaType("json", MediaType.APPLICATION_JSON)
                .mediaType("xml", MediaType.APPLICATION_XML)
                .mediaType("x-yaml", MEDIA_TYPE_APPLICATION_YML);

    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        //WebMvcConfigurer.super.extendMessageConverters(converters);

        converters.add(new YamlJackson2HttpMessageConverter());
    }

}

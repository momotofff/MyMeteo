package com.example.swagger.configuration;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.openapitools.jackson.nullable.JsonNullableModule;
import org.springframework.context.annotation.Bean;
import com.fasterxml.jackson.databind.Module;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.example.swagger.appsettings.AppSettings;
import com.example.swagger.services.DatabaseService;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.swagger", "com.example.swagger.api", "com.example.swagger.configuration", "io.swagger.model", "com.example.swagger.services", "com.example.swagger.appsettings"})
public class Swagger2SpringBoot implements CommandLineRunner
{
    @Override
    public void run(String... arg0) throws Exception
    {
        if (arg0.length > 0 && arg0[0].equals("exitcode"))
            throw new ExitException();
    }

    public static void main(String[] args) throws Exception
    {
        new SpringApplication(Swagger2SpringBoot.class).run(args);
    }
    @Bean
    public Module jsonNullableModule() {
        return new JsonNullableModule();
    }

    @Bean
    public AppSettings appSettings()
    {
        return new AppSettings();
    }

    @Bean
    @DependsOn("appSettings")
    public DatabaseService dbService()
    {
        return new DatabaseService(
                String.format("jdbc:postgresql://%s:%s/postgres", appSettings().getDbServerAddress(), appSettings().getDbServerPort()),
                appSettings().getDbServerUser(),
                appSettings().getDbServerPassword()
        );
    }

    @Configuration
    static class CustomDateConfig extends WebMvcConfigurerAdapter
    {
        @Override
        public void addFormatters(FormatterRegistry registry)
        {
            registry.addConverter(new LocalDateConverter("yyyy-MM-dd"));
            registry.addConverter(new LocalDateTimeConverter("yyyy-MM-dd'T'HH:mm:ss.SSS"));
        }
    }

    class ExitException extends RuntimeException implements ExitCodeGenerator
    {
        private static final long serialVersionUID = 1L;

        @Override
        public int getExitCode() {
            return 10;
        }

    }
}

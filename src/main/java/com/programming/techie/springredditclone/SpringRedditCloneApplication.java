package com.programming.techie.springredditclone;

import com.programming.techie.springredditclone.config.OpenAPIConfiguration;
import com.programming.techie.springredditclone.model.User;
import com.programming.techie.springredditclone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.time.Instant;
import java.util.Arrays;

@SpringBootApplication(scanBasePackages={"com.programming.techie.springredditclone"})
@EnableAsync
@Import(OpenAPIConfiguration.class)
@EntityScan(basePackages = {"com.programming.techie.springredditclone.model"})
@EnableJpaRepositories
public class SpringRedditCloneApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(com.programming.techie.springredditclone.SpringRedditCloneApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        System.out.println("----------All Data saved into Database----------------------");
    }

    @Bean
    public WebMvcConfigurer configure(){
        return new WebMvcConfigurer(){
            @Override
            public void addCorsMappings(CorsRegistry reg){
                reg.addMapping("/*").allowedOrigins("*");
            }
        };
    }

}

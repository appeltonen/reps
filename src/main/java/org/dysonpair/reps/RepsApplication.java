package org.dysonpair.reps;

import org.dysonpair.reps.config.WebSecurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@Import({WebSecurityConfig.class})
public class RepsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RepsApplication.class, args);
	}
}

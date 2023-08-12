package br.com.lmonaro.acme.microservicecommand;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class MicrosserviceCommandApplication {
    public static void main(String[] args) {
        SpringApplication.run(MicrosserviceCommandApplication.class, args);
    }
}

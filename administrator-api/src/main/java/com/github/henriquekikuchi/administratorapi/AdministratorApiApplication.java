package com.github.henriquekikuchi.administratorapi;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAdminServer
public class AdministratorApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdministratorApiApplication.class, args);
    }

}

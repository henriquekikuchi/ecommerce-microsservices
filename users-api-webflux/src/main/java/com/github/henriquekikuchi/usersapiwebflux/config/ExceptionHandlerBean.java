package com.github.henriquekikuchi.usersapiwebflux.config;

import com.github.henriquekikuchi.usersapiwebflux.exceptions.EmailAlreadyExistsException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebExceptionHandler;
import reactor.core.publisher.Mono;

@Configuration
public class ExceptionHandlerBean {

    @Bean
    public WebExceptionHandler exceptionHandler(){
        return (ServerWebExchange exchange, Throwable ex) -> {
            if (ex instanceof EmailAlreadyExistsException) {
                exchange.getResponse().setStatusCode(HttpStatus.BAD_REQUEST);
                return exchange.getResponse().setComplete();
            }
            return Mono.error(ex);
        };
    }
}

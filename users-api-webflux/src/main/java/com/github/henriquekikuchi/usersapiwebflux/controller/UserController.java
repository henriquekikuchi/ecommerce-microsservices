package com.github.henriquekikuchi.usersapiwebflux.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.henriquekikuchi.usersapiwebflux.dto.LoginRequestDto;
import com.github.henriquekikuchi.usersapiwebflux.dto.UserResponseDto;
import com.github.henriquekikuchi.usersapiwebflux.entity.User;
import com.github.henriquekikuchi.usersapiwebflux.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Configuration
@EnableWebFlux
@RequiredArgsConstructor
public class UserController {

    private static final String BASE_URL = "v1/users";
    private final UserService userService;

    @Bean
    public RouterFunction<ServerResponse> getAllUsers() {
        return RouterFunctions.route()
                .GET(BASE_URL, request -> ServerResponse.ok().body(userService.getAllUsers(), User.class))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> getUserByUserCode() {
        return RouterFunctions.route()
                .GET(BASE_URL.concat("/{code}"), request -> {
                    String userCode = request.pathVariable("code");
                    return userService.getUserByUserCode(userCode).flatMap(user ->
                            Mono.just(UserResponseDto.fromUser(user))
                    ).flatMap(userResponseDto -> ServerResponse.ok().body(userResponseDto, UserResponseDto.class));
                }).build();
    }

    @Bean
    public RouterFunction<ServerResponse> saveUser() {
        return RouterFunctions.route()
                .POST(BASE_URL, request -> request.bodyToMono(User.class).flatMap(userService::saveUser)
                        .map(UserResponseDto::fromUser)
                        .flatMap(user -> ServerResponse.status(HttpStatus.CREATED).body(Mono.just(user), UserResponseDto.class)))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> login() {
        return RouterFunctions.route().POST(BASE_URL.concat("/login"),
                        request -> request.bodyToMono(LoginRequestDto.class)
                                .flatMap(user -> userService.login(user.email(), user.password()))
                                .flatMap(user ->
                                        ServerResponse.ok().body(Mono.just(
                                                        UserResponseDto.fromUser(user)),
                                                UserResponseDto.class)))
                .build();
    }
}

package com.github.henriquekikuchi.usersapiwebflux.repository;

import com.github.henriquekikuchi.usersapiwebflux.entity.User;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface UserRepository extends R2dbcRepository<User, Long> {

    Mono<User> findUserByEmail(String email);
    Mono<User> findUserByUserCode(String code);
}

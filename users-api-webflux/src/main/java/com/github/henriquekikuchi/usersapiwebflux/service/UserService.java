package com.github.henriquekikuchi.usersapiwebflux.service;

import com.github.henriquekikuchi.usersapiwebflux.entity.User;
import com.github.henriquekikuchi.usersapiwebflux.exceptions.EmailAlreadyExistsException;
import com.github.henriquekikuchi.usersapiwebflux.repository.UserRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public record UserService(UserRepository userRepository) {

    public Mono<User> getUserByEmail(String email){
        return userRepository.findUserByEmail(email);
    }

    public Mono<User> getUserById(Long id){
        return userRepository.findById(id);
    }

    public Mono<User> getUserByUserCode(String code) {
        return userRepository.findUserByUserCode(code);
    }

    public Flux<User> getAllUsers(){
        return userRepository.findAll();
    }

    public Mono<User> saveUser(User user) throws EmailAlreadyExistsException {
        return userRepository.findAll()
                .any(user1 -> user1.getEmail().equals(user.getEmail()))
                .flatMap(result -> {
                    if (!result.booleanValue()) {
                        return userRepository.save(user);
                    }
                    return Mono.empty();
                }).switchIfEmpty(Mono.error( new EmailAlreadyExistsException("Email already exists")));
    }

    public Mono<User> changePassword(String email, String lastPassword, String newPassword){
        return userRepository.findUserByEmail(email)
                .map(user -> {
                    if (!user.getPassword().equals(lastPassword)) throw new Error();
                    user.setPassword(newPassword);
                    return userRepository.save(user);
                })
                .cast(User.class);
    }

    public Mono<User> login(String email, String password){
        return userRepository.findUserByEmail(email)
                .map(user -> {
                    if (user.getPassword().equals(password)){
                        return user;
                    }
                    return Mono.empty();
                }).cast(User.class);
    }
}

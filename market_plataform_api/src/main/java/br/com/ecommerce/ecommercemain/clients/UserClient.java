package br.com.ecommerce.ecommercemain.clients;

import br.com.ecommerce.ecommercemain.dtos.users.UserLoginDTO;
import br.com.ecommerce.ecommercemain.dtos.users.UserLoginResponseDTO;
import br.com.ecommerce.ecommercemain.dtos.users.UserResponseDTO;
import br.com.ecommerce.ecommercemain.dtos.users.UserSaveDTO;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="users")
//@LoadBalancerClient(name = "users")
public interface UserClient {
    @PostMapping("/v1/users/login")
    @CircuitBreaker(name = "servico")
    UserResponseDTO login(@RequestBody UserLoginDTO userLoginDTO);

    @PostMapping("/v1/users")
    @CircuitBreaker(name = "servico")
    UserLoginResponseDTO save(@RequestBody UserSaveDTO userSaveDTO);
}

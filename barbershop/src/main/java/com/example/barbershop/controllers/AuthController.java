package com.example.barbershop.controllers;

import com.example.barbershop.config.jwt.JwtProvider;
import com.example.barbershop.dtos.auth.AuthRequest;
import com.example.barbershop.dtos.auth.AuthResponse;
import com.example.barbershop.dtos.auth.RegistrationRequest;
import com.example.barbershop.entity.AccountEntity;
import com.example.barbershop.entity.ClientEntity;
import com.example.barbershop.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AccountService accountService;

    private final JwtProvider jwtProvider;

    @GetMapping("/registration")
    public String registration(){
        return "Welcome to registration page";
    }

    @PostMapping("/register")
    public String registerAccount(@RequestBody @Valid RegistrationRequest registrationRequest){
        AccountEntity accountEntity = new ClientEntity();
        accountEntity.setEmail(registrationRequest.getEmail());
        accountEntity.setPassword(registrationRequest.getPassword());
        // here we have static data< but after we will take it from real registration form
        accountEntity.setRoleId(3);
        accountEntity.setPhoneNumber("12346577");
        accountEntity.setFirstName("firstName");
        accountEntity.setSecondName("secondName");
        accountEntity.setLastName("lastName");
        accountEntity.setAge(15);
        accountEntity.setGender('w');
        System.out.println("create user");
        accountService.saveAccount(accountEntity,"ROLE_CLIENT");
        return "OK";
    }

    @PostMapping("/register/customer")
    public String registerCustomerAccount(@RequestBody @Valid RegistrationRequest request){
        var accountEntity = new ClientEntity();
        accountEntity.setEmail(request.getEmail());
        accountEntity.setPassword(request.getPassword());
        accountEntity.setPhoneNumber(request.getPhoneNumber());
        accountEntity.setFirstName(request.getFirstName());
        accountEntity.setSecondName(request.getSecondName());
        accountEntity.setLastName(request.getLastName());
        accountEntity.setAge(request.getAge());
        accountEntity.setGender(request.getGender());
        System.out.println("create user");
        accountService.saveAccount(accountEntity,"ROLE_CLIENT");
        return "OK";
    }

    @GetMapping("/auth")
    public String authorization(){
        return "Welcome to Authorization page";
    }

    /**
     *
     * @param request
     * @return JWT token
     */
    @PostMapping("/auth")
    public AuthResponse auth(@RequestBody AuthRequest request) {
        AccountEntity accountEntity = accountService.findByEmailAndPassword(request.getEmail(), request.getPassword());
        String token = jwtProvider.generateToken(accountEntity.getEmail());
        System.out.println(token);
        return new AuthResponse(token);
    }

}


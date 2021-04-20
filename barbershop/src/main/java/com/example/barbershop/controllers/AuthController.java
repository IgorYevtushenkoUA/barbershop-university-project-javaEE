package com.example.barbershop.controllers;

import com.example.barbershop.config.jwt.JwtProvider;
import com.example.barbershop.controllers.auth.AuthResponse;
import com.example.barbershop.controllers.auth.AuthRequest;
import com.example.barbershop.controllers.auth.RegistrationRequest;
import com.example.barbershop.entity.AccountEntity;
import com.example.barbershop.entity.ClientEntity;
import com.example.barbershop.service.AccountService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AuthController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private JwtProvider jwtProvider;

    @GetMapping("/registration")
    public String registration() {
        return "Welcome to registration page";
    }

    @PostMapping("/register")
    public String registerAccount(@RequestBody @Valid RegistrationRequest registrationRequest) {
        AccountEntity accountEntity = new ClientEntity();
//        accountEntity.setEmail(registrationRequest.getEmail());
//        accountEntity.setPassword(registrationRequest.getPassword());
        accountEntity.setEmail("email@gmail.com");
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
        accountService.saveAccount(accountEntity, "ROLE_CLIENT");
        return "OK";
    }

    /**
     * @param request
     * @return JWT token
     */
    @PostMapping("/auth")
    public AuthResponse auth(@RequestBody AuthRequest request) throws NotFoundException {
        AccountEntity accountEntity = accountService.findByEmailAndPassword(request.getEmail(), request.getPassword());
        if (accountEntity == null) {
            throw new NotFoundException("User not found");
        } else {
            String token = jwtProvider.generateToken(accountEntity.getEmail());
            return new AuthResponse(token);
        }
    }

}


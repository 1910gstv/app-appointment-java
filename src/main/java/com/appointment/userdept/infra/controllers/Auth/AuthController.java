package com.appointment.userdept.infra.controllers.Auth;

import com.appointment.userdept.domain.DTOs.Auth.AuthenticationDTO;
import com.appointment.userdept.domain.DTOs.Auth.LoginResponseDTO;
import com.appointment.userdept.domain.DTOs.Auth.RegisterDTO;
import com.appointment.userdept.domain.entity.User;
import com.appointment.userdept.infra.persistance.UserEntity;
import com.appointment.userdept.infra.persistance.UserRepository;
import com.appointment.userdept.infra.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository repository;
    @Autowired
    private TokenService tokenService;

        @PostMapping("/login")
        public ResponseEntity login(@RequestBody AuthenticationDTO data){
            var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
            var auth = this.authenticationManager.authenticate(usernamePassword);

            var token = tokenService.generateToken((UserEntity) auth.getPrincipal());

            return ResponseEntity.ok(new LoginResponseDTO(token));
        }

}

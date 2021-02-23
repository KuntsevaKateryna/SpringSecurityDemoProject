package com.example.demo.controller;

import com.example.demo.model.AuthorizationRequestDTO;
import com.example.demo.model.User;
import com.example.demo.repo.UserRepo;
import com.example.demo.security.JwtProvider;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/jwt")
public class JwtController {
    private final AuthenticationManager authenticationManager;
    private UserRepo userRepo;
    private JwtProvider jwtProvider;

    public JwtController(AuthenticationManager authenticationManager, UserRepo userRepo, JwtProvider jwtProvider) {
        this.authenticationManager = authenticationManager;
        this.userRepo = userRepo;
        this.jwtProvider = jwtProvider;
    }


    @PostMapping("/login")
    public ResponseEntity<?> authentificate(@RequestBody AuthorizationRequestDTO request) {
       String email = request.getEmail();

        try{
           authenticationManager.authenticate(
                   new UsernamePasswordAuthenticationToken(email, request.getPassword()));
        User user = userRepo.findByEmail(email);
        if (user == null)
            throw new UsernameNotFoundException("User doesn't exist");
        String token = jwtProvider.createToken(email, user.getRole().name());
            Map<Object, Object> response = new HashMap<>();
            response.put("email", email);
            response.put("token", token);
            return ResponseEntity.ok(response);
        }
        catch(AuthenticationException e) {
        return new ResponseEntity<>("Invalid email/password", HttpStatus.FORBIDDEN);
}

    }

    @PostMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        SecurityContextLogoutHandler securityContextLogoutHandler = new SecurityContextLogoutHandler();
        securityContextLogoutHandler.logout(request, response, null);
    }
}

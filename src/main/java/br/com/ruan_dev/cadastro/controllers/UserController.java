package br.com.ruan_dev.cadastro.controllers;


import br.com.ruan_dev.cadastro.entites.User;
import br.com.ruan_dev.cadastro.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping ("/users")
@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User sucesso = userService.insert(user);
        return ResponseEntity.ok(sucesso);
    }

    @GetMapping("/saved")
    public ResponseEntity<List<User>> findAllUsers() {
        List<User> user = userService.findAllUsers();
        return ResponseEntity.ok(user);
    }

    @GetMapping("/user/{email}")
    public ResponseEntity<List<User>> findUser(@PathVariable String email) {
        List<User> user = userService.findUser();
        return ResponseEntity.ok(user);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody User loginData) {
        Optional<User> userOptional = userService.findUserByEmail(loginData.getEmail());


        if (userOptional.isPresent()) {
            User user = userOptional.get();

            if (user.getSenha().equals(loginData.getSenha())) {
                return ResponseEntity.ok("Login realizado com sucesso!");
            } else {
                return ResponseEntity.status(401).body("Senha incorreta");
            }
        } else {
            return ResponseEntity.status(404).body("Usuário não encontrado");
        }
    }

}

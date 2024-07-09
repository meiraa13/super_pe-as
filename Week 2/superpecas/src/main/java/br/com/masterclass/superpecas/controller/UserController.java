package br.com.masterclass.superpecas.controller;

import br.com.masterclass.superpecas.dto.user.UserRequestDTO;
import br.com.masterclass.superpecas.dto.user.UserResponseDTO;
import br.com.masterclass.superpecas.dto.user.UserUpdateDTO;
import br.com.masterclass.superpecas.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserRequestDTO body){

        UserResponseDTO user = this.userService.createUser(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @GetMapping
    public ResponseEntity readUsers(){
        return ResponseEntity.ok().body("users");
    }

    @GetMapping("/{id}")
    public ResponseEntity readUserById(@PathVariable String id){
        return ResponseEntity.ok().body("user");
    }

    @PatchMapping
    public ResponseEntity updateUser(@RequestBody UserUpdateDTO body){
        return ResponseEntity.ok().body("updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable String id){
        return ResponseEntity.noContent().build();
    }
}

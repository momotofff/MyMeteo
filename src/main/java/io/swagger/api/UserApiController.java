package java.io.swagger.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.io.swagger.UserRepository;
import java.io.swagger.model.User;

@RestController
@RequestMapping("/users")
public class UserApiController
{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder; // Для хеширования паролей

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user)
    {
        // Проверка на существование пользователя
        if (userRepository.findByUsername(user.getUsername()) != null) {
            return ResponseEntity.badRequest().body("Username is already taken.");
        }

        // Хеширование пароля
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Сохранение пользователя
        userRepository.save(user);
        return ResponseEntity.ok("User registered successfully.");
    }
}
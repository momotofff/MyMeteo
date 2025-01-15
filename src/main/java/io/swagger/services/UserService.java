package java.io.swagger.services;

import io.swagger.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.swagger.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(User user) {
        return userRepository.save(user);
    }

    // Метод для поиска пользователя по имени
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    // Метод для поиска пользователя по email
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
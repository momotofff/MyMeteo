package java.io.swagger.api;

import io.swagger.api.UsersApi;
import io.swagger.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.swagger.services.UserService;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-01-15T05:30:04.287976148Z[GMT]")
@RestController
public class UsersApiController implements UsersApi {
    private static final Logger log = LoggerFactory.getLogger(UsersApiController.class);
    private final ObjectMapper objectMapper;
    private final HttpServletRequest request;

    private final UserService userService;

    @Autowired
    public UsersApiController(ObjectMapper objectMapper, HttpServletRequest request, UserService userService) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.userService = userService;
    }

    @Override
    public ResponseEntity<String> usersRegisterPost(
            @Parameter(name = "User", description = "", required = true) @Valid @RequestBody User user
    ) {
        String accept = request.getHeader("Accept");

        if (accept != null && accept.contains("application/json")) {
            try {
                // Проверка на уникальность пользователя
                if (userService.findByUsername(user.getUsername()) != null) {
                    return new ResponseEntity<>("Username already exists", HttpStatus.CONFLICT);
                }

                if (userService.findByEmail(user.getEmail()) != null) {
                    return new ResponseEntity<>("Email already exists", HttpStatus.CONFLICT);
                }

                User registeredUser = userService.registerUser(user);
                return new ResponseEntity<>("User registered successfully with ID: " + registeredUser.getId(), HttpStatus.CREATED);
            } catch (Exception e) {
                log.error("Error during user registration", e);
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}

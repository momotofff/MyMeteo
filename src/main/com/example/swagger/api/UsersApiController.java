package com.example.swagger.api;

import io.swagger.api.UsersApi;
import io.swagger.model.CreateUserRequest;
import io.swagger.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Parameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import com.example.swagger.services.DatabaseService;
import java.sql.SQLException;

@RestController
@DependsOn("dbService")
public class UsersApiController implements UsersApi
{
    private static final Logger logger = LoggerFactory.getLogger(UsersApiController.class);
    private final ObjectMapper objectMapper;
    private final HttpServletRequest request;

    @Autowired
    private DatabaseService databaseService;

    @Autowired
    public UsersApiController(ObjectMapper objectMapper, HttpServletRequest request)
    {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    @Override
    public ResponseEntity<User> usersRegisterPost(
            @Parameter(name = "CreateUserRequest", description = "", required = true)
            @Valid @RequestBody CreateUserRequest createUserRequest
    )  {
        String accept = request.getHeader("Accept");

        if (accept != null && accept.contains("application/json"))
        {
            try
            {
                User createdUser = databaseService.usersRegisterPost(createUserRequest.getUsername(), createUserRequest.getEmail());
                logger.info("Successfully created user with username: {}", createUserRequest.getUsername());
                return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
            }

            catch (SQLException e)
            {
                throw new RuntimeException(e);
            }
        }

        return new ResponseEntity<User>(HttpStatus.NOT_IMPLEMENTED);
    }
}

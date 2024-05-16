package com.aims.Formulary.Controllers;

import com.aims.Formulary.Entity.User;
import com.aims.Formulary.Service.UserService;
import com.aims.Formulary.exception.ErrorDetails;
import com.aims.Formulary.exception.ResourceNotFoundException;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController

public class UserController {

private final MongoTemplate mongoTemplate;
@Autowired
private UserService userService;


    public UserController(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }
    @PostMapping("/register")
    @CrossOrigin(origins = "http://localhost:3000")
    @ResponseStatus(HttpStatus.CREATED)
    public User registerUser(@RequestBody User user){
        return mongoTemplate.save(user);

    }
    @GetMapping("/getallUsers")
    public List<User> getallUsers(){
        return mongoTemplate.findAll(User.class);
    }
    @ExceptionHandler(ResourceNotFoundException.class)
public ResponseEntity<ErrorDetails> resourceNotfound(ResourceNotFoundException exception, WebRequest webRequest){
    ErrorDetails errorDetails= new ErrorDetails(LocalDateTime.now(),
            exception.getMessage(),
            webRequest.getDescription(false),
            "USER_NOT_FOUND"

            );
    return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);

}

}

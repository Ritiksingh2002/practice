package com.aims.Formulary.Controllers;

import com.aims.Formulary.Entity.User;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

private final MongoTemplate mongoTemplate;


    public AuthController(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @PostMapping("/login")
    @CrossOrigin(origins = "http://localhost:3000")
    @ResponseStatus(HttpStatus.OK)
    public String loginUser(@RequestBody User user){
        Query query= new Query(Criteria.where("username").is(user.getUsername()));
        User exists= mongoTemplate.findOne(query,User.class);
        if(exists==null){
            return "Invalid USername";
        } else if(! exists.getPassword().equals(user.getPassword())){
            return "Enter Correct Password for "+user.getUsername();
        }

       else if(exists!=null && exists.getPassword().equals(user.getPassword())){
            return "LoginSuccess";
        }

        else return "Invalid";
    }
}

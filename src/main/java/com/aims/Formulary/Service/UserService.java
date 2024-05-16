package com.aims.Formulary.Service;

import com.aims.Formulary.Entity.User;
import com.aims.Formulary.Repositories.UserRepository;
import com.aims.Formulary.exception.ResourceNotFoundException;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    MongoTemplate mongoTemplate;
    @Autowired
    UserRepository userRepository;



}

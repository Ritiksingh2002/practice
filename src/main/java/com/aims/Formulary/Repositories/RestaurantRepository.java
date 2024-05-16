package com.aims.Formulary.Repositories;

import com.aims.Formulary.Entity.Restaurant;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RestaurantRepository extends MongoRepository<Restaurant, ObjectId> {


}

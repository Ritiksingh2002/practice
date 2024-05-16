package com.aims.Formulary.Service;

import com.aims.Formulary.Controllers.RestaurantController;
import com.aims.Formulary.Entity.Formulary;
import com.aims.Formulary.Entity.Restaurant;
import com.aims.Formulary.Repositories.RestaurantRepository;
import com.aims.Formulary.dto.Mapper.RestaurantMapper;
import com.aims.Formulary.dto.RestaurantDTO;
import com.aims.Formulary.exception.ResourceNotFoundException;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {
    @Autowired
    MongoTemplate mongoTemplate;
    @Autowired
    RestaurantRepository restaurantRepository;
    @Autowired
    RestaurantMapper restaurantMapper;

    public RestaurantDTO addRestaurant(@RequestBody RestaurantDTO restaurantDTO) {
        Query q = new Query(Criteria.where("restaurantId").is(restaurantDTO.getRestaurantId()));

        Restaurant exists = mongoTemplate.findOne(q, Restaurant.class);
        if (restaurantDTO.getRestaurantId() == null || exists != null)
            throw new IllegalArgumentException("already exists / id can not be empty");
        return restaurantMapper.toDTO(mongoTemplate.save(restaurantMapper.toEntity(restaurantDTO)));
    }


    public List<Restaurant> getAllRestaurant() {
        return mongoTemplate.findAll(Restaurant.class);
    }

    public RestaurantDTO searchByResId(Integer restaurantId) {

        Query q = new Query(Criteria.where("restaurantId").is(restaurantId));
        Restaurant restaurant = mongoTemplate.findOne(q, Restaurant.class);
        if (restaurant == null)
            throw new IllegalArgumentException("Not Found");
        else
            return restaurantMapper.toDTO(restaurant);
    }

    public Restaurant find(String id) {
        return restaurantRepository.findById(new ObjectId(id)).orElseThrow(() ->
                new ResourceNotFoundException("formulary", "not dounf", 3432L));
    }


}
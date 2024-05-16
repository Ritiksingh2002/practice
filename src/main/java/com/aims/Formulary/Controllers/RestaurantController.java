package com.aims.Formulary.Controllers;

import com.aims.Formulary.Entity.Formulary;
import com.aims.Formulary.Entity.Restaurant;
import com.aims.Formulary.Service.RestaurantService;
import com.aims.Formulary.dto.RestaurantDTO;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestaurantController {


    @Autowired
   private MongoTemplate mongoTemplate;

    public RestaurantController(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;

    }

    @Autowired
     RestaurantService restaurantService;
    @Autowired
    public RestaurantController( RestaurantService restaurantService) {

        this.restaurantService = restaurantService;
    }

    @PostMapping("/addRestaurant")
    @ResponseStatus(HttpStatus.CREATED)
    @CrossOrigin(origins = "http://localhost:3000")
public RestaurantDTO addRestaurant(@RequestBody RestaurantDTO restaurantDTO){
        return restaurantService.addRestaurant(restaurantDTO);
    }
    @GetMapping("/getRestaurant")
    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin(origins = "http://localhost:3000")
    public List<Restaurant> getALlRestaurant(){
        return restaurantService.getAllRestaurant();
    }

@GetMapping("/search/{restaurantId}")
    @ResponseStatus(HttpStatus.OK)
@CrossOrigin(origins = "http://localhost:3000")
    public RestaurantDTO searchByResId(@PathVariable Integer restaurantId){
        return restaurantService.searchByResId(restaurantId);

}

    @GetMapping("/exception/{objectID}")
    @ResponseStatus(HttpStatus.OK)
    public Restaurant findByIDEx(@PathVariable("objectID") String objectId){
        return restaurantService.find(objectId);
    }
}

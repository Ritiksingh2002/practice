package com.aims.Formulary.dto.Mapper;

import com.aims.Formulary.Entity.Formulary;
import com.aims.Formulary.Entity.Restaurant;
import com.aims.Formulary.dto.FormularyDTO;
import com.aims.Formulary.dto.RestaurantDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface RestaurantMapper {
    Restaurant toEntity(RestaurantDTO restaurantDTO);
    RestaurantDTO toDTO(Restaurant restaurant);
    List<RestaurantDTO> toEntities(List<Restaurant> restaurants);

}

package com.aims.Formulary.Repositories;

import com.aims.Formulary.Entity.Restaurant;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Component
public class RestaurantRepositoryImpl implements  RestaurantRepository{
    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public <S extends Restaurant> S insert(S entity) {
        return null;
    }

    @Override
    public <S extends Restaurant> List<S> insert(Iterable<S> entities) {
        return null;
    }

    @Override
    public <S extends Restaurant> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Restaurant> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Restaurant> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Restaurant> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Restaurant> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Restaurant> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Restaurant, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Restaurant> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Restaurant> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Restaurant> findById(ObjectId objectId) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(ObjectId objectId) {
        return false;
    }

    @Override
    public List<Restaurant> findAll() {
        return null;
    }

    @Override
    public List<Restaurant> findAllById(Iterable<ObjectId> objectIds) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(ObjectId objectId) {

    }

    @Override
    public void delete(Restaurant entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends ObjectId> objectIds) {

    }

    @Override
    public void deleteAll(Iterable<? extends Restaurant> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Restaurant> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Restaurant> findAll(Pageable pageable) {
        return null;
    }
}

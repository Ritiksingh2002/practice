package com.aims.Formulary.Repositories;

import com.aims.Formulary.Entity.Formulary;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Function;

@Component
public class FormularyRepositoryImpl implements  FormularyRepository{

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public Formulary saveFormulary(Formulary formulary) {
        return null;
    }

    @Override
    public Formulary findByFormularyId(Long formularyId){
        try{
            Query query= new Query(Criteria.where("formularyId").is(formularyId));
            return mongoTemplate.findOne(query,Formulary.class);
        }catch(Exception e){
            System.out.println( e.getMessage());
            return null;
        }
    }


    @Override
    public <S extends Formulary> S insert(S entity) {
        return null;
    }

    @Override
    public <S extends Formulary> List<S> insert(Iterable<S> entities) {
        return null;
    }

    @Override
    public <S extends Formulary> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Formulary> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Formulary> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Formulary> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Formulary> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Formulary> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Formulary, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Formulary> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Formulary> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Formulary> findById(ObjectId objectId) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(ObjectId objectId) {
        return false;
    }

    @Override
    public List<Formulary> findAll() {
        return null;
    }

    @Override
    public List<Formulary> findAllById(Iterable<ObjectId> objectIds) {
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
    public void delete(Formulary entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends ObjectId> objectIds) {

    }

    @Override
    public void deleteAll(Iterable<? extends Formulary> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Formulary> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Formulary> findAll(Pageable pageable) {
        return null;
    }
}

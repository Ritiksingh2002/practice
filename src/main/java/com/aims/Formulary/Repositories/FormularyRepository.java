package com.aims.Formulary.Repositories;

import com.aims.Formulary.Entity.Formulary;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FormularyRepository extends MongoRepository<Formulary, ObjectId> {

    Formulary saveFormulary(Formulary formulary);

    Formulary findByFormularyId(Long formularyId);

}

package com.aims.Formulary.Service;

import com.aims.Formulary.Entity.Formulary;
import com.aims.Formulary.Repositories.FormularyRepository;
import com.aims.Formulary.dto.FormularyDTO;
import com.aims.Formulary.dto.Mapper.FormularyMapper;
import com.aims.Formulary.exception.ResourceNotFoundException;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Service
public class FormularyService {
    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    private FormularyMapper formularyMapper;
    @Autowired
    private FormularyRepository formularyRepository;
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    public FormularyDTO getFormularyDetailsByFormularyId(Long formularyId) {
        if(formularyRepository.findByFormularyId(formularyId)==null)
            throw new IllegalArgumentException("NotExist");
        return formularyMapper.toFormularyDTO(formularyRepository.findByFormularyId(formularyId));
    }

    public FormularyDTO saveFormulary(FormularyDTO formularyDTO) {
        if (formularyDTO == null || formularyDTO.getFormularyId() == null) {
            throw new IllegalArgumentException("formularyId cannot be null");
        }
        Formulary existingFormulary = formularyRepository.findByFormularyId(formularyDTO.getFormularyId());

        if (existingFormulary != null) {
            logger.warn("Formulary with ID {} already exists.", formularyDTO.getFormularyId());
            throw new IllegalArgumentException("Formulary with this ID already exists");
        }
        return formularyMapper.toFormularyDTO(mongoTemplate.save(formularyMapper.toEntity(formularyDTO)));
    }

    public FormularyDTO updateTheFormulary(Long formularyId, FormularyDTO formularyDTO) {
        if (formularyId == null)
            throw new IllegalArgumentException("Formularyid is null");
        Formulary formulary = formularyRepository.findByFormularyId(formularyId);
        if (formulary == null) {
            logger.warn("formulary not existed {}", formularyId);
            throw new IllegalArgumentException("PArticular Formulary  Not existed ");
        }
        // formulary.setFormularyId(formularyDTO.getFormularyId());
        formulary.setProgram(formularyDTO.getProgram());
        formulary.setReleventForGxOps(formularyDTO.getReleventForGxOps());
        formulary.setShortDescription(formularyDTO.getShortDescription());
        formulary.setDescription(formularyDTO.getDescription());


        return formularyMapper.toFormularyDTO(mongoTemplate.save(formulary));


    }

    public List<Formulary> getallFormularies() {
        return mongoTemplate.findAll(Formulary.class);
    }

    public void deleteFormulary(Long formularyId) {
        Query query = new Query(Criteria.where("formularyId").is(formularyId));


        long deleteCount = mongoTemplate.remove(query, Formulary.class).getDeletedCount();
        if (deleteCount == 0) {
            logger.warn("formulary not existed {}", formularyId);
            throw new IllegalArgumentException("Particular Formulary  Not existed ");
        }
    }


}
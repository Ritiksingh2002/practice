package com.aims.Formulary.Entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "formularyDetails")
public class Formulary {

    @Id
    @Field("_id")
    private ObjectId id;

    @Indexed(unique = true)
    @Field("formularyId")
    private Long formularyId;
    @Field("program")
    private String program;
    @Field("isReleventForGxOps")
    private boolean isReleventForGxOps;
    @Field("shortDescription")
    private String shortDescription;

    @Field("description")
    private String description;

    public Formulary() {
    }

    public ObjectId getId() {
        return id;
    }

    public Long getFormularyId() {
        return formularyId;
    }

    public void setFormularyId(Long formularyId) {
        this.formularyId = formularyId;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public boolean getReleventForGxOps() {
        return isReleventForGxOps;
    }

    public void setReleventForGxOps(boolean releventForGxOps) {
        isReleventForGxOps = releventForGxOps;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Formulary{" +
                "id=" + id +
                ", formularyId=" + formularyId +
                ", program='" + program + '\'' +
                ", isReleventForGxOps=" + isReleventForGxOps +
                ", shortDescription='" + shortDescription + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

package com.aims.Formulary.dto;


import org.bson.types.ObjectId;
import org.springframework.aot.generate.Generated;


public class FormularyDTO {

    private ObjectId id;

    private Long formularyId;

    private String program;

    private boolean isReleventForGxOps;

    public void setId(ObjectId id) {
        this.id = id;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    private String shortDescription;

    private String description;

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
        this.isReleventForGxOps = releventForGxOps;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "FormularyDTO{" +
                "id=" + id +
                ", formularyId=" + formularyId +
                ", program='" + program + '\'' +
                ", isReleventForGxOps=" + isReleventForGxOps +
                ", shortDescription='" + shortDescription + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

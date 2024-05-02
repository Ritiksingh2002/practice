package com.aims.Formulary.dto.Mapper;

import com.aims.Formulary.Entity.Formulary;
import com.aims.Formulary.dto.FormularyDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface FormularyMapper {
    FormularyDTO toFormularyDTO(Formulary formulary);

    List<FormularyDTO> toFormulariesDTOs(List<Formulary> formularies);

    Formulary toEntity(FormularyDTO formularyDTO);
}

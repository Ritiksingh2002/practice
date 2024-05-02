package com.aims.Formulary.Service;

import com.aims.Formulary.Entity.Formulary;
import com.aims.Formulary.Repositories.FormularyRepository;
import com.aims.Formulary.dto.FormularyDTO;
import com.aims.Formulary.dto.Mapper.FormularyMapper;
import org.apache.commons.lang3.text.FormattableUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@DisplayName("Formulary Service Tests")
public class FormularyServiceTest {

    @InjectMocks
    private FormularyService formularyService;
    @Mock
    private FormularyRepository formularyRepository;
    @Mock
    private FormularyMapper formularyMapper;
@Mock

private MongoTemplate mongoTemplate;
    @Test
    public void testGetFormularyById (){
        Long validFormularyId = 1L;

        Formulary mockFormulary = new Formulary();
        mockFormulary.setFormularyId(validFormularyId);

        FormularyDTO mockFormularyDTO = new FormularyDTO();
        mockFormularyDTO.setFormularyId(validFormularyId);


        when(formularyRepository.findByFormularyId(validFormularyId)).thenReturn(mockFormulary);
        when(formularyMapper.toFormularyDTO(mockFormulary)).thenReturn(mockFormularyDTO);


        FormularyDTO result = formularyService.getFormularyDetailsByFormularyId(validFormularyId);
        assertNotNull(result);
        assertEquals(validFormularyId, result.getFormularyId());
    }

@Test
    public void testGetFoumyaryifitisnull() {
    Long Formularyid = null;
    Formulary formulary = new Formulary();
    formulary.setFormularyId(Formularyid);
    FormularyDTO formularyDTO = new FormularyDTO();
    formularyDTO.setFormularyId(Formularyid);

    when(formularyRepository.findByFormularyId(Formularyid)).thenReturn(null);
    IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
        formularyService.getFormularyDetailsByFormularyId(Formularyid);


    });
    assertEquals("NotExist", ex.getMessage());
}
@Test
    public void testSaveFOrmulary(){
        FormularyDTO formularyDTO=null;
        Long Fid=null;
        Formulary formulary= null;
        when(formularyRepository.saveFormulary(formulary)).thenReturn(null);
        IllegalArgumentException ex=assertThrows(IllegalArgumentException.class,()->{formularyService.saveFormulary(formularyDTO);});
        assertEquals("formularyId cannot be null",ex.getMessage());

}
@Test
    public void testIfAlreadyExistFormulary(){

        FormularyDTO formularyDTO= new FormularyDTO();
        formularyDTO.setFormularyId(1232L);
        formularyDTO.setProgram("OS");
        formularyDTO.setDescription("mmm");
        formularyDTO.setShortDescription("dsd");
        formularyDTO.setReleventForGxOps(true);

        Formulary formulary= new Formulary();

       when(formularyRepository.findByFormularyId(formularyDTO.getFormularyId())).thenReturn(formulary);
       IllegalArgumentException ex= assertThrows(IllegalArgumentException.class,()->{formularyService.saveFormulary(formularyDTO);});
       assertEquals("Formulary with this ID already exists",ex.getMessage());

}
@Test
    public void testSaveFormulary(){
    FormularyDTO formularyDTO= new FormularyDTO();
    Long fid=1232L;
    formularyDTO.setFormularyId(1232L);
    formularyDTO.setProgram("OS");
    formularyDTO.setDescription("mmm");
    formularyDTO.setShortDescription("dsd");
    formularyDTO.setReleventForGxOps(true);

    Formulary formulary= new Formulary();
    formulary.setFormularyId(fid);


    when(formularyRepository.findByFormularyId(fid)).thenReturn(formulary);

    when(formularyMapper.toEntity(formularyDTO)).thenReturn(formulary);
    when(formularyMapper.toFormularyDTO(formulary)).thenReturn(formularyDTO);

    FormularyDTO result= formularyService.saveFormulary(formularyDTO);
    //assertNotNull(result);
    assertEquals(fid,result.getFormularyId());
}

@Test
    public void testGetALlFormularies(){
        List<Formulary> formularyList= new ArrayList<>();
        Formulary formulary= new Formulary();
        formulary.setFormularyId(232L);
        formulary.setDescription("sds");
        formulary.setProgram("sdse");
        formulary.setReleventForGxOps(true);
        formulary.setShortDescription("fdfd");
        formularyList.add(formulary);

        when(mongoTemplate.findAll(Formulary.class)).thenReturn(formularyList);

        List<Formulary> resutl= formularyService.getallFormularies();
        assertEquals(resutl,formularyList);

}


}

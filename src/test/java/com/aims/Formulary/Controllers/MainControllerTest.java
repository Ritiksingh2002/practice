package com.aims.Formulary.Controllers;

import com.aims.Formulary.Service.FormularyService;
import com.aims.Formulary.dto.FormularyDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = MainController.class)

public class MainControllerTest {

    @MockBean
    private FormularyService formularyService;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getGreetTest() throws Exception {
        this.mockMvc.perform(get("/greet")).andExpect(status().isOk());
    }
    @Test
    void getTestConnection() throws Exception {
        this.mockMvc.perform(get("/test")).andExpect(status().isOk());
    }

    @Test
    @DisplayName("get the formularies by id")
    void testGetFormularies() throws Exception {
        when(formularyService.getFormularyDetailsByFormularyId(any())).thenReturn(new FormularyDTO());
        this.mockMvc.perform(get("/getFormularies/1000")).andExpect(status().isOk());
    }

    @Test
    @DisplayName("ADd the Formularies")
    void testAddFormulary() throws Exception {
        FormularyDTO formularyDTO = new FormularyDTO();
        when(formularyService.saveFormulary(formularyDTO)).thenReturn(formularyDTO);
        this.mockMvc.perform(post("/addFormulary").
                        contentType(MediaType.APPLICATION_JSON).
                        content(objectMapper.writeValueAsString(formularyDTO)))
                .andExpect(status().isCreated());
    }

    @Test
    @DisplayName("Update the Formulary")
    void testUpdateFormulary() throws Exception {
        FormularyDTO formularyDTO = new FormularyDTO();
        formularyDTO.setFormularyId(1213242L);

        when(formularyService.updateTheFormulary(any(),any())).thenReturn(formularyDTO);
        this.mockMvc.perform(put("/updateByFormularyId/121324").
                contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(formularyDTO)).accept(MediaType.APPLICATION_JSON)).andDo(print()).
                andExpect(status().isOk());
    }
    @Test
    @DisplayName("get all the formjularies")
    void testGetALLFormularies() throws  Exception
    {
        when(formularyService.getallFormularies()).thenReturn(new ArrayList<>());
        this.mockMvc.perform(get("/getallFomularies")).andExpectAll(status().isOk());
    }

    @Test
    void deleteFormulary() throws Exception{

       doNothing().when(formularyService).deleteFormulary(anyLong());
       this.mockMvc.perform(delete("/deleteFormulary/1213232")).andExpect(status().isNoContent());

    }
}

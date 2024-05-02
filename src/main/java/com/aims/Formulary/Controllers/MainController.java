package com.aims.Formulary.Controllers;

import com.aims.Formulary.Entity.Formulary;
import com.aims.Formulary.Service.FormularyService;
import com.aims.Formulary.dto.FormularyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {
    @Autowired
    FormularyService formularyService;

    @Autowired
    public MainController(FormularyService formularyService) { // Constructor-based autowiring
        this.formularyService = formularyService;
    }

    @GetMapping("/greet")
    public String getGreetMessage() {
        return "Hello!!, welcome to formulary  service";
    }

    @GetMapping("/getFormularies/{formularyId}")
    @CrossOrigin(origins = "http://localhost:3000")
    @ResponseStatus(HttpStatus.OK)
    public FormularyDTO getFormularies(@PathVariable Long formularyId) {
        return formularyService.getFormularyDetailsByFormularyId(formularyId);
    }

    @PostMapping("/addFormulary")
    @CrossOrigin(origins = "http://localhost:3000")
    @ResponseStatus(HttpStatus.CREATED)
    public FormularyDTO addFormulary(@RequestBody FormularyDTO formularyDTO) {
        return formularyService.saveFormulary(formularyDTO);
    }

    @PutMapping("/updateByFormularyId/{formularyId}")
    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin(origins = "http://localhost:3000")
    public FormularyDTO updateFormularyByFormularyId(@PathVariable Long formularyId, @RequestBody FormularyDTO formularyDTO) {
        return formularyService.updateTheFormulary(formularyId, formularyDTO);
    }

    @GetMapping("/getallFomularies")
    @CrossOrigin(origins = "http://localhost:3000")
    @ResponseStatus(HttpStatus.OK)
    public List<Formulary> getALlFormularies() {
        return formularyService.getallFormularies();
    }

    @DeleteMapping("deleteFormulary/{formularyId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @CrossOrigin(origins = "http://localhost:3000")
    public String deleteFormulary(@PathVariable Long formularyId) {
        formularyService.deleteFormulary(formularyId);
        return "Formulary deleted";
    }
    @GetMapping("/test")
    @CrossOrigin(origins = "http://localhost:3000")
    public String testConnection() {
        return "Connection successful!";
    }

}

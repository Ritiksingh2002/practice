package com.aims.Formulary.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

    private String resourceName;
    private String fieldname;
    private Long fieldValue;

    public ResourceNotFoundException(String resourceName, String fieldname, Long fieldValue) {
       super(String.format("%s  not found ,%s ,%s" ,resourceName,fieldname,fieldValue));
       this.resourceName=resourceName;
       this.fieldname=fieldname;
       this.fieldValue=fieldValue;
    }
}

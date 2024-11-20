package net.javaguides.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)    // when spring boot got NOT FOUND exception, spring boot handle this exception to through error msg
public class ResourceNotFoundException extends RuntimeException{

    private String resourceName;
    private String filedName;
    private Long fieldValue;

    public ResourceNotFoundException(String resourceName,String filedName,Long fieldValue){
        super(String.format("%s not with %s : %s",resourceName,filedName,fieldValue));  // custom error msg passed to super class
        this.resourceName=resourceName;
        this.fieldValue=fieldValue;
        this.filedName=filedName;

    }
}

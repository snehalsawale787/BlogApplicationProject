package com.codewithdurgesh.blog.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException {
String resourceName;
String fieldName;
long fieldValue;
public ResourceNotFoundException(String resourceName, String fieldName, long fieldValue) {
	super(String.format("%s not found with %s : %s", resourceName,fieldName,fieldValue));
	this.resourceName = resourceName;
	this.fieldName = fieldName;
	this.fieldValue = fieldValue;
}

}

package com.ecommerce.order.customValidation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Configurable;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

@Configurable
public class PhoneNumberValidator implements ConstraintValidator<ValidPhoneNumber, String> {

@Override
public boolean isValid(String value, ConstraintValidatorContext context) {
	
	   Pattern ptrn = Pattern.compile("(0/91)?[7-9][0-9]{9}");  
	   Matcher match = ptrn.matcher(value);  
	   return (match.find() && match.group().equals(value));  
}  
}



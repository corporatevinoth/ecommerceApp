package com.ecommerce.customer.config;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Configurable;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

@Configurable
public class PhoneNumberValidator implements ConstraintValidator<ValidPhoneNumber, Long> {
/**
 * Valid number are.

9883443344
09883443344
919883443344
0919883443344
+919883443344
+91-9883443344
0091-9883443344
+91 -9883443344
+91- 9883443344
+91 - 9883443344
0091 - 9883443344
 */
@Override
public boolean isValid(Long value, ConstraintValidatorContext context) {
	
	   Pattern ptrn = Pattern.compile("^(?:(?:\\+|0{0,2})91(\\s*[\\-]\\s*)?|[0]?)?[789]\\d{9}$");  
	   Matcher match = ptrn.matcher(value.toString());  
	   return (match.find());  
}  
}



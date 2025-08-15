package com.example.demo.validators;

import com.example.demo.domain.Part;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 *
 *
 *
 */
public class InventoryValidator implements ConstraintValidator<ValidInventory, Part> {

    @Override
    public void initialize(ValidInventory constraintAnnotation) {

    }

    @Override
    public boolean isValid(Part part, ConstraintValidatorContext constraintValidatorContext) {

        if (part.getInv() > part.getMaxInv()){
            constraintValidatorContext.buildConstraintViolationWithTemplate( "Solution: inventory error, inventory greater than maximum inventory").addConstraintViolation();
            return false;
        }
        if (part.getInv() < part.getMinInv()){
            constraintValidatorContext.buildConstraintViolationWithTemplate("Solution: inventory error, inventory less than minimum inventory").addConstraintViolation();
            return false;
        }

        return true;
    }
}
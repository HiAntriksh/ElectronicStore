package com.lcwd.electronic.store.validate;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = ImageNameValidator.class)
public @interface  ImageNameValid {

    // error message
    String message() default "{Invalid Image Name !!}";

    // represent group of constraints
    Class<?>[] groups() default { };

    // additional information about annotaion
    Class<? extends Payload>[] payload() default { };

}

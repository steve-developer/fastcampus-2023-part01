package com.example.validation.validator;

import com.example.validation.annotation.PhoneNumber;
import com.example.validation.annotation.YearMonth;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

public class YearMonthValidator implements ConstraintValidator<YearMonth, String> {

    private String pattern;

    @Override
    public void initialize(YearMonth constraintAnnotation) {
        this.pattern = constraintAnnotation.pattern();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // "2023-01-01T13:00:00" yyyy-MM-ddTHH:mm:ss
        // "2023-01"
        // size = 6

        // yyyy MM dd

        var reValue = value+"01";
        var rePattern = pattern+"dd";

        try{
            LocalDate date = LocalDate.parse(reValue, DateTimeFormatter.ofPattern(rePattern));
            System.out.println(date);
            return true;
        }catch (Exception e){
            return false;
        }

    }
}

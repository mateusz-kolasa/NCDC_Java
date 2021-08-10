package ncdc.assessment.java.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AuthorValidation implements ConstraintValidator<AuthorAnnotation, String> {
    @Override
    public void initialize(AuthorAnnotation author) {
    }

    @Override
    public boolean isValid(String author,ConstraintValidatorContext cxt) {
    	return author != null && author.startsWith("A");
    }
}

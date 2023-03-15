package fpt.m2.common.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.util.ObjectUtils;

import fpt.m2.common.validation.constraint.Email;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<Email, String> {

	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	private final Pattern pattern = Pattern.compile(EMAIL_PATTERN);
	private Matcher matcher;

	private boolean validate(final String email) {
		matcher = pattern.matcher(email);
		return matcher.matches();
	}

	@Override
	public void initialize(Email email) {
	}

	@Override
    public boolean isValid(String email,
      ConstraintValidatorContext cxt) {
		if (ObjectUtils.isEmpty(email)) {
			return false;
		}
        return validate(email);
    }

}

package week15_mid_prep.MovieDataTransformation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FieldFormat {
    TextFormatter text_format() default TextFormatter.ORDINARY;
    NumberFormatter number_format() default NumberFormatter.CURRENCY;
}

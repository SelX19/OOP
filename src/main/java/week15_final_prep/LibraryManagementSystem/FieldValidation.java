package week15_final_prep.LibraryManagementSystem;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FieldValidation {
    BookCategory category() default BookCategory.FICTION;
    AvailabilityStatus status() default AvailabilityStatus.AVAILABLE;
}

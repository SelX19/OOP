package week15_mid_prep.InvoiceManagement;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FieldFormat {
    TextFormat text_format() default TextFormat.PLAIN;
    CurrencyFormat currency_format() default CurrencyFormat.USD;
}

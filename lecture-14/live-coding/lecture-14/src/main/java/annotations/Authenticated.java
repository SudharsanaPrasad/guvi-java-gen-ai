package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// defines how long the annotation is retained in the program lifecycle
@Retention(RetentionPolicy.RUNTIME)
// where the annotation can be applied
@Target(ElementType.METHOD)
public @interface Authenticated {
    String value() default "default";
}

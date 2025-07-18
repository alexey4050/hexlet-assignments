package exercise.annotation;

// BEGIN
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Inspect {
    boolean logArgs() default true;
    boolean logReturn() default true;
}
// END

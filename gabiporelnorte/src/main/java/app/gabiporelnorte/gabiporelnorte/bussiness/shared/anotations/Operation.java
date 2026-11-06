package app.gabiporelnorte.gabiporelnorte.bussiness.shared.anotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target (ElementType.METHOD)
@Retention (RetentionPolicy.RUNTIME)
public @interface Operation {

    String name() default "";

    String description() default "";

    String entity() default "";


}

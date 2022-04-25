package java2;

import java.lang.annotation.*;

/**
 * @author shkstart
 * @create 2021-12-13 17:49
 */
@Inherited
@Repeatable(MyAnnotations.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.TYPE_PARAMETER})
public @interface MyAnnotation {

    String value() ;

}

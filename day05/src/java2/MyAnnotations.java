package java2;

import java.lang.annotation.*;

/**
 * @author shkstart
 * @create 2021-12-14 9:31
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.TYPE_PARAMETER})
public @interface MyAnnotations {


    MyAnnotation[] value();
}

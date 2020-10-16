package MathPlugin;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
     Purpose: Used to define an annotation that will be implemented by
     a user-defined math function that can be evaluated in python on
     runtime. Annotations are used to identify the location of the math
     function.
     Author: Aaron Gangemi (19447337)
     Date Modified: 16/10/2020
*/
/*
     @Documented: Used to include annotation information in javadoc
     @Target: Used to identify that the annotation will be performed on methods.
     @Retention: Indicates annotation should be discarded after runtime
*/
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MathData {
     public String name();
     // used to define the name of the math function such as "fibonacci" or 
     // "factorial"
     public String packageName();
     // used to identify the package name of the math function. Currently
     // stored math functions are listed in the MathPlugin package
     public String className();
     // used to identify the class name of each math function. Math functions
     // are currently stored in MathFunctions.java
}

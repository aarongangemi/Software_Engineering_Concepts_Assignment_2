package MathPlugin;
import java.lang.reflect.Method;
import API.*;
/*
    Purpose: A plugin that implements math functions. Each math function
    requires an annotation so the program can identify its location. The
    MathFunctions class implements plugin so it can be loaded upon runtime
    by the user.
    Author: Aaron Gangemi (19447337)
    Date Modified: 16/10/2020
*/
public class MathFunctions implements Plugin
{
    private String name;
    // stores the name of the plugin
    /*
        Purpose: The start method which is used to register the math function
        using its provided annotations. The method will retrieve the function
        definition and add pass it to registerMathematicalFunctions which will
        add the math function execution details to a hashmap for execution by the
        main program.
        @Params:
        api: The api will be used to register the math function
    */
    @Override
    public void start(API api) 
    {
        Class<?> classObj = this.getClass(); // get the math class
        for(Method m : classObj.getMethods())
        {

            MathData annotation = m.getAnnotation(MathData.class);
            // find all methods with annotations in this class
            if(annotation != null && annotation.className().length() > 0 
                    && annotation.name().length() > 0 && 
                    annotation.packageName().length() > 0)
            {
                // ensure that the annotation has all required data
                api.registerMathematicalFunctions(annotation.name() ,"from " + 
                        annotation.packageName() + "." + annotation.className() + 
                        " import " + annotation.name());
                // register the may function by providing math function name
                // and python string for execution
            }
        }
    }

    /*
        Purpose: Used to set the name of the plugin
        @Params: The name of the plugin
    */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /*
        Purpose: retrieve the name of the plugin.
    */
    @Override
    public String getName() {
        return name;
    }
    
    /*
        Purpose: This method performs the fibonacci calculation if the
        text "fibonacci(x)" appears in the entered expression. The annotation
        defines this method as a math function that can be used by the program.
        Reference: https://www.geeksforgeeks.org/program-for-nth-fibonacci-number/
        @params:
        x: the x value that fibonacci will be calculated for. This value is provided
        in the for loop
    */
    @MathData(name="fibonacci",
              packageName="MathPlugin",
              className="MathFunctions")
    public static double fibonacci(double x)
    {
        if(x < 0.0)
        {
            return 0; // if x is negative then return 0
        }
        int val = (int) x;
        if(val <= 1)
        {  //return value after recursion
            return val;
        }
        return fibonacci(val-1) + fibonacci(val-2); // perform fibonacci calc
    }
    /*
        Purpose: Used to perform the factorial calculation once the math plugin has
        been loaded. The annotations provided indicate the location of the factorial
        class and are used to load the calculation. If the string "factorial(x)" is 
        provided to the plugin, then this function will be executed.
        @annotations:
        Used to store the location of the factorial calculation in this class
        @params:
        x: the changing x value used to calculate factorial.
        Reference: https://www.javatpoint.com/factorial-program-in-java
    */
    @MathData(name="factorial",
              packageName="MathPlugin",
              className="MathFunctions")
    public static double factorial(double x)
    {
        if(x < 0.0)
        {
            return 0; // if x is negative, return 0
        }
        double factorialValue = 1.0;
        for(double i = 1.0; i<=x;i++)
        {
            // calculate factorial
            factorialValue *=i;
        }
        return factorialValue;
    }
}

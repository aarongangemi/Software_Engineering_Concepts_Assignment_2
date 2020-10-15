/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 61459
 */
package MathPlugin;
import java.lang.reflect.Method;
import API.*;
public class MathFunctions implements Plugin
{
    private String name;
    @Override
    public void start(API api) 
    {
        Class<?> classObj = this.getClass();
        for(Method m : classObj.getMethods())
        {
            MathData annotation = m.getAnnotation(MathData.class);
            if(annotation != null && annotation.className().length() > 0 
                    && annotation.name().length() > 0 && 
                    annotation.packageName().length() > 0)
            {
                api.registerMathematicalFunctions(annotation.name() ,"from " + 
                        annotation.packageName() + "." + annotation.className() + 
                        " import " + annotation.name());
            }
        }
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
    
    @MathData(name="fibonacci",
              packageName="MathPlugin",
              className="MathFunctions")
    public static double fibonacci(double x)
    {
        if(x < 0.0)
        {
            return 0;
        }
        int val = (int) x;
        if(val <= 1)
        {
            return val;
        }
        return fibonacci(val-1) + fibonacci(val-2);
    }
    @MathData(name="factorial",
              packageName="MathPlugin",
              className="MathFunctions")
    public static double factorial(double x)
    {
        if(x < 0.0)
        {
            return 0;
        }
        double factorialValue = 1.0;
        for(double i = 1.0; i<=x;i++)
        {
            factorialValue *=i;
        }
        return factorialValue;
    }
}

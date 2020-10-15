/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 61459
 */
package SEC_Assignment;

public class MathFunctions implements Plugin
{
    private String name;
    @Override
    public void start(API api) 
    {
        api.registerMathematicalFunctions("from SEC_Assignment.MathFunctions import factorial");
        api.registerMathematicalFunctions("from SEC_Assignment.MathFunctions import fibonacci");
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
    
    public static double fibonacci(double x)
    {
        int val = (int) x;
        if(val <= 1)
        {
            return val;
        }
        return fibonacci(val-1) + fibonacci(val-2);
    }
    
    public static double factorial(double x)
    {
        double factorialValue = 1.0;
        for(double i = 1.0; i<=x;i++)
        {
            factorialValue *=i;
        }
        return factorialValue;
    }
}

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
        
import java.util.HashMap;
import java.util.Scanner;

public class MathFunctions implements ResultHandler, Plugin
{
    private String name;
    @Override
    public void PerformOperation(double x, double y) 
    {
        a
    }

    @Override
    public void start(API api) 
    {
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
    
    private static int Fibonacci(double x)
    {
        if(x <= 1.0)
        {
            return x;
        }
        return Fibonacci(x-1) + Fibonacci(x-2);
    }
    
    private static int Factorial(double x)
    {
        double factorialValue = 1.0;
        for(int i = 1; i<=x;i++)
        {
            factorialValue *=i;
        }
        return factorialValue;
    }
}

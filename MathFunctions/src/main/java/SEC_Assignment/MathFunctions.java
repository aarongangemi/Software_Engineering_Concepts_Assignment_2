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
    @Override
    public void PerformOperation(double x, double y) 
    {
    }

    @Override
    public void start(API api) 
    {
    }

    @Override
    public void setName(String arg0) {
        
    }

    @Override
    public String getName() {
        return "";
    }
    
    private static int Fibonacci(int x)
    {
        if(x <= 1)
        {
            return x;
        }
        return Fibonacci(x-1) + Fibonacci(x-2);
    }
    
    private static int Factorial(int x)
    {
        int factorialValue = 1;
        for(int i = 1; i<=x;i++)
        {
            factorialValue *=i;
        }
        return factorialValue;
    }
}

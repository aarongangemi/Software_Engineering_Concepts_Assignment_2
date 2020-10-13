/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SEC_Assignment;
import SEC_Assignment.API;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author 61459
 */
public class CalculationAPI implements API
{
    //add fields
    private String expression;
    private double minValue;
    private double maxValue;
    private double incrementValue;
    private double YValue;
    private ArrayList<ResultHandler> resultList = new ArrayList<ResultHandler>();
    public CalculationAPI(String expression, double minValue,double maxValue, double incrementValue)
    {
        this.expression = expression;
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.incrementValue = incrementValue;
    }
    
    @Override
    public void registerNotifyCalculation(ResultHandler result) 
    {
        resultList.add(result);
    }

    @Override
    public void registerMathematicalFunctions()
    {
        
    }
    
    public void notifyResult(double x, double y)
    {
        for(ResultHandler r : resultList)
        {
            r.PerformOperation(x, y);
        }
    }

    @Override
    public String getExpression() {
        return expression;
    }

    @Override
    public double getMinValue() {
        return minValue;
    }

    @Override
    public double getMaxValue() {
        return maxValue;
    }

    @Override
    public double getIncrement() {
        return incrementValue;
    }

    @Override
    public double getYValue() {
        return YValue;
    }

    @Override
    public void setYValue(double YValue) {
        this.YValue = YValue;
    }
    
}

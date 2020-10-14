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
public class NativeProgressImpl implements Plugin, ResultHandler
{
    private double maxXValue;
    private String name;
    @Override
    public void start(API api) {
        this.maxXValue = api.getMaxValue();
        api.registerNotifyCalculation(this);
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    static
    {
        System.loadLibrary("progress");
    }
    
    
    @Override
    public void PerformOperation(double x, double y) 
    {
        double val = maxXValue;
        double percentage = progress(x, val);
        System.out.println("Progress Complete: " + percentage + "%");
    }
   
    public static native double progress(double x, double val);
}

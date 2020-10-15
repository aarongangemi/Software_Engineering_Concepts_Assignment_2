/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 61459
 */
package NativePackage;
import API.*;
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
    
    @Override
    public void PerformOperation(double x, double y) 
    {
        NativeDeclaration nativeDecl = new NativeDeclaration();
        double val = maxXValue;
        double percentage = nativeDecl.progress(x, val);
        System.out.println("Progress Complete: " + percentage + "%");
    }
   

    
}

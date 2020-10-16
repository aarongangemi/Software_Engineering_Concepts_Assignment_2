package ProgressPlugin;
import API.*;
/*
    Purpose: This is the Java implementation/plugin for the progress
    of the function. The progress is used to calculate the progress
    of the for loop implemented in main. The function implements Plugin
    to indicate that this class can be loaded as a plugin on runtime. The
    result handler is user to create the progress operation and load the 
    result on each iteration of the calculation.
*/
public class Progress implements ResultHandler, Plugin
{
    private double maxXValue; // store max value
    private String name; // store name of plugin
    /*
        Purpose: Used to calculate the running progress of the 
        for loop.
        @Params:
        x: the changing x value of the for loop
        y: the resulting value of the calculation
    */
    @Override
    public void PerformOperation(double x, double y) {
        double percentage = (x/maxXValue)*100;
        System.out.println(percentage + "%");
    }
    /*
        Purpose: The start method is used to set the max x value that
        will be required by the calculation. This value is retrieved by
        from the api method "getMaxValue()". This calculation then uses
        the api to register progress as a plugin that will be used to
        register this plugin upon calculation completion.
        @params:
        api: pass in the api to register the plugin
    */
    @Override
    public void start(API api) {
        this.maxXValue = api.getMaxValue();
        api.registerPlugin(this);
    }
    /*
        Purpose: set the name of the plugin
        @params:
        name: name of plugin
    */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /*
        Purpose: retrieve name of plugin
    */   
    @Override
    public String getName() {
        return name;
    }
}
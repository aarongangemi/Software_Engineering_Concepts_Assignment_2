/*
    Purpose: This is a plugin which calculates the running progress
    of the for loop calculation. It implements the plugin and result
    handler to register this class as a plugin and ensure that the 
    progress is calculated on each iteration of the loop.
    Author: Aaron Gangemi (19447337)
    Date Modified: 16/10/2020
*/
package NativePackage;
import API.*;
public class NativeProgressImpl implements Plugin, ResultHandler
{    
    private double maxXValue; // store max value entered by user
    private String name; // store name of plugin
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
        this.maxXValue = api.getMaxValue(); // set max value
        api.registerPlugin(this); // register plugin
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
    /*
        Purpose: To execute the C++ code for the running progress.
        The function first gets an instance of the declaration then
        calls the progress method in C++ to calculate completion.
    */
    @Override
    public void PerformOperation(double x, double y) 
    {
        NativeDeclaration nativeDecl = new NativeDeclaration();
        // get declaration
        double val = maxXValue;
        // get max value
        double percentage = nativeDecl.progress(x, val);
        // call C++ code using native declaration
        System.out.println("Progress Complete: " + percentage + "%");
        // print result
    }
   

    
}

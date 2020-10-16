package SEC_Assignment;
import API.ResultHandler;
import API.API;
import java.util.ArrayList;
import java.util.HashMap;
/*
    Purpose: The CalculationAPI class is a sub-class of the API interface
    which is used to implement the API functions. This class stores values
    for each field utilized by the expression as well as a list of math functions
    and result handlers which connects the API to each associated plugin.
    As defined by the name, this API is predominantely used when calculating the
    result in App.java
    Author: Aaron Gangemi (19447337)
    Date Modified: 16/10/2020
    @Implements:
    API: implements all the API interface functions
*/
public class CalculationAPI implements API
{
    private String expression; // inputted expression
    private double minValue; // inputted min value
    private double maxValue; // inputted max value
    private double incrementValue; // inputted increment value
    private double YValue; // resulting y value
    private ArrayList<ResultHandler> resultList = new ArrayList<ResultHandler>();
    // result handler list for each plugin's result handler
    private HashMap<String, String> mathFunctions = new HashMap<String, String>();
    // hashmap for math functions
    /*
        Purpose: Constructor for the CalculationAPI which is used to set each value
        in the API
        @params:
        expression: inputted expression
        minValue: the inputted min value
        maxValue: the inputted max value
        incrementValue: the inputted value to increment in the loop
    */
    public CalculationAPI(String expression, double minValue,double maxValue, double incrementValue)
    {
        this.expression = expression;
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.incrementValue = incrementValue;
    }
    /*
        Purpose: To register the plugin using the result handler for a given plugin.
        This methods adds a plugin to the list for execution.
        @params:
        result: the result handler for a given plugin
    */
    @Override
    public void registerPlugin(ResultHandler result) 
    {
        resultList.add(result);
    }
    /*
        Purpose: adds the math function name and execution string into a
        hash map. The hashmap is used to execute each given math function
        using the python interpreter.
        @params:
        functionName: the name of the math function
        pythonString: the python string that will allow the math function to be
        executed.
    */
    @Override
    public void registerMathematicalFunctions(String functionName, String pythonString)
    {
        mathFunctions.put(functionName,pythonString);
        // add to hashmap
    }
    /*
        Purpose: retrieve the hashmap containing the math function name and execution
        string.
        @return:
        math hashmap
    */
    public HashMap<String, String> getMathFunctions()
    {
        return mathFunctions;
    }
    
    /*
        Purpose: notifyResult is used to call perform operation on all result handlers
        for plugins that have been loaded. This will execute the main method from each
        plugin using the associated x and y value from the main program.
        @params:
        x: the changing x value which starts at the minimum inputted value
        y: the resulting y value of each iteration.
    */
    public void notifyResult(double x, double y)
    {
        for(ResultHandler r : resultList)
        {
            r.PerformOperation(x, y);
        }
    }

    /*
        Purpose: Retrieve the expression
    */
    @Override
    public String getExpression() {
        return expression;
    }
    /*
        Purpose: retrieve the minimum value
    */
    @Override
    public double getMinValue() {
        return minValue;
    }

    /*
        Purpose: retrieve the max value
    */
    @Override
    public double getMaxValue() {
        return maxValue;
    }

    /*
        Purpose: To retrieve the increment value inputted by user
        @return: increment value
    */
    @Override
    public double getIncrement() {
        return incrementValue;
    }

    /*
        Purpose: To retrieve the resulting Y Value
        @return: Y Value
    */
    @Override
    public double getYValue() {
        return YValue;
    }

    /*
        Purpose: set the resulting Y value
        @params:
        YValue: The y result
    */
    @Override
    public void setYValue(double YValue) {
        this.YValue = YValue;
    }
    
}

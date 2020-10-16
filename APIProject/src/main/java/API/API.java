package API;

import java.util.List;
/*
    Purpose: This is the API interface. It defines a set of methods that
    the user may implement to either retrieve data or register a plugin/
    event.
    Author: Aaron Gangemi (19447337)
    Date Modified: 16/10/2020
*/
public interface API
{
    /*registerNotifyCalculation:
        Purpose: Used to register a result that has been calculated.
        @Params
        result: The user should pass in an instance of a class that implements
        the ResultHandler interface. This method can also be called 
        after the result has been determined.
    */
    void registerPlugin(ResultHandler result);
    /*registerMathematicalFunctions
        Purpose: The user will be able to register any new mathematical functions
        that they wish to use in their python expression. The API definition takes
        a key and a value as it uses a hashmap to store each function to ensure that
        each function is unique and not defined twice.
        @Params:
        Key: The user must pass in the name of the function they wish to add
        Value: The user must pass in the python string that will be executed by the 
        python interpreter.

        This method is called in the start method of MathFunctions so users just need
        to add their functions with the associated annotations to the MathFunctions 
        class.
    */
    void registerMathematicalFunctions(String functionName, String pythonString);
    /*
        Purpose: This function is used to access the expression that has been entered
        by the user. The expression will at least contain the variable 'x' to ensure
        that the expression is valid.
    */
    String getExpression();
    /*
        Purpose: This function is used to retrieve the minimum value that has been 
        entered by the user on runtime. The minimum value will be greater than 0.0
        and is return to the program as a double.
    */
    double getMinValue();
    /*
        Purpose: This function is used to retrieve the maximum value that has been
        entered by the user on runtime. The max value will be greater than the minimum
        value and is returned as a double.
    */
    double getMaxValue();
    /*
        Purpose: The get increment function is used to retrieve the incremented value
        that is entered by the user on run time. This value will be greater than 0.0
        and is used to execute the for loop that is used for the calculation.
    */
    double getIncrement();
    /*
        Purpose: getYValue() is used to retrieve the Y value after each iteration of 
        the for loop calculation.This value is returned as a double.
    */
    double getYValue();
    /*
        Purpose: SetYValue() is used to set the resulting value after each iteration
        of the for loop found in the main app.
        @params: The value the user wishes to set the YValue to which should be the
        resulting value.
    */
    void setYValue(double YValue);
}

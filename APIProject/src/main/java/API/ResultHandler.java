package API;
/*
    Purpose: ResultHandler is used to perform a core operation for any
    given plugin. For example, the CSVWriter plugin will perform CSV writing
    in this class using the desired x and y values. The ResultHandler will
    then be implemented by a given plugin to register the plugin with the
    program.
    Author: Aaron Gangemi (19447337)
    Date Modified: 16/10/2020
*/
public interface ResultHandler
{
    /*
        Purpose: Used to perform an operation on the calculation that the plugin
        may wish to implement.
        @Params:
        x: The changing x value that is initially set to the minimum value entered
        by the user at run time. This value will change on each iteration of the for
        loop until it reaches the maximum value that has been entered by the user.
        y: The resulting value of the calculation in each iteration.
    */
    void PerformOperation(double x , double y);
}

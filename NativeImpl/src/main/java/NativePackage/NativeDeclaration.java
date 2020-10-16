package NativePackage;
/*
    Purpose: Used to construct a declaraction for the implementation
    of the C++ progress function. This function is called during the
    native implementation in Java.
    Author: Aaron Gangemi (19447337)
    Date Modified: 16/10/2020
*/
public class NativeDeclaration 
{
    // load the progress function
    static
    {
        System.loadLibrary("progress");
    }
    // define the progress function as native
    public native double progress(double x, NativeProgressImpl n);
}

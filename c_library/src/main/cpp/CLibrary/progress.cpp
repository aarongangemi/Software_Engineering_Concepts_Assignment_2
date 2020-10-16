#include <jni.h>
#include <stdio.h>
/*
    Purpose: This class is written in C++ to demonstrate the native implementation and
    integration of a plugin in Java. The method used calculates the progress percentage 
    of the for loop. This plugin can be loaded by entering "NativeProgressImpl.progress"
    Author: Aaron Gangemi (19447337)
    Date Modified: 16/10/2020
/**/
extern "C"
{
    /*
        Purpose: This method is used to calculate the running progress of the for loop calculation.
        @Params:
        x: takes the changing x value that starts at the minimum value entered by the user.
        val: the maximum value entered by the user
    /**/
    JNIEXPORT double JNICALL Java_NativePackage_NativeDeclaration_progress(JNIEnv *env, jclass cls, jdouble x, jdouble val)
    {
        double percentageResult = (x/val)*100;
        return percentageResult;
    }
}

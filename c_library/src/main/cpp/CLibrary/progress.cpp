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
    JNIEXPORT double JNICALL Java_NativePackage_NativeDeclaration_progress(JNIEnv *env, jobject obj, jdouble x, jobject nativeImpl)
    {
        jclass progressClass = (env)->GetObjectClass(nativeImpl);
        jfieldID maxValueField = (env)->GetFieldID(progressClass,"maxXValue","D");
        jdouble maxValue = (env)->GetDoubleField(nativeImpl, maxValueField);
        double percentageResult = (x/maxValue)*100;
        return percentageResult;
    }
}

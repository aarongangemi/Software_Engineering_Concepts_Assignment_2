#include <jni.h>
#include <stdio.h>
extern "C"
{
    JNIEXPORT double JNICALL Java_NativePackage_NativeDeclaration_progress(JNIEnv *env, jclass cls, jdouble x, jdouble val)
    {
        double percentageResult = (x/val)*100;
        return percentageResult;
    }
}

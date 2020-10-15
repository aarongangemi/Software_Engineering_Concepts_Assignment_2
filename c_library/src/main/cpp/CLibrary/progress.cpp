#include <jni.h>
#include <stdio.h>
extern "C"
{
    JNIEXPORT double JNICALL Java_SEC_1Assignment_NativeProgressImpl_progress(JNIEnv *env, jclass cls, jdouble x, jdouble val)
    {
        double percentageResult = (x/val)*100;
        return percentageResult;
    }
}

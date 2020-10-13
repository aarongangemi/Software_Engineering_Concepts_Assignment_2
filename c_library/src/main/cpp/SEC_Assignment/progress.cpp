#include <jni.h>
#include <stdio.h>
extern "C"
{
    JNIEXPORT void JNICALL PerformOperation(JNIEnv *env, jclass cls, jdouble x, jdouble y)
    {
        jfieldID maxXValue = (*env)->GetFieldID(env,cls,"maxXValue", "D");
	jdouble percentage = (*env)->GetDoubleField(cls, maxXValue);
	double percentDouble = static_cast<double>(percentage);
        double percentageResult = (x/percentDouble)*100;
        printf("%f",percentageResult);
    }
}

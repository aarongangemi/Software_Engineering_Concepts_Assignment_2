package SEC_Assignment;

import java.util.List;

public interface API
{
    void registerNotifyCalculation(ResultHandler result);
    void registerMathematicalFunctions(String mathFunction);
    String getExpression();
    double getMinValue();
    double getMaxValue();
    double getIncrement();
    double getYValue();
    void setYValue(double YValue);
    List<String> getMathFunctions();
    // add getters for x, y, exp, increment
}

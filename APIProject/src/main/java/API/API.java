package API;

import java.util.List;

public interface API
{
    void registerNotifyCalculation(ResultHandler result);
    void registerMathematicalFunctions(String key, String value);
    String getExpression();
    double getMinValue();
    double getMaxValue();
    double getIncrement();
    double getYValue();
    void setYValue(double YValue);
    // add getters for x, y, exp, increment
}

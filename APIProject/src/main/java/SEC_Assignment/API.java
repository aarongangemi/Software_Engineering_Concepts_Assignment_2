package SEC_Assignment;
public interface API
{
    void registerNotifyCalculation(ResultHandler result);
    void registerMathematicalFunction();
    String getExpression();
    double getMinValue();
    double getMaxValue();
    double getIncrement();
    double getYValue();
    void setYValue(double YValue);
    // add getters for x, y, exp, increment
}

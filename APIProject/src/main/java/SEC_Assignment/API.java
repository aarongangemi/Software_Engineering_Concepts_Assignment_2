package SEC_Assignment;
public interface API
{
    void registerNotifyCalculation(ResultHandler result);
    void registerMathematicalFunctions();
    String getExpression();
    double getMinValue();
    double getMaxValue();
    double getIncrement();
    // add getters for x, y, exp, increment
}

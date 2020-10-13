package SEC_Assignment;
import java.io.IOException;
import java.util.*;

public class Progress implements ResultHandler, Plugin
{
    private double maxXValue;
    @Override
    public void recieveResult(double x, double y) {
        double percentage = (x/maxXValue)*100;
        System.out.println(percentage + "%");
    }
    //class field for max x

    @Override
    public void start(API api) {
        this.maxXValue = api.getMaxValue();
        api.registerNotifyCalculation(this);
    }
}
package ProgressPlugin;
import API.*;
public class Progress implements ResultHandler, Plugin
{
    private double maxXValue;
    private String name;
    @Override
    public void PerformOperation(double x, double y) {
        double percentage = (x/maxXValue)*100;
        System.out.println(percentage + "%");
    }

    @Override
    public void start(API api) {
        this.maxXValue = api.getMaxValue();
        api.registerNotifyCalculation(this);
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
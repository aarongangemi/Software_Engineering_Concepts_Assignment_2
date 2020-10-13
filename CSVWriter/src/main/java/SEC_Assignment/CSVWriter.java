package SEC_Assignment;
import java.io.BufferedWriter;
import org.apache.commons.csv.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class CSVWriter implements ResultHandler, Plugin
{
    private String name;
    public void PerformOperation(double XValue, double YValue)
    {
        try
        {
            String fileName = "CSV_Values.csv";
            File file = new File(fileName);
            if(!file.exists())
            {
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file,true);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT);
            csvPrinter.printRecord(XValue,YValue);
            csvPrinter.flush();
        }
        catch(IOException e)
        {
            System.out.println("Unable to write to file");
        }
    }
    
    public void start(API api)
    {
        api.registerNotifyCalculation(this);
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName()
    {
        return name;
    }
}
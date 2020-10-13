package SEC_Assignment;
import java.io.BufferedWriter;
import java.util.Scanner;
import org.apache.commons.csv.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
public class CSVWriter implements ResultHandler, Plugin
{
    public void recieveResult(double XValue, double YValue)
    {
        try
        {
            Scanner sc = new Scanner(System.in);
            System.out.println("Please enter a file name to write to");
            String fileName = sc.nextLine();
            BufferedWriter writer = Files.newBufferedWriter(Paths.get(fileName));
            CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader("X Values", "Y Values"));
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
        api.registerNotifyCalculation(this)
    }
}
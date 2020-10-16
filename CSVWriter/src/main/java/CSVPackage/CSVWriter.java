package CSVPackage;
import java.io.BufferedWriter;
import org.apache.commons.csv.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import API.*;
/*
    Purpose: This is a plugin that is used to write the x and y values to the file 
    "CSV_Values.csv". To write to file, the org.apache.commons.csv package has been
    used as depicted by the assignment specification.
    @Implements
    ResultHandler: Used to call the perform operation method which is registered by 
    the api.
    Plugin: Indicates that this method is a plugin that the user may enter at runtime
    by typing "CSVPackage.CSVWriter"
    Author: Aaron Gangemi (19447337)
    Date Modified: 16/10/2020
*/
public class CSVWriter implements ResultHandler, Plugin
{
    private String name;
    // The name field is used to store the name of the plugin
    /*
        Purpose: Used to perform the CSV Writing operation. This method
        is identified in the ResultHandler interface so this method will be
        executed on each iteration of the for loop. Each x and y value will
        be written to file.
        @Params:
        xValue: The changing x value that starts at the minimum value entered
        by the user
        yValue: The resulting y value from the calculation in the for loop.
    */
    @Override
    public void PerformOperation(double XValue, double YValue)
    {
        try
        {
            String fileName = "CSV_Values.csv";
            // written to CSV_Values.csv
            File file = new File(fileName);
            // construct the file in the root directory.
            if(!file.exists())
            {
                // if the file does not exist then create one.
                file.createNewFile();
            }
            // create a file writer that will append to the given file
            FileWriter fileWriter = new FileWriter(file,true);
            // use org.apache.commons.csv to write to file
            BufferedWriter writer = new BufferedWriter(fileWriter);
            // print csv values
            CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT);
            csvPrinter.printRecord(XValue,YValue);
            // close writer
            csvPrinter.flush();
        }
        catch(IOException e)
        {
            // if anything goes wrong during writing, then catch IO Exception
            System.out.println("Unable to write to file");
        }
    }
    /*
        Purpose: The start method is used to register this class using the 
        registerNotifyCalculation method. This ensures that once an iteration of
        the calculation has been performed, the values will be written to the csv file.
        @Params:
        api: Takes an instance of the api or its subclass.
    */
    @Override
    public void start(API api)
    {
        api.registerPlugin(this);
        // register this class with api
    }
    /*
        Purpose: Used to set the name of this plugin using the name field.
        @Params: 
        name: Takes a string representing the plugin name
    */
    @Override
    public void setName(String name) {
        this.name = name;
    }
    /*
        Purpose: retrieves the name of the plugin
        @return: returns the name as a string.
    */
    @Override
    public String getName()
    {
        return name;
    }
}
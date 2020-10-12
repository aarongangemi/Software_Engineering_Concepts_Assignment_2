package SEC_Assignment;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class CSVWriter
{
    public void writeToFile(double XValue, double YValue)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter a file name to write to");
        String fileName = sc.nextLine();
        FileWriter writer = null;
        try 
        {
            writer = new FileWriter(fileName);
            writer.write(XValue + "," + YValue);
            writer.close();
        } 
        catch (IOException e) 
        {
            try
            {
                System.out.println("Could not write to file, closing file stream");
                writer.close(); 
            }
            catch(IOException x)
            {
                x.printStackTrace();
            }
        }
    }
}
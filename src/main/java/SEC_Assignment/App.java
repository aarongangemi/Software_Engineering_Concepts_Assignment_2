package SEC_Assignment;
import API.Plugin;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import org.python.util.PythonInterpreter;
import org.python.core.*;
/*
    Purpose: The App class stores the main class that will be executed as
    well as all methods that take user input and evaluate the expression.
    It also creates the implementation of the API for use.
    Author: Aaron Gangemi
    Date Modified: 16/10/2020
*/
public class App 
{
    // stores a list of currently loaded plugins
    private static ArrayList<Plugin> pluginList = new ArrayList<Plugin>();
    /*
        Purpose: The main class that will be executed by the program.
        It asks for all users input and deciphers between menu options. The 
        menu is looped until the user selects the exit option.
    */
    public static void main(String[] args)
    {
        int menuOption = 0;
        while(menuOption != 3)
        {
            menuOption = DisplayMenu();
            // display main menu
            if(menuOption == 1)
            {
                // user wants to manage plugins
                int pluginOption = getPluginMenuOption();
                if (pluginOption == 1)
                {
                    // user wants to view plugins
                    displayPlugins();
                }
                else if(pluginOption == 2)
                {
                    // user wants to add plugins
                   AddPlugin(pluginOption);
                }
            }
            else if(menuOption == 2)
            {
                // user wants to evaluate given expression
                EvaluateExpression();
            } 
        }
    }
    /*
        Purpose: To retrieve the name of a plugin that the user wishes to load
        into the program. The method will then construct a new instance of the
        plugin and add it to the list of plugins so it can be used later in the 
        program. The method performs a heap of validation as depicted by the try-
        catch statements below.
    */
    public static void AddPlugin(int pluginOption)
    {
        while(pluginOption == 2) // loop until plugin is valud
        {
           try
           {
              String pluginName = getPluginName(); // retrieve input for plugin name
              Class<?> pluginClass = Class.forName(pluginName); // get plugin class by name
              Plugin pluginObj = (Plugin) pluginClass.getConstructor().newInstance();
              // construct new instance of plugin using constructor
              pluginObj.setName(pluginClass.getName());
              // set the plugin name using class name
              pluginList.add(pluginObj); // add plugin to list
              pluginOption = 0; // exit the loop due to successful plugin found
              System.out.println("Successfully Loaded Plugin: " +pluginObj.getName());
              System.out.println("..............................................");
              // display successful message
           }
           catch(ClassCastException c)
           {
               // if the user loads a class that is not a plugin
               System.out.println("Class does not implement plugin, try again");
           }
           catch(NoSuchMethodException e)
           {
               // if no method exists in the plugin
               System.out.println("Plugin does not exist, please try again");
           }
           catch(ClassNotFoundException f)
           {
               // if the user enters a class name that does not exist
               System.out.println("Class does not exist, please try again");
           }
           catch(InstantiationException g)
           {
               // if an instantiation in the class does not exist
               System.out.println("Something went wrong, try again");
           }
           catch(IllegalAccessException h)
           {
               // if a class that is private is entered
               System.out.println("Can't access class, try again");
           }
           catch(InvocationTargetException j)
           {
               // if the class cannot be invoked
               System.out.println("Can't call class constructor, try again");
           }
        }
    }
    
    /*
        Purpose: Used to display all loaded plugins by looping through all
        plugins that the user has loaded successfully and displaying the name
        field using the appropriate accessor
    */
    public static void displayPlugins()
    {
        if(pluginList.isEmpty())
        {
            // if no plugins are loaded, display message back to user
            System.out.println("..............................................");
            System.out.println("No plugins have been loaded yet");
            System.out.println("..............................................");
        }
        else
        {
            // if plugins do exist
            System.out.println("................Loaded Plugins................");
            for(Plugin p : pluginList)
            {
                // loop through plugin list and display name
                System.out.println(p.getName());
            }
            System.out.println("..............................................");
        }
    }
    /*
        Purpose: To ask the user for the plugin name that they wish to load.
        @return: return the plugin name entered by the user
    */
    public static String getPluginName()
    {
        // prompt user
        System.out.println("..........Please enter a plugin name..........");
        Scanner sc = new Scanner(System.in);
        // user enters string
        String pluginName = sc.nextLine();
        while(pluginName.length() == 0)
        {
            // if string is empty, ask user to retry until not empty
            System.out.println("Please enter a non-empty plugin name");
            pluginName = sc.nextLine();
        }
        System.out.println(".............................................");
        return pluginName;
    }
    /*
        Purpose: To ask the user whether they would like to view or add a plugin
        @return: menu option
    */
    public static int getPluginMenuOption()
    {
        boolean inputValid = false;
        // use bool condition to loop menu until valid option is entered
        int option = -1;
        do
        {
            try
            {
                System.out.println("Please type a number to select an option");
                System.out.println("1. View Plugins");
                System.out.println("2. Add Plugins");
                // ask user for input
                Scanner sc = new Scanner(System.in);
                option = sc.nextInt();
                while(option < 1 || option > 2)
                {
                    // if option not in menu
                    System.out.println("Please enter an integer between 1 and 2");
                    option = sc.nextInt();
                }
                inputValid = true;
                // once option found
            }
            catch(InputMismatchException e)
            {
                System.out.println("Please enter valid input");
            }
        }while(!inputValid);
        return option;
    }
    /*
        Purpose: To evaluate the expression provided by the user at run time. This
        function will use the python interpreter to calculate the answer for each
        iteration of the for loop and perform any provided function from the loaded
        plugins.
    */
    public static void EvaluateExpression()
    {
        PythonInterpreter py = new PythonInterpreter(); //  py interpreter
        String expression = getExpression(); // ask user for expression
        double minValue = getMinimumValue(); // ask user for minimum value
        double maxValue = getMaximumValue(minValue); // ask user for max value
        double incrementValue = getIncrementValue(); // get increment value
        CalculationAPI calcApi= new CalculationAPI(expression, minValue, 
                                                    maxValue, incrementValue);
                                                    // used to access api functions
        for(Plugin p : pluginList)
        {
            p.start(calcApi);
            // start all loaded plugins
            // register plugins in list
        }
        String tempExp;
        for(String str : calcApi.getMathFunctions().keySet())
        {
            py.exec(calcApi.getMathFunctions().get(str));
            // execute any math functions that may be required
        }
        for(double x = minValue; x <= maxValue; x+=incrementValue)
        {
            tempExp = expression;
            tempExp = tempExp.replace("x", Double.toString(x));
            // replace x with value x value in for loop
            try
            {
                double result = ((PyFloat) py.eval("float(" + tempExp + ")")).getValue();
                // calculate result in python and return as double in java
                calcApi.setYValue(result);
                // set api values
                calcApi.notifyResult(x, result);
            }
            catch(PyException e)
            {
                // if anything goes wrong with python evaluation
                System.out.println("Something went wrong with the calculation, please double check the input string");
            }
        }
        
    }
    /*
        Purpose: To display the menu back to the user. User will be able to select
        an option for either plugins or evaluation of expression or exit program
        @return: menuOption
    */
    private static int DisplayMenu()
    {
        int option = -1;
        boolean inputValid = false;
        // use boolean to loop menu until valid
        do
        {
            try
            {
                System.out.println("Please type a number to select an option");
                System.out.println("1. Manage Plugins");
                System.out.println("2. Evaluate Equation");
                System.out.println("3. Exit");
                Scanner sc = new Scanner(System.in);
                option = sc.nextInt();
                // get menu option from user
                while(option < 1 || option > 3)
                {
                    System.out.println("Please enter an integer between 1 and 3");
                    option = sc.nextInt();
                    // if option invalid, loop until valid
                }
                inputValid = true;
                //set to true once option valid
            }
            catch(InputMismatchException e)
            {
                // if user enters letters or special characters
                System.out.println("Please enter a valid number");
            }
        }while(!inputValid);
        return option;
    }
    /*
        Purpose: Used to retrieve the inputted expression from user input
        @return: expression as string
    */
    private static String getExpression()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter a mathematical expression");
        // ask user to enter math expression
        String expression = sc.nextLine();
        while(!expression.contains("x"))
        {
            // ensure expression contains x variable
            System.out.println("Please enter a valid expression that contains the variable x");
            expression = sc.nextLine();
        }
        return expression;
    }
    /*
        Purpose: ask user to enter minimum value
        @return: minimum value as double
    */
    private static double getMinimumValue()
    {
        boolean inputValid = false;
        // use bool to loop menu until valid input entered
        double option = -1.0;
        do
        {
            try
            {
                Scanner sc = new Scanner(System.in);
                System.out.println("Please enter the minimum x value");
                option = sc.nextDouble();  
                // ask user to enter min value
                while(option < 0.0)
                {
                    System.out.println("Please enter a decimal number "
                            + "that is greater than or equal to 0");
                    option = sc.nextDouble();
                    // user must enter value >= 0
                }
                inputValid = true;
                // input checks passed
            }
            catch(InputMismatchException e)
            {
                // if user enters invalid data type
                System.out.println("Invalid input, try again");
            }
        }while(!inputValid);
        // loop menu till valid
        return option;   
    }
    
    /*
        Purpose: retrieve max value from user input
        @returns: max value
    */
    private static double getMaximumValue(double minValue)
    {
        boolean inputValid = false;
        double maxValue = -1;
        do{
            try
            {
                Scanner sc = new Scanner(System.in);
                System.out.println("Please enter the maximum x value");
                // get max value from user input as double
                maxValue = sc.nextDouble();  
                while(maxValue < minValue)
                {
                    System.out.println("Please enter a value higher than " + minValue);
                    maxValue = sc.nextDouble();
                    // loop until max value > min value to ensure loop can run
                }
                inputValid = true;
                // all input is valid
            }
            catch(InputMismatchException e)
            {
                // if user enters invalid data type
                System.out.println("Invalid input, try again");
            }
        }while(!inputValid);
        // loop menu till valid input entered
        return maxValue;
    }
    /*
        Purpose: Ask user to enter the increment value
        @returns: increment value
    */
    private static double getIncrementValue()
    {
        boolean inputValid = false;
        // use bool to validate input
        double option = -1.0;
        do
        {
            try
            {
                Scanner sc = new Scanner(System.in);
                System.out.println("Please enter the increment x value");
                option = sc.nextDouble();  
                // user enters increment value as a double
                while(option <= 0.0)
                {
                    System.out.println("Please enter a decimal number "
                            + "that is greater than 0");
                    option = sc.nextDouble();
                    // if increment value <= 0 then try again
                }
                inputValid = true;
                // all input valid
            }
            catch(InputMismatchException e)
            {
                // if user enters incorrect data type
                System.out.println("Invalid input, try again");
            }
        }while(!inputValid);
        return option;
    }           
    
}
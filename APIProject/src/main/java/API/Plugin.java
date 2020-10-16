package API;
/*
    Purpose: This is the plugin class. It defines a set of methods that
    must be implemented by each plugin that is defined by the user.
    Author: Aaron Gangemi (19447337)
    Date Modified: 16/10/2020
*/
public interface Plugin
{
    /*
        Purpose: The start method is used to define a set of actions that
        the plugin would like to perform before the initial calculation
        is performed. It is recommended that the user use this method to 
        register the result handler so that the result can be registered
        with the program.
        @Params:
        The start method requires an instance of the api so various methods
        used by the expression calculation can be utilized.
    */
    void start(API api);
    /*
        Purpose: This method is required to set the name of the plugin. The
        user should require a name field in each plugin so that the program can
        track which plugins have been currently loaded. The name field will be 
        of type String.
        @Params:
        name: The name of the plugin that the user enters
    */
    void setName(String name);
    /*
        Purpose: This method is used to access the value of the plugin name.
        It is used during the display of the plugins that have been currently
        loaded to identify which plugins currently exist. This method will return
        a string identifying the name of the plugin.
    */
    String getName();
    
}
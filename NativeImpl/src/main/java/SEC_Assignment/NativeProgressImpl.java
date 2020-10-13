/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 61459
 */
package SEC_Assignment;
public class NativeProgressImpl implements Plugin, ResultHandler
{

    @Override
    public void start(API arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setName(String arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void PerformOperation(double arg0, double arg1) 
    {
        progress();
    }
    
    static
    {
        System.loadLibrary("c_library");
    }
    
    public static native void progress();
}

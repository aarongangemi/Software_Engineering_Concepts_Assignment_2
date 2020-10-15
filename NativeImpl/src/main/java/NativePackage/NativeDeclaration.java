/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 61459
 */
package NativePackage;
public class NativeDeclaration {
    static
    {
        System.loadLibrary("progress");
    }
    public native double progress(double x, double val);
}

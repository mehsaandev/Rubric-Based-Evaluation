/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author Ahsan
 */
public class Bro {
    private static Bro bro = null;
    
    private Bro()
    {
        System.out.println("Hello Bro");
    }
    public static Bro getInstance()
    {
        if(bro == null)
        {
            bro = new Bro();
            return bro;
        }
        return bro;
    }
}

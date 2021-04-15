/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;
import java.util.ArrayList;
/**
 *
 * @author Ehsaan
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        //////////////////////////////////////// List Declaration
        ArrayList<String> testList = new ArrayList<String>();
        
        ////////////////////////////////////////// Add data in List
        testList.add("My Name is Ehsaan");
        testList.add("My Registration Number is 2020-CS-128");
        
        System.out.println(testList.get(0));
        System.out.println(testList.get(1));
        System.out.println("\n");
        
        ////////////////////////////////////////// Remove Data from List
        testList.remove("My Name is Ehsaan");
        System.out.println(testList.get(0));
        System.out.println("\n");
        
        ////////////////////////////////////////// Update Data in List
        testList.add("Hello Word");
        testList.set(1, "Hello Mars");
        System.out.println(testList.get(0));
        System.out.println(testList.get(1));
        
        
    }
    
}

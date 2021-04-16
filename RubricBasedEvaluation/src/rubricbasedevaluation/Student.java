/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rubricbasedevaluation;
import java.util.ArrayList;
/**
 *
 * @author Ehsaan
 */
public class Student extends SystemBody{
    
    private String regNumber;
    private static ArrayList<Assessments> assessmentsList= new ArrayList<Assessments>();
    /** Set value of fRegistration Number
     * 
     * @param regNumber 
     */
    public void setRegNumber(String regNumber)
    {
        this.regNumber = regNumber;
    }
    /**
     * 
     * @return 
     */
    public String getRegNumber()
    {
        return this.regNumber;
    }
    
}

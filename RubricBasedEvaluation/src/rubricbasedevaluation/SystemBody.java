/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rubricbasedevaluation;

/**
 *
 * @author Ahsan
 */
public class SystemBody {
    protected String name;
    protected String cnic;
    protected String email;
    
    //////////////////////////////////////////////////////////////////////////// Setter
    public void setName(String name)
    {
        this.name = name;
    }
    public void setCNIC(String cnic)
    {
        this.cnic = cnic;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }
    
    //////////////////////////////////////////////////////////////////////////// Getters
    public String getName()
    {
        return this.name;
    }
    public String getCNIC()
    {
        return this.cnic;
    }
    public String getEmail()
    {
        return this.email;
    }
}

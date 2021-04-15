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
public class Teacher extends SystemBody {

    private String username;
    private String password;
    private static Teacher teacher = null;

    private Teacher(String name, String CNIC, String email, String username, String password) {
        this.name = name;
        this.cnic = CNIC;
        this.email = email;
        this.username = username;
        this.password = password;
        
    }

    public static Teacher getInstance(String name, String CNIC, String email, String username, String password) {
        if (teacher == null) {
            teacher = new Teacher(name, CNIC, email, username, password);
            return teacher;
        }
        return teacher;
    }
    public static Teacher getTeacher()
    {
        return teacher;
    }

    //////////////////////////////////////////////////////////////////////////// Getters
    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    //////////////////////////////////////////////////////////////////////////// Setters
    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean checkLogin(String username, String password) {
        System.out.println(this.username + "  "+ username);
        System.out.println(this.password + "  "+ password);
        if ((this.username.equals(username) || this.email.equals(username)) && (this.password.equals(password))) {
            System.out.println("Entered in if");
            return true;
        }
        return false;
    }

}

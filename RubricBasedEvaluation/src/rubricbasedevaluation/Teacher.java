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

    private Teacher() {
        this.name = "NA";
        this.cnic = "NA";
        this.email = "NA";
        this.username = "NA";
        this.password = "NA";

    }

    public static Teacher getInstance(String name, String CNIC, String email, String username, String password) {
        if (teacher == null || teacher.getUsername().equals("NA")) {
            teacher = new Teacher(name, CNIC, email, username, password);
            return teacher;
        }
        return teacher;
    }

    public static Teacher getInstance() {
        if (teacher == null) {
            teacher = new Teacher();
            return teacher;
        }
        return teacher;
    }

    public static Teacher getTeacher() {
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
        if ((this.username.equals(username) || this.email.equals(username)) && (this.password.equals(password))) {

            return true;
        }
        return false;
    }

}

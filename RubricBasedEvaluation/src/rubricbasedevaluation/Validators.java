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
public class Validators {

    public static boolean validateName(String name) {
        boolean flag = false;
        for (int i = 0; i < name.length(); i++) {
            if ((name.charAt(i) >= 'A' && name.charAt(i) <= 'Z') || (name.charAt(i) >= 'a' && name.charAt(i) <= 'z') || (name.charAt(i) == ' ')) {
                flag = true;
            } else {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public static boolean validateUsername(String name) {
        boolean flag = false;
        if (name.length() >= 8 && ((name.charAt(0) >= 'A' && name.charAt(0) <= 'Z') || (name.charAt(0) >= 'a' && name.charAt(0) <= 'z'))) {
            for (int i = 0; i < name.length(); i++) {
                if ((name.charAt(i) >= 'A' && name.charAt(i) <= 'Z') || (name.charAt(i) >= 'a' && name.charAt(i) <= 'z') || (name.charAt(i) >= '0' && name.charAt(i) <= '9')) {
                    flag = true;
                } else {
                    flag = false;
                    break;
                }
            }

        }
        return flag;
    }

    public static boolean validateCNIC(String cnic) {
        boolean flag = false;
        if (cnic.length() == 13) {
            for (int i = 0; i < cnic.length(); i++) {
                if (cnic.charAt(i) >= '0' && cnic.charAt(i) <= '9') {
                    flag = true;
                } else {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }

    public static boolean validateEmail(String email) {
        boolean flag = false;
        int check = 0;
        if (email.length() >= 5 && ((email.charAt(0) >= 'A' && email.charAt(0) >= 'Z') || (email.charAt(0) >= 'a' && email.charAt(0) >= 'z'))) {
            for (int i = 0; i < email.length(); i++) {
                if (email.charAt(i) == '@') {
                    for (int j = i + 1; j < (email.length() - 1); j++) {
                        if (email.charAt(j) == '@') {
                            flag = false;
                            break;
                        }

                        if (email.charAt(j) == '.') {
                            flag = true;
                            check++;
                        }
                    }
                    break;

                } else if (!((email.charAt(i) >= 'A' && email.charAt(i) <= 'Z') || (email.charAt(i) >= 'a' && email.charAt(i) <= 'z') || (email.charAt(i) >= '1' && email.charAt(i) <= '9') || email.charAt(i) == '.')) {
                    flag = false;
                    break;
                }
                if (flag == true && check == 1) {
                    if (email.charAt(email.length() - 1) == '.' || email.charAt(email.length() - 1) == '@') {
                        flag = false;
                    }
                }
            }
        }

        return flag;
    }

    public static boolean validatePassword(String password) {
        boolean flag1 = false;
        boolean flag2 = false;
        if (password.length() >= 8) {
            for (int i = 0; i < password.length(); i++) {
                if (password.charAt(i) >= 'A' && password.charAt(i) <= 'Z') {
                    flag1 = true;
                    break;
                }
            }
            for(int i = 0; i < password.length(); i++)
            {
                if (!((password.charAt(i) >= 'A' && password.charAt(i) <= 'Z') ||(password.charAt(i) >= 'a' && password.charAt(i) <= 'z') || (password.charAt(i) >= '0' && password.charAt(i) <= '9'))) {
                    flag2 = true;
                    break;
                }
            }
        }
        if(flag1 == true && flag2 == true)
        {
            return true;
        }
        return false;
    }
    
}

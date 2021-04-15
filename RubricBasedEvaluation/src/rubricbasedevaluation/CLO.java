/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rubricbasedevaluation;

import java.util.ArrayList;

/**
 *
 * @author Ahsan
 */
public class CLO {

    private String name;
    private int totalMarks;
    private ArrayList<Rubrics> rubricsList = new ArrayList<Rubrics>();

    /////////////////////////////////////////////////////////////////////////// Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setTotalMarks(int totalMarks) {
        this.totalMarks = totalMarks;
    }

    public void setRubricsList(ArrayList<Rubrics> rubricsList) {
        this.rubricsList = rubricsList;
    }

    /////////////////////////////////////////////////////////////////////////// Getters
    public String getName() {
        return this.name;
    }

    public int getTotalMarks() {
        return this.totalMarks;
    }

    public ArrayList<Rubrics> getRubricsList() {
        return this.rubricsList;
    }

    ////////////////////////////////////////////////////////////////////////////// Functions on Rubrics List
    public boolean addRubric(Rubrics rubric) {
        if (this.searchRubric(rubric) == -1) {
            rubricsList.add(rubric);
            return true;
        }
        return false;
    }

    public boolean deleteRubric(Rubrics rubric) {
        if (this.searchRubric(rubric) != -1) {
            rubricsList.remove(rubric);
            return true;
        }
        return false;
    }

    public boolean editRubric(Rubrics rubric) {
        if (this.searchRubric(rubric) != -1) {
            rubricsList.set(this.searchRubric(rubric),rubric);
            return true;
        }
        return false;
    }

    public int searchRubric(Rubrics rubric) {
        int flag = -1;
        for (int i = 0; i < this.rubricsList.size(); i++) {
            if (this.rubricsList.get(i).equals(rubric)) {
                flag = i;
                break;
            }
        }
        return flag;
    }

}

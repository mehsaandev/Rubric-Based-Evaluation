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
public class Student extends SystemBody {

    private String regNumber;
    private static ArrayList<Assessments> assessmentsList = new ArrayList<Assessments>();
    private ArrayList<Double> studentOM = new ArrayList<Double>();

    /**
     * Set value of fRegistration Number
     *
     * @param regNumber
     */
    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    /**
     *
     * @return
     */
    public void addStdOM(double OM)
    {
        this.studentOM.add(OM);
    }
    public void setStdOmList(ArrayList<Double> list)
    {
        this.studentOM = list;
    }
    
    public ArrayList<Double> getStdOmList()
    {
        return this.studentOM;
    }
    public String getRegNumber() {
        return this.regNumber;
    }

    public static void addAssessment(Assessments assessment) {
        assessmentsList.add(assessment);
    }

    public static boolean deleteAssessment(Assessments assessment) {
        if (searchAssessment(assessment) != -1) {
            assessmentsList.remove(assessment);
            return true;
        }
        return false;
    }

    public static boolean editAssessment(int index, Assessments assessment) {
        if (searchAssessment(assessment) != -1) {
            assessmentsList.set(index, assessment);
            return true;
        }
        return false;
    }

    public static int searchAssessment(Assessments assessment) {
        for (int i = 0; i < assessmentsList.size(); i++) {
            if (assessmentsList.get(i) == assessment) {
                return i;
            }
        }
        return -1;
    }

    public static ArrayList<Assessments> getAssessmentList() {
        return assessmentsList;
    }

    public ArrayList<Assessments> getAssessmentofStudent() {
        return assessmentsList;
    }

    public static void setAssessmentList(ArrayList<Assessments> assessmentList) {
        assessmentsList = assessmentList;
    }

}

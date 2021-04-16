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
public class EvaluationRecord {

    private ArrayList<Student> studentList = new ArrayList<Student>();
    private ArrayList<CLO> cloList = new ArrayList<CLO>();
    private static EvaluationRecord evaluationRecord = null;
    private RubricLevels rubricLevel = new RubricLevels();

    private EvaluationRecord() {
    }

    ////////////////////////////////////////////////////////////////////
    public RubricLevels getRubricLevel() {
        return this.rubricLevel;
    }

    public void setRubricLevel(RubricLevels rubricLevel) {
        this.rubricLevel = rubricLevel;
    }

    /////////////////////////////////////////////////////////// Student List Functions
    public void setStudentList(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }

    public ArrayList<Student> getStudentList() {
        return this.studentList;
    }

    //////////////////////////////////////////////////////////////// CLO list functions
    public void setCLOList(ArrayList<CLO> cloList) {
        this.cloList = cloList;
    }

    public ArrayList<CLO> getCLOList() {
        return this.cloList;
    }

    public boolean addCLO(CLO clo) {
        if (searchCLO(clo) == -1) {
            this.cloList.add(clo);
            return true;
        }
        return false;
    }

    public boolean editCLO(int index, CLO clo) {

        this.cloList.set(index, clo);
        return true;
    }

    public boolean deleteCLO(CLO clo) {
        if (searchCLO(clo) != -1) {
            this.cloList.remove(clo);
            return true;
        }
        return false;
    }

    public int searchCLO(CLO clo) {
        for (int i = 0; i < this.cloList.size(); i++) {
            if (this.cloList.get(i).getName().equals(clo.getName())) {
                return i;
            }
        }
        return -1;
    }

    //////////////////////////////////////////////////////////////////////// Stduent List Functions
    public int searchStudent(Student student) {
        for (int i = 0; i < this.studentList.size(); i++) {
            if (this.studentList.get(i).cnic.equals(student.getCNIC()) || this.studentList.get(i).getEmail().equals(student.getEmail())) {
                return i;
            }
        }
        return -1;
    }

    public boolean addStudent(Student student) {
        if (searchStudent(student) == -1) {
            this.studentList.add(student);
            return true;
        }
        return false;
    }

    public boolean deleteStudent(Student student) {
        if (searchStudent(student) != -1) {
            this.studentList.remove(student);
            return true;
        }
        return false;
    }

    public boolean editStudent(Student student) {
        if (searchStudent(student) != -1) {
            this.studentList.set(searchStudent(student), student);
            return true;
        }
        return false;
    }

    public static EvaluationRecord getInstance() {
        if (evaluationRecord == null) {
            evaluationRecord = new EvaluationRecord();
            return evaluationRecord;
        }
        return evaluationRecord;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        RegisterTeacher loginForm = new RegisterTeacher();
        loginForm.setVisible(true);
    }

}

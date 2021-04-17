/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rubricbasedevaluation;

import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.JOptionPane;
import java.util.Scanner;

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
        loadCLO();
    }

    private static ArrayList<CLO> loadCLO() {
        try {
            int count = 0;
            ArrayList<CLO> cloList = new ArrayList<CLO>();
            File reader = new File("CLO.txt");
            Scanner input = new Scanner(reader);
            while (input.hasNextLine()) {
                if (count > 0) {
                     System.out.println("clo count is" + count);
                    CLO clo = new CLO();
                    String getRecord = input.nextLine();
                    String[] arrayRecord = getRecord.split(";");
                    System.out.println(arrayRecord[0]);
                    clo.setName(arrayRecord[0]);
                    clo.setTotalMarks(Integer.parseInt(arrayRecord[1]));
                    cloList.add(clo);
                } else {
                    String lost = input.nextLine();
                }
                count++;

            }

            return cloList;

        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "CLO data is not loaded, File not Found");
        }
        return null;
    }

    private static void loadRubric() {
        try {
            File rubricFile = new File("Rubrics.txt");
            Scanner input = new Scanner(rubricFile);
            int count = 0;
            while (input.hasNextLine()) {

                System.out.println("count is" + count);
                if (count > 0) {
                    System.out.println("Entered count is " + count);
                    String rubricRecord = input.nextLine();
                    String[] arrayRubric = rubricRecord.split(":");
                    Rubrics rubric = new Rubrics();

                    System.out.println("name clo is : " + arrayRubric[1]);
                    String[] indexNumber = (arrayRubric[0].split("-"));
                    int index = Integer.parseInt(indexNumber[1]);
                    System.out.println("Index is :" + index);
                    rubric.setName(arrayRubric[1]);
                    evaluationRecord.getCLOList().get(index - 1).getRubricsList().add(rubric);
                } else {
                    String lost = input.nextLine();
                }
                count++;
            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Rubrics data is not loaded, File not Found");
        }
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

    public boolean editStudent(int index, Student student) {

        this.studentList.set(index, student);
        return true;
    }

    public static EvaluationRecord getInstance() {
        if (evaluationRecord == null) {
            evaluationRecord = new EvaluationRecord();
            evaluationRecord.setCLOList(loadCLO());
            loadRubric();
            return evaluationRecord;
        }
        return evaluationRecord;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        EvaluationRecord evaluationRecord = EvaluationRecord.getInstance();
        RegisterTeacher loginForm = new RegisterTeacher();
        loginForm.setVisible(true);
    }

}

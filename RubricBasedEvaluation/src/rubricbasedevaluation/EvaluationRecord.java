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

    private static void loadRubricLevels() {
        try {
            File rubricLevelReader = new File("RubricLevels.txt");
            Scanner getLevel = new Scanner(rubricLevelReader);
            RubricLevels rubricLevel = new RubricLevels();
            getLevel.nextLine();
            rubricLevel.setRubricLevels(Integer.parseInt(getLevel.nextLine()));
            ArrayList<String> listRubric = new  ArrayList<String>();
            while (getLevel.hasNextLine()) {
                listRubric.add(getLevel.nextLine());
            }
            rubricLevel.setLevelList(listRubric);
            evaluationRecord.setRubricLevel(rubricLevel);
        } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Rubrics Levels data is not loaded, File not Found");
        }

    }

    private static ArrayList<Student> loadStudent() {
        try {
            int count = 0;
            File reader = new File("Student.txt");
            Scanner studentReader = new Scanner(reader);
            ArrayList<Student> studentList = new ArrayList<Student>();
            while (studentReader.hasNextLine()) {
                if (count > 0) {
                    String[] getStd = studentReader.nextLine().split(":");

                    Student student = new Student();
                    student.setRegNumber(getStd[0]);
                    student.setCNIC(getStd[1]);
                    student.setEmail(getStd[2]);
                    student.setName(getStd[3]);
                    studentList.add(student);
                } else {
                    String lost = studentReader.nextLine();
                }
                count++;
            }
            return studentList;
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Student data is not loaded, File not Found");
        }
        return null;

    }

    private static void loadAssessment() {
        try {
            File reader = new File("Assessment.txt");
            Scanner input = new Scanner(reader);
            int count = 0;
            while (input.hasNextLine()) {
                if (count > 0) {
                    Assessments assessment = new Assessments();
                    String getAssessment = input.nextLine();
                    if (getAssessment.equals("true")) {
                        assessment.setActive(true);
                    } else if (getAssessment.equals("false")) {
                        assessment.setActive(false);
                    }
                    Student.addAssessment(assessment);
                } else {
                    String lost = input.nextLine();
                }
                count++;
            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Assessment data is not loaded, File not Found");
        }

    }

    private static void loadQuestions() {

        try {
            File reader = new File("Questions.txt");
            Scanner input = new Scanner(reader);
            int count = 0;
            while (input.hasNextLine()) {
                if (count > 0) {

                    String[] getQuestions = input.nextLine().split(";");
                    int cloIndex = Integer.parseInt(getQuestions[3].substring(4, getQuestions[3].length()));
                    int indexRubric = Integer.parseInt(getQuestions[4].substring(7, getQuestions[4].length()));
                    Questions question = new Questions();
                    question.setCLO(evaluationRecord.getCLOList().get(cloIndex - 1));
                    question.setRubric(evaluationRecord.getCLOList().get(cloIndex - 1).getRubricsList().get(indexRubric - 1));
                    question.setQuestionStatement(getQuestions[1]);
                    question.setTotalMarks(Integer.parseInt(getQuestions[2]));
                    Student.getAssessmentList().get(Integer.parseInt(getQuestions[0])).getQuestionsList().add(question);
                } else {
                    String lost = input.nextLine();
                }
                count++;
            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Question data is not loaded, File not Found");
        }
    }

    private static ArrayList<CLO> loadCLO() {
        try {
            int count = 0;
            ArrayList<CLO> cloList = new ArrayList<CLO>();
            File reader = new File("CLO.txt");
            Scanner input = new Scanner(reader);
            while (input.hasNextLine()) {
                if (count > 0) {
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

                if (count > 0) {
                    String rubricRecord = input.nextLine();
                    String[] arrayRubric = rubricRecord.split(":");
                    Rubrics rubric = new Rubrics();

                    String[] indexNumber = (arrayRubric[0].split("-"));
                    int index = Integer.parseInt(indexNumber[1]);
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
            loadAssessment();
            loadQuestions();
            evaluationRecord.setStudentList(loadStudent());
            loadRubricLevels();
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

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
public class Questions {
    private CLO clo;
    private Rubrics rubric;
    private int obtainedMarks;
    private int totalMarks;
    
    ////////////////////////////////////////////////////////////////////////////    Setters
    public void setCLO(CLO clo)
    {
        this.clo = clo;
    }
    public void setRubric(Rubrics rubric)
    {
        this.rubric = rubric;
    }
    public void setObtainedMarks(int obtainedMarks)
    {
        this.obtainedMarks = obtainedMarks;
    }
    public void setTotalMarks(int totalMarks)
    {
        this.totalMarks = totalMarks;
    }
    
    ////////////////////////////////////////////////////////////////////////////    Getters
    public CLO getClO()
    {
        return this.clo;
    }
    public Rubrics getRubric()
    {
        return this.rubric;
    }
    public int getObtainedMarks()
    {
        return this.obtainedMarks;
    }
    public int getTotalMarks()
    {
        return this.totalMarks;
    }
}

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
public class Assessments {
   private ArrayList<Questions> questionsList = new ArrayList<Questions>();
   private boolean activeAssessments;
   
   ////////////////////////////////////////////////////////////////////////////  Getters
   public boolean getActive()
   {
       return this.activeAssessments;
   }
   public ArrayList<Questions> getQuestionsList()
   {
       return this.questionsList;
   }
   ////////////////////////////////////////////////////////////////////////////  Setters
   public void setActive(boolean activeAssessments)
   {
       this.activeAssessments = activeAssessments;
   }
   public void setQuestionsList(ArrayList<Questions> questionsList)
   {
       this.questionsList = questionsList;
   }
   ///////////////////////////////////////////////////////////////////////////// Questions Lsit functions
   /**
    * 
    * @param question
    * @return 
    */
   public boolean addQuestion(Questions question)
   {
       if(searchQuestion(question) == -1)
       {
           this.questionsList.add(question);
           return true;
       }
       return false;
   }
   /**
    * 
    * @param question
    * @return 
    */
   public boolean editQuestion(Questions question)
   {
       if(searchQuestion(question) !=-1)
       {
           this.questionsList.set(searchQuestion(question), question);
           return true;
       }
       return false;
   }
   public boolean removeQuestion(Questions question)
   {
       if(searchQuestion(question)!=-1)
       {
           this.questionsList.remove(question);
           return true;
       }
       return false;
   }
   /**
    * 
    * @param question
    * @return 
    */
   public int searchQuestion(Questions question)
   {
       int flag = -1;
       for(int i = 0;i<this.questionsList.size();i++)
       {
           if(this.questionsList.get(i).equals(question))
           {
               flag = i;
               break;
           }
       }
       return flag;
   }
    
}

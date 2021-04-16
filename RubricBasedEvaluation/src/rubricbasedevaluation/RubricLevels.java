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
public class RubricLevels {

    private int rubricLevels;
    private ArrayList<String> levelList = new ArrayList<>();

    public void setRubricLevels(int rubricLevels) {
        this.rubricLevels = rubricLevels;
    }

    public void setLevelList(ArrayList<String> levelList) {
        this.levelList = levelList;
    }

    public int getRubricLevels() {
        return this.rubricLevels;
    }

    public ArrayList<String> getLevelList() {
        return this.levelList;
    }

    public boolean addLRubricLevelList(String levelName) {
        if (searchRubicLevel(levelName) == false) {
            this.levelList.add(levelName);
            return true;
        }
        return false;
    }

    public boolean searchRubicLevel(String levelName) {
        for (int i = 0; i < this.levelList.size(); i++) {
            if (this.levelList.get(i).equals(levelName)) {
                return true;
            }
        }
        return false;
    }
    public void setEmpty()
    {
        this.levelList =new ArrayList<String>();
    }
}

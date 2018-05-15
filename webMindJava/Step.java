package webMindJava;
/************************************************************************
 Intermediate Class used to store/load step data to/from JSON
 I************************************************************************/

public class Step {
    private Grid stepGrid;
    private String stepName;

    //constructor that include stepName
    public Step(Grid inputGrid,String stepName) {
        stepGrid=inputGrid;
        this.stepName=stepName;
    }

    //constructor that doesn't include stepName
    public Step(Grid inputGrid) {
        stepGrid=inputGrid;
        stepName="";
    }

    //Setters and Getter
    public void setStepGrid(Grid inputGrid) {
        stepGrid=inputGrid;
    }
    public Grid getStepGrid() {
        return stepGrid;
    }
    public void setStepName(String stepName) {
        this.stepName=stepName;
    }
    public String getStepName() {
        return stepName;
    }

    // Used to print out step to see what the values are
    public String toString() {
        String returnString="stepGrid: " + stepGrid + "\n";
        returnString += "stepName: " + stepName + "\n";
        return returnString;
    }
}

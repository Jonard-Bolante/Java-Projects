package webMindJava;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.LinkedList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.lang.Object;


public class Session {
    private String sessionFilename;
    private File sessionFile;
    private Integer currentStep;

    LinkedList<Step> steps;

    public Session() { //Used for creating a new session
		/*Creates a new file for a new session*/
        steps=new LinkedList<Step>();
        sessionFilename= generateFileName();
        sessionFile = new File(sessionFilename);
        currentStep = 0;
    }

    public Session(String sessionFilename) { //Used to load a previously saved Session
        steps=new LinkedList<Step>();
        this.sessionFilename = sessionFilename;
        loadSession(this.sessionFilename);

    }

    public Session(Grid grid) {
        steps=new LinkedList<Step>();
        currentStep = 1;
        sessionFilename= generateFileName();
        sessionFile = new File(sessionFilename);
        Step tmpStep=new Step(grid); //create a Step object from Grid Object
        steps.add(tmpStep); //add Step to step Linked List
    }

    //creates a name for a step, so a step can be identified by a string identifier
    public void nameStepAt(String stepName,int stepNum) {
        Step steppy=steps.get(stepNum-1);// gets the node at the indicated index
        steppy.setStepName(stepName);
    }

    //retrieve a step by its name
    public Grid retrieveStepByName(String stepName) {
        Grid tmpGrid=null;
        boolean match=false;// to see if the step was found
        int index=0;
        int sizeLL=steps.size();
        Step current=steps.element();// this is the head of the list
        while(index!=sizeLL) {// will iterate thru the list to find the neeeded stepname
            Step tmpStep=steps.get(index);// gets the step out of the current node
            String tmpStepName=tmpStep.getStepName();// gets the string name of the current step object
            if ( tmpStepName.equals(stepName)) {
                match=true;
                current=tmpStep;
                break;// breaks out of the while loop
            }
            index++;
        }// at this point current is the node that we wanted to find or it wasnt found
        if ( match==true) {
            tmpGrid = current.getStepGrid();
        }
        return tmpGrid;
//		else {
//			System.out.println("ERROR 404: Step Not Found :");
//		}
    }

    //add a step to link list (boolean is based on success or failure of add)
    public boolean addStep(Grid stepGrid) {
        Step tmpStep=new Step(stepGrid); //create a Step object from Grid Object
        int numSteps=steps.size();//get the last step in the session
        if( steps.add(tmpStep) ) {
            this.currentStep=numSteps+1; //make the current step the one after the last step
            return true;
        }
        return false;
    }

    //move forward n steps and return step
    public Grid forwardStep(int numSteps) {
        if(currentStep + numSteps <= steps.size()) {
            currentStep+=numSteps;
            return(steps.get(currentStep-1).getStepGrid());
        } else {
            //if they fast forward beyond the end, return null
            Grid tmpGrid= null;
            return tmpGrid;
        }
    }

    //move backwards n steps and returns step
    public Grid rewindStep(int numSteps) {
        if(currentStep - numSteps >= 1) {
            currentStep-=numSteps;
            return(steps.get(currentStep-1).getStepGrid());
        } else {
            //If they go too far return current step
            Grid tmpGrid=null;
            return tmpGrid;
        }
    }

    //reads the last step from the link list
    public Grid readLastStep() {
        currentStep = steps.size();
        return steps.get(steps.size()-1).getStepGrid();
    }

    //reads the currentStep from the link list
    public Grid readCurrentStep() {
        return(steps.get(currentStep-1).getStepGrid());
    }

    public boolean loadSession(String SessionFileame) {

		/*Opens and reads the JSON file that is storing the currentStep and numStep*/
        JSONParser parser = new JSONParser();
        try {

            Object obj = parser.parse(new FileReader(sessionFilename));
            JSONObject jsonObject = (JSONObject) obj;
            Long test=(long)jsonObject.get("currentStep");
            this.currentStep=test.intValue();
            JSONArray stepsInJSON = (JSONArray) jsonObject.get("steps");


            for (int i = 0; i < stepsInJSON.size(); i++) {
                JSONObject objectInArray = (JSONObject) stepsInJSON.get(i);
                String grid = (String) objectInArray.get("grid");
                Grid tempGrid = new Grid(grid);
                Step tempStep = new Step(tempGrid);
                String StrstepName = (String) objectInArray.get("stepName");
                tempStep.setStepName(StrstepName);
                steps.add(tempStep);
            }

        } catch (FileNotFoundException e){
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    //Current File: write step from link list to file for new session(boolean is based on success or failure of load)
    @SuppressWarnings("unchecked")
    public boolean saveCurrentSession() {
        //prepared JSON Object to write to file
        //prepared meta data file-storage
        JSONObject JSONObj=new JSONObject();
        JSONObj.put("sessionFilename", sessionFilename);
        JSONObj.put("currentStep", currentStep);
        //iterate through step link list to get array of JSON arrays
        JSONArray stepList=new JSONArray();
        for(int i=0;i<steps.size();i++) {
            int stepNum=i;
            Step tmpStep= steps.get(i);
            JSONObject tmpJSONObj=new JSONObject();
            tmpJSONObj.put("step", stepNum+1);
            tmpJSONObj.put("grid", tmpStep.getStepGrid().toString() );
            tmpJSONObj.put("stepName", tmpStep.getStepName());
            stepList.add(tmpJSONObj);
        }
        JSONObj.put("steps",stepList);
        //Write JSON Object to File
        try {
            BufferedWriter FileWriter=new BufferedWriter(new FileWriter(sessionFile,false));
            FileWriter.write( JSONObj.toString() );
            FileWriter.flush();
            FileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    //New File: write step from link list to file for new session(boolean is based on success or failure of load)
    public boolean saveNewSession(String newFileName) {
        sessionFilename=newFileName + ".json";
        boolean status=saveCurrentSession();
        return status;
    }

    //dynamically generate a new session File Name
    private String generateFileName() {
        String newFileName="";
        File testFile=null;
        for(int i=1;i<20;i++) {
            newFileName="Untitled" + i +".json";
            testFile=new File(newFileName);
            if (! testFile.exists()) {
                testFile.delete();
                break;
            }
        }
        return newFileName;
    }

    //Setter and Getters
    public void setSessionFile(String sessionFileName) {
        this.sessionFile=new File(sessionFileName);
    }

    public void SetCurrentStep(int currentStep) {
        this.currentStep=currentStep;
    }

    public int getCurrentStep() {
        return  currentStep;
    }

    public int getNumSteps() {
        return steps.size();
    }
}

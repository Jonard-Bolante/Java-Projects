package webMindJava;

import javafx.fxml.FXML;

public class Controller extends ExecutionContext{
    static Main main = new Main();


    @FXML
    public void stepForward() {
        main.currGrid = main.context.stepForward(1);
        if (main.currGrid !=null) {
            main.createBoxes();
        }
    }

    @FXML
    public void stepBackwards(){
        main.currGrid = main.context.stepBackward(1);
        //if current step is first step or if resulting Grid is going to be a step below 0
        //do not display grid
        if (main.currGrid != null) {
            main.createBoxes();
        }
        else {
            //put alert/pop-up box here that they they are already on the starting step
        }
    }

    public void save(){
        System.out.println("SAVING...SAVING");
        saveSessionToFile("something");
    }
    public void load(){
        System.out.println("loading...loading");
        loadSessionFromFile("something");
    }


}

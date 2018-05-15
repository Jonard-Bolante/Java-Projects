package webMindJava;

public class ExecutionContext {
    Session session;

    /**
     * Loads a session from a file.
     * @param fileName the name of the file.
     */
    public void loadSessionFromFile(String fileName) {
        session = new Session(fileName);
    }

    /**
     * Makes a session from a grid.
     * @param grid an initial grid.
     */
    public void makeSessionFromGrid(Grid grid) {
        session = new Session(grid);
    }

    /**
     * Saves a session to a file.
     * @param fileName the name of the file.
     */
    public void saveSessionToFile(String fileName) {
        session.saveNewSession(fileName);
    }

    /**
     * Steps backward.
     * @param steps the number of steps to take.
     * @return the grid located at new location.<br>
     * Returns null if attempt to backtrack past first step
     */
    public Grid stepBackward(int steps) {
        return session.rewindStep(steps);
    }

    /**
     * Steps forward.
     * @param steps the number of steps to take.
     * @return the grid located at new location.
     */
    public Grid stepForward(int steps) {
        int numStep=session.getNumSteps();
        int stepInputIterator=0;
        //if current step is not last step, retrieve steps rather than addStep to session
        while (session.getCurrentStep()+1 <= numStep) {
            stepInputIterator++;
            //after navigating the desired number of steps
            if (stepInputIterator == numStep) {
                break; //exit if no more steps available to retrieve
            }
            if (stepInputIterator == steps) { //if desired step forward achieved return Grid
                return session.forwardStep(steps);
            }
        }
        //if no more step ahead of current step, calculate next step and add to session
        steps-=stepInputIterator; //subtract the number of step required to get get last step
        int finalStep = session.getCurrentStep() + steps;
        while (session.steps.size() < finalStep) {
            session.addStep(session.readLastStep().stepForward());
        }
        return session.readCurrentStep();
    }

    /**
     * Allows user to label/name the current step
     * @param stepName name of the step
     */
    public void nameCurrentStep(String stepName) {
        int currentStep= session.getCurrentStep();
        session.nameStepAt(stepName, currentStep);
    }

    /**
     * Retrieve the step based on its label or name
     * @param stepName searchKey stepName to search for
     * @return Grid associate with the given search name.<br>
     * <b>Note: Grid returned is Null if no matching steps found for search name</b>
     */
    public Grid searchForStep(String stepName) {
        //Grid object returned is Null if no step found(display alert screen in this event)
        Grid tmpGrid=session.retrieveStepByName(stepName);
        return tmpGrid;
    }

}

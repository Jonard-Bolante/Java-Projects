/**
 * Created by Jonard_Bolante on 9/16/2016.
 */
public class SpeakerOfTheHouse implements Speaker{

    public void speak() {
        System.out.println("I am Speaker of the House");
    }
    public void announce(String billName){
        System.out.println("the " +billName+ " has passed!");
    }
}

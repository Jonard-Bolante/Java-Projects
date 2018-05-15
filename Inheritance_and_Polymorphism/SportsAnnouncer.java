/**
 * Created by Jonard_Bolante on 9/16/2016.
 */
public class SportsAnnouncer implements Speaker{
    public void speak(){
        System.out.println("Goal!");
    }

    public void announce(String teamName){
        System.out.println("The "+teamName+" have scored a goal!");
    }
}

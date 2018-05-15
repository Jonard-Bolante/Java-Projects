/**
 * Created by Jonard_Bolante on 9/16/2016.
 */
public class Actor implements Speaker{
    public void speak(){
        System.out.println("I've been nominated for three Academy Awards.");
    }

    public void announce(String movieName){
        System.out.println("I'm currently staring in "+movieName+".");
    }
}

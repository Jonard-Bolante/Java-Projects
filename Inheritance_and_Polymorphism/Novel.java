/**
 * Created by Jonard_Bolante on 9/16/2016.
 */
public class Novel extends ReadingMaterial{
    private String[] characters;

    public Novel(){ }

    public Novel(String[] characters, String title, String author, int numPages){
        super(title, author, numPages);
        this.characters = characters;
    }

    public void listCharacters(){
        for(int i=0; i<characters.length; i++)
            System.out.println(characters[i]);
    }
}

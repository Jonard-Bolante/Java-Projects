/**
 * Created by Jonard_Bolante on 9/16/2016.
 */
public class ReadingMaterial {
    private String title;
    private String author;
    private int numPages;
//Empty Constructor
    public ReadingMaterial(){ }

//Initialized variables with values passed into the constructor
    public ReadingMaterial(String title, String author, int numPages){
        this.title = title;
        this.author = author;
        this.numPages = numPages;
    }

    public String getTitle(){
        return title;
    }
    public String getAuthor(){
        return author;
    }
    public int getPages(){
        return numPages;
    }

    public boolean isLong(){
        if(numPages>250)
            return true;
        else
            return false;
    }
    public void summary(){
        System.out.printf("%s, written by %s\n", getTitle(),getAuthor());
    }
}
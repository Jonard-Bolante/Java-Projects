/**
 * Created by Jonard_Bolante on 9/16/2016.
 */
public class GraphicNovel extends Novel{
    private String illustrator;

    public GraphicNovel(String illustrator, String[] characters, String title, String author, int numPages) {
        super(characters, title, author, numPages);
        this.illustrator = illustrator;
    }

    public String getIllustrator(){
        return illustrator;
    }
    public void summary(){
        System.out.printf("%s, written by %s, illustrated by %s", getTitle(),getAuthor(), getIllustrator());
        System.out.println();
    }
}

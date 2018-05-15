/**
 * Created by Jonard_Bolante on 9/16/2016.
 */
public class Article extends ReadingMaterial {
    private String publication;

    public Article(String publication, String title, String author, int numPages){
        super(title,author,numPages);
        this.publication = publication;
    }

    public String getPublication(){
        return publication;
    }

    public void summary(){
        System.out.printf("%s, written by %s, published in %s", getTitle(), getAuthor(), getPublication());
        System.out.println();
    }
}

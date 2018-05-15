/* Created by Jonard_Bolante on 9/16/2016.  */

import java.util.Scanner;
public class Driver {
    public static void main(String[] args) {
// (a)  Inheritence by extending and obtaining data from the super class and implementing it in the sub classes
        String[] novelChar = {"Harry Potter", "Hermione Granger", "Ronald Weasley", "Voldemort"};
        String[] graphicNovel = {"Iron Man", "Captain America", "Black Widow", "The Hulk", "Thor"};
        Novel harryPotter = new Novel(novelChar,"Harry Potter", "JK Rowling", 303);
        GraphicNovel avengers = new GraphicNovel("Jack Kirby", graphicNovel, "Avengers", "Stan Lee", 50);
        Article pc = new Article("Anthropological Quarterly", "The Social Meaning of the Personal Computer", "Bryan Pfaffenberger", 10);

        harryPotter.summary();
        harryPotter.isLong();
        avengers.listCharacters();
        avengers.summary();
        pc.isLong();
        pc.summary();



// (b) Polymorphism by implementing an interphase and using the following methods
        System.out.println("\nNow for Part(b)");
        Scanner input = new Scanner(System.in);
        System.out.println("What is the name of your bill?");
        String bill = input.nextLine();
        System.out.println("What's your favorite sports team?");
        String team = input.nextLine();
        System.out.println("What's your favorite movie?");
        String movie = input.nextLine();

        SpeakerOfTheHouse stuffOne = new SpeakerOfTheHouse();
        stuffOne.announce(bill);
        stuffOne.speak();
        SportsAnnouncer stuffTwo = new SportsAnnouncer();
        stuffTwo.announce(team);
        stuffTwo.speak();
        Actor stuffThree = new Actor();
        stuffThree.announce(movie);
        stuffThree.speak();



/*
QUESTIONS
        Why did I have to make an empty constructor for my Novel class to inherit? I originally
        had an error saying that 'ReadingMaterial' had no 'default constructor'. Isnt a default constructor
        automatically created?

        When trying to extend GraphicNovel to Novel, there appears an error saying
        there is no default constructor again?
 */

    }
}

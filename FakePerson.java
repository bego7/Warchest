import java.util.*;  
public class FakePerson {

    private String name;
    private int gamesWon;
    private String date;

    FakePerson(String name, int gamesWon, String date) {
        this.name = name;
        this.gamesWon = gamesWon;
        this.date = date;
    }

    //Getters 
    public String getName() {
        return name;
    }
    public String getDate() {
        return date;
    }
    public int getGamesWon() {
        return gamesWon;
    }

    //Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setGamesWon(int gamesWon) {
        this.gamesWon = gamesWon;
    }

    

}

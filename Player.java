import java.util.*;  
public class Player{
    private String name; 
    private String token;

    Player(String name){
      this.name = name;
    }

    // Getters
    public String getName() {
      return name;
    }
  
    // Setters
    public void setName(String name) {
      this.name = name;
    }
}
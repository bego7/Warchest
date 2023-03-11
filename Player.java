import java.util.*;  
public class Player{

    private String name; 
    private String token;

    Player(String name, String token){
      this.name = name;
      this.token = token;
    }

    // Getters
    public String getName() {
      return name;
    }

    public String getToken() {
      return token;
    }
  
    // Setters
    public void setName(String name) {
      this.name = name;
    }
}
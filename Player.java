import java.util.*;  
public class Player{

    private String name; 
    private String token;
    private Bag bag;


    Player(String name, String token){
      this.name = name;
      this.token = token;
    }
    //overloading to create a player without a bag initially
    Player(String name, String token, Bag bag){
      this.name = name;
      this.token = token;
      this.bag = bag;
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

    public void preparePlayerSettings(){

    }
    public void play(){
      System.out.println("Make an action (move/recruit/place/attack/control/initiative/forfeit): ");
      //bag.printBag();
    }

    public int getControlledZones(){
      return 1;
    }
}
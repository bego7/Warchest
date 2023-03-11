import java.util.*;  
public class Player{

    Scanner sc = new Scanner(System.in);

    private String name; 
    private String token;
    private Bag bag;
    private Boolean playInitiative = false;
    private int controlledZones = 1;


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

    public Boolean getPlayedInitiative(){
      return playInitiative;
    }
  
    // Setters
    public void setName(String name) {
      this.name = name;
    }

    public void preparePlayerSettings(){

    }
    public void play(){
      /*while(numActions > 0){
        takeAction();
      }*/
      
      takeAction();
    }

    public void takeAction(){
      System.out.println("Make an action (move/recruit/place/attack/control/initiative/forfeit): ");
      String action = sc.nextLine();
      switch(action){
        case "move":
        System.out.println("From position (row, col): ");
        
        break;

        case "recruit":
          System.out.println("Recruit action selected");
        break;

        case "place":
          System.out.println("Place action selected");

        break;

        case "attack":
          System.out.println("Attack action selected");

        break;

        case "control":
          System.out.println("Control action selected");

        break;

        case "initiative":
          playInitiative = true;
          System.out.println("Initiative action selected");

        break;

        case "forfeit":
          System.out.println("Forfeit action selected");

        break;

        default:
          System.out.println("Wrong action selected");
      }
    }

    public int getControlledZones(){
      return 1;
    }
}
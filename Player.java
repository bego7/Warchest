import java.util.*;  
public class Player{

    Scanner sc = new Scanner(System.in);
    

    private String name; 
    private String token;
    private Bag bag;
    private Boolean playInitiative = false;
    private int numActions = 0;
    private int controlledZones = 1;
    private boolean forfeit = false;
    private String lastActionPlayed = "";


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

    public int getNumAction(){
      return this.numActions;
    }

    public boolean getForfeit(){
      return this.forfeit;
    }
    public String getLastActionPlayed(){
      return lastActionPlayed;
    }
  
    // Setters
    public void setName(String name) {
      this.name = name;
    }

    public void setPlayedInitiative(boolean value){
      this.playInitiative = value;
    }

    public void setNumActions(int value){
      this.numActions = value;
    }

    public void setForfeit(boolean value){
      this.forfeit = true;
    }

    public void preparePlayerSettings(){

    }
    public boolean play(boolean finishRound){
      while(this.numActions < 3 && !getForfeit()){
        takeAction();
      }
      finishRound = true;
      return finishRound;
    }

    public void takeAction(){
      
      System.out.println("Make an action (move/recruit/place/attack/control/initiative/forfeit): ");
      String action = sc.nextLine();
      switch(action){
        case "move":
        System.out.println("From position (row, col): ");

        this.numActions++;
        break;

        case "recruit":
          System.out.println("Recruit action selected");
          this.numActions++;

        break;

        case "place":
          System.out.println("Place action selected");
          this.numActions++;


        break;

        case "attack":
          System.out.println("Attack action selected");
          this.numActions++;

        break;

        case "control":
          System.out.println("Control action selected");
          this.numActions++;

        break;

        case "initiative":
          playInitiative = true;
          System.out.println("Initiative action selected");
          this.numActions++;

        break;

        case "forfeit":
          System.out.println("GAME OVER!");
          setForfeit(true);
          this.lastActionPlayed = "forfeit";
          this.numActions = 3;
        break;

        default:
          System.out.println("Wrong action selected");
      }
    }

    public int getControlledZones(){
      return 1;
    }
}
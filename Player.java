import java.util.*;  
public class Player{

    Scanner sc = new Scanner(System.in);
    

    private String name; 
    private String token;
    private Bag bag = new Bag();
    private Boolean playInitiative = false;
    private int numActions = 0;
    private int controlledZones = 1;
    private boolean forfeit = false;
    private String lastActionPlayed = "";
    private Board board;

    //test to see if i can create Archer objects using the inherited methods from unitType
    private Archer archer = new Archer("Archer", "A");


    Player(String name, String token){
      this.name = name;
      this.token = token;
    }
    //overloading to create a player without a bag initially
    Player(String name, String token, Board board){
      this.name = name;
      this.token = token;
      this.board = board;
    }

    // Getters
    public String getName() {
      return this.name;
    }

    public String getToken() {
      return this.token;
    }

    public Boolean getPlayedInitiative(){
      return this.playInitiative;
    }

    public int getNumAction(){
      return this.numActions;
    }

    public boolean getForfeit(){
      return this.forfeit;
    }
    public String getLastActionPlayed(){
      return this.lastActionPlayed;
    }

    public Board getBoard() {
      return this.board;
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

    public void preparePlayerSettings(String coinType1, String coinType2){
      //get first unit type
      UnitType firstArmyElem = parseCoin(coinType1);

      //get first unit type
      UnitType secondArmyElem = parseCoin(coinType2);

      //add both elements to the bag for this player
      for(int i=0;i<2;i++){
        bag.addCoin(firstArmyElem);
        bag.addCoin(secondArmyElem);
      }
      //add the royal coin to the bag
      Royal royal = new Royal("Royal", "R");
      bag.addCoin(royal);

      //bag.printPiecesInsideBag();
    }

    public UnitType parseCoin(String coin){
      
      UnitType coinToReturned = null;
      switch(coin){
        case "A":
        Archer archer = new Archer("Archer", coin);
        coinToReturned = archer;
        break;

        case "B":
        Berserker berserker = new Berserker("Berserker", coin);;
        coinToReturned = berserker;
        break;

        case "C":
        Cavalry cavalry = new Cavalry("Cavalry", coin);;
        coinToReturned = cavalry;
        break;

        case "S":
        Swordsman swordsman = new Swordsman("Swordsman", coin);
        coinToReturned = swordsman;
        break;
      }

      return coinToReturned;
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
        String coordinates = sc.nextLine();
        System.out.println("Select a piece of the same type in your hand ");
        String piece = sc.nextLine();
        //check that piece exists in the hand, if it doenst send an error
        System.out.println("Position to place (row, col): ");

        String newCoordinates = sc.nextLine();

        archer.move(coordinates,newCoordinates, board, this);

        System.out.println(archer.getName());
        //String answer = sc.nextLine();

        this.numActions++;
        break;

        case "recruit":
          System.out.println("Recruit action selected");
          this.numActions++;

        break;

        case "place":
          System.out.println("Piece to place from hand");
           piece = sc.nextLine();
          //iterate to get the actual object and send it to place the token
          System.out.println("Position to place (row, col): ");

          coordinates = sc.nextLine();

          
          archer.place(coordinates, board, this);

          //print hand



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
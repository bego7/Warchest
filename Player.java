import java.util.*;  
public class Player{
    Random r = new Random();
    Scanner sc = new Scanner(System.in);
    
    private Bag bag = new Bag();
    private Hand hand = new Hand();
    private RecruitingPile recruiting = new RecruitingPile();
    private DiscardPile discardPile = new DiscardPile();
    private CoinsBoard coinsBoard = new CoinsBoard();

    private String name; 
    private String token;
    
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

    public int getBagSize(){
      return this.bag.getBagSize();
    }

    public int getHandSize(){
      return this.hand.getHandSize();
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

      //get second unit type
      UnitType secondArmyElem = parseCoin(coinType2);

      //adds elements to the recruiting area
      for(int i=0;i<2;i++){
        recruiting.addCoin(firstArmyElem);
        recruiting.addCoin(secondArmyElem);
      }

      //add both elements to the bag for this player
      for(int i=0;i<2;i++){
        bag.addCoin(firstArmyElem);
        bag.addCoin(secondArmyElem);
      }
      //add the royal coin to the bag
      Royal royal = new Royal("Royal", "R");
      bag.addCoin(royal);

      //bag.printPiecesInsideBag();
      //recruiting.printRecruitingPile();
    }

    public void printCurrentCoins(){
      hand.printHand();
      recruiting.printRecruitingPile();
      discardPile.printPiecesInsideDiscardPile();
      System.out.println();
      System.out.println();

    }

    //removes 3 elements from the bag and adds them to the hand of the player
    public void drawFromBag(){
      //removes random coin from the bag
      for(int i=0;i<3;i++){
        int bagSize = bag.getBagSize();
        int val = r.nextInt(0,bagSize);
        UnitType coin = bag.removeCoin(val);
        hand.addCoin(coin);
      }
      //hand.printHand();
    }
    //removes one element from the bag and adds them to the players hand
    public void drawOneFromBag(){
        int bagSize = bag.getBagSize();
        UnitType coin = bag.removeCoin(bagSize-1);
        hand.addCoin(coin);
    }

    public void setRecruitingPile(){
      System.out.println("Elements inside the bag one by one");
      for(UnitType piece: bag.getBag()){
        System.out.println(piece.getName());
      }
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
      printCurrentCoins();
      
      System.out.println("Make an action (move/recruit/place/attack/control/initiative/forfeit): ");
      String action = sc.nextLine();
      switch(action){

        case "move":
        System.out.println("From position (row, col): ");
        String coordinates = sc.nextLine();
        UnitType coin = null;

        while(coin == null){
          System.out.println("Select a piece of the same type in your hand ");
          String piece = sc.nextLine();
          //checks for existing piece in hand 
          coin = coinExistsInHand(piece);
        }
        discardPile.addCoin(coin);
        System.out.println("Position to place (row, col): ");

        String newCoordinates = sc.nextLine();

        coin.move(coordinates,newCoordinates, board, this);
        //removes coin from hand
        hand.removeCoinObject(coin);

        this.numActions++;
        break;

        case "recruit":
          System.out.println("Piece to discard from hand to recruit piece of the same type");
          String piece = sc.nextLine();
          coin = coinExistsInHand(piece);
          //removes coin from hand
          hand.removeCoinObject(coin);
          discardPile.addCoin(coin);
          System.out.println("Used "+ piece +" coin, type the piece you want to recruit");
          String pieceToRecruit = sc.nextLine();
          coin = coinExistsInRecruitment(pieceToRecruit);


          //remove coin from recruiting zone 
          recruiting.removeCoinObject(coin);
          //add coin to bag
          bag.addCoin(coin);
          


          this.numActions++;

        break;

        case "place":
          System.out.println("Piece to place from hand");
          coin = null;
          while(coin == null){
            System.out.println("Select a piece of the same type in your hand ");
            piece = sc.nextLine();
            //checks for existing piece in hand 
            coin = coinExistsInHand(piece);
          }
          
          System.out.println("Position to place (row, col): ");
          coordinates = sc.nextLine();
          coin.place(coordinates, board, this);
          hand.removeCoinObject(coin);
          this.numActions++;
        break;

        case "attack":
          System.out.println("Attack from position (row,col): ");
          coordinates = sc.nextLine();
          coin = null;
          while(coin == null){
            System.out.println("Select a piece of the same type in your hand ");
            piece = sc.nextLine();
            //checks for existing piece in hand 
            coin = coinExistsInHand(piece);
          }
          System.out.println("To position(row,col): ");
          newCoordinates = sc.nextLine();
          coin.attack(newCoordinates, board, this);

          //hand.printHand();
          this.numActions++;

        break;

        case "control":
          System.out.println("Control action selected");
          this.numActions++;

        break;

        case "initiative":
          playInitiative = true;
          System.out.println("Piece to discard from hand");
          piece = sc.nextLine();
          coin = coinExistsInHand(piece);
          this.discardPile.addCoin(coin);
          hand.removeCoinObject(coin);
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

    public UnitType coinExistsInHand(String name){
      UnitType coin = null;
      for(UnitType piece: hand.getHand()){
        
        if(piece.getName().equals(name)){
          coin = piece;
        }
      }
      return coin;
    }


    public UnitType coinExistsInRecruitment(String name){
      UnitType coin = null;
      for(UnitType piece: recruiting.getRecruitingPile()){
        
        if(piece.getName().equals(name)){
          coin = piece;
        }
      }
      return coin;
    }

    
}
import java.util.*;  
public class Game {
    Scanner sc = new Scanner(System.in);
    Random r = new Random();

    
    private Board board = new Board(5);

    //when creating the player object I need to pass in the board to it so it can actually set the tokens into the board 
    private Player playerWolf;
    private Player playerCrow;
    private Player currentPlayer;
    private boolean gameOver = false;

    public void startGame(){
        
            System.out.println();
            System.out.println("Board size is 5x5");
            preparePlayersToPlay();
            currentPlayer = getStartingPlayer();

            board.initializeBoard(5);
            board.printBoard(5,currentPlayer);
            //currentPlayer.printCurrentCoins();
            while(!isGameOver() || !this.gameOver){
                
                currentPlayer.play(false);
                
                //only changes the current player playing if he/she
                //didn't use the initiative action
                if(!currentPlayer.getPlayedInitiative() && currentPlayer.play(true)){
                    if(currentPlayer.getLastActionPlayed().equals("forfeit")){
                        if(currentPlayer.getName().equals("Wolf")){
                            System.out.println("Wolf surrendered!");
                            System.out.println("The winner is Crow");
                        }
                        else{
                            System.out.println("Crow surrendered!");
                            System.out.println("The winner is Wolf!");
                        }
                        break;
                    }
                    else{
                        switchTurn();
                        startNewRound();
                    }
                }
                //player finished playing but played the take the initiative action during
                //his/ her turn
                else{
                    startNewRound();
                }
                
            }
    }

    public void startNewRound(){
        cleanScreen(); 
        board.printBoard(5,currentPlayer);
        
        //before startin the next round check if someone at the end of the other round 
        //didnt run out of coins in their bag
        if(playerWolf.getBagSize()==0 | playerCrow.getBagSize() == 0 ){
            this.gameOver = true;
            System.out.println("GAME IS OVER, LAST PLAYER TO PLAY DOESN'T HAVE ENOUGH COINS IN BAG TO GET FROM");
            System.out.println("The winner is "+ currentPlayer.getName());
        }

        else{
            //check number of elements in bag
            if(currentPlayer.getHandSize()<3){
                while(currentPlayer.getBagSize()>0){
                    //take individual items from bag and add them to your hand
                    currentPlayer.drawOneFromBag();
                }
                
            }
            // playerWolf.drawFromBag();
            // playerCrow.drawFromBag();
            //currentPlayer.printCurrentCoins();
            currentPlayer.setPlayedInitiative(false);
            currentPlayer.setNumActions(0);
            currentPlayer.play(false);
        }
        
    }

    public void cleanScreen(){
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }

    public void switchTurn(){
        if(currentPlayer.equals(playerWolf)){
            currentPlayer = playerCrow;
        }
        else{
            currentPlayer = playerWolf;
        }
    }

    //returns a number between 1 inclusive and 3 exclusive
    // 1 represents wolf
    // 2 represents crow
    public Player getStartingPlayer(){
        int val = r.nextInt(1,3);
        if(val == 1 ){
            return playerWolf;
        }
            return playerCrow;
        
    }

    //send to each player the coins that they will have
    //possible improvements make it random
    //however for simplicity purposes and also as displayed on the video of the real life board game I will assign the type of army by default
    public void preparePlayersToPlay(){
         playerWolf = new Player("Wolf", "v",board);
         playerCrow = new Player("Crow", "^",board);

         //Wolf player will have archer and berseker elements
         playerWolf.preparePlayerSettings("A", "B");
         playerWolf.drawFromBag();
         
         //Crow player will have Swordsman and cavalry elements
         playerCrow.preparePlayerSettings("S","C");
         playerCrow.drawFromBag();
        
    }


    public boolean isGameOver(){

        if(playerCrow.getControlledZones() == 4 |  playerWolf.getControlledZones() == 4 | currentPlayer.getForfeit() == true){
            gameOver = true;

            //player surrenders
            if(currentPlayer.getForfeit() == true){
                if(currentPlayer.getName().equals("Wolf")){
                    System.out.println("Wolf surrendered!");
                    System.out.println("The winner is Crow");
                }
                else{
                    System.out.println("Crow surrendered!");
                    System.out.println("The winner is Wolf!");
                }
            }
            //one player gets 4 zones
            else{
                if(playerCrow.getControlledZones() == 4){
                    System.out.println("The winner is crow");
                }
                else{
                    System.out.println("The winner is wolf!");
                }
            }
            
            
        }
        return gameOver;
    }

}

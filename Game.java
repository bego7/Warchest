import java.util.*;  
public class Game {
    Scanner sc = new Scanner(System.in);
    Random r = new Random();

    
    private Board board = new Board(5);
    private Player playerWolf = new Player("Wolf", "v");
    private Player playerCrow = new Player("Crow", "^");
    private Player currentPlayer;
    private boolean gameOver = false;

    public void startGame(){
        
            System.out.println();
            System.out.println("Board size is 5x5");
            currentPlayer = getStartingPlayer();
            board.initializeBoard(5);
            board.printBoard(5,currentPlayer);
            while(!isGameOver()){
                currentPlayer.play(false);
                //only changes the current player playing if he/she
                //didn't use the initiative action
                if(!currentPlayer.getPlayedInitiative() && currentPlayer.play(true)){
                    if(currentPlayer.getLastActionPlayed().equals("forfeit")){
                        if(currentPlayer.getName().equals("Wolf")){
                            System.out.println("The winner is Crow");
                        }
                        else{
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
        currentPlayer.setPlayedInitiative(false);
        currentPlayer.setNumActions(0);
        currentPlayer.play(false);
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


    public boolean isGameOver(){

        if(playerCrow.getControlledZones() == 4 |  playerWolf.getControlledZones() == 4 | currentPlayer.getForfeit() == true){
            gameOver = true;
            if(currentPlayer.getForfeit() == true){
                if(currentPlayer.getName().equals("Wolf")){
                    System.out.println("The winner is Crow");
                }
                else{
                    System.out.println("The winner is Wolf!");
                }
            }
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

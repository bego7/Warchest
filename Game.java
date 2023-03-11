import java.util.*;  
public class Game {
    Scanner sc = new Scanner(System.in);
    Random r = new Random();

    //private Board board = new Board(9);
    private Board board = new Board(5);
    private Player playerWolf = new Player("Wolf", "v");
    private Player playerCrow = new Player("Crow", "^");
    private boolean gameOver = false;

    public void startGame(){
        
        // System.out.println("The board size by default is 9 x 9, do you want to make it 5 x 5? Answer: 5 or 9");
        // int size = sc.nextInt();
        
            System.out.println("Board size is 5x5");
            Player playerToStart = getStartingPlayer();
            board.initializeBoard(5);
            board.printBoard(5,playerToStart);
            while(isGameOver()){
                playerToStart.play();
            }
            
        
        // else{
        //     System.out.println("Board size is the default one");
        //     Player playerToStart = getStartingPlayer();
        //     board.initializeBoard(size);
        //     board.printBoard(size,playerToStart);
            
        //     while(isGameOver()){
        //         playerToStart.play();
        //     }

        // }

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
        if(playerCrow.getControlledZones() == 4 |  playerWolf.getControlledZones() == 4){
            gameOver = true;
        }
        return gameOver;
    }

}

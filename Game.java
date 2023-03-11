import java.util.*;  
public class Game {
    Scanner sc = new Scanner(System.in);
    Random r = new Random();

    //private Board board = new Board(9);
    private Board board = new Board(9);
    private Player playerWolf = new Player("Wolf");
    private Player playerCrow = new Player("Crow");

    public void startGame(){
        
        System.out.println("The board size by default is 9 x 9, do you want to make it 5x5? Answer: 5 or 9");
        int size = sc.nextInt();
        if(size == 5){
            System.out.println("Board size is now 5x5");
            String playerToStart = getStartingPlayer();
            board.initializeBoard(size);
            board.printBoard(size,playerToStart);
        }
        else{
            System.out.println("Board size is the default one");
            String playerToStart = getStartingPlayer();
            board.initializeBoard(size);
            board.printBoard(size,playerToStart);
        }

    }

    //returns a number between 1 inclusive and 3 exclusive
    // 1 represents wolf
    // 2 represents crow
    public String getStartingPlayer(){
        int val = r.nextInt(1,3);
        if(val == 1 ){
            return playerWolf.getName();
        }
            return playerCrow.getName();
        
    }

}

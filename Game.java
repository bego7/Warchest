import java.util.*;  
public class Game {

    private Board board = new Board(9);
    private Player playerWolf = new Player("Wolf");
    private Player playerCrow = new Player("Crow");

    public void startGame(){
        board.initializeBoard();
    }


}

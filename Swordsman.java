import java.util.*;  
public class Swordsman extends UnitType {

    Swordsman(String name, String token){
        super(name,token);
    }

    @Override
	public void place(String coordinates, Board board,Player player) {
		System.out.println("Placing piece");
        board.setToken(coordinates, this.getToken() ,player.getToken());
		
	}

    @Override
	public void move(String coordinates, String newCoordinates, Board board,Player player) {
        board.removeToken(coordinates);
        board.setToken(newCoordinates, this.getToken() ,player.getToken());
		
	}
    
    //Getters
    
    //Setters

}
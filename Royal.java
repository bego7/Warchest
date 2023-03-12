import java.util.*;  
public class Royal extends UnitType {

    Royal(String name, String token){
        super(name,token);

    }

    @Override
	public void place(String coordinates, Board board,Player player) {
		System.out.println("Placing piece");
        board.setToken(coordinates, this.getToken() ,player.getToken());
		
	}
    
    //Getters
    
    //Setters

}
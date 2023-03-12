import java.util.*;  
public class Royal extends UnitType {

    

    Royal(String name, String token){
        super(name,token);
    }

    @Override
	public void place(String coordinates, Board board,Player player) {
		System.out.println("This piece can't be placed");
	}

    @Override
	public void move(String coordinates, String newCoordinates, Board board,Player player) {
        System.out.println("This piece can't be moved");
	}
    
    //Getters
    
    //Setters

}
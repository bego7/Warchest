public class Cavalry  extends UnitType{


    Cavalry(String name, String token){
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

    @Override
	public void attack(String coordinates, Board board,Player player) {
        board.removeToken(coordinates);
	}
    //Getters
    
    //Setters
}

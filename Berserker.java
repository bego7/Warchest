public class Berserker extends UnitType {

    Berserker(String name, String token){
        super(name,token);
    }

    @Override
	public void place(String coordinates, Board board,Player player) {
		System.out.println("Placing piece");
        board.setToken(coordinates, this.getToken() ,player.getToken());
		
	}

    @Override
	public void move(String coordinates, String newCoordinates, Board board,Player player) {
        board.setToken(coordinates, this.getToken() ,player.getToken());
		
	}
    //Getters
    
    //Setters
}

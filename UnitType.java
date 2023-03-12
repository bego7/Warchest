import java.util.*;  

//unit type should be an abstract class as no instancesof it will be created 
public abstract class UnitType{
    private String token;
    private String name;

    private String coords;

    UnitType(String name, String token){
        this.name = name;
        this.token = token;
    }

    //Getters
    public String getCoords(){
        return this.coords;
    }
   
    public String getToken(){
        return this.token;
    }
    public String getName(){
        return this.name;
    }

    //Setters
    public void setName(String value){
        this.name = value;
    }

    public void setCoords(String coords){
        this.coords = coords;
    }

    public void setToken(String value){
        this.token = value;
    }

    public void control(String coordinates, Board board,Player player){
        board.setToken(coordinates, this.getToken() ,player.getToken());
    }

    //asbtract methos to be implemented by the rest 
    //of my pieces 

    public abstract void move(String coordinates,String newCoordinates, Board board,Player player);

    public abstract void place(String coordinates, Board board,Player player);

    public abstract void attack(String coordinates, Board board,Player player);

    



}
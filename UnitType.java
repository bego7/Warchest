import java.util.*;  

//unit type should be an abstract class as no instancesof it will be created 
public abstract class UnitType{
    private String token;
    private String name;

    UnitType(String name, String token){
        this.name = name;
        this.token = token;
    }

    //Getters
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

    public void setToken(String value){
        this.token = value;
    }

    //asbtract methos to be implemented by the rest 
    //of my pieces 

    //public abstract void move(char row,int col, Board board, Player player);

    public abstract void place(String coordinates, Board board,Player player);


}
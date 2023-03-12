import java.util.*;  
public class UnitType{
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
}
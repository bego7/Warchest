import java.util.*;  
public class Bag {
    
    private ArrayList<Object> pieces = new ArrayList<Object>();
    // Getters
    public ArrayList<Object> getBag(){
        return this.pieces;
    }
    
    // Setters
    public void setBag(ArrayList<Object> pieces){
        this.pieces = pieces;
    }

    public void addCoin(UnitType coin){
        pieces.add(coin);
    }
    
    public void removeCoin(UnitType coin){
        pieces.remove(coin);
    }

    public void printPiecesInsideBag(){
        System.out.println("The bag has:");
        for(Object piece: pieces){
            System.out.println(piece);
        }
    }
}

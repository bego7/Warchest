import java.util.*;  
public class Bag {
    
    private ArrayList<UnitType> pieces = new ArrayList<UnitType>();
    // Getters
    public ArrayList<UnitType> getBag(){
        return this.pieces;
    }
    
    // Setters
    public void setBag(ArrayList<UnitType> pieces){
        this.pieces = pieces;
    }

    public void addCoin(UnitType coin){
        this.pieces.add(coin);
    }
    
    public UnitType removeCoin(int i){
        UnitType coinToReturn = this.pieces.get(i);
        this.pieces.remove(i);
        return coinToReturn;
    }

    public void printPiecesInsideBag(){
        System.out.println("The bag has:");
        for(UnitType piece: pieces){
            System.out.println(piece);
        }
    }
}

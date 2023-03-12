import java.util.*;  
public class DiscardPile {
    
    private ArrayList<UnitType> pieces = new ArrayList<UnitType>();
    // Getters
    public ArrayList<UnitType> getDiscardPile(){
        return this.pieces;
    }
    
    // Setters
    public void setDiscardPile(ArrayList<UnitType> pieces){
        this.pieces = pieces;
    }

    public void addCoin(UnitType coin){
        this.pieces.add(coin);
    }

    public void printPiecesInsideDiscardPile(){
        System.out.println("The discard pile is:");
        for(UnitType piece: pieces){
            System.out.print("  "+ piece.getName());
        }
    }
}

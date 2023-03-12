import java.util.*;  
public class DiscardPile {
    
    private ArrayList<Object> pieces = new ArrayList<Object>();
    // Getters
    public ArrayList<Object> getDiscardPile(){
        return this.pieces;
    }
    
    // Setters
    public void setDiscardPile(ArrayList<Object> pieces){
        this.pieces = pieces;
    }

    public void printPiecesInsideDiscardPile(){
        System.out.println("The discard pile is:");
        for(Object piece: pieces){
            System.out.println(piece);
        }
    }
}

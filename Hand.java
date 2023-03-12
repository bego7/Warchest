import java.util.*;  
public class Hand {
    
    private ArrayList<Object> pieces = new ArrayList<Object>();
    // Getters
    public ArrayList<Object> getHand(){
        return this.pieces;
    }
    
    // Setters
    public void setHand(ArrayList<Object> pieces){
        this.pieces = pieces;
    }

    public void printPiecesInsideBag(){
        System.out.println("The hand has:");
        for(Object piece: pieces){
            System.out.println(piece);
        }
    }
}

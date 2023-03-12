import java.util.*;  
public class RecruitingPile {
    
    private ArrayList<Object> pieces = new ArrayList<Object>();
    // Getters
    public ArrayList<Object> getRecruitingPile(){
        return this.pieces;
    }
    
    // Setters
    public void setRecruitingPile(ArrayList<Object> pieces){
        this.pieces = pieces;
    }

    public void printPiecesInsideRecruitingPile(){
        System.out.println("The recruiting pile has:");
        for(Object piece: pieces){
            System.out.println(piece);
        }
    }
}

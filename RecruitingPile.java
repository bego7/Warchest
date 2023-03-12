import java.util.*;  
public class RecruitingPile {
    
    private ArrayList<UnitType> pieces = new ArrayList<UnitType>();
    // Getters
    public ArrayList<UnitType> getRecruitingPile(){
        return this.pieces;
    }
    
    // Setters
    public void setRecruitingPile(ArrayList<UnitType> pieces){
        this.pieces = pieces;
    }

    public void printPiecesInsideRecruitingPile(){
        System.out.println("The recruiting pile has:");
        for(UnitType piece: pieces){
            System.out.println(piece);
        }
    }
}

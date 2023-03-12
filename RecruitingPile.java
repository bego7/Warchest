import java.util.*;  
public class RecruitingPile {
    
    private ArrayList<UnitType> pieces = new ArrayList<UnitType>();
    // Getters
    public ArrayList<UnitType> getRecruitingPile(){
        return this.pieces;
    }

    public void addCoin(UnitType coin){
        this.pieces.add(coin);
    }
    
    // Setters
    public void setRecruitingPile(ArrayList<UnitType> pieces){
        this.pieces = pieces;
    }

    public void printRecruitingPile(){
        System.out.println("The recruiting pile has:");
        for(UnitType piece: pieces){
            System.out.print("  "+piece.getName());
        }
        System.out.println();
    }

    public UnitType removeCoin(int i){
        UnitType coinToReturn = this.pieces.get(i);
        this.pieces.remove(i);
        return coinToReturn;
    }

    public void removeCoinObject(UnitType coin){
        this.pieces.remove(coin);
    }
}

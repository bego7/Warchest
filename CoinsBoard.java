import java.util.*;  
public class CoinsBoard {
    
    private ArrayList<UnitType> pieces = new ArrayList<UnitType>();
    // Getters
    public ArrayList<UnitType> getHand(){
        return this.pieces;
    }

    public int getCoinsBoardSize(){
        return this.pieces.size();
    }
    
    // Setters
    public void setCoinsBoard(ArrayList<UnitType> pieces){
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

    public void removeCoinObject(UnitType coin){
        this.pieces.remove(coin);
    }

    public void printCoinsBoard(){
        System.out.println("The coins on the board are:");
        for(UnitType piece: pieces){
            System.out.print("  " + piece.getName());
        }
        System.out.println();
    }
}

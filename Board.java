import java.util.*;  
public class Board {
    private int size;
    private String grid [][];

    Board(int size) {
        this.size = size;
        this.grid = new String[size][size];
    }

    public void initializeBoard(int size){
        for(int i=0;i<size;i++){
            System.out.print(i+ " ");
        }
        System.out.println();
        for(int i=0;i<size*2;i++){
            System.out.print('-');
        }
        System.out.println();
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                grid[i][j] =". ";
            }
        }
     }

     public void printBoard(int size,String playerName ){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        System.out.print("#### "+playerName+" ####");
        System.out.println();
     }
        

    

    // public void setToken(){

    // }
}
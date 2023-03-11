import java.util.*;  
public class Board {
    private int size;
    private String grid [][];

    Board(int size) {
        this.size = size;
        this.grid = new String[size][size];
    }

    public void initializeBoard(int size){
        System.out.print("   ");
        for(int i=0;i<size;i++){
            System.out.print(i+ "  ");
        }
        System.out.println();
        System.out.print("   ");
        for(int i=0;i<size*3;i++){
            System.out.print('-');
        }
        System.out.println();
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                grid[i][j] =".  ";
            }
        }
     }

     public void printBoard(int size,Player player ){
        String letters = "bcdefghij";

        System.out.print("a|"+ " ");
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                System.out.print(grid[i][j]);
            }
            System.out.println();

            //fixes problem with last letter which was getting printed
            if(i<size-1){
                System.out.print(letters.charAt(i));
                System.out.print('|'+ " ");
            }
            
        }
        System.out.println();
        System.out.print("#### "+player.getName()+ " (" +player.getToken()+ ")"+" ####");
        System.out.println();
        System.out.println();
        System.out.println();
     }
        

    

    //  public void setToken(char row, int col, Player player){

    //  }
}
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

        setControlledAreas();
     }

     //sets the controlled and available zones in the board
     public void setControlledAreas(){

        //C represents crow's zone already controlled
        grid[0][2] = "C  ";

        //W represents wolf's zone already controlled
        grid[4][2] = "W  ";

        //@ represents free zones to be conquered
        grid[2][1] = "@  ";
        grid[2][3] = "@  ";
        grid[3][2] = "@  ";
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
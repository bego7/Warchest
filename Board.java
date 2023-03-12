import java.util.*;  
public class Board {
    Scanner sc = new Scanner(System.in);
    private int size;
    private String grid [][];
    private CoinsBoard coinsBoard = new CoinsBoard();

    Board(int size) {
        this.size = size;
        this.grid = new String[size][size];
    }

    public CoinsBoard getCoinsInTheBoard(){
        return this.coinsBoard;
    }

    public void initializeBoard(int size){
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

    public void setToken(String coordinates, String token, String playerToken){
        String tokenToPlace = token + playerToken + " " ;
        int arr [] = parseCoordinates(coordinates);
        //checks for invalid coordinates on the first position
        while(arr[0] == -1){
            System.out.println("Invalid coordinates added, enter new coordinates");
            String newVal = sc.nextLine();
            arr= parseCoordinates(newVal);
        }

        grid[arr[0]][arr[1]] = tokenToPlace;
    }

    public void removeToken(String coordinates){
        int arr [] = parseCoordinates(coordinates);
        grid[arr[0]][arr[1]] =".  ";
    }

    public int[] parseCoordinates(String coordinates){
        int[] newCoords = new int [2];
        newCoords[0] = parseRow(coordinates.charAt(0));
        newCoords[1] = Character.getNumericValue(coordinates.charAt(2));
        
        return newCoords;
    }
    public int parseRow(char row){
        int parsedRow = -1;
        switch(row){
            case 'a':
                parsedRow = 0;
            break;
            case 'b':
                parsedRow = 1;
            break;
            case 'c':
                parsedRow = 2;
            break;
            case 'd':
                parsedRow = 3;
            break;
            case 'e':
                parsedRow = 4;
            break;
            default:
                System.out.println("Row value is invalid");
                parsedRow = -1;
        }

        return parsedRow;
    }
}
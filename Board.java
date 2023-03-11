import java.util.*;  
public class Board {
    Scanner sc = new Scanner(System.in);
    private int size = 9;
    private String grid [][] = new String [size][size];

    Board(int size) {
        this.size = size;
    }

    public void initializeBoard(){
        System.out.println("The board size by default is 9 x 9, do you want to make it smaller? yes or no");
        String ans = sc.nextLine();

        if(ans == "yes"){
            System.out.println("Board size is now 5x5");
            for(int i=0;i<5;i++){
                for(int j=0;j<5;j++){
                    System.out.print('-'+" ");
                }
                System.out.println();
            }
        }
        else {
            System.out.println("Board size is the default one");
            for(int i=0;i<9;i++){
                for(int j=0;j<9;j++){
                    System.out.print('-'+" ");
                }
                System.out.println();
            }
        }

    }

    // public void setToken(){

    // }
}
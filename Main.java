import java.util.*;  
class Main {
    public static void main(String[] args) {

        //creates the array of fake people
        createFakePeople();
        //starts the Warchest game
        Game newGame = new Game();
        newGame.startGame();
    }

    //functionality related to displaying fake data about past players of the game and sorting them by date
    static void createFakePeople() {
         ArrayList<FakePerson> people = new ArrayList<FakePerson>();
         Random r = new Random();
         String names [] = {"Bego", "Pablo", "Juan", "Maria", "Sofia"};
         
 
         System.out.println("####PLAYERS THAT HAVE WON WARCHEST###");
         System.out.println();
 
         for (int i = names.length-1; i >= 0; i--) {
             String name = names[i];
             int gamesWon = r.nextInt(10);
             String date = "202"+i + "-" +(r.nextInt(0, 13)) + "-" + (r.nextInt(0,31));
             FakePerson person = new FakePerson(name, gamesWon, date);
             people.add(person);
         }

        people.sort((p1, p2)-> p1.getDate().compareTo(p2.getDate()));

        for(FakePerson person: people){
            System.out.println(person.getName()+ " "+ person.getGamesWon()+ " " + person.getDate());
        }
    }
}
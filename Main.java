import java.util.*;  
class Main {
    public static void main(String[] args) {

        //functionality related to displaying fake data about past players of the game
        ArrayList<FakePerson> people = new ArrayList<FakePerson>();
        Random r = new Random();
        String names [] = {"Bego", "Pablo", "Juan", "Maria", "Pedro"};
        

        System.out.println("####PLAYERS THAT HAVE WON WARCHEST###");
        System.out.println();

        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            int gamesWon = r.nextInt(10);
            String date = "2021-" + (r.nextInt(12) + 1) + "-" + (r.nextInt(28) + 1);
            FakePerson person = new FakePerson(name, gamesWon, date);
            people.add(person);
        }

        for(FakePerson person: people){
            System.out.println(person.getName()+ " "+ person.getGamesWon()+ " " + person.getDate());
        }

        //starts the Warchest game
        Game newGame = new Game();
        newGame.startGame();
        
    }
}
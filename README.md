# Warchest
Basic implementation of the Warchest game, player has actions such as: place, move, attack, control, initiative, forfeit, recruit. I had some questions regarding the implementation, however I didn't get any answers, therefore I did what I was understanding.


## Prerequisites
This implementation of the Warchest game uses Java, thus, it's necesary to install a Java Development Kit (JDK) on your local environment. 

## Run the project
Files need to be compiled before being able to execute the game as the .class files were added to the .gitignore file. Given that the user is in the main folder, the expected commands to be entered in order to execute the game are:
```bash
    javac -d ./out/ ./*.java 
    cd out/
    java Main
```
First command compiles all existing files and moves the output to the out folder, thus it's needed to move to the out folder and then run the java Main command as Main in the main class that invokes the Game class.

## Improvements

Given the time constraint there's some functionality that could be improved, for instance the different coins have different tactics such as they can attack multiple times or constraints regarding how they can move. I didn't have the time to implement this part, however the code's insfrastructure is ready to handle such changes as each coin has its own class to implement or override the move, attack and place functionalities inside their own class definition. 

Also I understood later on that the recruit functionality changed depending on if it was the Royal coin played or a different one, and for time's sake I kept it the same for all coins

## Questions left unanswered
I asked some questions during the weekend regarding a possible error in the implementation that's shown in the video regarding the number of elements that remain in the recruiting pile after adding them to the bag.

Also I had questions regarding the control functionality which wasn't clear enough for me, so I also did what I understood in this part. 

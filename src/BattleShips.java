import java.util.Scanner; // you must import Scanner to use it

public class BattleShips {
    // initializing a few variables first because the will be needed throughout the entire class.
    private static final int NUMBER_SHIPS = 5;
    private static Scanner input = new Scanner(System.in);
    private static Random randomNumber = new Random();
    private static String[][] mapOfOcean = new String[12][14];
    private static int userCount = 1;
    private static int computerCount = 1;
    private static String winnerID;
    private static String cheerID;

    public static void main(String[] args){

        System.out.println("Welcome to battleship!");
        System.out.println();
        displayMap();
        userMove();
        computerMove();
        theBattle();

    }

    private static void displayMap() {
        // Remember it's [12] x [14]

        // fills in the white space either side of the coordinate listing, top and bottom
        mapOfOcean[0][0] = " ";
        mapOfOcean[0][1] = "  ";
        mapOfOcean[0][12] = " ";
        mapOfOcean[0][13] = " ";
        mapOfOcean[11][0] = " ";
        mapOfOcean[11][1] = "  ";
        mapOfOcean[11][12] = " ";
        mapOfOcean[11][13] = " ";

        // fills in the coordinate listing, top
        System.out.print(mapOfOcean[0][0] + mapOfOcean[0][1]);
        for(int colIndex = 2; colIndex < 12; colIndex++){
            mapOfOcean[0][colIndex] = " " + String.valueOf(colIndex - 2) + " ";
            System.out.print(mapOfOcean[0][colIndex]);

        }

        // generate the ocean, row #s and | on either side, and a playing field filled with null values.
        for(int rowIndex = 0; rowIndex < mapOfOcean.length; rowIndex++){
            for(int colIndex = 0; colIndex < mapOfOcean[rowIndex].length; colIndex++){
                if(rowIndex > 0 && rowIndex < 11) {

                    // fills in the coordinate listing, left and right
                    if (colIndex == 0 || colIndex == 13) {
                        mapOfOcean[rowIndex][colIndex] = String.valueOf(rowIndex - 1);
                        System.out.print(mapOfOcean[rowIndex][colIndex]);
                    }
                    // fills in the barrier, left and right
                    if (colIndex == 1){
                        mapOfOcean[rowIndex][colIndex] = "| ";
                        System.out.print(mapOfOcean[rowIndex][colIndex]);
                    }
                    if(colIndex == 12){
                        mapOfOcean[rowIndex][colIndex] = " |";
                        System.out.print(mapOfOcean[rowIndex][colIndex]);
                    }

                    // fills in the oceans spaces, which I prefer not to be blank
                    // so I used ~ to represent the waves.
                    // fills in player 1 spots with @
                    // fill in computer player spots with more ocean
                    // fills in misses with 0 and hits with X
                    if (colIndex > 1 && colIndex < 12) {
                        if(mapOfOcean[rowIndex][colIndex] == null){
                            System.out.print(" ~ ");
                        }else if(mapOfOcean[rowIndex][colIndex].equals("Player1")){
                            System.out.print(" @ ");
                        }else if(mapOfOcean[rowIndex][colIndex].equals("Computer")){
                            System.out.print(" ~ ");
                        }else if(mapOfOcean[rowIndex][colIndex].equals("miss")){
                            System.out.print(" M ");
                        }else if(mapOfOcean[rowIndex][colIndex].equals("hit")){
                            System.out.print(" X ");
                        }
                    }
                }
            }
            System.out.println();
        }
        // fills in the coordinate listing, bottom
        System.out.print(mapOfOcean[11][0] + mapOfOcean[11][1]);
        for(int colIndex = 2; colIndex < 12; colIndex++){
            mapOfOcean[11][colIndex] = " " + String.valueOf(colIndex - 2) + " ";
            System.out.print(mapOfOcean[0][colIndex]);
        }
        System.out.println();
        System.out.println("-----------------------------------");
    }

    // method to let the player place their ships. I feel like this could probably be simplified.
    private static void userMove() {
        System.out.println("You have five ships to place.");
        while(userCount <= NUMBER_SHIPS) {
            System.out.print("enter your y coordinate (between 0 and 9) for your #" + userCount + " ship: ");
            int userX = input.nextInt();
            System.out.print("enter your x coordinate (between 0 and 9) for your #" + userCount + " ship: ");
            int userY = input.nextInt();
            // note I used a separate method below to check whether ship placement is valid.  This let me write it
            // once and then call it for both the player and the computer, which saved me a few minutes of typing.
            while(!(checkMove(userX, userY))){
                System.out.println("Invalid move! must be placed on the map and in an empty space!");
                System.out.print("enter your y coordinate (between 0 and 9) for your #" + userCount + " ship: ");
                userX = input.nextInt();
                System.out.print("enter your x coordinate (between 0 and 9) for your #" + userCount + " ship: ");
                userY = input.nextInt();
            }
        mapOfOcean[userX + 1][userY + 2] = "Player1";
        displayMap();
        userCount++;
        }
    }

    // method to let the computer place its ships.
    private static void computerMove(){
        System.out.println("Now it's the computer's turn!");
        while(computerCount <= NUMBER_SHIPS){
            int computerX = randomNumber.nextInt(10);
            int computerY = randomNumber.nextInt(10);
            // Here's me using my checkMove method the second time.
            while(!(checkMove(computerX, computerY))){
                computerX = randomNumber.nextInt(10);
                computerY = randomNumber.nextInt(10);
            }
            mapOfOcean[computerX+1][computerY+2] = "Computer";
            computerCount++;
        }
    displayMap();
    }

    // method to control the battle itself
    private static void theBattle(){
        userCount = NUMBER_SHIPS; // reset the number of ships for each player to 5.
        computerCount = NUMBER_SHIPS; // the counters above will have incremented  them to 6.
        System.out.println("And now the battle commences.");
        System.out.println("You must sink all your opponents ships before they sink yours.");
        System.out.println("Player one shoots first.  Just like Han.");
        // this loop contains the player and computer turns and will execute until either the player
        // or the computer has no ships.
        while(userCount > 0 && computerCount > 0){
            System.out.println("Player One: " + userCount + " ships remaining.");
            System.out.println("Computer: " + computerCount + " ships remaining");
            System.out.println("-----------------------------------");
            // user turn
            System.out.println("Choose a target.");
            System.out.println("Enter a y coordinate: ");
            int userShotX = input.nextInt();
            System.out.println("Enter an x coordinate: ");
            int userShotY = input.nextInt();
            // I created a second check method to check if shots are valid.  THe checkMove method checks for
            // a couple of things, but also if the space is null.  this method doesn't check if the space is null
            // because it doesn't metter, it just needs to know that the selected space is in the map.
            while(!(checkShot(userShotX, userShotY))){
                System.out.println("Your shot must land in the map! Choose a number from 0 to 9!");
                System.out.println("Enter a y coordinate: ");
                userShotX = input.nextInt();
                System.out.println("Enter an x coordinate: ");
                userShotY = input.nextInt();
            }

            // Here's me calling a third support method I created which places shots on the map.  It accepts a
            // String for used ID and the shot coordinates and then determines if the shot is a hit or a miss.
            // The user ID makes the responses a little less general.
            // This again saved me a few minutes of typing.  At least 3 or maybe even 4!
            placeShot("Player One", userShotX, userShotY);
            displayMap();

            // computer turn
            System.out.println("Computer is firing...");
            int computerShotX = randomNumber.nextInt(10);
            int computerShotY = randomNumber.nextInt(10);
            while(!(checkShot(computerShotX, computerShotY))){
                computerShotX = randomNumber.nextInt(10);
                computerShotY = randomNumber.nextInt(10);
            }
            // Here is the placeShot method again.
            placeShot("Computer", computerShotX, computerShotY);
            displayMap();
        }

        // These if statements literally change the language of the println that runs when someone wins.
        if(userCount == 0){
            winnerID = "Computer";
            cheerID = "Boooo!";
        }
        if(computerCount == 0){
            winnerID = "Player One";
            cheerID = "Hurray!";
        }
        System.out.println(cheerID + " " + winnerID + " is the winner!");
    }

    // the check move method.
    private static boolean checkMove(int checkMoveX, int checkMoveY){
        // this method takes in two ints, the X and Y coordinates from either the palyer or computers ship placement
        // and makes sure that the coordinates are valid, and also that there is nothing there already.
        boolean goodMove = true ;
        if(checkMoveX < 0 || checkMoveX > 9 || checkMoveY < 0 || checkMoveY > 9 || (mapOfOcean[checkMoveX+1][checkMoveY+2] != null)) {
            goodMove = false;
        }
        return goodMove;
    }
    // the check shot method.
    private static boolean checkShot(int checkMoveX, int checkMoveY) {
        // this method takes in two ints, the x and y coordinates from either the player or computers shots
        // and makes sure they are in the map.  it doesn't need to check for null because if the field has a value
        // then something is going to happen.
        boolean goodMove = true;
        if (checkMoveX < 0 || checkMoveX > 9 || checkMoveY < 0 || checkMoveY > 9) {
            goodMove = false;
        }
        return goodMove;
    }

    // this place shot method
    private static void placeShot(String userID, int shotX, int shotY){
        // this method takes in a string for the user ID (player or computer) and the x and y coordinates of the
        // shot and makes the appropriate changes to the map.  separating this action into it's own method has the drawback
        // of making the language a little less specific, but also of letting me only have to write it once.
        if(mapOfOcean[shotX + 1][shotY + 2] == null){
            System.out.println(userID + " missed!");
            mapOfOcean[shotX + 1][shotY + 2] = "miss";
        }else if(mapOfOcean[shotX + 1][shotY + 2] == "Computer"){
            System.out.println(userID + " sunk one of the computers ships!");
            mapOfOcean[shotX + 1][shotY + 2] = "hit";
            computerCount--;
        }else if(mapOfOcean[shotX + 1][shotY + 2] == "Player1"){
            System.out.println(userID + " sunk one of Player One's ships1");
            mapOfOcean[shotX + 1][shotY + 2] = "hit";
            userCount--;
        }
    }
}

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    //to get input from player
   static Scanner scanner = new Scanner(System.in);
   //player score after win
   static int pScore;
   // computer score after win
   static int cScore;
    public static void main(String[] args) {


        char[][] gameBoard = {
                {'_','|','_','|','_'},
                {'_','|','_','|','_'},
                {' ','|',' ','|',' '}
        };

        printFirstBoard();
// always the playe start with x

          playerMove(gameBoard);

          System.out.println("enter only numbers from 1-9");




// cumputer with y
        computerMove(gameBoard);

        boolean end = false;

        boolean again = true;
//this loop make comuter play more than once and give the choice to do other round
        while(again) {
            while (!end) {

                System.out.println("let's do it again");

                playerMove(gameBoard);



                //check win conditions after each move
                end = isGameOver(gameBoard);
                if (end) {
                    break;
                }


                computerMove(gameBoard);

                //نشيك بعد كل لعبة للكمبيوتر
                end = isGameOver(gameBoard);
                if (end) {
                    break;
                }
            }

            System.out.println("Your Score: " +pScore);
            System.out.println("Computer Score: "+ cScore);
            System.out.println("Would you like to play again? Y/N");
            scanner.nextLine();
            String result = scanner.nextLine();


            switch (result){
                case "Y":
                case "y":
                    again = true;

                    resetBoard(gameBoard);

                    end = false;

                    print(gameBoard);
                    break;

                case "N":
                case "n":
                    again = false;
                    System.out.println("see you soon");
                    break;
                default:
                    break;
            }
        }

    }



    // we print first board so the user know the location of each number
    static void printFirstBoard()
    {
        System.out.println("|---|---|---|");
        System.out.println("| " + 1 + " | "
                + 2 + " | " + 3
                + " |");
        System.out.println("|-----------|");
        System.out.println("| " + 4 + " | "
                + 5+ " | " + 6
                + " |");
        System.out.println("|-----------|");
        System.out.println("| " + 7 + " | "
                + 8 + " | " + 9
                + " |");
        System.out.println("|---|---|---|");
    }





    // print the board using the 2d array
    public static void print(char [][] gameBoard){

        for(char[] row : gameBoard){
            for( char c : row){
                int i=0;
                System.out.print(c);
            }
            System.out.println();
        }
    }


    //تحط  xo حسب من لعب بعد كل ادخال
        public static void updateBoard(int position, int player, char[][] gameBoard) {

            char xo;

            if (player == 1) {
                xo = 'X';
            } else {
                xo = 'O';
            }

            switch (position) {

                case 1:
                    gameBoard[0][0] = xo;
                    print(gameBoard);
                    break;
                case 2:
                    gameBoard[0][2] = xo;
                    print(gameBoard);
                    break;
                case 3:
                    gameBoard[0][4] = xo;
                    print(gameBoard);
                    break;
                case 4:
                    gameBoard[1][0] = xo;
                    print(gameBoard);
                    break;
                case 5:
                    gameBoard[1][2] = xo;
                    print(gameBoard);
                    break;
                case 6:
                    gameBoard[1][4] = xo;
                    print(gameBoard);
                    break;
                case 7:
                    gameBoard[2][0] = xo;
                    print(gameBoard);
                    break;
                case 8:
                    gameBoard[2][2] = xo;
                    print(gameBoard);
                    break;
                case 9:
                    gameBoard[2][4] = xo;
                    print(gameBoard);
                    break;

                default:
                    break;
            }
        }
// تحركات اللاعب
    public static void playerMove(char[][] gameBoard){

        System.out.println("Please make a move 1-9");

try{
        int move = scanner.nextInt();



        boolean result = isValidMove(move,gameBoard);

        while(!result){
            System.out.println("Invalid Move. Try again");
            move = scanner.nextInt();
            result = isValidMove(move,gameBoard);
        }

        System.out.println("Player moved at position " + move);
        updateBoard(move,1,gameBoard);

    }catch (InputMismatchException e1){
            System.out.println("enter only numbers from 1-9");
    System.exit(0);
        }
    }
// تشيك هل تحركات اللاعب و الكمبيوتر صحيحه او لا
    public static boolean isValidMove(int move, char[][] gameboard){

        switch (move){
            case 1:
                if(gameboard[0][0] == '_'){
                    return true;
                } else{
                    return false;
                }
            case 2:
                if(gameboard[0][2] == '_'){
                    return true;
                } else{
                    return false;
                }
            case 3:
                if(gameboard[0][4] == '_'){
                    return true;
                } else{
                    return false;
                }

            case 4:
                if(gameboard[1][0] == '_'){
                    return true;
                } else{
                    return false;
                }
            case 5:
                if(gameboard[1][2] == '_'){
                    return true;
                } else{
                    return false;
                }
            case 6:
                if(gameboard[1][4] == '_'){
                    return true;
                } else{
                    return false;
                }
            case 7:
                if(gameboard[2][0] == ' '){
                    return true;
                } else{
                    return false;
                }
            case 8:
                if(gameboard[2][2] == ' '){
                    return true;
                } else{
                    return false;
                }
            case 9:
                if(gameboard[2][4] == ' '){
                    return true;
                } else{
                    return false;
                }

            default:
                return false;
        }
    }

// حركات عشوائية للكمبيوتر باستخدام Random class
    public static void computerMove(char [][] gameBoard){

        Random rand = new Random();
        int move = rand.nextInt(9)+1;

        boolean result = isValidMove(move,gameBoard);

        while(!result){
            move = rand.nextInt(9)+1;
            result = isValidMove(move, gameBoard);
        }

        System.out.println("Computer moved at position "+ move);
        updateBoard(move,2,gameBoard);
    }
// شروط الفوز
    public static boolean isGameOver(char [][] gameboard){

        // فوز بالعرض
        if(gameboard[0][0] == 'X'&& gameboard[0][2] == 'X' && gameboard [0][4] == 'X' ){
            System.out.println("Player Wins");
            pScore++;
            return true;
        }
        if(gameboard[0][0] == 'O'&& gameboard[0][2] == 'O' && gameboard [0][4] == 'O' ){
            System.out.println("Computer Wins");
            cScore++;
            return true;
        }
        if(gameboard[1][0] == 'X'&& gameboard[1][2] == 'X' && gameboard [1][4] == 'X' ){
            System.out.println("Player Wins");
            pScore++;
            return true;
        }
        if(gameboard[1][0] == 'O'&& gameboard[1][2] == 'O' && gameboard [1][4] == 'O' ){
            System.out.println("Computer Wins");
            cScore++;
            return true;
        }
        if(gameboard[2][0] == 'X'&& gameboard[2][2] == 'X' && gameboard [2][4] == 'X' ){
            System.out.println("Player Wins");
            pScore++;
            return true;
        }
        if(gameboard[2][0] == 'O'&& gameboard[2][2] == 'O' && gameboard [2][4] == 'O' ) {
            System.out.println("Computer Wins");
            cScore++;
            return true;
        }

        //فوز بالطول

        if(gameboard[0][0] == 'X'&& gameboard[1][0] == 'X' && gameboard [2][0] == 'X' ){
            System.out.println("Player Wins");
            pScore++;
            return true;
        }
        if(gameboard[0][0] == 'O'&& gameboard[1][0] == 'O' && gameboard [2][0] == 'O' ){
            System.out.println("Computer Wins");
            cScore++;
            return true;
        }

        if(gameboard[0][2] == 'X'&& gameboard[1][2] == 'X' && gameboard [2][2] == 'X' ){
            System.out.println("Player Wins");
            pScore++;
            return true;
        }
        if(gameboard[0][2] == 'O'&& gameboard[1][2] == 'O' && gameboard [2][2] == 'O' ){
            System.out.println("Computer Wins");
            cScore++;
            return true;
        }

        if(gameboard[0][4] == 'X'&& gameboard[1][4] == 'X' && gameboard [2][4] == 'X' ){
            System.out.println("Player Wins");
            pScore++;
            return true;
        }
        if(gameboard[0][4] == 'O'&& gameboard[1][4] == 'O' && gameboard [2][4] == 'O' ){
            System.out.println("Computer Wins");
            cScore++;
            return true;
        }

        //فوز من الزوايا
        if(gameboard[0][0] == 'X'&& gameboard[1][2] == 'X' && gameboard [2][4] == 'X' ){
            System.out.println("Player Wins");
            pScore++;
            return true;
        }
        if(gameboard[0][0] == 'O'&& gameboard[1][2] == 'O' && gameboard [2][4] == 'O' ){
            System.out.println("Computer Wins");
            cScore++;
            return true;
        }

        if(gameboard[2][0] == 'X'&& gameboard[1][2] == 'X' && gameboard [0][4] == 'X' ){
            System.out.println("Player Wins");
            pScore++;
            return true;
        }
        if(gameboard[2][0] == 'O'&& gameboard[1][2] == 'O' && gameboard [0][4] == 'O' ){
            System.out.println("Computer Wins");
            cScore++;
            return true;
        }

        if(gameboard[0][0] != '_' && gameboard[0][2] != '_' && gameboard[0][4] != '_' && gameboard[1][0] !='_'&&
                gameboard[1][2] != '_' && gameboard[1][4] != '_' && gameboard[2][0] != ' ' && gameboard[2][2] != ' ' && gameboard[2][4] != ' '){
            System.out.println("Its a tie");
            return true;
        }

        return false;}

// ترجع شكل اللعبة لشكلة للبداية
    public static void resetBoard(char [][] gameBoard){
        gameBoard[0][0] = '_';
        gameBoard[0][2] = '_';
        gameBoard[0][4] = '_';
        gameBoard[1][0] = '_';
        gameBoard[1][2] = '_';
        gameBoard[1][4] = '_';
        gameBoard[2][0] = ' ';
        gameBoard[2][2] = ' ';
        gameBoard[2][4] = ' ';
    }





}








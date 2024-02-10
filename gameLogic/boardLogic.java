package gameLogic;
import botSetup.Bot;
import printingFunctions.printing;
import java.util.Random;
import java.util.Scanner;

/*  class [boardLogic]
 *  Contains all the game logic of switching turns
 *  initializing the board, and a game loop
 *  contains constants, choice, board, flag, counter, 
 *  and scanner variables + objects
 * 
 *  These methods call other methods for them to run
 *  properly, but this class requires an object to be
 *  made to use it
 * 
 *  @authors
 *  Betim Hodza
 *  Byran Lucio
 *  Erik Guerrero
 *  Louis Do
 */
public class boardLogic 
{
    /* Variables that are used in each function, not to be touched outside */
    //constants
    private final int ROW = 6; 
    private final int COL = 7;

    //choice variables
    private int botChoice = 0; 
    private int usercol = -1; 
    private int botcol = -1;

    //game board
    private char board [][] = new char[ROW][COL]; 

    //bool flags
    private boolean isPlayer1 = false;
    private boolean hasWon = false;
    private boolean FancyPrint = true;
    private boolean isfull=true;

    //board counter
    private int boardisfull = 0;

    //scanner
    private Scanner input = new Scanner(System.in);
    
    /* [PlayervsPlayer]
        function that takes in the string menuChoice 
        and returns menuChoice string once the game is over
        contains logic code that takes turns between player 1 and 2 
        to play, along with calling logic to check who has won
        also calls functions that take care of edge cases

        @ Authors
        Betim Hodza
        Bryan Lucio
    */
    public String PlayervsPlayer(String menuChoice) throws Exception 
    {
        printing.playVsPlay();
        board = initializeBoard(board);

        /* Condition to check if a game was already played to let P2 go first */
        if (hasWon) 
        {
            isPlayer1 = true; 
        }

        /* required to reinitialize variables as to properly run it again */
        boardisfull = 0;
        hasWon = false;
        isfull = false;
        FancyPrint = true;

        /* While loop runs until someone wins */
        while (!hasWon) 
        {
            /* prints the board */
            boardisfull++;
            if (FancyPrint)
            {
                printing.printBoardFancy(board);
            }
            else
            {
                printing.printBoard(board);
            }
            FancyPrint = false;
            
            /* swaps players turns */
            if (!isPlayer1) 
            {
                /* 
                    User places their coin, then checks if that spot is full
                    if it is, they choose again, after that it inputs the
                    coin, and checks if they have won.
                */
                usercol = boardLogic.playerColNum(usercol, input, isPlayer1); 
                isfull = logic.isColumnFull(board, usercol, isfull);
                while (isfull) 
                {                       
                    System.out.print("P1, column is full choose a new column: ");
                    usercol = input.nextInt();
                    isfull = logic.isColumnFull(board, usercol, isfull);
                }
                
                logic.inputPlayerCoin(isPlayer1, usercol, ROW, board);
                hasWon = logic.Win(hasWon, isPlayer1, ROW, COL, board, boardisfull);
                isPlayer1 = true;
                
            } 
            else 
            {
                /* 
                    User places their coin, then checks if that spot is full
                    if it is, they choose again, after that it inputs the
                    coin, and checks if they have won.
                */
                usercol = boardLogic.playerColNum(usercol, input, isPlayer1);
                isfull = logic.isColumnFull(board, usercol, isfull);
                while (isfull) 
                {                       
                    System.out.print("P2, column is full choose a new column: ");
                    usercol = input.nextInt();
                    isfull = logic.isColumnFull(board, usercol, isfull);
                }
                
                logic.inputPlayerCoin(isPlayer1, usercol, ROW, board);
                
                hasWon = logic.Win(hasWon, isPlayer1, ROW, COL, board, boardisfull);
                isPlayer1 = false;
            }
        }
        printing.printMenu();
        menuChoice = input.next();
        return menuChoice;
    }
    
    /* [PlayervsBot]
        Similar to player vs player function, takes in menuChoice and returns it
        but this time the player gets to choose a bot difficulty, still contains
        similar logic of taking turns but the 2nd player is the bot and calls methods
        from it's class files

        @ Authors
        Betim Hodza
        Bryan Lucio
    */
    public String PlayervsBot(String menuChoice) throws Exception
    {
        printing.playVsBot();
        
        /* this needs to be initialized before starting a game w/ ai (P1 always goes first in this case) */
        board = initializeBoard(board);
        boardisfull = 0;
        isfull = false;
        isPlayer1 = false; 
        hasWon = false;
        FancyPrint = true;
        botChoice = 0;
        
        /*  ask for bot difficulty */
        printing.printBotMenu();
        botChoice = input.nextInt();
        while(botChoice < 1 || botChoice>3)
        {
            System.out.println("That is not one of the options. Please choose again");
            botChoice = input.nextInt();
        }
        
        while (!hasWon) 
        {
            /*
                printing board logic
             */
            boardisfull++;
            if (FancyPrint == true)
            {
                printing.printBoardFancy(board);
            }
            else
            {
                printing.printBoard(board);
            }
            FancyPrint = false;
            
            if (!isPlayer1) 
            {
                /* 
                    User places their coin, then checks if that spot is full
                    if it is, they choose again, after that it inputs the
                    coin, and checks if they have won.
                */
                usercol = boardLogic.playerColNum(usercol, input, isPlayer1);
                isfull = logic.isColumnFull(board, usercol, isfull);
                while (isfull) 
                {                       
                    System.out.print("P1, column is full choose a new column: ");
                    usercol = input.nextInt();
                    isfull = logic.isColumnFull(board, usercol, isfull);
                }

                logic.inputPlayerCoin(isPlayer1, usercol, ROW, board); 
                hasWon = logic.Win(hasWon, isPlayer1, ROW, COL, board, boardisfull); 
                isPlayer1 = true;
            } 
            else 
            {
                System.out.println("Bot is thinking");
                Thread.sleep(600);
                
                /* 
                    Bot passes in difficulty depending on what the user chooses
                    and chooses what move to make
                    botcol = botColNum(botChoice, board, COL, ROW, usercol);
    
                    checks if that spot is valid, if its not 
                    it chooses a random number for where to place,
                    then it checks who has won.
                */
                botcol = botColNum(botChoice, board, COL, ROW, usercol);
                isfull = logic.isColumnFull(board, botcol, isfull);
                while (isfull) 
                {
                    Random rand = new Random();           
                    botcol = rand.nextInt(7)+1;
                    isfull = logic.isColumnFull(board, botcol, isfull);
                }

                //player gets to input
                logic.inputPlayerCoin(isPlayer1, botcol, ROW, board);
                Thread.sleep(600);

                //checks for winner
                hasWon = logic.Win(hasWon, isPlayer1, ROW, COL, board, boardisfull);
                isPlayer1 = false;
            }

        }
        //starts next option
        printing.printMenu();
        menuChoice = input.next();
        return menuChoice;
    }

    /* [enterColNum]
        takes in usercol, input, and isPlayer1 to ask the player 
        where they want to drop their coin, and returns usercol

        contains logic to keep input within range, and logic 
        on who is inputing the coin

        this method is private since its only used in boardlogic

        @ Authors
        Betim Hodza
    */
    private static int playerColNum(int usercol, Scanner input, boolean isPlayer1)
    {
        if (!isPlayer1) 
        {
            System.out.print("\nPlayer 1 you're up!\nEnter the column number where you want to drop your checker: ");
        }
        else
        {
            System.out.print("\nPlayer 2 you're up!\nEnter the column number where you want to drop your checker: ");
        }
        usercol = input.nextInt();
        System.out.println();
        
        // fallback to keep input within range
        if ((usercol <= 0 || usercol > 7)) 
        {
            while ((usercol <= 0 || usercol > 7)) 
            {
                if (!isPlayer1)
                {
                    System.out.print("P1, please input a col again: ");
                }
                else
                {
                    System.out.print("P2, please input a col again: ");
                }
                usercol = input.nextInt();
            }
        } 
        
        return usercol;
    }
    /* [botColNum]
        Takes in botChoice, our board, our 2 constant ROW and COl
        and it takes in the usercol too. It then calls a function
        to get that bots choice, then checks to make sure its within
        range. 
        Finally returns botcol to be placed on the board.

        @ Authors
        Betim Hodza
    */
    private static int botColNum(int botChoice, char[][] board, int COL, int ROW, int usercol) throws Exception
    {
        int botcol = Bot.botChoice(botChoice, board, COL, ROW, usercol); 
        if ((botcol <= 0 || botcol > 7)) // fallback to keep input within range
        {
            while ((botcol <= 0 || botcol > 7)) 
            {
                        
                botcol = Bot.botChoice(botChoice, board, COL, ROW, usercol);
            }
        } 

        return botcol;
    }
    /* [initializedBoard]
        Passes in a copy of the board 
        to be filled in with dashes
        and returns it

        @ Authors
        Betim Hodza
    */
    private static char[][] initializeBoard(char[][] board)
    {
        for (int i = 0; i < 6; i++) 
        {
            for (int j = 0; j < 7; j++) 
            {
                board[i][j] = '-'; 
            }
        }

        return board;
    }

}



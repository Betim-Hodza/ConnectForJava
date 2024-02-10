package printingFunctions;

/*  class [printing]
 *  A class contiaining mostly static void print methods
 *  that are used within main method. Class exists for
 *  encapsulation and organization.
 * 
 *  @authors
 *  Betim Hodza
 *  Byran Lucio
 *  Erik Guerrero
 *  Louis Do
 */

public class printing 
{
    /*  [printMenu]
        Function prints out the menus selection of choices to choose from.
        uses the Thread.sleep method to create a themed printing

        @ Authors
        Betim Hodza
        Bryan Lucio
    */
    public static void printMenu() throws InterruptedException
    {
        System.out.println("Welcome to Connect FOR JAVA\n");
        try 
        {
            Thread.sleep(600); 
        } 
        catch (InterruptedException e) 
        {
            e.printStackTrace();
        }
        System.out.println("Choose what you want to do: ");
        Thread.sleep(600);
        System.out.println("1. Player vs Player");
        Thread.sleep(600);
        System.out.println("2. Player vs Computer");
        Thread.sleep(600);
        System.out.println("3. Rules");
        Thread.sleep(600);
        System.out.println("4. Exit Game");
        Thread.sleep(600);
        System.out.print("Enter your choice: ");
        Thread.sleep(600);
    }

    /*  [printBotMenu]
        Function prints out the bot menus selection of difficulties.
        uses the Thread.sleep method to create a themed printing
        
        @ Authors
        Bryan Lucio

    */
    public static void printBotMenu() throws InterruptedException
    {
        System.out.println("\nPlease enter a difficulty: ");
        Thread.sleep(600);
        System.out.println("1. Easy");
        Thread.sleep(600);
        System.out.println("2. Medium");
        Thread.sleep(600);
        System.out.println("3. Hard");
        Thread.sleep(600);
        System.out.print("Enter your choice: ");
        Thread.sleep(600);
    }

    /*  [printBoardFancy]
        Function prints out board in a one by one animation.
        uses the Thread.sleep method to create a themed printing
        
        @ Authors
        Bryan Lucio
    */
    public static void printBoardFancy(char board [][])
    {
        System.out.println("1  2  3  4  5  6  7  ");
        try 
        {
            Thread.sleep(200);
        } 
        catch (InterruptedException e) 
        {
            e.printStackTrace();
        }
        for (char[] cs : board) // Nested For-Loop to print out the one by one animation
        {
            for (char cs2 : cs) 
            {
                System.out.print(cs2 + "  ");
                try 
                {
                    Thread.sleep(100); // Prints out slowly 1 by 1
                } 
                catch (InterruptedException e) 
                {
                    e.printStackTrace();
                }
            }
            System.out.println();
        }
    }

    /*  [printBoard]
        Function prints out the board all at once,
        that way the game doesn't delay 

        @ Authors
        Betim Hodza
    */
    public static void printBoard(char board [][])
    {
        System.out.println("1  2  3  4  5  6  7  ");
        for (char[] cs : board) // Nested For-Loop to print out the board
        {
            for (char cs2 : cs) 
            {
                System.out.print(cs2 + "  ");
            }
            System.out.println();
        }
    }

    /*  [printRules]
        Function prints out the rules one by one.
        uses the Thread.sleep method to create a themed printing

        @ Authors
        Bryan Lucio
    */
    public static void printRules() throws InterruptedException
    {
        System.out.println("\n1) Decide who plays first. Players will alternate turns after playing\n a checker.\n");
        Thread.sleep(600);
        System.out.println("2) On your turn, you will choose where you want to drop your checker in ANY of the slots\n");
        Thread.sleep(600);
        System.out.println("3) Players will alternate until one gets FOUR checkers in a row. This can be done in any way it can be horizontal ,vertical , or diagonal;\n");
        Thread.sleep(600);
    }

    /*  [printWin]
        Function prints out the current board, and which player won.
        passes in the game board and the boolean flag for if it's
        player1, returns hasWon boolean

        @ Authors 
        Betim Hodza
    */
    public static boolean printWin(char board[][], boolean isPlayer1) 
    {
        int i = 2; // Default it's player 2
        if(!isPlayer1) // Checks if it's player 1
        {
            i = 1; 
        }
        printing.printBoard(board);
        System.out.println("Player " + i + " has won!!!\n");
        boolean hasWon = true;
        return hasWon;
    }
    
    /*  [printTie]
        Function prints out the current board, and that it's a tie.
        returns true to end the while loop

        @ Authors
        Bryan Lucio
    */
    public static boolean printTie(char board[][]) 
    {
        printing.printBoard(board);
        System.out.println("It is a tie!!!\n");
        return true;
    }

    /*  [printExit]
        Function prints out an exit animation.
        uses the Thread.sleep method to create a themed printing

        @ Authors
        Betim Hodza
    */
    public static void printExit() throws InterruptedException
    {
        System.out.println("Exiting");
        Thread.sleep(400);
        System.out.print(".");
        Thread.sleep(400);
        System.out.print(".");
        Thread.sleep(400);
        System.out.print(".");
    }
    
    /*  [playVsBot]
        Function prints what gamemode it is, 
        and how many players required, and how to play.
        uses the Thread.sleep method to create a themed printing

        @ Authors
        Betim Hodza
    */
    public static void playVsBot() throws InterruptedException
    {
        System.out.println("\nWelcome to Connect FOR JAVA PVB!");
        Thread.sleep(600);
        System.out.println("1 player is required to play, \nall you need to do is choose a column number and have at it!");
        Thread.sleep(600);
    }
    /*  [playVsBot]
        Function prints what gamemode it is, 
        and how many players required, and how to play.
        uses the Thread.sleep method to create a themed printing

        @ Authors
        Betim Hodza
    */
    public static void playVsPlay() throws InterruptedException
    {
        System.out.println("Welcome to Connect FOR JAVA PVP!");
        Thread.sleep(600);
        System.out.println("2 players are required to play, \nall you need to do is choose a column number and have at it!");
        Thread.sleep(600);
    }
}
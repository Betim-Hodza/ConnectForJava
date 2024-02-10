import java.util.Scanner;

import gameLogic.boardLogic;
import printingFunctions.printing;

public class connect4 
{
    /* [Main method]
     * makes use of boardLogic.java object
     * and printing.java static methods
     * 
     * contains a while loop with switch statements 
     * for the choice of the player on what they want to do
     * 
     * 1: player vs player
     * 2: player vs bot
     * 3: show rules
     * 4: exit
     * 
     * @ authors
     * Betim Hodza
     * Bryan Lucio
     * Erik Guerrero
     * Louis Do
     */
    public static void main(String[] args) throws Exception
    {
        Scanner input = new Scanner(System.in);
        printing.printMenu();
        String menuChoice = input.nextLine();
        boardLogic board = new boardLogic();
        
        while(true)
        {
            switch (menuChoice) 
            {
                /*  [Player vs Player]
                    Our board object gets called to return a string for the menu and
                    it starts the player vs player game with the logic in boardLogic.java
                */
                case "1":
                {
                    menuChoice = board.PlayervsPlayer(menuChoice);
                    break;
                }
                /*  [Player vs Bot]
                    Our board object gets called to return a string for the menu
                    and it starts the player vs bot game, using bot.java for the logic.
                */
                case "2": 
                {
                    menuChoice = board.PlayervsBot(menuChoice);
                    break;
                }
                /*  [Show Rules]
                    Static method that simply prints out the rules
                    contains a while loop to only allow the user
                    to enter 0 to go back to the menu
                */
                case "3": 
                {
                    printing.printRules();
                    String garbage = "-1";
                    while(garbage != "1")
                    {
                        System.out.print("\n Enter 0 to go back to the menu: ");
                        garbage = input.nextLine();
                        if(garbage.contentEquals("0")) 
                        {
                            printing.printMenu();
                            menuChoice = input.nextLine(); // Setup for menu
                            break;
                        }
                    }
                    break;   
                }
                /*  [Exit game]
                    Prints an exit message and closes the scanner
                */
                case "4":
                {
                    printing.printExit();
                    input.close();
                    return;
                }
                /*  [Invalid Input]
                    No valid value inputted, ask for user input again
                */
                default:
                    System.out.println("Invalid input");
                    System.out.println("Please input again");
                    menuChoice = input.nextLine();
                    break;
            }
        }
    } 
}
package botSetup;
import java.util.Random;

public class Bot 
{

    /*** [botChoice]
     * makes use of random number generator
     * and making a good choice
     * 
     * method takes in parameters botChoice, board, col, row, and usercol
     * contains a while loop with a switch statement
     * 1: Easy
     * 2: Medium
     * 3: Hard
     * It returns the choice for the bot to boardLogic
     * 
     * @ Authors
     * Bryan Lucio
     * Betim Hodza
     * Erik Guerrero
     * Louis Do
     ***/
    public static int botChoice(int botChoice, char board[][],int col,int row,int usercol) throws Exception
    {
        int column = 7;
        int choice = -1; 
        switch (botChoice) 
        {
            /* Easy: bot that randomly picks numbers, can be seen as easiest 
             * 
             * Author 
             * Byran Lucio
             * Betim Hodza
            */
            case 1:
            {
                Random rand = new Random();
                choice = BotBlocks.makeMoveCol(board, usercol, column, row, choice, rand);
                if(choice == -1)
                {
                    choice = rand.nextInt(column)+1;
                }                
                if(choice == 0)
                {
                    choice = rand.nextInt(column)+1;
                }
                else if(choice == 8)
                {
                    choice = rand.nextInt(column)+1;
                }
                return choice;
            }
            case 2://Medium
            {
                /*** Difficulty : Medium
                * Goes trough every possible check for bot to win
                * Also Goes trough every possible check for bot to block user
                * Only checks for rows and columns
                * 
                * @ Author
                * Bryan Lucio
                * Erik Guerrero
                * Louis Do
                ***/           
                Random rand = new Random();

                choice = BotCheckWin.checkCol(row, column, board, choice);

                if(choice == -1)
                {
                    choice = BotCheckWin.checkRow(row, column, board, choice);
                }
                if(choice == -1)
                {
                    choice = BotBlocks.makeMoveRow(board, usercol, column, row, choice, rand);  
                }  
                if(choice == -1)
                {
                    choice = BotBlocks.makeMoveCol(board, usercol, column, row, choice, rand);
                }
                if(choice == -1)
                {
                    choice = rand.nextInt(column)+1;
                }
                if(choice == 0)
                {
                    choice = rand.nextInt(column)+1;
                }
                    else if(choice == 8)
                {
                    choice = rand.nextInt(column)+1;
                }
                return choice;
            }
            case 3://Hard
            {
                Random rand = new Random();
                /*** Difficulty : Hard
                * Goes trough every possible check for bot to win
                * Also Goes trough every possible check for bot to block user
                * Checks for rows,columns and Diags
                * 
                * @ Author
                * Bryan Lucio
                * Erik Guerrero
                * Louis Do
                ***/

                choice = BotCheckWin.checkCol(row, column, board, choice);

                if(choice == -1)
                {
                    choice = BotCheckWin.checkRow(row, column, board, choice);
                }
                if(choice == -1)
                {
                    choice = BotCheckWin.checkDiagUp(row, column, board, choice);
                }
                if(choice == -1)
                {
                    choice = BotCheckWin.checkDiagDown(row, column, board, choice);
                }
                if(choice == -1)
                {
                    choice = BotBlocks.makeMoveRow(board, usercol, column, row, choice, rand);  
                }  
                if(choice == -1)
                {
                    choice = BotBlocks.makeMoveCol(board, usercol, column, row, choice, rand);
                }
                if(choice == -1)
                {
                    choice = BotBlocks.makeMoveDiagUp(board, usercol, column, row, choice, rand);
                }
                if(choice == -1)
                {
                    choice = BotBlocks.makeMoveDiagDown(board, usercol, column, row, choice, rand);
                }
                if(choice == -1)
                {
                    choice = rand.nextInt(column)+1;
                }
                if(choice == 0)
                {
                    choice = rand.nextInt(column)+1;
                }
                else if(choice == 8)
                {
                    choice = rand.nextInt(column)+1;
                }
                return choice;
            }
            default:
            return choice;
        }
    }

}
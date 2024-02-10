package gameLogic;

import printingFunctions.printing;

public class logic 
{
    /*** [isColumnFull]
     * A short method to check if a column is full, used 
     * inside an if statement to add to the fallback checker 
     * returns T or F.
     * 
     * @ authors 
     * Betim Hodza
     ***/
    public static boolean isColumnFull(char board[][], int col, boolean isfull) throws Exception
    {
        if(board[0][col-1] == 'X' || board[0][col-1] == 'O')
        {
            isfull = true;
        }
        else
        {
            isfull = false;
        }
        return isfull;
            
    }
    /*** winnerRow
     *  Checks who has won based on the row
     *  returns win (T/F) based if someone won
     * 
     *  @ Author
     *  Bryan lucio
     ***/
    
    public static boolean winnerRow(char board[][], boolean isPlayer1, int row, int col) throws Exception
    {
        boolean win = false;
        for(int i=0; i<row;i++)
        {
            for(int j=0; j<col-3;j++)
            {
                if((board[i][j] == 'X' && board[i][j+1] == 'X' && board[i][j+2] == 'X' && board[i][j+3] == 'X') || (board[i][j] == 'O' && board[i][j+1] == 'O' && board[i][j+2] == 'O' && board[i][j+3]== 'O'))
                {
                    win = true;
                }
            }

        }
        return win;
    }

    /*** winnerCol
     *  Checks who has won based on the col
     *  returns win (T/F) based if someone won
     * 
     *  @ Author
     *  Bryan lucio
     ***/
    public static boolean winnerCol(char board[][],boolean isPlayer1,int row,int col) throws Exception
    {
        boolean win = false;
        for(int i=0; i<row-3;i++)
        {
            for(int j=0; j<col;j++)
            {
                if((board[i][j] == 'X' && board[i+1][j] == 'X' && board[i+2][j] == 'X' && board[i+3][j] == 'X') || (board[i][j] == 'O' && board[i+1][j] == 'O' && board[i+2][j] == 'O' && board[i+3][j]== 'O'))
                {
                    win = true;

                }
            }

        }
        return win;
    }

    /*** winnerDiagUo
     *  Checks who has won based on the diagUp
     *  returns win (T/F) based if someone won
     * 
     *  @ Author
     *  Bryan lucio
     ***/
    public static boolean winnerDiagUp(char board[][],boolean isPlayer1,int row,int col)throws Exception
    {
        boolean win = false;
        for(int i=3; i<row;i++)
        {
            for(int j=0; j<col-3;j++)
            {
                if((board[i][j] == 'X' && board[i-1][j+1] == 'X' && board[i-2][j+2] == 'X' && board[i-3][j+3] == 'X') || (board[i][j] == 'O' && board[i-1][j+1] == 'O' && board[i-2][j+2] == 'O' && board[i-3][j+3]== 'O'))
                {
                    win = true;

                }
            }

        }
        return win;
    }

    /*** winnerDiagDown
     *  Checks who has won based on the diagDown
     *  returns win (T/F) based if someone won
     * 
     *  @ Author
     *  Bryan lucio
     ***/
    public static boolean winnerDiagDown(char board[][],boolean isPlayer1,int row,int col)throws Exception
    {
        boolean win = false;
        for(int i=0; i<row-3;i++)
        {
            for(int j=0; j<col-3;j++)
            {
                if((board[i][j] == 'X' && board[i+1][j+1] == 'X' && board[i+2][j+2] == 'X' && board[i+3][j+3] == 'X') || (board[i][j] == 'O' && board[i+1][j+1] == 'O' && board[i+2][j+2] == 'O' && board[i+3][j+3]== 'O'))
                {
                    win = true;

                }
            }

        }
        return win;
    }

    /*** winnerRow
     * will check which player is putting their coin in the C4 board,
     * if it is player 1 there will be X's, if it's 2 then 
     * there will be O's
     * 
     * It then inputs the coins onto the board
     * returns nothing, just edits the board
     * 
     * @ Authors
     * Betim Hodza
     * Bryan Lucio
     * Erik Guerrero
     * Louis Do
     ***/
    public static void inputPlayerCoin(boolean isPlayer1, int col, int ROW , char board[][]) throws Exception
    {
        int counter = 5;
        if(!isPlayer1)
        {
            for (int i = 0; i < ROW ; i++) 
            {
                if(board[i][col-1] == 'X' || board[i][col-1] == 'O')
                {
                    if(counter > 0)
                        counter--;
                }
            }
            if (!(counter >= 0) || !(board[0][col-1] == 'X' || board[0][col-1] == 'O'))
            {
                board[counter][col-1] = 'X';   
            }
            
        }
        else
        {
            for (int i = 0; i < ROW ; i++) 
            {
                if(board[i][col-1] == 'X' || board[i][col-1] == 'O')
                {
                    if(counter > 0)
                        counter--;
                }
            }
            if (!(counter >= 0) || !(board[0][col-1] == 'X' || board[0][col-1] == 'O'))
            {
                board[counter][col-1] = 'O';   
            }
            
        }
    } 

    /*** Win
     *  boolean method that returns who has won on the board, 
     *  uses winnerRow, col, diag up and down methods previously created
     *  to do so and returns the hasWon (T/F) at the end, as someone could win
     *  in a different area
     * 
     *  @ authors
     *  Bryan Lucio
     *  Betim Hodza
     ***/
    public static boolean Win(boolean hasWon, boolean isPlayer1, int ROW, int COL, char [][] board, int boardisfull) throws Exception
    {
        if (logic.winnerRow(board, isPlayer1, ROW, COL)) 
        {
            hasWon = printing.printWin(board, isPlayer1);
        } 
        else if (logic.winnerCol(board, isPlayer1, ROW, COL)) 
        {
            hasWon = printing.printWin(board, isPlayer1);
        } 
        else if (logic.winnerDiagDown(board, isPlayer1, ROW, COL)) 
        {
            hasWon = printing.printWin(board, isPlayer1);
        } 
        else if (logic.winnerDiagUp(board, isPlayer1, ROW, COL)) 
        {
            hasWon = printing.printWin(board, isPlayer1);
        } 
        else if (boardisfull == 42) // tie caase
        {
            hasWon = true;
            printing.printTie(board);
        }
        
        return hasWon;
    }

}

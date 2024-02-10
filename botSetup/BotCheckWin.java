package botSetup;
/*** [BotCheckWin]
* Goes through every possible check for bot to win
* This is for Col, Rows, and Diags
* 
* @ Author
* Bryan Lucio
* Erik Guerrero
* Louis Do
***/
public class BotCheckWin
{
    /*** [checkCol]
    * i < 3 because that is the last possible way to win in a column
    * if i goes any higher it will check out of bounds
    * 
    *  @ Author
    *  Bryan Lucio
    ***/
    static int checkCol(int row, int column, char[][] board, int choice)
    {
        for(int i=0; i<3;i++)//Check Col
        {
            for(int j=0; j < column;j++)
            {
                if(board[i][j] == '-' && board[i+1][j] == 'O' && board[i+2][j] == 'O' && board[i+3][j] == 'O')
                {
                    choice = j+1;        
                }
            }
            if(choice > 0)
            {
                break;
            }
        }
        return choice;
    }

    /*** [checkRow]
    * j < 4 because that is the last possible way to win in a row
    * if j goes any higher it will check out of bounds
    *
    * @ Author
    * Bryan Lucio
    ***/
    static int checkRow(int row, int column, char[][] board, int choice) 
    {
        for(int i=0; i<6;i++)//Chech Row
        {
            for(int j=0; j < 4;j++)
            {
                if(i==5)
                {
                    if(board[i][j] == 'O' && board[i][j+1] == 'O' && board[i][j+2] == 'O' && board[i][j+3] == '-')
                    {
                        choice = j+4;
            
                    }
                    else if(j != 0 && board[i][j] == 'O' && board[i][j+1] == 'O' && board[i][j+2] == 'O' && board[i][j+3] == 'X' && board[i-1][j-1] == '-')
                    {
                        choice = j;
                        
                    }
                    else if(board[i][j] == 'O' && board[i][j+1] == '-' && board[i][j+2] == 'O' && board[i][j+3] == 'O')
                    {
                        choice = j+2;
                        
                    }
                    else if(board[i][j] == 'O' && board[i][j+1] == 'O' && board[i][j+2] == '-' && board[i][j+3] == 'O')
                    {
                        choice = j+3;
                        
                    }
                    else if(board[i][j] == '-' && board[i][j+1] == 'O' && board[i][j+2] == 'O' && board[i][j+3] == 'O')
                    {
                        choice = j+1;  
                    }
                }
                else if(i==0)
                {
                    if(board[i][j] == 'X' && board[i][j+1] == 'X' && board[i][j+2] == 'X' && board[i][j+3] == '-' && (board[i+1][j+3] == 'X'|| board[i+1][j+3] == 'O'))
                    {
                        choice = j+4;
            
                    }
                    else if(board[i][j] == 'X' && board[i][j+1] == 'X' && board[i][j+2] == 'X' && board[i][j+3] == 'O' && (board[i+1][j-1] == 'X'|| board[i+1][j-1] == 'O'))
                    {
                        choice = j;
                        
                    }
                    else if(board[i][j] == 'X' && board[i][j+1] == '-' && board[i][j+2] == 'X' && board[i][j+3] == 'X' && (board[i+1][j+1] == 'X'|| board[i+1][j+1] == 'O'))
                    {
                        choice = j+2;
                        
                    }
                    else if(board[i][j] == 'X' && board[i][j+1] == 'X' && board[i][j+2] == '-' && board[i][j+3] == 'X' && (board[i+1][j+2] == 'X'|| board[i+1][j+2] == 'O'))
                    {
                        choice = j+3;
                        
                    }
                    else if(board[i][j] == '-' && board[i][j+1] == 'X' && board[i][j+2] == 'X' && board[i][j+3] == 'X' && (board[i+1][j] == 'X'|| board[i+1][j] == 'O'))
                    {
                        choice = j+1;  
                    }
                }
                else
                {
                    if( board[i][j] == 'O' && board[i][j+1] == 'O' && board[i][j+2] == 'O' && board[i][j+3] == '-' && (board[i+1][j+3] == 'X'|| board[i+1][j+3] == 'O') && board[i-1][j+3] == '-')
                    {
                        choice = j+4;
            
                    }
                    else if(j != 0 && board[i][j] == 'O' && board[i][j+1] == 'O' && board[i][j+2] == 'O' && board[i][j+3] == 'X' && (board[i+1][j-1] == 'X'|| board[i+1][j-1] == 'O') && board[i-1][j-1] == '-')
                    {
                        choice = j;
                        
                    }
                    else if(board[i][j] == 'O' && board[i][j+1] == '-' && board[i][j+2] == 'O' && board[i][j+3] == 'O' && (board[i+1][j+1] == 'X'|| board[i+1][j+1] == 'O') && board[i-1][j+1] == '-')
                    {
                        choice = j+2;
                        
                    }
                    else if(board[i][j] == 'O' && board[i][j+1] == 'O' && board[i][j+2] == '-' && board[i][j+3] == 'O' && (board[i+1][j+2] == 'X'|| board[i+1][j+2] == 'O') && board[i-1][j+2] == '-')
                    {
                        choice = j+3;
                        
                    }
                    else if(board[i][j] == '-' && board[i][j+1] == 'O' && board[i][j+2] == 'O' && board[i][j+3] == 'O' && (board[i+1][j] == 'X'|| board[i+1][j] == 'O') && board[i-1][j] == '-')
                    {
                        choice = j+1;  
                    }
                }
            }
            if(choice > 0)
            {
                break;
            }
        }
        return choice;
    }

    /*** [checkDiagUp]
    * 
    * 
    *  @ Author
    *  Bryan Lucio
    ***/
    static int checkDiagUp(int row, int column, char[][] board, int choice) 
    {
        for(int i=3; i<row;i++)
        {
            for(int j=0; j<column-3;j++)
            {
                if( i != 5 && board[i][j] == '-' && board[i-1][j+1] == 'O' && board[i-2][j+2] == 'O' && board[i-3][j+3]== 'O' && (board[i+1][j] == 'X' || board[i+1][j] == 'O'))
                {
                    choice = j+1;
                    break;
                }
                else if(i == 5 && board[i][j] == '-' && board[i-1][j+1] == 'O' && board[i-2][j+2] == 'O' && board[i-3][j+3]== 'O')
                {
                    choice = j+1;
                    break;
                }
                else if(board[i][j] == 'O' && board[i-1][j+1] == '-' && board[i-2][j+2] == 'O' && board[i-3][j+3]== 'O' && (board[i][j+1] == 'X' || board[i][j+1] == 'O'))
                {
                    choice = j+2;
                    break;
                }
                else if(board[i][j] == 'O' && board[i-1][j+1] == 'O' && board[i-2][j+2] == '-' && board[i-3][j+3]== 'O' && (board[i-1][j+2] == 'X' || board[i-1][j+2] == 'O'))
                {
                    choice = j+3;
                    break;
                }
                else if(board[i][j] == 'O' && board[i-1][j+1] == 'O' && board[i-2][j+2] == 'O' && board[i-3][j+3]== '-' && (board[i-2][j+3] == 'X' || board[i-2][j+3] == 'O'))
                {
                    choice = j+4;
                    break;
                }

            }
            if(choice != -1)
            {
                break;
            }
        }
        return choice;
    }

    /*** [checkDiagDown]
    * 
    * 
    *  @ Author
    *  Bryan Lucio
    ***/
    static int checkDiagDown(int row, int column, char[][] board, int choice)
    {
        for(int i=0; i<row-3;i++)
        {
            for(int j=0; j<column-3;j++)
            {
                if(board[i][j] == '-' && board[i+1][j+1] == 'O' && board[i+2][j+2] == 'O' && board[i+3][j+3]== 'O' && (board[i+1][j] == 'X' || board[i+1][j] == 'O'))
                {
                    choice = j+1;
                    break;
                }
                else if(board[i][j] == 'O' && board[i+1][j+1] == '-' && board[i+2][j+2] == 'O' && board[i+3][j+3]== 'O' && (board[i+2][j+1] == 'X' || board[i+2][j+1] == 'O'))
                {
                    choice = j+2;
                    break;
                }
                else if(board[i][j] == 'O' && board[i+1][j+1] == 'O' && board[i+2][j+2] == '-' && board[i+3][j+3]== 'O' && (board[i+3][j+2] == 'X' || board[i+3][j+2] == 'O'))
                {
                    choice = j+3;
                    break;
                }
                else if(i+3 == 5 && board[i][j] == 'O' && board[i+1][j+1] == 'O' && board[i+2][j+2] == 'O' && board[i+3][j+3]== '-')
                {
                    choice = j+4;
                    break;
                }
                else if( board[i][j] == 'O' && board[i+1][j+1] == 'O' && board[i+2][j+2] == 'O' && board[i+3][j+3]== '-'  && (board[i+3][j+3] == 'X' || board[i+3][j+3] == 'O'))
                {
                    choice = j+4;
                    break;
                }

            }
            if(choice != -1)
            {
                break;
            }

        }
        return choice;
    } 
}
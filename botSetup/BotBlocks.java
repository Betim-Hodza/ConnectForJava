package botSetup;
import java.util.Random;

/*** [BotBlocks]
* This method is to block the user in rows, columns and diags
* 
* @ Author
* Bryan Lucio
***/
public class BotBlocks 
{
    /* [makeMovCol]
        Makes a move to block the player by the column based on where the user place their coin

        @ Authors
        Bryan Lucio
    */
    static int makeMoveCol(char [][] board, int usercol, int column, int row, int choice, Random rand)
    {
       
       switch(usercol)//Choose position to block column
        {
            case 1:
            {
                for(int i = 5; i>2;i--)
                {
                    if(board[i][usercol-1] == 'X' && board[i-1][usercol-1] == 'X' && board[i-2][usercol-1] == 'X' && board[i-3][usercol-1] == '-')
                    {
                        choice = 1;
                        break;
                    }
                }
                break;
            }
            case 2:
            {
                for(int i = 5;i>2;i--)
                {
                    if(board[i][usercol-1] == 'X' && board[i-1][usercol-1] == 'X' && board[i-2][usercol-1] == 'X' && board[i-3][usercol-1] == '-')
                    {
                        choice = 2;
                        break;
                    }
                }
                break;
            }
            case 3:
            {
                for(int i = 5 ; i>2; i--)
                {
                    if(board[i][usercol-1] == 'X' && board[i-1][usercol-1] == 'X' && board[i-2][usercol-1] == 'X' && board[i-3][usercol-1] == '-')
                    {
                        choice = 3;
                        break;
                    }
                }
                break;
            }
            case 4:
            {
                for(int i = 5;i>2;i--)
                {
                    if(board[i][usercol-1] == 'X' && board[i-1][usercol-1] == 'X' && board[i-2][usercol-1] == 'X' && board[i-3][usercol-1] == '-')
                    {
                        choice = 4;
                        break;
                    }
                } 
                break;
            }
            case 5:
            {
                for(int i = 5;i>2;i--)
                {
                    if(board[i][usercol-1] == 'X' && board[i-1][usercol-1] == 'X' && board[i-2][usercol-1] == 'X' && board[i-3][usercol-1] == '-')
                    {
                        choice = 5;
                        break;
                    }
                }
                break;
            }
            case 6:
            {            
                for(int i = 5;i>2;i--)
                {
                    if(board[i][usercol-1] == 'X' && board[i-1][usercol-1] == 'X' && board[i-2][usercol-1] == 'X' && board[i-3][usercol-1] == '-')
                    {
                        choice = 6;
                        break;
                    }
                }
                break;
            }
            case 7:
            {
                for(int i = 5;i>2;i--)
                {
                    if(board[i][usercol-1] == 'X' && board[i-1][usercol-1] == 'X' && board[i-2][usercol-1] == 'X' && board[i-3][usercol-1] == '-')
                    {
                        choice = 7;
                        break;
                    }
                }
                break;
            }
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
    
    
    /* [makeMovRow]
        Makes a move to block the player by the row based on where the user place their coin

        @ Authors
        Bryan Lucio
        Erik Guerrero
    */
    static int makeMoveRow(char [][] board, int usercol, int column, int row, int choice, Random rand)
    {
        for(int i=0; i<6;i++)//Chech Row
        {
            for(int j=0; j < 4;j++)
            {
                if(i==5)
                {
                    if(board[i][j] == 'X' && board[i][j+1] == 'X' && board[i][j+2] == 'X' && board[i][j+3] == '-')
                    {
                        choice = j+4;
                
                    }
                    else if(j != 0 && board[i][j] == 'X' && board[i][j+1] == 'X' && board[i][j+2] == 'X' && board[i][j+3] == 'O' && board[i-1][j-1] == '-')
                    {
                        choice = j;
                        
                    }
                    else if(board[i][j] == 'X' && board[i][j+1] == '-' && board[i][j+2] == 'X' && board[i][j+3] == 'X')
                    {
                        choice = j+2;
                        
                    }
                    else if(board[i][j] == 'X' && board[i][j+1] == 'X' && board[i][j+2] == '-' && board[i][j+3] == 'X')
                    {
                        choice = j+3;      
                    }
                    else if(board[i][j] == '-' && board[i][j+1] == 'X' && board[i][j+2] == 'X' && board[i][j+3] == 'X')
                    {
                        choice = j+1;  
                    }
                }
                else if(i==0)
                {
                    if(board[i][j] == 'O' && board[i][j+1] == 'O' && board[i][j+2] == 'O' && board[i][j+3] == '-' && (board[i+1][j+3] == 'X'|| board[i+1][j+3] == 'O'))
                    {
                        choice = j+4;
                        
                    }
                    else if(board[i][j] == 'O' && board[i][j+1] == 'O' && board[i][j+2] == 'O' && board[i][j+3] == 'X' && (board[i+1][j-1] == 'X'|| board[i+1][j-1] == 'O'))
                    {
                        choice = j;
                            
                    }
                    else if(board[i][j] == 'O' && board[i][j+1] == '-' && board[i][j+2] == 'O' && board[i][j+3] == 'O' && (board[i+1][j+1] == 'X'|| board[i+1][j+1] == 'O'))
                    {
                        choice = j+2;
                        
                    }
                    else if(board[i][j] == 'O' && board[i][j+1] == 'O' && board[i][j+2] == '-' && board[i][j+3] == 'O' && (board[i+1][j+2] == 'X'|| board[i+1][j+2] == 'O'))
                    {
                        choice = j+3;
                        
                    }
                    else if(board[i][j] == '-' && board[i][j+1] == 'O' && board[i][j+2] == 'O' && board[i][j+3] == 'O' && (board[i+1][j] == 'X'|| board[i+1][j] == 'O'))
                    {
                        choice = j+1;  
                    }
                }
                else
                {
                    if(board[i][j] == 'X' && board[i][j+1] == 'X' && board[i][j+2] == 'X' && board[i][j+3] == '-' && (board[i+1][j+3] == 'X'|| board[i+1][j+3] == 'O') && board[i-1][j+3] == '-')
                    {
                        choice = j+4;
                        
                    }
                    else if(j != 0 && board[i][j] == 'X' && board[i][j+1] == 'X' && board[i][j+2] == 'X' && board[i][j+3] == 'O' && (board[i+1][j-1] == 'X'|| board[i+1][j-1] == 'O')  && board[i-1][j-1] == '-')
                    {
                        choice = j;
                        
                    }
                    else if(board[i][j] == 'X' && board[i][j+1] == '-' && board[i][j+2] == 'X' && board[i][j+3] == 'X' && (board[i+1][j+1] == 'X'|| board[i+1][j+1] == 'O') && board[i-1][j+1] == '-')
                    {
                        choice = j+2;
                        
                    }
                    else if(board[i][j] == 'X' && board[i][j+1] == 'X' && board[i][j+2] == '-' && board[i][j+3] == 'X' && (board[i+1][j+2] == 'X'|| board[i+1][j+2] == 'O')  && board[i-1][j+2] == '-' )
                    {
                        choice = j+3;
                        
                    }
                    else if(board[i][j] == '-' && board[i][j+1] == 'X' && board[i][j+2] == 'X' && board[i][j+3] == 'X' && (board[i+1][j] == 'X'|| board[i+1][j] == 'O')  && board[i-1][j] == '-')
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
    
    
    /* [makeMovDiagUp]
        Makes a move to block the player diagnolly up based on where the user place their coin

        @ Authors
        Bryan Lucio
    */
    static int makeMoveDiagUp(char [][] board, int usercol, int column, int row, int choice, Random rand)
    {
        for(int i=3; i<row;i++)
        {
            for(int j=0; j<column-3;j++)
            {
                if( i != 5 && board[i][j] == '-' && board[i-1][j+1] == 'X' && board[i-2][j+2] == 'X' && board[i-3][j+3]== 'X' && (board[i+1][j] == 'X' || board[i+1][j] == 'O'))
                {
                    choice = j+1;
                    break;
                }
                else if(i == 5 && board[i][j] == '-' && board[i-1][j+1] == 'X' && board[i-2][j+2] == 'X' && board[i-3][j+3]== 'X')
                {
                    choice = j+1;
                    break;
                }
                else if(board[i][j] == 'X' && board[i-1][j+1] == '-' && board[i-2][j+2] == 'X' && board[i-3][j+3]== 'X' && (board[i][j+1] == 'X' || board[i][j+1] == 'O'))
                {
                    choice = j+2;
                    break;
                }
                else if(board[i][j] == 'X' && board[i-1][j+1] == 'X' && board[i-2][j+2] == '-' && board[i-3][j+3]== 'X' && (board[i-1][j+2] == 'X' || board[i-1][j+2] == 'O'))
                {
                    choice = j+3;
                    break;
                }
                else if(board[i][j] == 'X' && board[i-1][j+1] == 'X' && board[i-2][j+2] == 'X' && board[i-3][j+3]== '-' && (board[i-2][j+3] == 'X' || board[i-2][j+3] == 'O'))
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
    
    
    /* [makeMovDiagdown]
        Makes a move to block the player diagnolly down based on where the user place their coin

        @ Authors
        Bryan Lucio
    */
    static int makeMoveDiagDown(char [][] board, int usercol, int column, int row, int choice, Random rand)
    {
        for(int i=0; i<row-3;i++)
        {
            for(int j=0; j<column-3;j++)
            {
                if(board[i][j] == '-' && board[i+1][j+1] == 'X' && board[i+2][j+2] == 'X' && board[i+3][j+3]== 'X' && (board[i+1][j] == 'X' || board[i+1][j] == 'O'))
                {
                    choice = j+1;
                    break;
                }
                else if(board[i][j] == 'X' && board[i+1][j+1] == '-' && board[i+2][j+2] == 'X' && board[i+3][j+3]== 'X' && (board[i+2][j+1] == 'X' || board[i+2][j+1] == 'O'))
                {
                    choice = j+2;
                    break;
                }
                else if(board[i][j] == 'X' && board[i+1][j+1] == 'X' && board[i+2][j+2] == '-' && board[i+3][j+3]== 'X' && (board[i+3][j+2] == 'X' || board[i+3][j+2] == 'O'))
                {
                    choice = j+3;
                    break;
                }
                else if(i+3 == 5 && board[i][j] == 'X' && board[i+1][j+1] == 'X' && board[i+2][j+2] == 'X' && board[i+3][j+3]== '-')
                {
                    choice = j+4;
                    break;
                }
                else if( board[i][j] == 'X' && board[i+1][j+1] == 'X' && board[i+2][j+2] == 'X' && board[i+3][j+3]== '-'  && (board[i+3][j+3] == 'X' || board[i+3][j+3] == 'O'))
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

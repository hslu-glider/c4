/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GameModel;



/**
 *
 * @author Jan
 */
public class PlayBoard implements GameRulez
{
    private static final int xaxes=7;
    private static final int yaxes=6;
    private Chip[][] playBoard;
    
    public PlayBoard() 
    {
        playBoard = new Chip[yaxes][xaxes];
    }
    
    public PlayBoard(Chip playBoard[][]) 
    {
        this.playBoard = playBoard;
    }
    
    
    @Override
    public boolean didIWin() 
    {
       for(Chip[] s : playBoard)
       {
           for(Chip val: s)
           {
               if(val.getWinnstone())
               {
                   return true;
               }
           }
       }
    return false;    
    }

    @Override
    public Chip[][] getBoard() 
    {
        return playBoard;
    }

    @Override
    public Chip getSlot(int row, int col) 
    {
            return playBoard[row][col];   
    }

    @Override
    public boolean isLegalInsert(int col) 
    {
        boolean stat=false;
        if(0<=col && col<7)
        {
        if (getSlot(0,col) == null)
           {
               stat = true;
           }
        }
        return stat;
    }

    @Override
    public void clearboard() 
    {
        playBoard = new Chip[yaxes][xaxes];
    }

    @Override
    public boolean isMyTurn() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean insertChip() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

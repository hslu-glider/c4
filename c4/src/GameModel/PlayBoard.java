/*
 *  C4 - Connect Four
 *  Copyright (C) 2014 by Ervin Mazlagic, Jan Vonmoos, Alain Studhalter,
 *  Michael Müller, Lukas Luthiger
 * 
 *  This program is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation; either version 2 of the License, or
 *  (at your option) any later version.
 * 
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *  
 *  You should have received a copy of the GNU General Public License along
 *  with this program; if not, write to the Free Software Foundation, Inc.,
 *  51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 */

package GameModel;

import java.awt.event.ActionEvent;


/**
 *
 * @author JanV Vonmoos
 */
public class PlayBoard implements GameRulez
{
    private static final int xaxes=7;
    private static final int yaxes=6;
    private Chip[][] playBoard;
    private boolean currentuser=true;
    
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
               if(val != null)
               {
                    if(val.getWinnstone())
                    {
                        return true;
                    }
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
        if(0<=col && col<7)
        {
        if (getSlot(0,col) == null)
           {
               return true;
           }
        }
        return false;
    }

    @Override
    public void clearboard() 
    {
        playBoard = new Chip[yaxes][xaxes];
    }

    @Override
    public boolean isMyTurn() {
        return currentuser;
    }

    @Override
    public boolean insertChip(int player, int x) 
    {
        int y = 0;
        if(isMyTurn() && isLegalInsert(x))
        {
            for(int n=1;n<6 ;n++)
            {
                if(playBoard[n][x]==null)
                {
                    y++;   
                }
            }
            playBoard[y][x] = new Chip(player, x , y, playBoard);
            switchPlayer();
            return true;
        }
    return false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void switchPlayer() 
    {
        if(currentuser)
        {
            currentuser=false;
        }
        else
        {
            currentuser=true;
        }
    }
}

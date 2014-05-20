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

/**
 *
 * @author Jan Vonmoos
 */
public class Chip {
    
    private int owner;
    private int xcord;
    private int ycord;
    private boolean winnstone=false;
    private int nbrright=0;
    private int nbrleft=0;
    private int nbrbot=0;
    private int nbrdiagtopright=0;
    private int nbrdiagbotright=0;
    private int nbrdiagtopleft=0;
    private int nbrdiagbotleft=0;
    
   
    
    public Chip(int player, int x , int y, Chip PlayBoard[][])
    {
        owner = player;
        xcord = x;
        ycord = y;
        calculateNbr(PlayBoard);
        winnChip(PlayBoard);
    }
    
    public int calNbrR(Chip PlayBoard[][])
    {
        int count=0;
        if(this.xcord+1<7)
        {
            if(PlayBoard[this.ycord][this.xcord+1]!=null)
            {
                if((PlayBoard[this.ycord][this.xcord+1].getOwner()==this.owner))
                {
                    count++;
                    count += PlayBoard[this.ycord][this.xcord+1].calNbrR(PlayBoard);
                }
            }
        }
    this.nbrright=count;    
    return count;
    }
    
    
    public int calNbrL(Chip PlayBoard[][])
    {
        int count=0;
        if(this.xcord-1>=0)
        {
            if(PlayBoard[this.ycord][this.xcord-1]!=null)
            {
                if((PlayBoard[this.ycord][this.xcord-1].getOwner()==this.owner))
                {
                    count++;
                    count += PlayBoard[this.ycord][this.xcord-1].calNbrL(PlayBoard);

                }
            }
        }
    this.nbrleft=count;
    
    return count;
    }
    
    
    public int calNbrB(Chip PlayBoard[][])
    {
        int count=0;
        if(this.ycord+1<6)
        {
            if(PlayBoard[this.ycord+1][this.xcord]!=null)
            {
                if((PlayBoard[this.ycord+1][this.xcord].getOwner()==this.owner))
                {
                    count++;
                    count += PlayBoard[this.ycord+1][this.xcord].calNbrB(PlayBoard);
                }
            }
        }
    this.nbrbot=count;    
    return count;
    }
    
    
    public int calNbrDTR(Chip PlayBoard[][])
    {
        int count=0;
        if(this.xcord+1<7 && this.ycord-1>=0)
        {
            if(PlayBoard[this.ycord-1][this.xcord+1]!=null)
            {
                if((PlayBoard[this.ycord-1][this.xcord+1].getOwner()==this.owner))
                {
                    count++;
                    count += PlayBoard[this.ycord-1][this.xcord+1].calNbrDTR(PlayBoard);
                }
            }
        }
    this.nbrdiagtopright=count;    
    return count;
    }
    
    
    public int calNbrDBR(Chip PlayBoard[][])
    {
        int count=0;
        if(this.xcord+1<7 && this.ycord+1<6)
        {
            if(PlayBoard[this.ycord+1][this.xcord+1]!=null)
            {
                if((PlayBoard[this.ycord+1][this.xcord+1].getOwner()==this.owner))
                {
                    count++;
                    count += PlayBoard[this.ycord+1][this.xcord+1].calNbrDBR(PlayBoard);
                }
            }
        }
    this.nbrdiagbotright=count;    
    return count;
    }
    
    public int calNbrDTL(Chip PlayBoard[][])
    {
        int count=0;
        if(this.xcord-1>=0 && this.ycord-1>=0)
        {
            if(PlayBoard[this.ycord-1][this.xcord-1]!=null)
            {   
                if((PlayBoard[this.ycord-1][this.xcord-1].getOwner()==this.owner))
                {
                    count++;
                    count += PlayBoard[this.ycord-1][this.xcord-1].calNbrDTL(PlayBoard);
                }
            }
        }
    this.nbrdiagtopleft=count;    
    return count;
    }
    
    public int calNbrDBL(Chip PlayBoard[][])
    {
        int count=0;
        if(this.xcord-1>=0 && this.ycord+1<6)
        {
            if(PlayBoard[this.ycord+1][this.xcord-1]!=null)
            {
                if((PlayBoard[this.ycord+1][this.xcord-1].getOwner()==this.owner))
                {
                    count++;
                    count += PlayBoard[this.ycord+1][this.xcord-1].calNbrDBL(PlayBoard);
                }
            }
        }
    this.nbrdiagbotleft=count;    
    return count;
    }
    
    public void calculateNbr(Chip PlayBoard[][])
    {
        calNbrR(PlayBoard);
        calNbrL(PlayBoard);
        calNbrB(PlayBoard);
        calNbrDTR(PlayBoard);
        calNbrDBR(PlayBoard);
        calNbrDTL(PlayBoard);
        calNbrDBL(PlayBoard);
    }
    
    public void winnChip(Chip PlayBoard[][])
    {
        if(nbrright+nbrleft>=3)
        {
            setWinnstone();
            for(int n=nbrright;n>0;n--)
            {
                PlayBoard[this.ycord][this.xcord+n].setWinnstone();
            }
            for(int n=nbrleft;n>0;n--)
            {
                PlayBoard[this.ycord][this.xcord-n].setWinnstone();
            }
        }
        if(nbrbot>=3)
        {
            setWinnstone();
            for(int n=nbrbot;n>0;n--)
            {
                PlayBoard[this.ycord+n][this.xcord].setWinnstone();
            }
            
        }
        if(nbrdiagtopright+nbrdiagbotleft>=3)
        {
            setWinnstone();
            for(int n=nbrdiagtopright;n>0;n--)
            {
                PlayBoard[this.ycord-n][this.xcord+n].setWinnstone();
            }
            for(int n=nbrdiagbotleft;n>0;n--)
            {
                PlayBoard[this.ycord+n][this.xcord-n].setWinnstone();
            }
            
        }
        if(nbrdiagtopleft+nbrdiagbotright>=3)
        {
            setWinnstone();
            for(int n=nbrdiagtopleft;n>0;n--)
            {
                PlayBoard[this.ycord-n][this.xcord-n].setWinnstone();
            }
            for(int n=nbrdiagbotright;n>0;n--)
            {
                PlayBoard[this.ycord+n][this.xcord+n].setWinnstone();
            }
            
        }
       
    }

    public int getOwner() {
        return owner;
    }

    public void setWinnstone()
    {
        this.winnstone = true;
    }
    public boolean getWinnstone()
    {
        return this.winnstone;
    }
}

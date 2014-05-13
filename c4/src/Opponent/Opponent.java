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
package Opponent;

/**
 * @author Michael Müller michael.mueller.02@stud.hslu.ch
 */
public class Opponent {
    
    public final static int LOCAL = 1;
    public final static int NETWORK = 2;
    private final static int DEFAULT_LEVEL = 3;
    private int opponent;
    private C4_KI ki;
    
    public Opponent(int opponent){
        this.opponent = opponent;
        if(opponent == LOCAL){
            ki = new C4_KI(DEFAULT_LEVEL);
        }
    }
    
    public Opponent(int opponent, int level){
        this.opponent = opponent;
        if(opponent == LOCAL){
            ki = new C4_KI(level);
        }
        addModelListener(this);
    }
    
    @Override
    public void UserMadeMove(ModelEvent e){
        int userMove = 0;
        int kiMove = 0;
        if(opponent == NETWORK){
            GameControl.getNetworkMove();
        }
        else if(opponent == LOCAL){
            kiMove = ki.KI_makeNextMove(userMove);
            GameControl.nextKiMove(kiMove);
        }
    }
}

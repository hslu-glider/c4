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

import java.awt.Color;

/**
 * @author Michael Müller michael.mueller.02@stud.hslu.ch
 */
public class Disc {
    public final static int NONE = 0;
    public final static int USER = 1;
    public final static int KI = 2;
    
    private int player;   //1: User, 2: KI
    
    public Disc(int player){
        this.player = player;
    }
    
    public int getDiscPlayer(){
        if(this == null){
            return 0;
        }
        return player;
    }
    
    public static Disc[][] placeUserDisc(int row, Disc gameField[][]){
        if(row >= 0 && row < 7){
            for(int i = 0; i < 6; i++){
                if(gameField[row][i] == null){
                    gameField[row][i] = new Disc(Disc.USER);
                    break;
                }
            }
        }
        return gameField;
    }
    
    public static Disc[][] placeKIDisc(int row, Disc gameField[][]){
        if(row >= 0 && row < 7){
            for(int i = 0; i < 6; i++){
                if(gameField[row][i] == null){
                    gameField[row][i] = new Disc(Disc.KI);
                    break;
                }
            }
        }
        return gameField;
    }
    
    public static Disc[][] removeUserDisc(int row, Disc gameField[][]){
        if(row >= 0 && row < 7){
            for(int i = 5; i >= 0; i--){
                if(gameField[row][i] != null){
                    gameField[row][i] = null;
                    break;
                }
            }
        }
        return gameField;
    }
    
    public static Disc[][] removeKIDisc(int row, Disc gameField[][]){
        if(row >= 0 && row < 7){
            for(int i = 5; i >= 0; i--){
                if(gameField[row][i] != null){
                    gameField[row][i] = null;
                    break;
                }
            }
        }
        return gameField;
    }
}

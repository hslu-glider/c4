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
public class Plot {
    
    public static void plot_GameField(Disc gameField[][]){
        // Testausgabe --------------------------
        System.out.println("");
        System.out.println("1 2 3 4 5 6 7");
        for(int i = 5; i >= 0; i--){
            for(int j = 0; j < 7; j++){
                if(gameField[j][i] != null){
                    if(gameField[j][i].getDiscPlayer() == Disc.USER){
                        System.out.print("o ");
                    }
                    else if(gameField[j][i].getDiscPlayer() == Disc.KI){
                        System.out.print("x ");
                    }
                }
                else{
                    System.out.print("- ");
                }
            }
            System.out.print("\n");
        }
        // Testausgabe --------------------------
    }
    
    public static void plot_value(int row, int value){
        System.out.println("Row " + row + ": " + value);
    }
}

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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Michael Müller michael.mueller.02@stud.hslu.ch
 */
public class C4_KI {
    private Alpha_Beta_Cut abc;
    private Disc gameField[][];
    
    public C4_KI(int level){
        gameField = new Disc[7][6];
        abc = new Alpha_Beta_Cut(level, gameField);
    }
    
    /*
     * return 
     */
    public int KI_makeNextMove(int row_user){
        int row;
        gameField = Disc.placeUserDisc(row_user, gameField);
        if(Eval.eval(gameField) < -500){
            return 10;
        }
        abc.updateGameField(gameField);
        row = abc.getNextRow();
        if (row != -1){
            gameField = Disc.placeKIDisc(row, gameField);
            if(Eval.eval(gameField) > 500){
                return 20;
        }
        }
        /*-----------------------------*/
        Plot.plot_GameField(gameField);   // for Tests
        /*-----------------------------*/
        return row;
    }
    
    /**
     * main for Tests
     * @param args the command line arguments
     */
    /*
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int eingabe = 0;   
        int res;
        int level = 4;      // Level 1-4
        
        C4_KI ki = new C4_KI(level);
        
        while(true){
        try{
            eingabe = br.read() - 48;
        }
        catch (IOException e){}
        if(eingabe == 9){
            break;
        }
        if(eingabe >= 0 && eingabe < 7){
            res = ki.KI_makeNextMove(eingabe);
            if(res == 10){
                System.out.println("Du hast gewonnen :)!!!");
            }
            else if(res == 20){
                System.out.println("Compuer hat gewonnen, du loser!");
            }
        }
        try{
            eingabe = br.read() - 48;
        }
        catch (IOException e){}
        }
    }
    * */
}
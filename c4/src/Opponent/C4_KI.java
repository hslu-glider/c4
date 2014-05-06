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

    private final static int neg_inf = Integer.MIN_VALUE;
    private final static int pos_inf = Integer.MAX_VALUE;
    private int level;
    private int savedRow;
    private int actRowKi;
    private int actRowUser;
    private Disc gameField[][];
    
    public C4_KI(int level){
        this.level = level;
        gameField = new Disc[7][6];
        savedRow = 0;
        actRowKi = 0;
        actRowUser = 0;
    }
    
    public int KI_makeNextMove(int row_user){
        placeUserDisc(row_user);
        alpha_beta_cut();
        placeKIDisc(savedRow);
        plot_GameField();   // for Tests
        return savedRow;
    }
    
    private void placeUserDisc(int row){
        if(row >= 0 && row < 7){
            for(int i = 0; i < 6; i++){
                if(gameField[row][i] == null){
                    gameField[row][i] = new Disc(Disc.USER);
                    break;
                }
            }
        }
    }
    
    private void placeKIDisc(int row){
        if(row >= 0 && row < 7){
            for(int i = 0; i < 6; i++){
                if(gameField[row][i] == null){
                    gameField[row][i] = new Disc(Disc.KI);
                    break;
                }
            }
        }
    }
    
    private void removeUserDisc(int row){
        if(row >= 0 && row < 7){
            for(int i = 5; i >= 0; i--){
                if(gameField[row][i] != null){
                    gameField[row][i] = null;
                    break;
                }
            }
        }
    }
    
    private void removeKIDisc(int row){
        if(row >= 0 && row < 7){
            for(int i = 5; i >= 0; i--){
                if(gameField[row][i] != null){
                    gameField[row][i] = null;
                    break;
                }
            }
        }
    }
    
    private void alpha_beta_cut(){
        savedRow = 0;
        actRowKi = -1;
        actRowUser = -1;
        max(level, neg_inf, pos_inf);
    }

    private int max(int depth, int alpha, int beta) {    
        int maxValue;
        int value;
        if (depth == 0 || actRowKi == 7){
            return eval();
        }
        maxValue = alpha;    
        actRowKi = setNextRow(actRowKi);
        while (actRowKi <= 6) {
            placeKIDisc(actRowKi);
            value = min(depth - 1, maxValue, beta);   
            plot_value(actRowKi, value);      // for Tests
            removeKIDisc(actRowKi);
            if (value > maxValue) {
                maxValue = value;
                if (maxValue >= beta){          
                    break;    
                }
                if (depth == level){
                    savedRow = actRowKi;
                }
            }
            actRowKi = setNextRow(actRowKi);
        }
        return maxValue;
     }

    private int min(int depth, int alpha, int beta) { 
        int minValue;
        int value;
        
        if (depth == 0 || actRowUser == 7){
            return eval();
        }
        minValue = beta;    
        actRowUser = setNextRow(actRowUser);
        while (actRowUser <= 6) {
            placeUserDisc(actRowUser);
            value = max(depth - 1, alpha, minValue); 
            removeUserDisc(actRowUser);
            if (value < minValue) {
                minValue = value;
                if (minValue <= alpha){
                    break;
                }       
            }
            actRowUser = setNextRow(actRowUser);
        }
        return minValue;
    }

    private int eval(){
        int sum = 0;
        int user = 0;
        int none_ki = 0;
        int none_user = 0;
        int ki = 0;
        int user_sum = 0;
        int ki_sum = 0;
        int ki_end = 0;     // Züge zum beenden
        int user_end = 0;
        //sum = (int)(Math.random() * 7);       // Random-KI
        
/*----vertikales Evaluieren----*/
        for(int i = 0; i < 7; i++){
            for(int j = 0; j < 6; j++){
                if(gameField[i][j] != null){
                    if(gameField[i][j].getDiscPlayer() == Disc.KI){
                        if(user_end == 4){
                            user_sum = 1000;            // nur 1000 um Overflow zu vermeiden
                        }
                        else if(user + none_user >= 4){           //es muss eine Viererreihe möglich sein
                            if(user * 5 + none_user > user_sum){    // Gewichtung
                                user_sum = user * 5 + none_user;
                            }
                        }
                        user = 0;
                        user_end = 0;
                        none_user = 0;
                        ki++;
                        ki_end++;
                    }
                    else if(gameField[i][j].getDiscPlayer() == Disc.USER){
                        if(ki_end == 4){
                            ki_sum = 1000;
                        }
                        else if(ki + none_ki >= 4){
                            if(ki * 5 + none_ki > ki_sum){
                                ki_sum = ki * 5 + none_ki;
                            }
                        }
                        ki = 0;
                        none_ki = 0;
                        ki_end = 0;
                        user++;
                        user_end++;
                    }
                }
                else{
                    none_ki++;
                    none_user++;
                    ki_end = 0;
                    user_end = 0;
                }
            }
            if(ki + none_ki >= 4){
                if(ki * 5 + none_ki > ki_sum){
                    ki_sum = ki * 5 + none_ki;
                }
            }
            if(user + none_user >= 4){
                if(user * 5 + none_user > user_sum){
                    user_sum = user * 5 + none_user;
                }
            }
            if(ki_end == 4){
                ki_sum = 1000;
            }
            if(user_end == 4){
                user_sum = 1000;
            }
            sum = sum + (ki_sum - user_sum);
            ki_sum = 0;
            user_sum = 0;
        }
/*----horizontales Evaluieren----*/
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 7; j++){
                if(gameField[j][i] != null){
                    if(gameField[j][i].getDiscPlayer() == Disc.KI){
                        if(user_end == 4){
                            user_sum = 1000;
                        }
                        else if(user + none_user >= 4){           //es muss eine Viererreihe möglich sein
                            if(user * 5 + none_user > user_sum){    // Gewichtung
                                user_sum = user * 5 + none_user;
                            }
                        }
                        user = 0;
                        user_end = 0;
                        none_user = 0;
                        ki++;
                        ki_end++;
                    }
                    else if(gameField[j][i].getDiscPlayer() == Disc.USER){
                        if(ki_end == 4){
                            ki_sum = 1000;
                        }
                        else if(ki + none_ki >= 4){
                            if(ki * 5 + none_ki > ki_sum){
                                ki_sum = ki * 5 + none_ki;
                            }
                        }
                        ki = 0;
                        none_ki = 0;
                        ki_end = 0;
                        user++;
                        user_end++;
                    }
                }
                else{
                    none_ki++;
                    none_user++;
                    ki_end = 0;
                    user_end = 0;
                }
            }
            if(ki + none_ki >= 4){
                if(ki * 5 + none_ki > ki_sum){
                    ki_sum = ki * 5 + none_ki;
                }
            }
            if(user + none_user >= 4){
                if(user * 5 + none_user > user_sum){
                    user_sum = user * 5 + none_user;
                }
            }
            if(ki_end == 4){
                ki_sum = 1000;
            }
            if(user_end == 4){
                user_sum = 1000;
            }
            sum = sum + (ki_sum - user_sum);
            ki_sum = 0;
            user_sum = 0;
        }
        return sum;
    }

    private int setNextRow(int actRow){
        do{
            actRow++;   
            if(actRow > 6){
                break;
            }
        }
        while(gameField[actRow][5] != null);
        return actRow;
    }
    
    
    private void plot_GameField(){
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
    
    private void plot_value(int row, int value){
        System.out.println("Row " + row + ": " + value);
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int eingabe = 0;    
        C4_KI ki = new C4_KI(1);
        
        while(true){
        try{
            eingabe = br.read() - 48;
        }
        catch (IOException e){}
        if(eingabe == 9){
            break;
        }
        if(eingabe >= 0 && eingabe < 7){
            ki.KI_makeNextMove(eingabe);
        }
        try{
            eingabe = br.read() - 48;
        }
        catch (IOException e){}
        }
    }
}
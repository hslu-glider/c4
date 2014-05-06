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
package c4_ki;

/**
 *
 * @author Michael Müller michael.mueller.02@stud.hslu.ch
 * 
 */
public class C4_KI {

    private final static int neg_inf = Integer.MIN_VALUE;
    private final static int pos_inf = Integer.MAX_VALUE;
    private int level;
    private int savedRow;
    private int actRowKi;
    private int actRowUser;
    
    
    public C4_KI(int level){
        this.level = level;
    }
    
    public int KI_makeNextMove(int row_user){
        int row_ki = 0;
        alpha_beta_cut();
        return row_ki;
    }
    
    private int alpha_beta_cut(){
        savedRow = 0;
        max(level, neg_inf, pos_inf);
        return savedRow + 1;
    }

    private int max(int depth, int alpha, int beta) {    
        int maxValue;
        int value;
        if (depth == 0 || actRowKi == 7){
            return eval();
        }
        maxValue = alpha;    
        actRowKi = 0;
        while (actRowKi <= 6) {
            actRowKi++;
            value = min(depth - 1, maxValue, beta);       
            actRowKi--;
            if (value > maxValue) {
                maxValue = value;
                if (maxValue >= beta){          
                    break;    
                }
                if (depth == 0){
                    savedRow = actRowKi;
                }
            }
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
        actRowUser = 0;
        while (actRowUser <= 6) {
            actRowUser++;
            value = max(depth - 1, alpha, minValue);       
            actRowUser--;
            if (value < minValue) {
                minValue = value;
                if (minValue <= alpha){
                    break;
                }       
            }
        }
        return minValue;
    }

    private int eval(){
        return 0;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        C4_KI ki = new C4_KI(1);
        ki.KI_makeNextMove(1);
    }
}

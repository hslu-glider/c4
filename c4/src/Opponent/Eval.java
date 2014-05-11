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
public class Eval {
    private final static int ROWS = 7;
    private final static int COLS = 6;
    
    private final static int USER_MUL = -3000;
    private final static int KI_MUL = 1000;
    
    public static int eval(Disc gameField[][]){
        int sum = 0;
                
        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLS; j++){
                sum += getNbrRight(gameField, i, j);
                sum += getNbrDiagRight(gameField, i, j);
                sum += getNbrUp(gameField, i, j);
                sum += getNbrDiagLeft(gameField, i, j);
            }
        }
        return sum;
    }
    
    private static int getNbrRight(Disc gameField[][], int row, int col){
        int sum = 0;
        if(row <= 3 && gameField[row][col] != null){
            if(gameField[row][col].getDiscPlayer() == Disc.KI){
                do{
                    row++;
                    sum++;
                    if(sum >= 4){
                        sum = KI_MUL;
                    }
                    if(row > 6 || gameField[row][col] == null){
                        break;
                    }
                }
                while(gameField[row][col].getDiscPlayer() == Disc.KI);
            }
            else{
                do{
                    row++;
                    sum--;
                    if(sum <= -4){
                        sum = USER_MUL;
                    }
                    if(row > 6 || gameField[row][col] == null){
                        break;
                    }
                }
                while(gameField[row][col].getDiscPlayer() == Disc.USER);               
            }
        }
        return sum;
    }
    
    private static int getNbrDiagRight(Disc gameField[][], int row, int col){
        int sum = 0;
        if(row <= 3 && col <= 2 && gameField[row][col] != null){
            if(gameField[row][col].getDiscPlayer() == Disc.KI){
                do{
                    row++;
                    col++;
                    sum++;
                    if(sum >= 4){
                        sum = KI_MUL;
                    }
                    if(row > 6 || col > 5 || gameField[row][col] == null){
                        break;
                    }
                }
                while(gameField[row][col].getDiscPlayer() == Disc.KI);
            }
            else{
                do{
                    row++;
                    col++;
                    sum--;
                    if(sum <= -4){
                        sum = USER_MUL;
                    }
                    if(row > 6 || col > 5 || gameField[row][col] == null){
                        break;
                    }
                }
                while(gameField[row][col].getDiscPlayer() == Disc.USER);               
            }
        }
        return sum;
    }

    private static int getNbrUp(Disc gameField[][], int row, int col){
        int sum = 0;
        if(col <= 2 && gameField[row][col] != null){
            if(gameField[row][col].getDiscPlayer() == Disc.KI){
                do{
                    col++;
                    sum++;
                    if(sum >= 4){
                        sum = KI_MUL;
                    }
                    if(col > 5 || gameField[row][col] == null){
                        break;
                    }
                }
                while(gameField[row][col].getDiscPlayer() == Disc.KI);
            }
            else{
                do{
                    col++;  
                    sum--;
                    if(sum <= -4){
                        sum = USER_MUL;
                    }
                    if(col > 5 || gameField[row][col] == null){
                        break;
                    }
                }
                while(gameField[row][col].getDiscPlayer() == Disc.USER);               
            }
        }
        return sum;
    }
    
    private static int getNbrDiagLeft(Disc gameField[][], int row, int col){
        int sum = 0;
        if(row >= 3 && col <= 2 && gameField[row][col] != null){
            if(gameField[row][col].getDiscPlayer() == Disc.KI){
                do{
                    row--;
                    col++;
                    sum++;
                    if(sum >= 4){
                        sum = KI_MUL;
                    }
                    if(col > 5 || row < 0 || gameField[row][col] == null){
                        break;
                    }
                }
                while(gameField[row][col].getDiscPlayer() == Disc.KI);
            }
            else{
                do{
                    row--;
                    col++;
                    sum--;
                    if(sum <= -4){
                        sum = USER_MUL;
                    }
                    if(col > 5 || row < 0|| gameField[row][col] == null){
                        break;
                    }
                }
                while(gameField[row][col].getDiscPlayer() == Disc.USER);               
            }
        }
        return sum;
    }
}
   
    //Random KI
 /*       
        sum = (int)(Math.random() * ROWS);       // Random-KI
        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLS; j++){
                if(gameField[i][j] != null){
                    if(gameField[i][j].getDiscPlayer() == Disc.KI){
                        ki++;
                        if(ki == 4){
                            sum_ki = 1000;
                        }
                        user = 0;
                    }
                    else if(gameField[i][j].getDiscPlayer() == Disc.USER){
                        user++;
                        if(user == 4){
                            sum_user = 1000;
                        }
                        ki = 0;
                    }
                }
                else{
                    ki = 0;
                    user = 0;
                }
            }
        }
        sum = sum + (sum_ki - sum_user); 
        sum_ki = 0;
        sum_user = 0;
        for(int j = 0; j < COLS; j++){
            for(int i = 0; i < ROWS; i++){
                if(gameField[i][j] != null){
                    if(gameField[i][j].getDiscPlayer() == Disc.KI){
                        ki++;
                        if(ki == 4){
                            sum_ki = 1000;
                        }
                        user = 0;
                    }
                    else if(gameField[i][j].getDiscPlayer() == Disc.USER){
                        user++;
                        if(user == 4){
                            sum_user = 1000;
                        }
                        ki = 0;
                    }
                }
                else{
                    ki = 0;
                    user = 0;
                }
            }
        }
        sum = sum + (sum_ki - sum_user); 
        return sum;
    }
*/
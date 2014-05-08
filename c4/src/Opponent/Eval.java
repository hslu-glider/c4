/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Opponent;

/**
 *
 * @author Michael Müller michael.mueller.02
 * @stud.hslu.ch
 */
public class Eval {
    private final static int ROWS = 7;
    private final static int COLS = 6;
    
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
                    if(sum == 4){
                        sum = 1000;
                    }
                    if(row < 7){
                        break;
                    }
                    if(gameField[row][col] == null){
                        break;
                    }
                }
                while(gameField[row][col].getDiscPlayer() == Disc.KI);
            }
            else if(gameField[row][col].getDiscPlayer() == Disc.USER){
                do{
                    row++;
                    sum--;
                    if(sum == -4){
                        sum = -1000;
                    }
                    if(row < 7){
                        break;
                    }
                    if(gameField[row][col] == null){
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
        if(row <= 3 && col <= 4 && gameField[row][col] != null){
            if(gameField[row][col].getDiscPlayer() == Disc.KI){
                do{
                    row++;
                    col++;
                    sum++;
                    if(sum == 4){
                        sum = 1000;
                    }
                    if(row < 7){
                        break;
                    }
                    if(gameField[row][col] == null){
                        break;
                    }
                }
                while(gameField[row][col].getDiscPlayer() == Disc.KI);
            }
            else if(gameField[row][col].getDiscPlayer() == Disc.USER){
                do{
                    row++;
                    col++;
                    sum--;
                    if(sum == -4){
                        sum = -1000;
                    }
                    if(row < 7){
                        break;
                    }
                    if(gameField[row][col] == null){
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
                    if(sum == 4){
                        sum = 1000;
                    }
                    if(col < 6){
                        break;
                    }
                    if(gameField[row][col] == null){
                        break;
                    }
                }
                while(gameField[row][col].getDiscPlayer() == Disc.KI);
            }
            else if(gameField[row][col].getDiscPlayer() == Disc.USER){
                do{
                    col++;  
                    sum--;
                    if(sum == -4){
                        sum = -1000;
                    }
                    if(col < 6){
                        break;
                    }
                    if(gameField[row][col] == null){
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
        if(row >= 3 && col >= 4 && gameField[row][col] != null){
            if(gameField[row][col].getDiscPlayer() == Disc.KI){
                do{
                    row--;
                    col++;
                    sum++;
                    if(sum == 4){
                        sum = 1000;
                    }
                    if(col < 6){
                        break;
                    }
                    if(gameField[row][col] == null){
                        break;
                    }
                }
                while(gameField[row][col].getDiscPlayer() == Disc.KI);
            }
            else if(gameField[row][col].getDiscPlayer() == Disc.USER){
                do{
                    row--;
                    col++;
                    sum--;
                    if(sum == -4){
                        sum = -1000;
                    }
                    if(col < 6){
                        break;
                    }
                    if(gameField[row][col] == null){
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
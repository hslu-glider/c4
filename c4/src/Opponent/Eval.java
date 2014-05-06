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
    
    public static int eval(Disc gameField[][]){
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
}

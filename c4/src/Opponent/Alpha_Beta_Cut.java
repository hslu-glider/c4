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
public class Alpha_Beta_Cut {
    
    private final static int neg_inf = Integer.MIN_VALUE;
    private final static int pos_inf = Integer.MAX_VALUE;
    
    private int level;
    private int savedRow;
    private int actRowKi;
    private int actRowUser;
    private Disc gameField[][];
    
    public Alpha_Beta_Cut(int level, Disc gameField[][]){
        this.level = level;
        this.gameField = gameField;
        savedRow = 0;
        actRowKi = -1;
        actRowUser = -1;
    }
    
    public void updateGameField(Disc gF[][]){
        gameField = gF;
    }
    
    public int getNextRow(){
        savedRow = 0;
        actRowKi = -1;
        actRowUser = -1;
        max(level, neg_inf, pos_inf);
        return savedRow;
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
        
    private int max(int depth, int alpha, int beta) {    
        int maxValue;
        int value;
        if (depth == 0 || actRowKi == 7){
            return Eval.eval(gameField);
        }
        maxValue = alpha;    
        actRowKi = setNextRow(actRowKi);
        while (actRowKi <= 6) {
            gameField = Disc.placeKIDisc(actRowKi, gameField);
            value = min(depth - 1, maxValue, beta);   
            Plot.plot_value(actRowKi, value);      // for Tests
            gameField = Disc.removeKIDisc(actRowKi, gameField);
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
            return Eval.eval(gameField);
        }
        minValue = beta;    
        actRowUser = setNextRow(actRowUser);
        while (actRowUser <= 6) {
            gameField = Disc.placeUserDisc(actRowUser, gameField);
            value = max(depth - 1, alpha, minValue); 
            gameField = Disc.removeUserDisc(actRowUser, gameField);
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
}

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
public class Alpha_Beta_Cut {
    
    private final static int neg_inf = Integer.MIN_VALUE;
    private final static int pos_inf = Integer.MAX_VALUE;
    
    private int level;
    private int savedRow;
    private Disc gameField[][];
    private MoveNode head;
    
    public Alpha_Beta_Cut(int level, Disc gameField[][]){
        this.level = level * 2;
        this.gameField = gameField;
        savedRow = 0;
        head = null;
    }
    
    public void updateGameField(Disc gF[][]){
        gameField = gF;
    }
    
    public int getNextRow(){
        savedRow = -1;
        head = new MoveNode(0);
        max(level, neg_inf, pos_inf, head);
        return savedRow;
    }
        
    private int max(int depth, int alpha, int beta, MoveNode node) {    
        int maxValue;
        int value;
        if (depth == 0 || isGameFieldFull()){
            return Eval.eval(gameField);
        }
        maxValue = alpha;    
        generateMoves(node);
        for(int i = 0; i < 7; i++) {
            if(node.moveRow[i] != null){
                gameField = Disc.placeKIDisc(node.moveRow[i].getRow(), gameField);
                value = min(depth - 1, maxValue, beta, node.getNext(i));   
                /*-----------------------------*/
                //Plot.plot_value(node.moveRow[i].getRow(), value);      // for Tests
                /*-----------------------------*/
                gameField = Disc.removeKIDisc(node.moveRow[i].getRow(), gameField);
                if (value > maxValue) {
                    maxValue = value;
                    if (maxValue >= beta){          
                        break;    
                    }
                    if (depth == level){
                        savedRow = node.moveRow[i].getRow();
                    }
                }
            }
        }
        return maxValue;
     }

    private int min(int depth, int alpha, int beta, MoveNode node) { 
        int minValue;
        int value;
        
        if (depth == 0 || isGameFieldFull()){
            return Eval.eval(gameField);
        }
        minValue = beta;  
        generateMoves(node); 

        for(int i = 0; i < 7; i++) {
            if(node.moveRow[i] != null){
                gameField = Disc.placeUserDisc(node.moveRow[i].getRow(), gameField);
                value = max(depth - 1, alpha, minValue, node.getNext(i)); 
                gameField = Disc.removeUserDisc(node.moveRow[i].getRow(), gameField);
                if (value < minValue) {
                    minValue = value;
                    if (minValue <= alpha){
                        break;
                    }       
                }
            }
        }
        return minValue;
    }
    
    private void generateMoves(MoveNode node){
        for(int i = 0; i < 7; i++) {
            if(node.moveRow[i] == null){     
                if(gameField[i][5] == null){
                    node.moveRow[i] = new MoveNode(i);
                }
            }
            else{
                generateMoves(node.getNext(i));
            }
        }
    }
    
    private boolean isGameFieldFull(){
        for(int i = 0; i < 7; i++){      
            if(gameField[i][5] == null){
                return false;
            }
        }
        return true;
    }
}


/*
 *     private int setNextRow(int actRow){
        do{
            actRow++;   
            if(actRow > 6){
                break;
            }
        }
        while(gameField[actRow][5] != null);
        return actRow;
    }
    * 
 * private int max(int depth, int alpha, int beta) {    
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
 */
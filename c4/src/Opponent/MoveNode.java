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
public class MoveNode {
    private int row;
    MoveNode[] moveRow;
    
    public MoveNode(int row){
        this.row = row;
        moveRow = new MoveNode[7];
    }
    
    public int getRow(){
        return row;
    }
    
    public MoveNode getNext(int i){
        return moveRow[i];
    }
}

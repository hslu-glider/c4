package GameControl;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import GameControl.*;
import GameControl.network.Server;
import GameControl.parser.Parser;
import java.io.IOException;
import GameView.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author ninux
 */
public class Main {
	
    private static ActionListener gameboardlistener;
	private static Parser p;
    
	public static void main(String[] args) throws Exception {
		p = new Parser();
		
		
                gameboardlistener = new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent evt){
                        GUIActionPerformed(evt);
                    }
                };
                GameBoard g = new GameBoard(gameboardlistener);
                Control c = new Control(g);
                
	}
        
        private static void GUIActionPerformed(ActionEvent evt){
            System.out.println("Action Performed: "+evt.getActionCommand());
        }
	
}

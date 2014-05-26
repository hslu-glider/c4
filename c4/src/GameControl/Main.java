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

/**
 *
 * @author ninux
 */
public class Main {
	
	public static void main(String[] args) throws Exception {
		GameBoard g = new GameBoard();
		Parser p = new Parser();
		
		
		
		p.waitForPlayer();
		int temp = p.sendMove(2);
		System.out.println(temp);
		temp = p.sendMove(5);
		System.out.println(temp);
	}
	
}

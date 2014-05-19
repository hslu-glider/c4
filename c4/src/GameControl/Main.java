package GameControl;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import GameControl.*;
import GameControl.network.Server;
import java.io.IOException;

/**
 *
 * @author ninux
 */
public class Main {
	
	public static void main(String[] args) throws IOException{
		Server s = new Server();
		try {
			s.connectPlayer();
		} catch (Exception ex){
			System.err.println("Error: " + ex.getMessage());
		}
		
	}
	
}

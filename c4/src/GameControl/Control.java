
package GameControl;

import GameControl.parser.*;
import GameModel.PlayBoard;
import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ninux
 */
public class Control implements Communication {
	
	private PlayBoard board;
	// private SaveGame savedGame;
	
	private Parser parser;
	
	private static int LOCAL = 1;
	private static int REMOTE = 2;
	
	private int opponent = LOCAL;
	
	public Control() throws IOException{
		parser = new Parser();
		board = new PlayBoard();
		// savedGame = new SaveGame();
	}

	@Override
	public int setDisk(int row) {
		try {
			if(board.insertChip(LOCAL, row)){
				int answer = parser.sendMove(row);
				board.insertChip(REMOTE, answer);
				return answer;
			}
		} catch (Exception ex) {
			
		}
		return -1;
	}

	@Override
	public InetAddress findPlayers() {
		try {
			InetAddress temp = parser.searchPlayer();
			while(temp == null){
				temp = parser.searchPlayer();
			}
			return temp;
		} catch (Exception ex) {
			
		}
		return null;
	}

	@Override
	public int startGame(InetAddress player) {
		try {
			return parser.connectToPlayer(player);
		} catch (Exception ex) {
			
		}
		return -1;
	}

	@Override
	public boolean waitForNetworkPlayer() {
		try {
			return parser.waitForPlayer();
		} catch (Exception ex) {
			
		}
		return false;
	}

	@Override
	public void setMode(int mode) {
		if(mode >= 1 && mode <= 2){
			opponent = mode;
		}
		else {
			opponent = LOCAL;
		}
	}

	@Override
	public void loadGame() {
		// board = new Board(savedGame.loadGame);
	}
	
}

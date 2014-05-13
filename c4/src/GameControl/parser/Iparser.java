

package GameControl.parser;

import java.net.InetAddress;

/**
 *
 * @author ninux
 */
public interface Iparser {
	
	/**
	 * Look for a open TCP server.
	 * @return 
	 */
	public InetAddress searchPlayer();
	
	/**
	 * Waits for a broadcast from a client and sends back 
	 * Inet Adress for connection.
	 */
	public void waitForPlayer();
	
	public boolean connectToPlayer(InetAddress adr);
	
	public int sendMove(int row);
	
}

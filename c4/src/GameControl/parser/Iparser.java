

package GameControl.parser;

import java.net.InetAddress;
import java.net.SocketException;

/**
 *
 * @author ninux
 */
public interface Iparser {
	
	/**
	 * Look for a open TCP server.
	 * @return 
	 */
	public InetAddress searchPlayer() throws Exception;
	
	/**
	 * Waits for a broadcast from a client and sends back 
	 * Inet Adress for connection.
	 */
	public void waitForPlayer() throws Exception;
	
	public int connectToPlayer(InetAddress adr) throws Exception;
	
	public int sendMove(int row);
	
}

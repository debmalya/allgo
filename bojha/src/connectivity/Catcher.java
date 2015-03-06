package connectivity;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

/**
 * Catches the messages. To receive the message and to send response to Pitcher.
 * 
 * Catcher should listen a port.
 * 
 * @author
 * 
 */
public class Catcher {

	/**
	 * TCP socket listener bind address.
	 */
	// private String listenerBindAddress;

	/**
	 * To establish the socket connection between the Catcher and the Pitcher.
	 */
	private ServerSocket catcherSocket;

	/**
	 * Used for writing to Pitcher.
	 */
	private PrintWriter out = null;

	/**
	 * Used for reading from Pitcher.
	 */
	private BufferedReader in = null;

	/**
	 * This stores last received token.
	 */
	private byte lastToken = 0;

	/**
	 * This stores last time when Pitcher sends the message.
	 */
//	private long lastMessageReceivedAt = 0L;

	// /**
	// * TCP socket port which will be used for listen.
	// */
	// private int port;

	/**
	 * 
	 * 
	 * @param bindAddress
	 *            to listen.
	 * @param listenPort
	 *            to listen
	 */
	public Catcher(final String bindAddress, final int listenPort) {

		try {
			// creates a new Socket object
			catcherSocket = new ServerSocket(listenPort);
			System.out.println("Catcher listening on port :" + listenPort);
			Socket clientSocket = null;
			try {
				clientSocket = catcherSocket.accept();
				out = new PrintWriter(clientSocket.getOutputStream(), true);
				in = new BufferedReader(new InputStreamReader(clientSocket
						.getInputStream()));

				while (true) {
					read();
					write();
				}
			} catch (IOException e) {
				System.err.println("Accept failed on port:" + listenPort
						+ ". Aborting program. Bye.");
				System.exit(-1);
			}
		} catch (IOException e) {
			System.err.println("Could not listen on port: " + listenPort
					+ ". Aborting program. Bye.");
			System.exit(-1);
		}

	}

	/**
	 * 
	 */
	private void write() {
		byte[] genereatedMessage = generateMessage(lastToken,
				TCPPingConstants.getMsgLength());
		out.println(new String(genereatedMessage));
	}

	/**
	 * @throws IOException
	 */
	private void read() {
		 
		try {
			String message = in.readLine();
			byte[] receivedMessage = message.getBytes();
//			byte[] receivedMessage = (byte[])in.readLine();
			lastToken = receivedMessage[0];
			System.out.println("Last token received: " + lastToken);

		} catch (IOException ie) {
			System.err.println("My Dear Pitcher, "
					+ "I am not able to hear you. Are u OK?");
		}
	}
	
	/** This method generates fixed length byte message.
	 * @param token to be sent by the Pitcher to the Catcher.
	 * token received by the Catcher from Pitcher will be passed as argument.
	 * @param length of the array.
	 * @return generated message.
	 */
	private byte[] generateMessage(final byte token, 
			final int length) {
		
		byte[] message = new byte[length];
		message[0] = token;
		Arrays.fill(message, 1, length - 1, TCPPingConstants.PADDING_BYTE);
		return message;
	}

}

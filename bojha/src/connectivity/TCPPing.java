package connectivity;
/**
 * 
 */

/**
 * This program is meant for testing IP network and determining RTT (Round Trip
 * Time).
 * 
 * @author
 * 
 */
public class TCPPing {
	/**
	 * This constant is for defalt message size. Value 300.
	 */
	private static final int DEFAULT_MESSAGE_SIZE = 300;

	/**
	 * Miniumum message size. 50
	 */
	private static final int MINIMUM_MESSAGE_SIZE = 50;

	/**
	 * Maximum message size. 3000
	 */
	private static final int MAXIMUM_MESSAGE_SIZE = 3000;

	/**
	 * Whether running in pitcherMode or not? If true means running in
	 * pitcherMode.
	 * 
	 * In pitcher mode only throws message.
	 * 
	 * In catcher mode catches the messages and send response to the sender.
	 */
	private static boolean pitcherMode;

	/**
	 * TCP socket port which will be used for connect by pitcher. OR TCP socket
	 * port which will be used for listen by Catcher.
	 */
	private static int port;

	/**
	 * TCP socket listener bind address.
	 */
	private static String listernerAddress;

	/**
	 * This is to store message sending speed. Expressed in msgs/s. Default
	 * value is 1.
	 */
	private static int messageSendingSpeed = 1;

	/**
	 * Message size. Default value is 300.
	 */
	private static int messageSize = TCPPing.DEFAULT_MESSAGE_SIZE;

	/**
	 * Name of the computer on which catcher runs.
	 */
	private static String hostName;

	/**
	 * @param args
	 *            to specify program arguments.
	 */
	public static void main(final String[] args) {
		// Set program environment

		if (args.length == 0) {
			System.out.println("Usage: java TCPPing -c -bind <IP Address>"
					+ " -port <port>");
			System.out.println("Usage: java TCPPing -p -port <port> "
					+ "-mps <Message Speed> -size <Message Size>"
					+ " <Catcher computer name>");
			System.exit(1);
		}
		boolean isModeSet = false;
		for (int i = 0; i < args.length; i++) {

			// Detect mode Pitcher (-p) or Catcher (-c) ?
			if (args[i].equals("-c")) {
				// Works in catcher mode
				if (!isModeSet) {
					pitcherMode = false;
					isModeSet = true;
				} else {
					System.err.println("Already specified pitcher mode"
							+ " by specifying argument -p");
					System.exit(1);
				}
			}
			if (args[i].equals("-p")) {
				if (!isModeSet) {
					// Works in pitcher mode
					pitcherMode = true;
					isModeSet = true;
				} else {
					System.err.println("Already specified catcher mode"
							+ " by specifying argument -c");
					System.exit(1);
				}
			}

			// Stored port number. Required in both Catcher and Pitcher mode
			if (args[i].equals("-port")) {
				String portArg = null;
				try {
					portArg = args[++i];
					port = Integer.parseInt(portArg);
				} catch (NumberFormatException nfe) {
					System.err.println("Mentioned port '" + portArg
							+ " is not numeric.");
					System.exit(1);
				}
			}

			// Store listener address required if runs in catcher mode.
			if (args[i].equals("-bind")) {
				listernerAddress = args[++i];
			}

			// Store message sending speed
			if (args[i].equals("-mps")) {
				String mps = args[++i];
				try {
					messageSendingSpeed = Integer.parseInt(mps);
				} catch (NumberFormatException nfe) {
					System.err.println("-mps value '" + mps
							+ " is not numeric.");
					System.exit(1);
				}
			}

			// Store message size
			if (args[i].equals("-size")) {
				String size = args[++i];
				hostName = args[++i];
				try {
					messageSize = Integer.parseInt(args[++i]);
					// (Minimum 50, Maximum 3000, Default 300)
					if (messageSize > MAXIMUM_MESSAGE_SIZE) {
						messageSize = MAXIMUM_MESSAGE_SIZE;
					} else if (messageSize < MINIMUM_MESSAGE_SIZE) {
						messageSize = MINIMUM_MESSAGE_SIZE;
					}
				} catch (NumberFormatException nfe) {
					System.err.println("-size value '" + size
							+ " is not numeric.");
					System.exit(1);
				}
			}
		}
		TCPPingConstants.setMsgLength(messageSize);
		TCPPingConstants.setMsgSpeed(messageSendingSpeed);
		// All arguments are captured now validate them
		// Validation will be based on mode
		// port is required for both the mode
		if (port == 0) {
			System.err.println("Please mention a valid port number.");
			System.exit(1);
		}
		if (pitcherMode) {
			// pitcher mode mandatory inputs
			// port
			// name of the computer which Catcher runs
			// last argument will be always host name
			
			hostName = args[args.length - 1];
			new Pitcher(hostName, port, messageSendingSpeed, messageSize);
		} else {
			// For catcher mode mandatory inputs are bind parameter and port
			if (listernerAddress == null) {
				System.err.println("bind address is missing.");
				System.exit(1);
			}
			new Catcher(listernerAddress, port);
		}

	}

}

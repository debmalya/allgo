package connectivity;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//import org.apache.log4j.Logger;


/**
 * Picher throws messages. Calculates and display following statistics in every
 * second. Time - HH:MM:SS Total number of messages sent. Number of messages in
 * previous second (speed). Average sent time. Average response time. Average
 * round trip time. Maximum sent time. Maximum response time. Maximum round trip
 * time.
 * 
 * Pitcher should know the host name where the catcher is running and the port
 * number on which catcher is listening. The Pitcher also needs to identify
 * itself to the Catcher so it binds to a local port number that it will use
 * during this connection.
 * 
 * @author
 * 
 * 
 */
public class Pitcher {
	
//	private static final Logger LOG = Logger.getLogger(Pitcher.class);

	/**
	 * This is to store network statistics data.
	 */
	private PitcherData data = null;

	/**
	 * To establish the socket connection between the Catcher and the Pitcher.
	 */
	private Socket pitcherSocket;

	/**
	 * To send data to Catcher.
	 */
	private PrintWriter out = null;

	/**
	 * To get the Catcher's response,
	 * 
	 * Pitcher reads from the BufferedReader.
	 */
	private BufferedReader in = null;

	/**
	 * This is used for sending message to catcher. Every time a message sent
	 * this value is incremented. This is also used to track the loss of
	 * message. If the token not found the catcher response. Then considered as
	 * a message loss.
	 */
	private byte token = 0;

	/**
	 * This is used to keep track of the messages sent. Key is the message sent
	 * to the Catcher. Value is the system time when message was sent. Whenever
	 * any message received from the Catcher. Then checked in the map. From the
	 * system time message was received, we calculate round trip time. round
	 * trip time = system time message received - system time message was sent.
	 * 
	 * Another function of this map to track any message lost. Suppose we
	 * receive a message with key 5. But in the map there are keys less than 5
	 * (e.g. 4,3,2). Then we consider 4,3,2 these three messages are lost.
	 */
	private Map<Byte, Long> messageMap = new HashMap<Byte, Long>(
			TCPPingConstants.INTERVAL);

	/**
	 * System time when last message received by the Catcher. System time may be
	 * different in Catcher and Pitcher system. Two successive message receiving
	 * time is subtracted to get the actual message receiving time.
	 */
//	private long lastMessageReceivedAt = System.currentTimeMillis();

	/**
	 * System time when last message sent to Catcher.
	 */
	private long lastMessageSentAt = System.currentTimeMillis();

	/**
	 * Message sending speed. Measured as no of messages / second. Default value
	 * is 1.
	 */
	private int sendingSpeed;

	/**
	 * Message size measured in number of bytes. Minimum : 50, Maximum 3000,
	 * Default 300
	 */
	private int messageSize;

	/**
	 * Constructor. Sends message to Catcher. Get the response. Collects network
	 * statistics.
	 * 
	 * 
	 * @param hostName
	 *            to listen.
	 * @param listenPort
	 *            to listen
	 * @param messageSpeed
	 *            messages speed no of messages / second.
	 * @param msgSize
	 *            size of message. (Minimum 50, Maximum 3000, Default 300).
	 */
	public Pitcher(final String hostName, final int listenPort,
			final int messageSpeed, final int msgSize) {
		BufferedReader stdIn = null;
		try {
			// creates a new Socket object
			pitcherSocket = new Socket(hostName, listenPort);
			// gets the socket's output stream and opens a PrintWriter on it.
			out = new PrintWriter(pitcherSocket.getOutputStream(), true);
			// gets the socket's
			// input stream and opens a BufferedReader on it.
			in = new BufferedReader(new InputStreamReader(pitcherSocket
					.getInputStream()));

			data = new PitcherData();

			sendingSpeed = messageSpeed;
			TCPPingConstants.setMsgSpeed(sendingSpeed);

			messageSize = msgSize;
			TCPPingConstants.setMsgLength(messageSize);

			long msgSentTime = 0L;
			long lastPrintTime = System.currentTimeMillis();
			while (true) {
				// immediately sends it to the Catcher by writing it to the
				// PrintWriter connected to the socket
				msgSentTime = sendToCatcher();

				// Get response from catcher
				checkResponse(msgSentTime);

				if (data.getNoOfMessagesSentLastSecond() == sendingSpeed) {
					System.out.println(data.toString());
					// lastPrintTime = System.currentTimeMillis();
					//					
					// Sleep till next second
					data.setSleeperTime(lastPrintTime
							+ TCPPingConstants.INTERVAL
							- System.currentTimeMillis());
					Thread.currentThread().sleep(
							lastPrintTime + TCPPingConstants.INTERVAL
									- System.currentTimeMillis());

//					lastMessageReceivedAt = System.currentTimeMillis();
					lastMessageSentAt = System.currentTimeMillis();
					lastPrintTime = System.currentTimeMillis();
				}
				
			}

		} catch (UnknownHostException e) {
			System.err.println("Don't know about host: " + hostName
					+ ". Aborting program. Bye.");
			System.exit(1);
		} catch (IOException e) {
			System.err.println("Couldn't get I/O for " + "the connection to: "
					+ hostName + ". Aborting program. Bye");
			System.exit(1);
		} catch (Throwable th) {
			th.printStackTrace();
		} finally {
			// cleans up
			if (out != null) {
				out.close();
			}
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (stdIn != null) {
					stdIn.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				pitcherSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * @param msgSentTime
	 *            - time required to sent message.
	 * @param msgResponseTime
	 * @return
	 * @throws IOException
	 */
	private void checkResponse(final long msgSentTime) {
		byte[] receivedMessage = new byte[TCPPingConstants.getMsgLength()];
//		long msgResponseTime = 0L;
		try {
			receivedMessage = in.readLine().getBytes();
			//			
			if (receivedMessage != null) {
				// retrieve sequence
	

				byte retrievedSequence = receivedMessage[0];
				long timeSent = 0L;
				long roundTripTime = 0L;
				Object sentTime = messageMap.get(retrievedSequence);

				if (sentTime != null) {
					timeSent = (Long) sentTime;
					roundTripTime = System.currentTimeMillis() - timeSent;
					// Message received no need to keep in map.
					messageMap.remove(retrievedSequence);

					
					// increment messages received counter
					data.incMessagesReceived(0L,
							0L, roundTripTime);
				} else {
					System.err.println("Token " + retrievedSequence
							+ " not found.");
//					LOG.error("Token " + retrievedSequence + " not found ");
					data.incMessageLost();
				}

				// check message lost
				long trace = retrievedSequence - 1;
				while (messageMap.get(trace) != null) {
					messageMap.remove(trace);
					--trace;
					data.incMessageLost();
				}

				// System.out.println(receivedMessage);
			} else {
				// received null from Catcher.
				data.incMessageLost();
			}
		} catch (IOException e) {
			data.incMessageLost();
		}

	}

	/**
	 * This method sends message to Catcher. Message format.
	 * <<Sequence>>_<<current system time>>_<<padding character>>
	 * padding_character will be only added if message has less number of bytes
	 * than the required message size.
	 * 
	 * @return time required to sent the message.
	 */
	private long sendToCatcher() {
		if (token == 9 ) {
			token = 0;
		}
		++token;

		long msgSentTime = System.currentTimeMillis();
		out.println(new String(generateMessage(token, TCPPingConstants
				.getMsgLength())));
		messageMap.put(token, msgSentTime);

		// increment messages sent counter
		data.incMessagesSent();
//		LOG.debug("Token " + token + " sent at " + msgSentTime);
		return msgSentTime;
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

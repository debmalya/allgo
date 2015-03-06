package connectivity;
/**
 * This class defines all the constants used in TCPPing
 *
 */
public final class TCPPingConstants {
	
	/**
	 * To print mili second.
	 */
	public static final String MILI_SECOND_S = " ms";
	/**
	 * This is used as separator between
	 * sequence and current system time.
	 */
	public static final String SEPARATOR = "_";

	/**
	 * This is used for padding. If derived message has
	 * lesser number of bytes, only then this character is padded.
	 */
	public static final String PADDING_CHARACTER = "#";
	
	public static final byte PADDING_BYTE = '#';
	

	/**
	 * This is to maintain 1 second (1000 mili second) interval.
	 */
	public static final int INTERVAL = 1000;
	
	private static int msgSpeed;
	
	private static int msgLength;

	/**
	 * @return the msgSpeed
	 */
	public static int getMsgSpeed() {
		return msgSpeed;
	}

	/**
	 * @return the msgLength
	 */
	public static int getMsgLength() {
		return msgLength;
	}

	/**
	 * @param speed the msgSpeed to set
	 */
	public static void setMsgSpeed(final int speed) {
		TCPPingConstants.msgSpeed = speed;
	}

	/**
	 * @param size the msgLength to set
	 */
	public static void setMsgLength(final int size) {
		TCPPingConstants.msgLength = size;
	}
	

}

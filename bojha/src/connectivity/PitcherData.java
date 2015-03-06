package connectivity;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PitcherData {

	/**
	 * Time when Pitcher starts execution.
	 */
	private long startTime;

	/**
	 * Time in mili seconds when last statistics are printed. This time is used
	 * for calculating last minute averages.
	 */
	private long lastPrintTime = System.currentTimeMillis();
	/**
	 * Total number of sent messages.
	 */
	private long noOfMessagesSent;

	/**
	 * Total number of sent messages.
	 */
	private int noOfMessagesSentLastSecond;

	/**
	 * Total number of messages received.
	 */
	private long noOfMessagesReceived;

	/**
	 * Number of messages received last second.
	 * */
	private long noOfMessagesReceivedLastSecond;

	/**
	 * Number of messages round trip last second.
	 */
	private long noOfMessagesRoundTripLastSecond;

	/**
	 * Maximum time required for message to come from (Pitcher->Catcher).
	 */
	private float maxSentTime;
	/**
	 * Maximum time required for message to come from (Catcher->Pitcher).
	 */
	private float maxResponseTime;
	/**
	 * Maximum time required for message to make a round trip
	 * (Pitcher->Catcher->Pitcher).
	 */
	private float maxRoundTripTime;

	/**
	 * Total number of messages lost.
	 */
	private long noOfMessagesLost;

	/**
	 * Number of messages lost in last second.
	 */
	private long noOfMessagesLostLastSecond;

	/**
	 * Number of mili seconds program sleeps.
	 */
	private long sleepingTime;

	/**
	 * Default constructor.
	 */
	public PitcherData() {
		startTime = System.currentTimeMillis();
		lastPrintTime = System.currentTimeMillis();
	}

	/**
	 * This displays the statistics for every second.
	 * 
	 * @see java.lang.Object#toString()
	 * @return statistics.
	 */
	public final String toString() {
		// 1
		StringBuilder message = new StringBuilder("Time - " + getTimeStamp());
		// 2
		message.append(", Total number of sent messages:" + noOfMessagesSent);
		// This is not in specification, added by me.
		message.append(", Total no of messages lost:" + noOfMessagesLost);
		// 3
		message.append(", Number of messages in previous second (speed):"
				+ noOfMessagesSentLastSecond);
		// This is not in specification, added by me
		message.append(", Total no of messages lost (last second):"
				+ noOfMessagesLostLastSecond);
		// 4
		message.append(", Average time (for previous second) required"
				+ " for message to come from Pitcher to Catcher"
				+ " (direction A->B):");
		// Sslong runTime = System.currentTimeMillis() - startTime;
		long lastRunTime = System.currentTimeMillis() - lastPrintTime
				- sleepingTime;
		if (noOfMessagesSentLastSecond > 0) {
			message.append(lastRunTime / (long) noOfMessagesSentLastSecond);
		} else {
			message.append(lastRunTime);
		}
		message.append(TCPPingConstants.MILI_SECOND_S);
		// 5
		message.append(", Average time (for previous second) required"
				+ " for message to come from Catcher to Pitcher"
				+ " (direction B->A):");
		if (noOfMessagesReceivedLastSecond > 0) {
			message.append(lastRunTime / (long) noOfMessagesReceivedLastSecond);
		} else {
			message.append("NA");
		}
		message.append(TCPPingConstants.MILI_SECOND_S);
		// 6
		message.append(", Average time in last second required "
				+ " for message to make round trip" + " (A->B->A):");
		if (noOfMessagesRoundTripLastSecond > 0) {
			message.append(lastRunTime / noOfMessagesRoundTripLastSecond);
		} else {
			message.append("NA");
		}
		message.append(TCPPingConstants.MILI_SECOND_S);
		// 7
		message
				.append(", Altogether maximal time required for message to come "
						+ "from Pitcher to Catcher (A->B):"
						+ maxSentTime
						+ TCPPingConstants.MILI_SECOND_S);
		// 8
		message
				.append(", Altogether maximal time required for response to come "
						+ "from Catcher to Pitcher (B->A):"
						+ maxResponseTime
						+ TCPPingConstants.MILI_SECOND_S);
		// 9
		message.append(", Altogether maximal time required to make a  "
				+ "round trip (A->B->A):" + maxRoundTripTime
				+ TCPPingConstants.MILI_SECOND_S);

		// initialization on each second
		noOfMessagesSentLastSecond = 0;
		noOfMessagesRoundTripLastSecond = 0;
		noOfMessagesLostLastSecond = 0;
		noOfMessagesReceivedLastSecond = 0;
		lastPrintTime = System.currentTimeMillis();
		return message.toString();
	}

	/**
	 * @return timestamp in the format of HH:mm:ss.
	 */
	private String getTimeStamp() {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		return sdf.format(new Date());
	}

	/**
	 * Increment messages sent and update max sent time if required.
	 * 
	 * @param msgSentTime
	 *            message sent time.
	 */
	public final void incMessagesSent() {
		noOfMessagesSentLastSecond++;
		noOfMessagesSent++;
	}

	/**
	 * Increment message received and update max received time and max round
	 * trip time if required.
	 * 
	 * @param msgRcvTime
	 *            message receiving time.
	 * @param msgSentTime
	 *            message sent time.
	 * @param roundTripTime
	 *            round trip time.
	 */
	public final void incMessagesReceived(final long msgRcvTime,
			final long msgSentTime, final long roundTripTime) {
		noOfMessagesReceived++;
		noOfMessagesReceivedLastSecond++;
		noOfMessagesRoundTripLastSecond++;
		
		if (maxResponseTime < roundTripTime / 2) {
			maxResponseTime = roundTripTime / 2;
		}
		
		if (maxSentTime < roundTripTime / 2) {
			maxSentTime = roundTripTime / 2;
		}

		if (maxRoundTripTime < roundTripTime) {
			maxRoundTripTime = roundTripTime;
		}

	}

	/**
	 * Increment messages lost.
	 */
	public final void incMessageLost() {
		++noOfMessagesLost;
		++noOfMessagesLostLastSecond;
	}

	/**
	 * @return the startTime
	 */
	public final long getStartTime() {
		return startTime;
	}

	/**
	 * @return the noOfMessagesSentLastSecond
	 */
	public final int getNoOfMessagesSentLastSecond() {
		return noOfMessagesSentLastSecond;
	}

	/**
	 * @param sleeperTime
	 *            the sleeperTime to set
	 */
	protected void setSleeperTime(long sleeperTime) {
		this.sleepingTime = sleeperTime;
	}

}
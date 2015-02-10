package ht;

public class CopyOfMeMom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * 
	 * @param seatingArrangement
	 *            - contains number of seats in the bus, number of scientists.
	 * @param firstSeatIndex
	 *            - index of first taken seat.
	 * @param noOfScientists
	 *            - number of scientists whose seat we want to check.
	 * @param scientists
	 *            - indexes of the scientist in ascending order.
	 * @return seat numbers.
	 */
	public static int[] arrangeSeat(int[] seatingArrangement,
			int firstSeatIndex, int noOfScientists, int[] scientists) {
		int[] finalSeats = new int[noOfScientists];

		boolean[] occupied = new boolean[seatingArrangement[0]];

		
		if (scientists[0] == 1) {
			finalSeats[0] = firstSeatIndex;					
		}
		occupied[0] = true;
		if (noOfScientists > 1) {
			for (int i = 1; i < seatingArrangement[0]; i++)
				if (i < noOfScientists) {
					finalSeats[i] = getNextSeat(finalSeats[i - 1], 1,
							seatingArrangement[0], occupied);
					occupied[finalSeats[i] - 1] = true;
				}
		}
		return finalSeats;
	}

	private static int getNextSeat(int currentSeat, int min, int max,
			boolean[] occupied) {

		int nextSeat = getNextSeat(currentSeat,min,max);
		/*
		if (occupied[nextSeat -1]) {
			System.out.println(nextSeat + " already occupied");
			nextSeat = getComplementarySeat(nextSeat, max);
		}
		*/
		return nextSeat;

	}

	public static int getNextSeat(int currentSeat, int min, int max) {
		if (max - currentSeat > currentSeat - min) {
			return max;
		}
		return min;
	}

	/**
	 * 
	 * @param currentSeat
	 *            - index of current seat.
	 * @param max
	 *            - maximum number of seat.
	 * @return farthest unoccupied seat from current seat.
	 */
	public static int getFarthesetSeat(int currentSeat, int max) {		
		return getNextSeat(currentSeat,1,max);
	}

	public static int getMid(int max) {
		return max / 2 + max % 2;
	}

	public static int getComplementarySeat(int seatNo,int maxCapacity) {
		return (maxCapacity + 1) - seatNo;
	}
}

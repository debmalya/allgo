package ht;

import java.util.Scanner;

import org.junit.experimental.theories.internal.Assignments;

public class MeMom2 {

	/**
	 * This will keep count of vacancy around each seat. Initially vacancy count
	 * is zero for all the seats. zero means vacancy is total seat - 1.
	 * 
	 * Now whenever any seat is occupied it will be updated. e.g. if seat 1 is
	 * taken. vacancy count will be adjusted for seat 2.
	 * 
	 * If seat 5 is taken vacancy count will be adjusted for both the seats 6
	 * and seat 4.
	 * 
	 * 
	 */
	public static int[] vacancy;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			String value = scanner.nextLine();
			int noOfTestCases = Integer.parseInt(value);

			String[][] inputs = new String[noOfTestCases][];
			for (int i = 0; i < noOfTestCases; i++) {
				inputs[i] = new String[4];
				inputs[i][0] = scanner.nextLine();
				inputs[i][1] = scanner.nextLine();
				inputs[i][2] = scanner.nextLine();
				inputs[i][3] = scanner.nextLine();
			}

			for (int i = 0; i < noOfTestCases; i++) {
				System.out.println(process(inputs[i]));
			}
		} catch (Throwable th) {
			System.err.println("ERR :" + th.getMessage());
		}
	}

	/**
	 * Process seating arrangement.
	 * 
	 * @param inputs
	 * @return final seating arrangement.
	 */
	public static String process(String[] inputs) {
		StringBuilder output = new StringBuilder();

		int totalSeats = 0;
		int availableSeats = 0;
		int noOfScientists = 0;
		int selectedSeat = 0;
		int count = 0;

		// gap from position 1 to lowest near position
		// int nearGap = 0;
		// gap from highest rear position to end
		// int rearGap = 0;

		// highest rear seat taken
		// int highestRearSeat = totalSeats;
		// lowest near seat taken
		// int lowestRearSeat = 1;

		int[] scientists = null;

		boolean[] occupied = null;

		String[] values = inputs[0].split(" ");
		totalSeats = Integer.parseInt(values[0]);
		vacancy = new int[totalSeats + 1];
		// highestRearSeat = totalSeats;
		occupied = new boolean[totalSeats];
		availableSeats = totalSeats;
		noOfScientists = Integer.parseInt(values[1]);

		int takenSeat = Integer.parseInt(inputs[1]);

		occupied[takenSeat - 1] = true;

		int checkingScientists = Integer.parseInt(inputs[2]);

		scientists = new int[checkingScientists];
		values = inputs[3].split(" ");
		for (int i = 0; i < values.length; i++) {
			scientists[i] = Integer.parseInt(values[i]);
		}
		if (scientists[count] == 1) {
			output.append(takenSeat);
			output.append(" ");
			count++;
		}

		for (int i = 1; i < totalSeats; i++) {
			selectedSeat = assingnSeat(occupied, takenSeat - 1);
			occupied[selectedSeat] = true;
			if (i + 1 == scientists[count]) {
				output.append(selectedSeat + 1);
				output.append(" ");				
				count++;
				if (count == checkingScientists) {
					break;
				}
			}
		}
		return output.toString().trim();
	}

	/**
	 * Process seating arrangement.
	 * 
	 * @param inputs
	 * @return final seating arrangement.
	 */
	public static String process0(String[] inputs) {
		StringBuilder output = new StringBuilder();

		int totalSeats = 0;
		int availableSeats = 0;
		int noOfScientists = 0;
		int count = 0;

		// gap from position 1 to lowest near position
		int nearGap = 0;
		// gap from highest rear position to end
		int rearGap = 0;

		// highest rear seat taken
		int highestRearSeat = totalSeats;
		// lowest near seat taken
		int lowestRearSeat = 1;

		int[] scientists = null;

		boolean[] occupied = null;

		String[] values = inputs[0].split(" ");
		totalSeats = Integer.parseInt(values[0]);
		vacancy = new int[totalSeats + 1];
		highestRearSeat = totalSeats;
		occupied = new boolean[totalSeats + 1];
		availableSeats = totalSeats;
		noOfScientists = Integer.parseInt(values[1]);

		int takenSeat = Integer.parseInt(inputs[1]);

		occupied[takenSeat] = true;

		int checkingScientists = Integer.parseInt(inputs[2]);

		scientists = new int[checkingScientists];
		values = inputs[3].split(" ");
		for (int i = 0; i < values.length; i++) {
			scientists[i] = Integer.parseInt(values[i]);
		}
		if (scientists[count] == 1) {
			output.append(takenSeat);
			output.append(" ");
			count++;
		}
		occupied[takenSeat] = true;

		// second seat assignment
		if (totalSeats - takenSeat > takenSeat) {
			lowestRearSeat = takenSeat;
			nearGap = takenSeat;
			takenSeat = totalSeats;
			highestRearSeat = totalSeats;
		} else {
			if (highestRearSeat < takenSeat) {
				highestRearSeat = takenSeat;
			}
			rearGap = totalSeats - takenSeat;
			takenSeat = 1;
			lowestRearSeat = 1;

		}

		if (scientists[count] == 2) {
			output.append(takenSeat);
			output.append(" ");
			count++;
		}
		occupied[takenSeat] = true;

		// rest of the seat assignment
		int currentGap = 0;
		for (int i = 2; count < checkingScientists; i++) {
			currentGap = (highestRearSeat - lowestRearSeat) / i + 1;
			if (!occupied[lowestRearSeat]) {
				takenSeat = lowestRearSeat;
			} else if (!occupied[highestRearSeat]) {
				// as it is the farthest seat, be careful
				// check whether any other seat is available near exit
				// TODO : this needs to be checked.
				if (countProximity(occupied, highestRearSeat) > countProximity(
						occupied, lowestRearSeat + 1)) {
					takenSeat = highestRearSeat;
				} else {
					takenSeat = lowestRearSeat + 1;
				}

			} else {
				if (!occupied[currentGap]) {
					takenSeat = currentGap;
				} else if (currentGap == nearGap) {
					// TODO : this needs to be checked.
					// What to do ?
					if (!occupied[1]) {
						takenSeat = 1;
					} else if (currentGap < mid(totalSeats)) {
						while (occupied[currentGap]) {
							currentGap++;
						}
						takenSeat = currentGap;
					} else {
						currentGap = getComplementarySeat(currentGap,
								totalSeats);
						while (occupied[currentGap]) {
							currentGap--;
						}
						takenSeat = currentGap;
					}

				} else {
					// how long this else will continue ?
					takenSeat = getComplementarySeat(takenSeat, totalSeats);
					if (!occupied[takenSeat]) {
						// safe and can proceed;
					} else if (currentGap < mid(totalSeats)) {
						while (occupied[currentGap]) {
							currentGap++;
						}
						takenSeat = currentGap;
					} else {
						currentGap = getComplementarySeat(currentGap,
								totalSeats);
						while (occupied[currentGap]) {
							currentGap--;
						}
						takenSeat = currentGap;
					}
				}
			}
			if (i + 1 == scientists[count]) {
				output.append(takenSeat);
				output.append(" ");
				count++;
			}
			occupied[takenSeat] = true;
		}

		return output.toString().trim();
	}

	private static int mid(int totalSeats) {
		return totalSeats / 2 + totalSeats % 2;
	}

	/**
	 * 
	 * @param takenSeat
	 * @param totalSeats
	 * @return
	 */
	private static int getComplementarySeat(int takenSeat, int totalSeats) {
		return totalSeats + 1 - takenSeat;
	}

	/**
	 * 
	 * @param occupied
	 *            - seat occupancy array. true means seat is occupied, else
	 *            false.
	 * @param currentSeat
	 *            - currentSeat which will be checked how isolated it is.
	 * @return 0 means already occupied or there is no free seat around. if two
	 *         seats have same return values then seat with lower index will be
	 *         considered.
	 * 
	 *         number of free seats in the neighborhood.
	 */
	public static int countProximity(boolean[] occupied, int currentSeat) {
		int result = 0;

		// Seat is occupied no need to check.
		if (occupied[currentSeat]) {
			return result;
		} else {
			result++;
		}

		// left proximity
		for (int i = currentSeat - 1; i > 1; i--) {
			if (!occupied[i]) {
				result++;
			} else {
				break;
			}
		}

		// right proximity
		for (int i = currentSeat + 1; i < occupied.length; i++) {
			if (!occupied[i]) {
				result++;
			} else {
				break;
			}
		}
		return result;
	}

	/**
	 * 
	 * @param seatNo
	 *            - occupied seat. Vacancy of its two neighbour will be updates.
	 */
	public void adjustVacancy(int seatNo, int totalSeats) {
		if (seatNo >= 1) {
			vacancy[seatNo + 1]++;
		} else if (seatNo <= totalSeats) {
			vacancy[seatNo - 1]++;
		}

	}

	public static int assingnSeat(boolean[] occupied, int currentSeat) {
		int selectedSeat = currentSeat;

		// from near end available seat
		int totalSeat = occupied.length;
		int mid = mid(totalSeat);
		int nearPosition = -1;
		int rearPosition = -1;

		for (int i = 0; i < mid; i++) {
			if (!occupied[i] ) {
				// available seat close to the exit
				nearPosition = i;
			}
			if (!occupied[totalSeat - i - 1]) {
				// available seat from the rear end
				rearPosition = totalSeat - i - 1;
			}
			if (rearPosition != -1 && nearPosition != -1) {
				break;
			}
		}
		if (nearPosition == -1 && rearPosition > -1) {
			return rearPosition;
		}

		if (nearPosition > -1 && rearPosition == -1) {
			return nearPosition;
		}
		if (Math.abs(nearPosition - currentSeat) >= Math.abs(rearPosition
				- currentSeat)) {
			selectedSeat = nearPosition;
		} else {
			selectedSeat = rearPosition;
		}
		return selectedSeat;
	}
}

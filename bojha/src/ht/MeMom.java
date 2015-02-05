package ht;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MeMom {

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
		} catch (Throwable th) {
			System.err.println("ERR :" + th.getMessage());
		}
	}

	class Bus {
		private int totalSeats;
		// private int[] seats;
		private boolean[] occupied;
		private int noOfScientists;
		private int checkingScientists;
		private int firstTakenSeat;
		private int[] seatingScientists;
		private List<Integer> bestAvailablePositions;

		public Bus(String[] arrangement) {
			String[] values = arrangement[0].split(" ");
			totalSeats = Integer.parseInt(values[0]);
			// seats = new int[totalSeats];
			occupied = new boolean[totalSeats + 1];

			noOfScientists = Integer.parseInt(values[1]);

			firstTakenSeat = Integer.parseInt(arrangement[1]);
			occupied[firstTakenSeat] = true;

			checkingScientists = Integer.parseInt(arrangement[2]);
			seatingScientists = new int[checkingScientists];
			String[] scientists = arrangement[3].split(" ");

			for (int i = 0; i < checkingScientists; i++) {
				seatingScientists[i] = Integer.parseInt(scientists[i]);
			}

			bestAvailablePositions = new ArrayList<Integer>(checkingScientists);

			if (firstTakenSeat == 1 || totalSeats - firstTakenSeat > firstTakenSeat - 1) {
				// last seat is the best seat now
				bestAvailablePositions.add(totalSeats);
			} else {
				// first seat is the best seat.
				bestAvailablePositions.add(1);
			} 

		}

		int getMid(int max) {
			return max / 2 + max % 2;
		}
	}

}

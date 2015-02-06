package ht;

import java.util.Scanner;

public class MeMom2 {
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
				process(inputs[i]);

			}
		} catch (Throwable th) {
			System.err.println("ERR :" + th.getMessage());
		}
	}

	public static String process(String[] inputs) {
		StringBuilder output = new StringBuilder();

		int totalSeats = 0;
		int availableSeats = 0;
		int noOfScientists = 0;
		int count = 0;

		int[] scientists = null;
//		int[] finalSeats = null;

		boolean[] occupied = null;

		String[] values = inputs[0].split(" ");
		totalSeats = Integer.parseInt(values[0]);
		occupied = new boolean[totalSeats + 1];
		availableSeats = totalSeats;
		noOfScientists = Integer.parseInt(values[1]);

		int takenSeat = Integer.parseInt(inputs[1]);
		occupied[takenSeat] = false;

		int checkingScientists = Integer.parseInt(inputs[2]);
//		finalSeats = new int[checkingScientists];
		scientists = new int[checkingScientists];
		values = inputs[3].split(" ");
		for (int i = 0; i < values.length; i++) {
			scientists[i] = Integer.parseInt(values[i]);
		}
		if (scientists[count] == 1) {
			output.append(takenSeat);
			output.append("");
			count++;
		}

		if (totalSeats - takenSeat > takenSeat - 1) {
			output.append(totalSeats);
		} else {
			output.append("1");
		}
		output.append(" ");
		count++;

		return output.toString().trim();
	}
}

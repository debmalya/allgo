package ht;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MeMom {
	
	/**
	 * This will keep count of vacancy around each seat.
	 * Initially vacancy count is zero for all the seats.
	 * zero means vacancy is total seat - 1.
	 * 
	 * Now whenever any seat is occupied it will be updated.
	 * e.g. if seat 1 is taken. vacancy count will be adjusted for seat 2.
	 * 
	 * If seat 5 is taken vacancy count will be adjusted for both the seats 6 and
	 * seat 4.
	 * 
	 * 
	 */
	public static int[] vacancy;

    public static void main(String[] args) {
    	MeMom me = new MeMom();
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
            	MeMom.Bus bus = me.new Bus(inputs[i]);
            	bus.process();
            	System.out.println(bus.printFinalSeats());
            	
            }
        } catch (Throwable th) {
            System.err.println("ERR :" + th.getMessage());
        }
    }

    class Bus {

        private int totalSeats;
        private int availableSeats;
        // private int[] seats;
        private boolean[] occupied;
        private int noOfScientists;
        private int checkingScientists;
        private int firstTakenSeat;
        private int[] seatingScientists;
        private List<Integer> bestAvailablePositions;
        private int[] finalSeats;

        public Bus(String[] arrangement) {
            int count = 0;
            String[] values = arrangement[0].split(" ");
            totalSeats = Integer.parseInt(values[0]);
            availableSeats = totalSeats;
            // seats = new int[totalSeats];
            occupied = new boolean[totalSeats + 1];

            noOfScientists = Integer.parseInt(values[1]);

            checkingScientists = Integer.parseInt(arrangement[2]);
            seatingScientists = new int[checkingScientists];
            String[] scientists = arrangement[3].split(" ");

            for (int i = 0; i < checkingScientists; i++) {
                seatingScientists[i] = Integer.parseInt(scientists[i]);
            }
            finalSeats = new int[checkingScientists];

            bestAvailablePositions = new ArrayList<Integer>(checkingScientists);
            
             // Assign first seat
            firstTakenSeat = Integer.parseInt(arrangement[1]);

        }
        
        void process() {
            int count = 0;
            occupied[firstTakenSeat] = true;
            availableSeats--;
            if (firstTakenSeat == 1 || totalSeats - firstTakenSeat > firstTakenSeat - 1) {
                // last seat is the best seat now
                bestAvailablePositions.add(totalSeats);
            } else {
                // first seat is the best seat.
                bestAvailablePositions.add(1);
            }

            if (seatingScientists[count] == 1) {
                finalSeats[count] = firstTakenSeat;
                count++;
            }

            // allocate remaining seats
            for (int i = 1; i < totalSeats; i++) {
                int selectedSeat = 0;
                if (!bestAvailablePositions.isEmpty()) {
                    selectedSeat = bestAvailablePositions.get(0);
                    occupied[selectedSeat] = true;
                    bestAvailablePositions.remove(0);

                    int mid = totalSeats / 2 + totalSeats % 2;
                    if (occupied[1] && occupied[totalSeats] && !occupied[mid]) {
                        bestAvailablePositions.add(mid);
                    } else {
                        
                        int complementarySeat = 0;
                        complementarySeat = (totalSeats + 1) - selectedSeat;
                        if (!occupied[complementarySeat]) {
                            bestAvailablePositions.add(complementarySeat);
                        } else {
                            complementarySeat = (totalSeats + 1) - selectedSeat;
                            if (complementarySeat == selectedSeat) {
                                complementarySeat = (totalSeats + 1) - selectedSeat - 1;
                               
                            }
                            if (!occupied[selectedSeat] && !occupied[complementarySeat]) {
                                int[] selectedSeatProximity = getProximityCount(selectedSeat, occupied);
                                int[] complementarySeatProximity = getProximityCount(complementarySeat, occupied);

                                if (selectedSeatProximity[0] + selectedSeatProximity[1] < complementarySeatProximity[0] + complementarySeatProximity[1]) {
                                    bestAvailablePositions.add(complementarySeat);
                                } else {
                                    bestAvailablePositions.add(selectedSeat);
                                }
                            } else if (!occupied[selectedSeat]) {
                                bestAvailablePositions.add(selectedSeat);
                            } else if (!occupied[complementarySeat]) {
                                bestAvailablePositions.add(complementarySeat);
                            }
                        }
                    }
                } else {
//                    Emptry suitable positions
                    if (availableSeats > 0) {
                        for (int j = 1; j < occupied.length; j++) {
                            if (!occupied[j]) {
                                selectedSeat = j;
                            }
                         }
                    }
                }
                if (seatingScientists[count] == i + 1) {
                    finalSeats[count] = selectedSeat;
                    availableSeats--;
                    occupied[selectedSeat] = true;
                    if (count + 1 == checkingScientists) {
                        break;
                    }
                    count++;

                }

            }
        }

        int getComplementarySeat(int seatNo) {
            return (totalSeats + 1) - seatNo;
        }

        int[] getProximityCount(int seatNo, boolean[] occupancy) {
            int[] counts = new int[2];

            // Going towards left
            for (int i = seatNo - 1; i > 1; i--) {
                if (occupancy[i]) {
                    break;
                } else {
                    counts[0]++;
                }
            }
            // Going towards right
            for (int i = seatNo + 1; i < occupancy.length; i++) {
                if (occupancy[i]) {
                    break;
                } else {
                    counts[1]++;
                }
            }

            return counts;
        }

        void printOccupancy() {
            for (int i = 1; i < occupied.length; i++) {
                System.out.print(occupied[i] + " ");
            }
        }

        String printFinalSeats() {
            StringBuilder seatingArrangement = new StringBuilder();
            for (int i = 0; i < finalSeats.length; i++) {
                if (i > 0) {
                    seatingArrangement.append(" ");
                }
                seatingArrangement.append(finalSeats[i]);
            }
            return seatingArrangement.toString();
        }
    }

}

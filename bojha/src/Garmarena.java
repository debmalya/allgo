import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author debmalyajash
 *
 */
public class Garmarena {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = null;
		try {
			scanner = new Scanner(System.in);
			int noOfTestCases = Integer.parseInt(scanner.nextLine());
			List<Integer> allOutputs = new ArrayList<Integer>(noOfTestCases);
			for (int i = 0; i < noOfTestCases; i++) {
//				Take all inputs for a test case
//				process that inputs
//				add the result into allOutputs
				allOutputs.add(processEachInput(takeEachInput(scanner)));
			}

//			print output one by one
			for (Integer each:allOutputs) {
				System.out.println(each);
			}
		} catch (Throwable th) {
			System.err.println("ERR :" + th.getMessage());
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}

	}

	

	/**
	 * @param scanner
	 */
	private static Input takeEachInput(Scanner scanner) {
		// First line contains two integers n and k.
		Input input = new Input(scanner);				
		return input;
	}
	
	/**
	 * @param takeEachInput
	 * @return
	 */
	private static Integer processEachInput(Input takeEachInput) {
		
		return process(takeEachInput.numberOfShelves,takeEachInput.numberOfBalls,takeEachInput.ballDroppingPointList,takeEachInput.shelves);
	}

	/**
	 * @param numberOfShelves
	 * @param numberOfBalls
	 * @param ballDroppingPointList
	 * @param shelves
	 * @return
	 */
	public static Integer process(int numberOfShelves, int numberOfBalls,
			List<Integer> ballDroppingPointList, List<String> shelves) {
		// TODO Auto-generated method stub
		return 0;
	}

	static class Input{
		int numberOfShelves;
		int numberOfBalls;
		List<Integer> ballDroppingPointList;
		List<String> shelves;
		
		public Input(Scanner scanner){
			processNnK(scanner.nextLine());
			
			int i = 0;
			for  (i = 0; i < numberOfBalls; i++){
				addBallDroppingPoints(Integer.parseInt(scanner.nextLine()));
			}
			
			for (i = 0; i < numberOfShelves; i++) {
				addShelves(scanner.nextLine());
			}
		}
		/**
		 * @param nextLine
		 */
		private void addShelves(String nextLine) {
			if (shelves == null) {
				shelves = new ArrayList<String>();
			}
			shelves.add(nextLine);
			
		}
		/**
		 * @param nextLine
		 */
		public void processNnK(String nextLine) {
			String[] nNk = nextLine.split(" ");
			numberOfShelves = Integer.parseInt(nNk[0]);
			numberOfBalls = Integer.parseInt(nNk[1]);			
		}
		/**
		 * @param droppingPosition
		 */
		public void addBallDroppingPoints(int droppingPosition) {
			if (ballDroppingPointList == null) {
				ballDroppingPointList = new ArrayList<Integer>();
			}
			ballDroppingPointList.add(droppingPosition);
		}
	}
}

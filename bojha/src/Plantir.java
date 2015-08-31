import java.util.Scanner;

/**
 * 
 */

/**
 * @author debmalyajash
 *
 */
public class Plantir {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			String firstLine = sc.nextLine();
			
			String[] MN = firstLine.split(" ");
			int m  = Integer.parseInt(MN[0]);
			int n = Integer.parseInt(MN[1]);
			
			String[] allRows = new String[m];
			for (int i = 0; i < m; i++) {
				allRows[i] = sc.nextLine();				
			}
			
			int max = 0;
			for (int i = 0; i < n; i++) {
				max = Math.max(max, flipColumn(i,allRows));
			}
			System.out.println(max);
			
		} catch(Throwable th) {
			System.err.println(th.getMessage());
		}
	}

	/**
	 * @param i
	 * @return
	 */
	public static int flipColumn(int i,String[] allRows) {
		int count = 0;
		for (int row = 0; row < allRows.length; row++) {
			char[] v = allRows[row].toCharArray();
			if (v[i]=='P'){				
				v[i] = 'T';
				
			} else {
				v[i] = 'P';
			}
			if (allEqual(v)) {
				count++;
			}
		}
		return count;
	}

	/**
	 * @param v
	 * @return
	 */
	private static boolean allEqual(char[] v) {
		char f = v[0];
		for (int i = 1; i < v.length; i++) {
			if (v[i] != f){
				return false;
			}
		}
		return true;
	}
}

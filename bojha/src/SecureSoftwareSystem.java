import java.util.Scanner;


public class SecureSoftwareSystem {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    	Scanner scanner = null;
    	try {
    		scanner = new Scanner(System.in);
    		int noOfTestCases = Integer.parseInt(scanner.nextLine());
    		String[] inputs = new String[noOfTestCases]; 
    		for (int i = 0; i < noOfTestCases; i++) {
    			inputs[i] = scanner.nextLine();
    		}
    		processInputs(inputs);
    	} catch(Throwable th) {
    		System.err.println(th.getMessage());
    	} finally {
    		if (scanner != null) {
    			scanner.close();
    		}
    	}
    }

	public static void processInputs(String[] inputs) {
		for (int i = 0; i < inputs.length; i++) {
			String[] all = inputs[i].split(" ");
			int m = Integer.parseInt(all[0]);
			int n = Integer.parseInt(all[1]);
			
			int max = Math.max(m, n);
			int min = Math.min(m, n);
			
			if (max > 6 || (max == 6 && min != 6) ) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
		
	}
}
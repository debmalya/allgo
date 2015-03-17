import java.util.Scanner;

public class ZeroOne {

	public static void main(String[] args) {
		Scanner scanner = null;
		try {
			scanner = new Scanner(System.in);
			int n = scanner.nextInt();
			
			String str = Long.toBinaryString(n);
			long value = Long.valueOf(str);
			if (value % n == 0) {
				System.out.println(value);
				System.exit(0);
			}
			
			long original = n;
			while (true) {								
				
				original++;
				str = Long.toBinaryString(original);
				value = Long.valueOf(str);
				if (value % n == 0) {
					System.out.println(value);
					break;
				}

			}
		} catch (Exception exc) {
			exc.printStackTrace();
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}

	}

}

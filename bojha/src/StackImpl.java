import java.util.Stack;


public class StackImpl {
	
	public static void main(String[] args) {
		int n = 50;
		Stack<Integer> stack = new Stack<Integer>();
		
		while (n > 0) {
			stack.push(n % 2);
			n = n / 2;
		}
		
		for (int d: stack) {
			System.out.print(d);
		}
		
		System.out.println();
	}

}

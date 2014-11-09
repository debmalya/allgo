/*
 * This is not the ideal solution.
 * GetElement from Stack implementation.
 */
public class StackTestDebmalyaJash {
	public static void main(String... s) throws Exception {
		
		MyStack stack = new MyStack();

		int random = (int) (Math.random() * 100);

		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(random);
		stack.push(50);
		stack.push(60);

		assertTrue(getStackElement(stack, 0) == 60);
		assertTrue(getStackElement(stack, 1) == 50);
		assertTrue(getStackElement(stack, 3) == 30);
		assertTrue(getStackElement(stack, 4) == 20);
		assertTrue(getStackElement(stack, 5) == 10);
		try {
			getStackElement(stack, 6);
			assertTrue(false);
		} catch (Exception e) {
			assertTrue(true);
		}

		assertTrue(getStackElement(stack, 2) == random);
		

	}

	public static void assertTrue(boolean v) {
		if (!v) {
			Thread.dumpStack();
			System.exit(0);
		}
	}

	public static int getStackElement(MyStack stack, int index)
			throws Exception {
		// 1) ONLY FILL IN YOUR CODE IN THIS METHOD
		// 2) DO NOT MODIFY ANYTHING ELSE
		// 3) USE OF new KEYWORD IS NOT ALLOWED
		// 4) DO NOT USE REFLECTION
		// 5) DO NOT USE STRING CONCATENATION
		
		if (index == 0) {
			return stack.peek();
		} else {
			int item = 0;
			long removedNumbers = 0;

			try {
				// pop loop
				for (int runningIndex = 0; runningIndex <= index; runningIndex++) {

					item = stack.pop();
					if (runningIndex > 0) {
						removedNumbers *= 100;
					}
					removedNumbers += item;

					
				}

			} catch (Exception th) {
				throw th;
			} finally {
				// pushloop
				while (removedNumbers > 0) {
					stack.push((int)removedNumbers % 100);
					removedNumbers /= 100;

				}
			}
			return item;
		}
		
		
	}

}

class MyStack {
	private java.util.List<Integer> items;

	public MyStack() {
		items = new java.util.ArrayList<Integer>();
	}

	public int pop() {
		if (isEmpty())
			throw new RuntimeException("Stack is empty!");
		return items.remove(items.size() - 1);
	}

	public void push(int i) {
		items.add(i);
	}

	public int peek() {
		if (isEmpty())
			throw new RuntimeException("Stack is empty!");
		return items.get(items.size() - 1);
	}

	public boolean isEmpty() {
		return items.size() == 0;
	}
}

package stack;

public class FixedCapacityStack {
	private int[] container;

	private int currentIndex = 0;

	public FixedCapacityStack(int size) {
		container = new int[size];
	}

	public boolean isEmptry() {
		return currentIndex <= 0;
	}

	public void push(int item) {
		if (currentIndex < container.length) {
			container[++currentIndex] = item;
		} else {
			throw new RuntimeException("Stack overflow exception");
		}
	}
	
	
	public int pop() {
		if (currentIndex >= 0) {
			return container[--currentIndex];
		} else {
			throw new RuntimeException("Stack underflow exception");
		}
	}
}

import java.util.List;
import java.util.ArrayList;

public class Test {
	public static void main(String... args) throws Exception {
		Deque queue = new Deque();

		int random = (int) (Math.random() * 100);

		queue.addLast(10);
		queue.addLast(20);
		queue.addLast(random);
		queue.addLast(40);
		queue.addLast(50);

		for (int i = 0; i < 2; i++) {
			assertTrue(get(queue, 0) == 10);
			assertTrue(get(queue, 1) == 20);
			assertTrue(get(queue, 2) == random);
			assertTrue(get(queue, 3) == 40);
			assertTrue(get(queue, 4) == 50);

			try {
				get(queue, 5);
				assertTrue(false);
			} catch (Exception e) {
				assertTrue(true);
			}
		}
		
	}

	public static void assertTrue(boolean v) {
		if (!v) {
			Thread.dumpStack();
			System.exit(0);
		}
	}

	public static int get(Deque queue, int index) throws Exception {
		// 1) Only fill in your code in this method
		// 2) Do not modify anything else
		// 3) Use of 'new' keyword is not allowed
		// 4) Do not use reflection
		// 5) Do not use string concatenation
		// 6) If your code cannot compile or fails the test case in 'main()',
		// you will NOT receive a response from us
		int i = 0;
		int item = 0;
		boolean firstTime = true;
		// get value at the index.
		
		while (i <= index) {
			item = queue.removeFirst();
			if (firstTime) {
				// End of queue marker.
				// This is a limitation, Integer.MAX_VALUE can not be used as
				// queue member.
				queue.addLast(Integer.MAX_VALUE);
				firstTime = false;
			} else if (item == Integer.MAX_VALUE) {
				throw new Exception("Index out of bound");
			}
			queue.addLast(item);
			i++;
		}

		int searchedItem = item;
		// arrange the queue in proper order.
		while (i > 0) {
			item = queue.removeLast();
			queue.addFirst(item);
			i--;
		}

		queue.removeLast();
		return searchedItem;
	}
}

class Deque {
	private List<Integer> items;

	public Deque() {
		items = new ArrayList<Integer>();
	}

	public void addFirst(int item) {
		items.add(0, item);
	}

	public void addLast(int item) {
		items.add(item);
	}

	public int removeFirst() {
		if (isEmpty())
			throw new RuntimeException();
		return items.remove(0);
	}

	public int removeLast() {
		if (isEmpty())
			throw new RuntimeException();
		return items.remove(items.size() - 1);
	}

	public boolean isEmpty() {
		return items.size() == 0;
	}
}

import static org.junit.Assert.*;

import org.junit.Test;

public class MainTest {

	private static final String ERROR_WRONG_COMMAND = "error: wrong command";
	private static final String ZERO = "0";
	private static final String NINETEEN = "19";
	private static final String BLANK = "";
	private static final String ERROR_QUEUE_IS_FULL = "error: queue is full";
	private static final String ERROR_QUEUE_IS_EMPTY = "error: queue is empty";
	private static final String STACK_5_PRINT_RESULT = "28 99 33 88";
	private static final String ERROR_STACK_IS_FULL = "error: stack is full";
	private static final String ERROR_STACK_IS_EMPTY = "error: stack is empty";
	private static final String EMPTY = "empty";

	@Test
	public void example1() {
		assertEquals("new_s 0", BLANK, Main.executeCommand("new_s 0"));
		assertEquals("push 0 96", BLANK, Main.executeCommand("push 0 96"));
		assertEquals("new_s 5", BLANK, Main.executeCommand("new_s 5"));

		assertEquals(EMPTY, EMPTY, Main.executeCommand("print_s 5"));
		assertEquals("push 5 28", BLANK, Main.executeCommand("push 5 28"));
		assertEquals("push 5 99", BLANK, Main.executeCommand("push 5 99"));
		assertEquals("push 5 88", BLANK, Main.executeCommand("push 5 88"));
		assertEquals("pop 0", BLANK, Main.executeCommand("pop 0"));

		assertEquals("28 99 88", "28 99 88", Main.executeCommand("print_s 5"));
		assertEquals("push 0 65", BLANK, Main.executeCommand("push 0 65"));
		assertEquals("stack->stack 5 0", BLANK,
				Main.executeCommand("stack->stack 5 0"));
		assertEquals("print_s 0", "65 88", Main.executeCommand("print_s 0"));
	}

	@Test
	public void example2() {

		assertEquals("new_s 0", BLANK, Main.executeCommand("new_s 0"));
		assertEquals("push 0 96", BLANK, Main.executeCommand("push 0 96"));

		assertEquals("new_s 5", BLANK, Main.executeCommand("new_s 5"));

		assertEquals("print_s 5", EMPTY, Main.executeCommand("print_s 5"));

		assertEquals("push 5 28", BLANK, Main.executeCommand("push 5 28"));
		assertEquals("push 5 99", BLANK, Main.executeCommand("push 5 99"));
		assertEquals("push 5 33", BLANK, Main.executeCommand("push 5 33"));
		assertEquals("push 5 88", BLANK, Main.executeCommand("push 5 88"));

		assertEquals("pop 0", BLANK, Main.executeCommand("pop 0"));
		assertEquals(STACK_5_PRINT_RESULT, STACK_5_PRINT_RESULT,
				Main.executeCommand("print_s 5"));
		assertEquals(ERROR_STACK_IS_EMPTY, ERROR_STACK_IS_EMPTY,
				Main.executeCommand("pop 0"));

		assertEquals("push 0 65", BLANK, Main.executeCommand("push 0 65"));
		assertEquals("push 5 99", BLANK, Main.executeCommand("push 5 999"));
		assertEquals("push 5 13", BLANK, Main.executeCommand("push 5 133"));
		assertEquals("push 5 99", BLANK, Main.executeCommand("push 5 99"));

		assertEquals("push 5 1", BLANK, Main.executeCommand("push 5 1"));
		assertEquals("push 5 99", BLANK, Main.executeCommand("push 5 99"));
		assertEquals("push 5 0", BLANK, Main.executeCommand("push 5 0"));

		assertEquals("push 5 9", ERROR_STACK_IS_FULL,
				Main.executeCommand("push 5 9"));
		assertEquals("push 5 87", ERROR_STACK_IS_FULL,
				Main.executeCommand("push 5 87"));

		assertEquals("stack->stack 5 0", BLANK,
				Main.executeCommand("stack->stack 5 0"));
		assertEquals("print_s 0", "65 0", Main.executeCommand("print_s 0"));
	}

	@Test
	public void example3(){
		
		assertEquals("new_s 0", BLANK, Main.executeCommand("new_s 0"));
//		S0_1
		assertEquals("push 0 96", BLANK, Main.executeCommand("push 0 96"));
		
		assertEquals("new_s 5", BLANK, Main.executeCommand("new_s 5"));		
		assertEquals("print_s 5", EMPTY, Main.executeCommand("print_s 5"));
//		S5_1
		assertEquals("push 5 28", BLANK, Main.executeCommand("push 5 28"));
//		S5_2
		assertEquals("push 5 99", BLANK, Main.executeCommand("push 5 99"));
		
		assertEquals("new_q 0", BLANK, Main.executeCommand("new_q 0"));
//		S5_3
		assertEquals("push 5 33", BLANK, Main.executeCommand("push 5 33"));
//		S5_4
		assertEquals("push 5 88", BLANK, Main.executeCommand("push 5 88"));
//		S0_0
		assertEquals("pop 0", BLANK, Main.executeCommand("pop 0"));
		assertEquals("print_s 5", STACK_5_PRINT_RESULT, Main.executeCommand("print_s 5"));
		assertEquals("pop 0", ERROR_STACK_IS_EMPTY, Main.executeCommand("pop 0"));
//		S0_1
		assertEquals("push 0 65", BLANK, Main.executeCommand("push 0 65"));
//		S5_5
		assertEquals("push 5 99", BLANK, Main.executeCommand("push 5 99"));
		assertEquals("dequeue 0", ERROR_QUEUE_IS_EMPTY, Main.executeCommand("dequeue 0"));
//		Q0_1
		assertEquals("enqueue 0 4", BLANK, Main.executeCommand("enqueue 0 4"));
		assertEquals("new_q 9", BLANK, Main.executeCommand("new_q 9"));
//		S5_6
		assertEquals("push 5 13", BLANK, Main.executeCommand("push 5 13"));
//		S5_7
		assertEquals("push 5 99", BLANK, Main.executeCommand("push 5 99"));
//		Q0_2
		assertEquals("enqueue 0 43", BLANK, Main.executeCommand("enqueue 0 43"));
//		Q0_3
		assertEquals("enqueue 0 21", BLANK, Main.executeCommand("enqueue 0 21"));
//		Q0_4
		assertEquals("enqueue 0 17", BLANK, Main.executeCommand("enqueue 0 17"));
//		Q0_5
		assertEquals("enqueue 0 4", BLANK, Main.executeCommand("enqueue 0 4"));
//		Q9_1
		assertEquals("enqueue 9 0", BLANK, Main.executeCommand("enqueue 9 0"));
//		Q0_6
		assertEquals("enqueue 0 4", BLANK, Main.executeCommand("enqueue 0 4"));		
//		Q0_7
		assertEquals("enqueue 0 43", BLANK, Main.executeCommand("enqueue 0 43"));
//		Q0_8
		assertEquals("enqueue 0 40", BLANK, Main.executeCommand("enqueue 0 40"));		
//		S5_9
		assertEquals("push 5 1", BLANK, Main.executeCommand("push 5 1"));
//		S5_10
		assertEquals("push 5 99", BLANK, Main.executeCommand("push 5 99"));	
//		Q0_9
		assertEquals("enqueue 0 33", BLANK, Main.executeCommand("enqueue 0 33"));		
//		Q0_10
		assertEquals("enqueue 0 99", BLANK, Main.executeCommand("enqueue 0 99"));
//		Q0_8
		assertEquals("enqueue 0 8", ERROR_QUEUE_IS_FULL, Main.executeCommand("enqueue 0 8"));
//		S5_10
		assertEquals("push 5 0", BLANK, Main.executeCommand("push 5 0"));
//		S5_10_FULL
		assertEquals("push 5 9", ERROR_STACK_IS_FULL, Main.executeCommand("push 5 9"));			
		
		assertEquals("delete_q 0", BLANK, Main.executeCommand("delete_q 0"));
		assertEquals("print_q 9", ZERO, Main.executeCommand("print_q 9"));
//		S5_10_FULL
		assertEquals("push 5 87", ERROR_STACK_IS_FULL, Main.executeCommand("push 5 87"));		
		
		assertEquals("new_q 0", BLANK, Main.executeCommand("new_q 0"));
		assertEquals("enqueue 0 19", BLANK, Main.executeCommand("enqueue 0 19"));
		assertEquals("print_q 0", NINETEEN, Main.executeCommand("print_q 0"));
		assertEquals("stack->stack 5 0", BLANK, Main.executeCommand("stack->stack 5 0"));		
		
		assertEquals("print_s 0", "65 0", Main.executeCommand("print_s 0"));

	}
	
	@Test
	public void example4(){
		
		assertEquals("new_s 0", BLANK, Main.executeCommand("new_s 0"));
//		S0_1
		assertEquals("push 0 96", BLANK, Main.executeCommand("push 0 96"));
		assertEquals("new_s 5", BLANK, Main.executeCommand("new_s 5"));
		assertEquals("print_s 5", EMPTY, Main.executeCommand("print_s 5"));
//		S5_1
		assertEquals("push 5 28", BLANK, Main.executeCommand("push 5 28"));
//		S5_2
		assertEquals("push 5 99", BLANK, Main.executeCommand("push 5 99"));
		assertEquals("new_q 0", BLANK, Main.executeCommand("new_q 0"));
//		S5_3
		assertEquals("push 5 33", BLANK, Main.executeCommand("push 5 33"));
//		S5_4
		assertEquals("push 5 88", BLANK, Main.executeCommand("push 5 88"));
//		S0_0
		assertEquals("pop 0", BLANK, Main.executeCommand("pop 0"));
		assertEquals("print_s 5", "28 99 33 88", Main.executeCommand("print_s 5"));
		assertEquals("pop 0", ERROR_STACK_IS_EMPTY, Main.executeCommand("pop 0"));
//		S0_1
		assertEquals("push 0 65", BLANK, Main.executeCommand("push 0 65"));
//		S5_5
		assertEquals("push 5 99", BLANK, Main.executeCommand("push 5 99"));
		assertEquals("dequeue 0", ERROR_QUEUE_IS_EMPTY, Main.executeCommand("dequeue 0"));
//		Q0_1
		assertEquals("enqueue 0 4", BLANK, Main.executeCommand("enqueue 0 4"));
		assertEquals("new_q 9", BLANK, Main.executeCommand("new_q 9"));
//		S5_6
		assertEquals("push 5 13", BLANK, Main.executeCommand("push 5 13"));
//		S5_7
		assertEquals("push 5 99", BLANK, Main.executeCommand("push 5 99"));
//		Q0_2
		assertEquals("enqueue 0 43", BLANK, Main.executeCommand("enqueue 0 43"));
//		Q0_3
		assertEquals("enqueue 0 21", BLANK, Main.executeCommand("enqueue 0 21"));
//		Q0_4
		assertEquals("enqueue 0 17", BLANK, Main.executeCommand("enqueue 0 17"));
//		S0_0,Q0_5
		assertEquals("stack->queue 0 0", BLANK, Main.executeCommand("stack->queue 0 0"));
//		Q0_6
		assertEquals("enqueue 0 4", BLANK, Main.executeCommand("enqueue 0 4"));
		assertEquals("stack->queue 0 0", ERROR_WRONG_COMMAND, Main.executeCommand("stack->queue 0 0"));
//		Q9_1
		assertEquals("enqueue 9 0", BLANK, Main.executeCommand("enqueue 9 0"));
//		Q0_5
		assertEquals("enqueue 0 4", BLANK, Main.executeCommand("enqueue 0 4"));
//		Q0_6
		assertEquals("enqueue 0 43", BLANK, Main.executeCommand("enqueue 0 43"));
		assertEquals("queue->queue 0 0", BLANK, Main.executeCommand("queue->queue 0 0"));
		assertEquals("stack->stack 5 5", BLANK, Main.executeCommand("stack->stack 5 5"));
//		Q0_7
		assertEquals("enqueue 0 40", BLANK, Main.executeCommand("enqueue 0 40"));
//		S5_8
		assertEquals("push 5 1", BLANK, Main.executeCommand("push 5 1"));
//		S5_9
		assertEquals("push 5 99", BLANK, Main.executeCommand("push 5 99"));
//		Q0_8
		assertEquals("enqueue 0 33", BLANK, Main.executeCommand("enqueue 0 33"));
//		Q0_9
		assertEquals("enqueue 0 99", ERROR_QUEUE_IS_FULL, Main.executeCommand("enqueue 0 99"));
//		Q0_10
		assertEquals("enqueue 0 8", ERROR_QUEUE_IS_FULL, Main.executeCommand("enqueue 0 8"));
//		S5_10
		assertEquals("push 5 0", BLANK, Main.executeCommand("push 5 0"));
//		S5_10_FULL
		assertEquals("push 5 9", ERROR_STACK_IS_FULL, Main.executeCommand("push 5 9"));
		assertEquals("delete_q 0", BLANK, Main.executeCommand("delete_q 0"));
		assertEquals("print_q 9", "0", Main.executeCommand("print_q 9"));
//		S5_10_FULL
		assertEquals("push 5 87", ERROR_STACK_IS_FULL, Main.executeCommand("push 5 87"));
		assertEquals("new_q 0", BLANK, Main.executeCommand("new_q 0"));
//		S5_10, Q0_10_FULL (error: wrong command)
		assertEquals("stack->queue 5 0", BLANK, Main.executeCommand("stack->queue 5 0"));
		assertEquals("enqueue 0 3", BLANK, Main.executeCommand("enqueue 0 3"));
//		
		assertEquals("queue->queue 0 0", BLANK, Main.executeCommand("queue->queue 0 0"));
//		
		assertEquals("enqueue 0 19", BLANK, Main.executeCommand("enqueue 0 19"));
//		S5_9,S0_1
		assertEquals("stack->stack 5 0", BLANK, Main.executeCommand("stack->stack 5 0"));
		assertEquals("print_s 0", "99", Main.executeCommand("print_s 0"));
		assertEquals("print_s 5", "28 99 33 88 99 13 99 1", Main.executeCommand("print_s 5"));
		assertEquals("print_q 0", "19 0 3", Main.executeCommand("print_q 0"));
		assertEquals("print_q 9", "0", Main.executeCommand("print_q 9"));		
	}
	
	@Test
	public void queueSwap() {
		assertEquals("new_q 0", BLANK, Main.executeCommand("new_q 0"));
		assertEquals("new_q 1", BLANK, Main.executeCommand("new_q 1"));
		assertEquals("enqueue 0 7", BLANK, Main.executeCommand("enqueue 0 7"));
		assertEquals("enqueue 1 11", BLANK, Main.executeCommand("enqueue 1 11"));
		assertEquals("queue->queue 0 1", BLANK, Main.executeCommand("queue->queue 0 1"));
		assertEquals("print_q 1", "7 11", Main.executeCommand("print_q 1"));	
		assertEquals("queue->queue 1 0", BLANK, Main.executeCommand("queue->queue 1 0"));
		assertEquals("queue->queue 1 0", BLANK, Main.executeCommand("queue->queue 1 0"));
		assertEquals("print_q 0", "7 11", Main.executeCommand("print_q 0"));
	}
}

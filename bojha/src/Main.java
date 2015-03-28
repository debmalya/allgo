/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;

/**
 *
 * @author debmalya jash
 */
public class Main {

	/**
	 * Error message for empty queue and pop command is executed.
	 */
	private static final String ERROR_QUEUE_IS_EMPTY = "error: queue is empty";

	/**
	 * Queue to stack movement.
	 */
	private static final String QUEUE_STACK_MOVE = "queue->stack";

	/**
	 * Queue to queue movement.
	 */
	private static final String QUEUE_QUEUE_MOVE = "queue->queue";

	/**
	 * Stack to queue movement.
	 */
	private static final String STACK_QUEUE_MOVE = "stack->queue";

	/**
	 * Error message for empty stack.
	 */
	private static final String ERROR_STACK_IS_EMPTY = "error: stack is empty";

	/**
	 * Error message when stack is full.
	 */
	private static final String ERROR_STACK_IS_FULL = "error: stack is full";

	/**
	 * Print queue command
	 */
	private static final String PRINT_QUEUE = "print_q";

	/**
	 * Delete queue command
	 */
	private static final String DELETE_QUEUE = "delete_q";

	/**
	 * Dequeue command
	 */
	private static final String DEQUEUE = "dequeue";

	/**
	 * Enqueue command.
	 */
	private static final String ENQUEUE = "enqueue";

	/**
	 * Command to create a new queue.
	 */
	private static final String NEW_QUEUE = "new_q";

	/**
	 * Print stack (FIFO) manner
	 */
	private static final String PRINT_STACK = "print_s";

	/**
	 * Delete stack and all of its contents.
	 */
	private static final String DELETE_STACK = "delete_s";
	/**
	 * Pop in the stack.
	 */
	private static final String POP = "pop";

	/**
	 * Push in the stack
	 */
	private static final String PUSH = "push";

	/**
	 * Wrong command
	 */
	private static final String ERROR_WRONG_COMMAND = "error: wrong command";

	/**
	 * Command to create a new stack.
	 */
	private static final String NEW_STACK = "new_s";

	/**
	 * List will have valid commands.
	 */
	public static List<String> validCommands = new ArrayList<>();

	/**
	 * Error message queue is full.
	 */
	private static final String ERROR_QUEUE_IS_FULL = "error: queue is full";

	/**
	 * Maximum number of elements a single stack and queue can contain.
	 */
	private static final int MAX_NUMBER_OF_ELEMENT = 10;

	/**
	 * Container of queues.
	 */
	private static Queue<Integer> queues[] = new ArrayBlockingQueue[MAX_NUMBER_OF_ELEMENT];

	private static Stack<Integer> stacks[] = new Stack[MAX_NUMBER_OF_ELEMENT];

	/**
	 * Stack to stack movement.
	 */
	private static final String STACK_TO_STACK_MOVE = "stack->stack";

	/**
	 * To receive keyboard input.
	 */
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String... args) {

		while (true) {
			try {
//				scanner = new Scanner(System.in);
				String command = scanner.nextLine();
				String result = executeCommand(command);
				if (!"".equals(result)) {
					System.out.println(result);
				}

			} catch (Throwable th) {
//				th.printStackTrace();
				System.out.println(ERROR_WRONG_COMMAND);
			} finally {
//				if (scanner != null) {
//					scanner.close();
//					scanner = null;
//				}
			}

		}
	}

    /**
	 * This will execute command and return result.
	 * @param command to be executed.
	 * @return execution result.
	 */
	public static String executeCommand(String command) throws NumberFormatException{
		String[] eachOptions = command.split(" ");
		String result = "";
		if (null != eachOptions[0]) // new_s

			switch (eachOptions[0]) {
			case NEW_STACK:
				result = newStack(eachOptions);
				break;
			case PUSH:
				result = push(eachOptions);
				break;
			case POP:
				result = pop(eachOptions);
				break;
			case DELETE_STACK:
				result = deleteStack(eachOptions);
				break;
			case PRINT_STACK:
				result = printStack(eachOptions);
				break;
			case STACK_TO_STACK_MOVE:
				result = stackToStackMove(eachOptions);
				break;
			case NEW_QUEUE:
				result = newQueue(eachOptions);
				break;
			case ENQUEUE:
				result = enqueue(eachOptions);
				break;
			case DEQUEUE:
				result = dequeue(eachOptions);
				break;
			case DELETE_QUEUE:
				result = deleteQueue(eachOptions);
				break;
			case PRINT_QUEUE:
				result = printQueue(eachOptions);
				break;
			case STACK_QUEUE_MOVE:
				result = stackToQueueMove(eachOptions);
				break;
			case QUEUE_QUEUE_MOVE:
				result = queueToQueueMove(eachOptions);
				break;
			case QUEUE_STACK_MOVE:
				result = queueToStackMove(eachOptions);
				break;
			default:
				System.out.println(ERROR_WRONG_COMMAND);
				break;
			}

		return result;

	}

	/**
	 * Moving element from queue with index eachOptions[1] to the stack with
	 * index eachOptions[2]. It will print "error: wrong command" in case of
	 * stack is full or queue is empty or index out of range.
	 * 
	 * @param eachOptions
	 *            command with options.
	 * @param queue
	 *            array.
	 * @param stack
	 *            array.
	 */
	private static String queueToStackMove(String[] eachOptions)
			throws NumberFormatException {
		int queueIndex = Integer.parseInt(eachOptions[1]);
		int stackIndex = Integer.parseInt(eachOptions[2]);
		if (queueIndex > -1 && queueIndex < 10 && stackIndex > -1
				&& stackIndex < 10) {
			if (queues[queueIndex] != null & !queues[queueIndex].isEmpty()
					&& stacks[stackIndex] != null
					&& stacks[stackIndex].size() < MAX_NUMBER_OF_ELEMENT) {
				stacks[stackIndex].push(queues[queueIndex].remove());
				return "";
			} else {
				return notInitialized();
			}
		} else {
			return invalidIndex();
		}

	}

	/**
	 * Moving element from queue with index eachOptions[1] to the queue with
	 * index eachOptions[2] It will print "error: wrong command" in case of
	 * destination queue is full or source queue is empty or index out of range.
	 * 
	 * @param eachOptions
	 *            commands and options.
	 * @param queue
	 *            array.
	 */
	private static String queueToQueueMove(String[] eachOptions)
			throws NumberFormatException {
		int sourceQueueIndex = Integer.parseInt(eachOptions[1]);
		int destinationQueueIndex = Integer.parseInt(eachOptions[2]);
		if (sourceQueueIndex > -1 && sourceQueueIndex < 10
				&& destinationQueueIndex > -1 && destinationQueueIndex < 10) {

			if (queues[sourceQueueIndex] != null
					&& !queues[sourceQueueIndex].isEmpty()
					&& queues[destinationQueueIndex] != null
					&& queues[destinationQueueIndex].size() < MAX_NUMBER_OF_ELEMENT) {
				queues[destinationQueueIndex].add(queues[sourceQueueIndex]
						.remove());
				return "";
			} else {
				return notInitialized();
			}

		} else {
			return invalidIndex();
		}

	}

	/**
	 * Moving elements from stack with index eachOptions[1] to the queue with
	 * index eachOptions[2] It will print "error: wrong command" in case of
	 * stack is empty or queue is full or index out of range.
	 * 
	 * @param eachOptions
	 *            command and options.
	 * @param stack
	 *            array.
	 * @param queue
	 *            array.
	 */
	private static String stackToQueueMove(String[] eachOptions)
			throws NumberFormatException {
		int stackIndex = Integer.parseInt(eachOptions[1]);
		int queueIndex = Integer.parseInt(eachOptions[2]);
		if (stackIndex > -1 && stackIndex < 10 && queueIndex > -1
				&& queueIndex < 10) {
			if (stacks[stackIndex] != null
					&& !stacks[stackIndex].isEmpty()) {
				if (queues[queueIndex] != null
						&& queues[queueIndex].size() < MAX_NUMBER_OF_ELEMENT) {
					queues[queueIndex].add(stacks[stackIndex].pop());
					return "";
				} else {
					return notInitialized();
				}
			} else {
				return notInitialized();
			}

		} else {
			return invalidIndex();
		}

	}

	/**
	 * Print queue contents. It will print "error: wrong command" in case of
	 * index out of range.
	 * 
	 * @param eachOptions
	 *            command with options.
	 * @param queue
	 *            containing all the queues.
	 */
	private static String printQueue(String[] eachOptions)
			throws NumberFormatException {
		int queueIndex = Integer.parseInt(eachOptions[1]);
		if (queueIndex > -1 && queueIndex < 10) {
			StringBuilder aboutMe = new StringBuilder();
			if (queues[queueIndex].isEmpty()) {
				return "empty";
			}
			Iterator<Integer> queueIterator = queues[queueIndex].iterator();
			while (queueIterator.hasNext()) {
				aboutMe.append(queueIterator.next());
				aboutMe.append(" ");
			}
			String result = aboutMe.toString();
			String[] all = result.split(" ");
			aboutMe.delete(0, aboutMe.length());
			for (int i = all.length - 1; i > -1; i--){
				aboutMe.append(all[i]);
				aboutMe.append(" ");
			}
			return aboutMe.toString().trim();
		} else {
			return invalidIndex();
		}

	}

	/**
	 * This will create a new stack
	 * 
	 * @param eachOptions
	 *            command with options.
	 * @param stack
	 *            array.
	 * @param me
	 *            instance
	 * @throws NumberFormatException
	 *             if stack number is not valid integer.
	 */
	private static String newStack(String[] eachOptions)
			throws NumberFormatException {
		int stackIndex = Integer.parseInt(eachOptions[1]);
		if (stackIndex > -1 && stackIndex < 10) {
			stacks[stackIndex] = new Stack<Integer>();
			return "";
		} else {
			// Stack index is not in range 0..9
			return invalidIndex();
		}
	}

	/**
	 * Push number into stack.
	 * 
	 * @param eachOptions
	 *            command with options
	 * @param stack
	 *            array.
	 */
	private static String push(String[] eachOptions)
			throws NumberFormatException {
		// push
		int stackIndex = Integer.parseInt(eachOptions[1]);
		int number = Integer.parseInt(eachOptions[2]);
		if (stacks[stackIndex] != null) {
			if (stacks[stackIndex].size() == MAX_NUMBER_OF_ELEMENT) {
				// Stack is full. Can not push
				return ERROR_STACK_IS_FULL;
			} else {
				stacks[stackIndex].push(number);
				return "";
			}
		} else {
			return notInitialized();
		}
	}

	/**
	 * It will pop from the stack
	 * 
	 * @param eachOptions
	 *            command with options.
	 * @param stack
	 *            array.
	 * @throws NumberFormatException
	 */
	private static String pop(String[] eachOptions)
			throws NumberFormatException {
		int stackIndex = Integer.parseInt(eachOptions[1]);
		if (stacks[stackIndex] != null) {
			if (stacks[stackIndex].isEmpty()) {
				return ERROR_STACK_IS_EMPTY;
			} else {
				stacks[stackIndex].pop();
				return "";
			}
		} else {
			return notInitialized();
		}
	}

	/**
	 * 
	 * @param eachOptions
	 * @param stack
	 * @throws NumberFormatException
	 */
	private static String deleteStack(String[] eachOptions)
			throws NumberFormatException {
		int stackIndex = Integer.parseInt(eachOptions[1]);
		if (stacks[stackIndex] != null) {
			stacks[stackIndex].clear();
			stacks[stackIndex] = null;
			return "";
		} else {
			return notInitialized();
		}
	}

	/**
	 * 
	 * @param eachOptions
	 * @param stack
	 * @throws NumberFormatException
	 */
	private static String printStack(String[] eachOptions)
			throws NumberFormatException {
		int stackIndex = Integer.parseInt(eachOptions[1]);
		if (stacks[stackIndex] != null) {
			Stack<Integer> auxiliaryStack = new Stack<Integer>();
			StringBuilder aboutMe = new StringBuilder();

			if (!stacks[stackIndex].isEmpty()) {
				while (!stacks[stackIndex].isEmpty()) {
					auxiliaryStack.push(stacks[stackIndex].pop());
				}

				while (!auxiliaryStack.empty()) {
					Integer value = auxiliaryStack.pop();
					aboutMe.append(value);
					aboutMe.append(" ");
					stacks[stackIndex].push(value);
				}
			} else {
				return "empty";
			}
			return aboutMe.toString().trim();
		} else {
			return notInitialized();
		}
	}

	/**
	 * 
	 * @param eachOptions
	 * @param stack
	 * @throws NumberFormatException
	 */
	private static String stackToStackMove(String[] eachOptions)
			throws NumberFormatException {
		int sourceStack = Integer.parseInt(eachOptions[1]);
		int destinationStack = Integer.parseInt(eachOptions[2]);
		if (stacks[sourceStack] != null && stacks[destinationStack] != null) {
			if (stacks[destinationStack].size() == MAX_NUMBER_OF_ELEMENT) {
				return ERROR_WRONG_COMMAND;

			}
			if (stacks[sourceStack].isEmpty()) {
				return ERROR_WRONG_COMMAND;

			}
			stacks[destinationStack].push(stacks[sourceStack].pop());
			return "";
		} else {
			return ERROR_WRONG_COMMAND;
		}
	}

	/**
	 * 
	 * @param eachOptions
	 * @param queue
	 * @param me
	 * @throws NumberFormatException
	 */
	private static String newQueue(String[] eachOptions)
			throws NumberFormatException {
		int queueIndex = Integer.parseInt(eachOptions[1]);
		if (queueIndex > -1 && queueIndex < 10) {
			queues[queueIndex] = new ArrayBlockingQueue<Integer>(
					MAX_NUMBER_OF_ELEMENT);
			return "";
		} else {
			return invalidIndex();
		}
	}

	/**
	 * Enqueue a number.
	 * 
	 * @param eachOptions
	 *            command with all options
	 *
	 * @throws NumberFormatException
	 */
	private static String enqueue(String[] eachOptions)
			throws NumberFormatException {
		int queueIndex = Integer.parseInt(eachOptions[1]);
		int number = Integer.parseInt(eachOptions[2]);
		if (queueIndex > -1 && queueIndex < 10) {
			if (queues[queueIndex] != null) {
				if (queues[queueIndex].size() == MAX_NUMBER_OF_ELEMENT) {
					return ERROR_QUEUE_IS_FULL;
				} else {
					queues[queueIndex].offer(number);
					return "";
				}
			} else {
				return notInitialized();
			}
		} else {
			return invalidIndex();
		}
	}

	/**
	 * 
	 * @param eachOptions
	 * @param queue
	 * @throws NumberFormatException
	 */
	private static String dequeue(String[] eachOptions)
			throws NumberFormatException {
		int queueIndex = Integer.parseInt(eachOptions[1]);
		if (queueIndex > -1 && queueIndex < 10) {
			if (queues[queueIndex] != null) {
				if (queues[queueIndex].isEmpty()) {
					return ERROR_QUEUE_IS_EMPTY;
				} else {
					queues[queueIndex].poll();
					return "";
				}
			} else {
				return notInitialized();
			}
		} else {
			return invalidIndex();
		}
	}

	/**
	 * Delete queue with index i with all it's element.
	 * 
	 * @param eachOptions
	 * @param queue
	 * @throws NumberFormatException
	 */
	private static String deleteQueue(String[] eachOptions)
			throws NumberFormatException {
		int queueIndex = Integer.parseInt(eachOptions[1]);
		if (queueIndex > -1 && queueIndex < 10) {
			queues[queueIndex].clear();
			queues[queueIndex] = null;
			return "";
		} else {
			return invalidIndex();
		}
	}

	/**
	 * Print error message if stack is not initialized.
	 */
	private static String notInitialized() {
		// Stack or queue is not initialized.
		// Need to call new_s first or new_q.
		return ERROR_WRONG_COMMAND;
	}

	/**
     * 
     */
	private static String invalidIndex() {
		return ERROR_WRONG_COMMAND;
	}

	@Override
	protected void finalize() throws Throwable {		
		super.finalize();
		if (scanner != null) {
			scanner.close();
			
		}
	}

	
}


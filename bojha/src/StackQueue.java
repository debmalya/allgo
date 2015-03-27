/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;

/**
 *
 * @author debmalya jash
 */
public class StackQueue {

    private static final String QUEUE_STACK_MOVE = "queue->stack";

	private static final String QUEUE_QUEUE_MOVE = "queue->queue";

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

    private static final String ERROR_QUEUE_IS_FULL = "error: queue is full";

    /**
     * Maximum number of elements a single stack and queue can contain.
     */
    private static final int MAX_NUMBER_OF_ELEMENT = 10;

    private static final String STACK_TO_STACK_MOVE = "stack->stack";

    public static void main(String... args) {
        StackQueue me = new StackQueue();
        ServStack<Integer> stack[] = new ServStack[MAX_NUMBER_OF_ELEMENT];
        ServQueue<Integer> queue[] = new ServQueue[MAX_NUMBER_OF_ELEMENT];
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {

                String command = scanner.nextLine();
                String[] eachOptions = command.split(" ");
                if (null != eachOptions[0]) // new_s
                switch (eachOptions[0]) {
                    case NEW_STACK:
                        newStack(eachOptions, stack, me);
                        break;
                    case PUSH:
                        push(eachOptions, stack);
                        break;
                    case POP:
                        pop(eachOptions, stack);
                        break;
                    case DELETE_STACK:
                        deleteStack(eachOptions, stack);
                        break;
                    case PRINT_STACK:
                        printStack(eachOptions, stack);
                        break;
                    case STACK_TO_STACK_MOVE:
                        stackToStackMove(eachOptions, stack);
                        break;
                    case NEW_QUEUE:
                        newQueue(eachOptions, queue, me);
                        break;
                    case ENQUEUE:
                        enqueue(eachOptions, queue);
                        break;
                    case DEQUEUE:
                        dequeue(eachOptions, queue);
                        break;
                    case DELETE_QUEUE:
                        deleteQueue(eachOptions, queue);
                        break;
                    case PRINT_QUEUE:
                    	printQueue(eachOptions, queue);
                    	break;
                    case STACK_QUEUE_MOVE:
                    	stackToQueueMove(eachOptions,stack,queue);
                    	break;
                    case QUEUE_QUEUE_MOVE:
                    	queueToQueueMove(eachOptions,queue);
                    	break;
                    case QUEUE_STACK_MOVE:
                    	queueToStackMove(eachOptions,queue,stack);
                    	break;
                    default:
                        System.out.println(ERROR_WRONG_COMMAND);
                        break;
                }

            } catch (Throwable th) {
            	th.printStackTrace();
                System.err.println(ERROR_WRONG_COMMAND);
            }

        }
    }

    /**
     * Moving element from queue with index eachOptions[1] to the stack with index eachOptions[2].
     * It will print "error: wrong command" in case of stack is full or queue is empty or index out of range.
     * @param eachOptions command with options.
     * @param queue array.
     * @param stack array.
     */
    private static void queueToStackMove(String[] eachOptions,
			ServQueue<Integer>[] queue, ServStack<Integer>[] stack) throws NumberFormatException{
		int queueIndex = Integer.parseInt(eachOptions[1]);
		int stackIndex = Integer.parseInt(eachOptions[2]);
		if (queueIndex > -1 && queueIndex < 10 && stackIndex > -1 && stackIndex < 10) {
			if (queue[queueIndex] != null & !queue[queueIndex].isEmpty() && stack[stackIndex] != null && !stack[stackIndex].isFull()){
				stack[stackIndex].push(queue[queueIndex].remove());
			} else {
				notInitialized();
			}
		} else {
			invalidIndex();
		}
		
	}

	/**
     * Moving element from queue with index eachOptions[1] to the queue with index eachOptions[2]
     * It will print "error: wrong command" in case of destination queue is full or source queue is empty or index out of range.
     * @param eachOptions commands and options.
     * @param queue array.
     */
    private static void queueToQueueMove(String[] eachOptions,
			ServQueue<Integer>[] queue) throws NumberFormatException{
		int sourceQueueIndex = Integer.parseInt(eachOptions[1]);
		int destinationQueueIndex = Integer.parseInt(eachOptions[2]);
		if (sourceQueueIndex > -1 && sourceQueueIndex < 10 && destinationQueueIndex > -1 && destinationQueueIndex < 10) {
			if (queue[sourceQueueIndex] != null && !queue[sourceQueueIndex].isEmpty() ){
				if (queue[destinationQueueIndex] != null && !queue[destinationQueueIndex].isFull()) {
					queue[destinationQueueIndex].add(queue[sourceQueueIndex].remove());
				}
			} else {
				notInitialized();
			}
		} else {
			invalidIndex();
		}
		
	}

	/**
     * Moving elements from stack with index eachOptions[1] to the queue with index eachOptions[2] 
     * It will print "error: wrong command" in case of stack is empty or queue is full or index out of range.
     * @param eachOptions command and options.
     * @param stack array.
     * @param queue array.
     */
    private static void stackToQueueMove(String[] eachOptions,
			ServStack<Integer>[] stack, ServQueue<Integer>[] queue) throws NumberFormatException{
		int stackIndex = Integer.parseInt(eachOptions[1]);
		int queueIndex = Integer.parseInt(eachOptions[2]);
		if (stackIndex > -1 && stackIndex < 10 && queueIndex > -1 && queueIndex < 10) {
			if (stack[stackIndex] != null && !stack[stackIndex].isEmpty()) {
				if (queue[queueIndex] != null && !queue[queueIndex].isFull()) {
					queue[queueIndex].add(stack[stackIndex].pop());
				} else {
					notInitialized();
				}
			} else {
				notInitialized();
			}
			
		} else {
			invalidIndex();
		}
		
	}

	/**
     * Print queue contents.
     * It will print "error: wrong command" in case of index out of range.
     * @param eachOptions command with options.
     * @param queue containing all the queues.
     */
    private static void printQueue(String[] eachOptions,
			ServQueue<Integer>[] queue) throws NumberFormatException {
		int queueIndex = Integer.parseInt(eachOptions[1]);
		if (queueIndex > -1 && queueIndex < 10) {
			System.out.println(queue[queueIndex]);
		} else {
			invalidIndex();
		}
		
	}

    /**
     * This will create a new stack
     * @param eachOptions command with options.
     * @param stack array.
     * @param me instance
     * @throws NumberFormatException if stack number is not valid integer.
     */
	private static void newStack(String[] eachOptions, ServStack<Integer>[] stack, StackQueue me)  throws NumberFormatException{
        int stackIndex = Integer.parseInt(eachOptions[1]);
        if (stackIndex > -1 && stackIndex < 10) {
            stack[stackIndex] = me.new ServStack<Integer>();
        } else {
            // Stack index is not in range 0..9
            invalidIndex();
        }
    }

	/**
	 * Push number into stack.
	 * @param eachOptions command with options
	 * @param stack array.
	 */
    private static void push(String[] eachOptions, ServStack<Integer>[] stack) throws NumberFormatException {
        // push
        int stackIndex = Integer.parseInt(eachOptions[1]);
        int number = Integer.parseInt(eachOptions[2]);
        if (stack[stackIndex] != null) {
            if (stack[stackIndex].isFull()) {
                // Stack is full. Can not push
                System.out.println(ERROR_STACK_IS_FULL);
            } else {
                stack[stackIndex].push(number);
            }
        } else {
            
            notInitialized();
        }
    }

    /**
     * It will pop from the stack
     * @param eachOptions command with options.
     * @param stack array.
     * @throws NumberFormatException
     */
    private static void pop(String[] eachOptions, ServStack<Integer>[] stack) throws NumberFormatException {
        int stackIndex = Integer.parseInt(eachOptions[1]);
        if (stack[stackIndex] != null) {
            if (stack[stackIndex].isEmpty()) {
                System.out.println(ERROR_STACK_IS_EMPTY);
            } else {
                stack[stackIndex].pop();
            }
        } else {
            notInitialized();
        }
    }

    /**
     * 
     * @param eachOptions
     * @param stack
     * @throws NumberFormatException
     */
    private static void deleteStack(String[] eachOptions, ServStack<Integer>[] stack) throws NumberFormatException {
        int stackIndex = Integer.parseInt(eachOptions[1]);
        if (stack[stackIndex] != null) {
            stack[stackIndex] = null;
        } else {
            notInitialized();
        }
    }

    /**
     * 
     * @param eachOptions
     * @param stack
     * @throws NumberFormatException
     */
    private static void printStack(String[] eachOptions, ServStack<Integer>[] stack) throws NumberFormatException {
        int stackIndex = Integer.parseInt(eachOptions[1]);
        if (stack[stackIndex] != null) {
            System.out.println(stack[stackIndex]);
        } else {
            notInitialized();
        }
    }

    /**
     * 
     * @param eachOptions
     * @param stack
     * @throws NumberFormatException
     */
    private static void stackToStackMove(String[] eachOptions, ServStack<Integer>[] stack) throws NumberFormatException {
        int sourceStack = Integer.parseInt(eachOptions[1]);
        int destinationStack = Integer.parseInt(eachOptions[2]);
        if (stack[sourceStack] != null && stack[destinationStack] != null) {
        	if (stack[destinationStack].isFull()) {
        		System.out.println(ERROR_WRONG_COMMAND);
        		return;
        	}
        	if (stack[sourceStack].isEmpty()) {
        		System.out.println(ERROR_WRONG_COMMAND);
        		return;
        	}
            stack[destinationStack].push(stack[sourceStack].pop());
        } else {
            System.out.println(ERROR_WRONG_COMMAND);
        }
    }

    /**
     * 
     * @param eachOptions
     * @param queue
     * @param me
     * @throws NumberFormatException
     */
    private static void newQueue(String[] eachOptions, ServQueue<Integer>[] queue, StackQueue me) throws NumberFormatException {
        int queueIndex = Integer.parseInt(eachOptions[1]);
        if (queueIndex > -1 && queueIndex < 10) {
            queue[queueIndex] = me.new ServQueue<Integer>(MAX_NUMBER_OF_ELEMENT);
        } else {
            invalidIndex();
        }
    }

    /**
     * 
     * @param eachOptions
     * @param queue
     * @throws NumberFormatException
     */
    private static void enqueue(String[] eachOptions, ServQueue<Integer>[] queue) throws NumberFormatException {
        int queueIndex = Integer.parseInt(eachOptions[1]);
        int number = Integer.parseInt(eachOptions[2]);
        if (queueIndex > -1 && queueIndex < 10) {
            if (queue[queueIndex] != null) {
                if (queue[queueIndex].isFull()) {
                    System.out.println(ERROR_QUEUE_IS_FULL);
                } else {
                    queue[queueIndex].offer(number);
                }
            } else {
                notInitialized();
            }
        } else {
            invalidIndex();
        }
    }

    /**
     * 
     * @param eachOptions
     * @param queue
     * @throws NumberFormatException
     */
    private static void dequeue(String[] eachOptions, ServQueue<Integer>[] queue) throws NumberFormatException {
        int queueIndex = Integer.parseInt(eachOptions[1]);
        if (queueIndex > -1 && queueIndex < 10) {
            if (queue[queueIndex] != null) {
                if (queue[queueIndex].isEmpty()) {
                    System.out.println("error: queue is empty");
                } else {
                    queue[queueIndex].poll();
                }
            } else {
                notInitialized();
            }
        } else {
            invalidIndex();
        }
    }

    /**
     * 
     * @param eachOptions
     * @param queue
     * @throws NumberFormatException
     */
    private static void deleteQueue(String[] eachOptions, ServQueue<Integer>[] queue) throws NumberFormatException {
        int queueIndex = Integer.parseInt(eachOptions[1]);
        if (queueIndex > -1 && queueIndex < 10) {
            queue[queueIndex] = null;
        } else {
            invalidIndex();
        }
    }

    /**
     * Print error message if stack is not initialized.
     */
    private static void notInitialized() {
        // Stack or queue is not initialized.
        // Need to call new_s first or new_q.
        System.out.println(ERROR_WRONG_COMMAND);
    }

    /**
     * 
     */
    private static void invalidIndex() {
        System.out.println(ERROR_WRONG_COMMAND);
    }

    /**
     * 
     * @author debmalyajash
     *
     * @param <E>
     */
    class ServStack<E> extends Stack<E> {

        /**
         *
         */
        private static final long serialVersionUID = 2960696804021946452L;

        /**
         * To check whether Stack is full or not.
         *
         * @return true if stack is full, false otherwise.
         */
        public boolean isFull() {
            return this.size() == MAX_NUMBER_OF_ELEMENT;
        }

        @Override
        public String toString() {
            Stack<E> auxiliaryStack = new Stack<E>();
            StringBuilder aboutMe = new StringBuilder();
            
            if (!this.isEmpty()) {
                while (!this.isEmpty()) {
                    auxiliaryStack.push(this.pop());
                }

                while (!auxiliaryStack.empty()) {
                    E value = auxiliaryStack.pop();
                    aboutMe.append(value);
                    aboutMe.append(" ");
                    this.push(value);
                }
            } else {
                return "empty";
            }
            return aboutMe.toString().trim();
        }

    }

    /**
     * 
     * @author debmalyajash
     *
     * @param <E>
     */
    class ServQueue<E> extends ArrayBlockingQueue<E> {

        public ServQueue(int capacity) {
            super(capacity);
        }

        public boolean isFull() {
            return this.size() == MAX_NUMBER_OF_ELEMENT;
        }

		@Override
		public String toString() {
			StringBuilder aboutMe = new StringBuilder();
			if (this.isEmpty()){
				return "empty";
			}
			Iterator<E> queueIterator = this.iterator();
			while (queueIterator.hasNext()) {
				aboutMe.append(queueIterator.next());
				aboutMe.append(" ");
			}
			return aboutMe.toString().trim();
		}
        
        
    }
}

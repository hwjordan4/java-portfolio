/* Harrison Jordan
 * CS 3401
 * Section 02
 * Prof. Gayler
 * 02/02/2015
 * Assignment 3-3
 */
import java.util.Stack;
/**
 * Modification of EvaluateExpression
 * @author Liang
 *
 */
public class Expression {

	public static void main(String[] args) {
		// Check number of arguments passed
		if (args.length != 1) {
			System.out.println("Usage: java Expression \"expression\"");
			System.exit(1);
		}

		try {
			System.out.println(infixToPostfix(args[0]));
		} catch (Exception ex) {
			System.out.println("Not an expression: " + args[0]);
		}

	}

	/**
	 * @param expression in infix form
	 * @return expression in post-fix form
	 * @throws Runtime Exception if the expression is null or empty
	 * 
	 */
	private static String infixToPostfix(String expression) {

		if (expression.length() == 0 || expression == null)
			throw new RuntimeException();

		// Create operandStack to store operands
		Stack<Integer> operandStack = new Stack<Integer>();

		// Create operatorStack to store operators
		Stack<Character> operatorStack = new Stack<Character>();

		Stack<String> postFix = new Stack<String>();
		String result = "";

		// Insert blanks around (, ), +, -, /, and *
		expression = insertBlanks(expression);

		// Extract operands and operators
		String[] tokens = expression.split(" ");

		// Phase 1: Scan tokens
		for (String token : tokens) {
			if (token.length() == 0) // Blank space
				continue; // Back to the while loop to extract the next token
			else if (token.charAt(0) == '+' || token.charAt(0) == '-') {
				// Process all +, -, *, / in the top of the operator stack
				while (!operatorStack.isEmpty()
						&& (operatorStack.peek() == '+'
								|| operatorStack.peek() == '-'
								|| operatorStack.peek() == '*' || operatorStack
								.peek() == '/')) {
					addToSTACK(operandStack, operatorStack, postFix);
				}

				// Push the + or - operator into the operator stack
				operatorStack.push(token.charAt(0));
			} else if (token.charAt(0) == '*' || token.charAt(0) == '/') {
				// Process all *, / in the top of the operator stack
				while (!operatorStack.isEmpty()
						&& (operatorStack.peek() == '*' || operatorStack.peek() == '/')) {
					addToSTACK(operandStack, operatorStack, postFix);
				}

				// Push the * or / operator into the operator stack
				operatorStack.push(token.charAt(0));
			} else if (token.trim().charAt(0) == '(') {
				operatorStack.push('('); // Push '(' to stack
			} else if (token.trim().charAt(0) == ')') {
				// Process all the operators in the stack until seeing '('
				while (operatorStack.peek() != '(') {
					addToSTACK(operandStack, operatorStack, postFix);
				}

				operatorStack.pop(); // Pop the '(' symbol from the stack
			} else { // An operand scanned
				// Push an operand to the stack
				operandStack.push(new Integer(token));
			}
		}

		// Phase 2: process all the remaining operators in the stack
		while (!operatorStack.isEmpty()) {
			addToSTACK(operandStack, operatorStack, postFix);
		}

		while (!postFix.isEmpty())
			result = postFix.pop() + result;
		// Return the result
		return result;
	}

	/**
	 * @param operandStack, operatorStack, postFix
	 * @void adds operands and operators to the postfix stack
	 * @throws runtime exception if any of the stacks are null
	 * 
	 */
	public static void addToSTACK(Stack<Integer> operandStack,
			Stack<Character> operatorStack, Stack<String> postFix) {

		if (operandStack == null || operatorStack == null || postFix == null)
			throw new RuntimeException();

		boolean stackHasTwo = true;
		boolean stackHasOne = true;
		char op = operatorStack.pop();
		int op1 = 0;
		if (!operandStack.empty()) {
			op1 = operandStack.pop();
			stackHasOne = true;
		} else {
			stackHasOne = false;
		}
		int op2 = 0;
		if (!operandStack.empty()) {
			op2 = operandStack.pop();
			stackHasTwo = true;
		} else {
			stackHasTwo = false;
		}

		if (stackHasTwo)
			postFix.push("" + op2);
		if (stackHasOne)
			postFix.push("" + op1);
		postFix.push("" + op);

	}

	/**
	 * @param String expression of operands and operators
	 * @return String with blanks inserted around operators
	 * @throws runtime exception if parameter is empty or null
	 */
	public static String insertBlanks(String s) {
		
		if(s == null || s.length() == 0)
			throw new RuntimeException();
		
		String result = "";

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(' || s.charAt(i) == ')' || s.charAt(i) == '+'
					|| s.charAt(i) == '-' || s.charAt(i) == '*'
					|| s.charAt(i) == '/')
				result += " " + s.charAt(i) + " ";
			else
				result += s.charAt(i);
		}

		return result;
	}

}

import java.util.Stack;

public class Solution {
    
	public static void reverseStack(Stack<Integer> stack) {
		// write your code here
		if(stack.isEmpty())return;
		int top=stack.pop();
		reverseStack(stack);
		addAtBottom(stack, top);
		
	}
	public static void addAtBottom(Stack<Integer> stack, int val){
		if(stack.isEmpty()){
            stack.push(val);
            return;
        }
		int top=stack.pop();
		addAtBottom(stack, val);
		stack.push(top);
	}

}

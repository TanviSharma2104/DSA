import java.util.* ;
import java.io.*; 
public class Solution {
	public static Stack<Integer> sortStack(Stack<Integer> s) {
		//Write your code here
		Stack<Integer> sorted=new Stack<>();
		while(!s.isEmpty()){
			int temp=s.pop();
			while(!sorted.isEmpty() && sorted.peek()>temp){
				s.push(sorted.pop());
			}
			sorted.push(temp);
		}
		return sorted;
	}

	
}

public class Solution {
    public static int countingGraphs(int n) {
        // Write your code here.
        int power=n*(n-1)/2;
        return (int)Math.pow(2, power);
    }
}

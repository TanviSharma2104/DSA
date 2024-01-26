import java.util.Arrays;

public class Solution {
    public static int minimizeCost(int n, int k, int []height){
        // Write your code here.
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        return solve(n, k, dp, height);

    }

    private static int solve(int n, int k, int[]dp, int[] height){
        dp[0]=0;
        for(int i=1;i<n;i++){
            int step=Integer.MAX_VALUE;
            
            for (int j = 1; j <= k; j++) {
                if (i - j >= 0) {
                    int jump = dp[i - j] + Math.abs(height[i] - height[i - j]);
                    step = Math.min(jump, step);
                }
            }
            dp[i]=step;
        }
        return dp[n-1];
    }
}

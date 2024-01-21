import java.util.* ;
import java.io.*; 
public class Solution {
    
    public static int frogJump(int n, int h[]) {

        // Write your code here..
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        dp[0]=0;
        
        
        for(int i=1;i<n;i++){
            int j1=Integer.MAX_VALUE;
            int j2=dp[i-1]+Math.abs(h[i]-h[i-1]);
            if(i>1){
                j1=dp[i-2]+Math.abs(h[i]-h[i-2]);
            }
            dp[i]=Math.min(j1,j2);
            
        }
        return dp[n-1];
        
    }

}

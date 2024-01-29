//Memorization

import java.util.Arrays;
public class Solution {
    private static int helper(int day, int last, int points[][], int dp[][]){
        
        if (day == 0) {
            int max = 0;
            for (int i = 0; i < 3; i++) {
                if (i != last) {
                    max = Math.max(points[0][i], max);
                }
            }
            return dp[day][last] = max;
        }


        if(dp[day][last]!=-1)return dp[day][last];


        int max=0;
        for(int i=0;i<3;i++){
            if(i!=last){
                int curr=points[day][i]+ helper(day-1, i, points, dp);
                max=Math.max(curr, max);
            }
        }
        return dp[day][last]=max;
    }
    public static int ninjaTraining(int n, int points[][]) {

        // Write your code here..
        int[][] dp=new int[n][4];
        for (int[] row : dp)
            Arrays.fill(row, -1);

        return helper(n-1, 3, points, dp);  

    }

}

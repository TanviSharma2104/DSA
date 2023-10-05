// You are climbing a staircase. It takes n steps to reach the top.

// Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

// Example 1:

// Input: n = 2
// Output: 2
// Explanation: There are two ways to climb to the top.
// 1. 1 step + 1 step
// 2. 2 steps


class Solution {
    public int climbStairs(int n) {

    // to reach 0th stair you have only one choice so dp[0]=1
		//to reach 1st stair again you have one choice only so dp[1]=1

		//for 2nd stair you can either reach from 0th stair or by 1st stair
		//so dp[2]=dp[0]+dp[1]
        if(n<=1)return 1;
        int[] dp=new int[n+1];
        for(int i=0;i<n+1;i++){
            dp[i]=-1;

        }
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}

//question link:- https://leetcode.com/problems/climbing-stairs/

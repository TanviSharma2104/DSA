import java.util.* ;
import java.io.*; 
public class Solution {
    
    public static ArrayList<Integer> subsetSum(int num[]) {
        // Write your code here..
        ArrayList<Integer> ans=new ArrayList<>();
        solve(0,0,num, ans);
        Collections.sort(ans);
        return ans;
    }

    private static void solve( int index, int sum, int num[], ArrayList<Integer> ans ){
        if(index==num.length){
            ans.add(sum);
            return;
        }
        
        //pick
        solve(index+1, sum+num[index], num, ans);

        //not picked
        solve(index+1, sum, num, ans);

    }

}

import java.util.ArrayList;
import java.util.List;
public class Solution {
    public static List<String> generateSubsequences(String s) {
        // Write your code here
        List<String> ans=new ArrayList<>();
        // int temp="";
        helper(ans, s, "", 0);
        return ans;
    }

    private static void helper(List<String> ans, String s,String temp, int i){
        if(i==s.length()){
            ans.add(temp);
            return;

        }

        helper(ans, s, temp+s.charAt(i), i+1);
        helper(ans, s, temp, i+1);

    }
}

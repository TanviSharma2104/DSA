import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static List< String > generateString(int n) {
        // Write your code here.
        List<String> list=new ArrayList<>();

        if(n==0){
            list.add("");
            return list;
        }

        if(n==1){
            list.add("0");
            list.add("1");
            return list;
        }

        List<String> res=new ArrayList<>();
        List<String> prev=generateString(n-1);

        for(String str: prev){
            res.add(str+"0");
            if(str.charAt(str.length()-1)!='1'){
                res.add(str+"1");
            }

        }
        return res;
    }
}

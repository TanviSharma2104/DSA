import java.util.ArrayList;
public class Solution {
    public static int[][] printAdjacency(int n, int m, int[][] edges) {
        // Write your code here.
        int[][] ans=new int[n][];

        ArrayList<ArrayList<Integer>> li=new ArrayList<>();

        for(int i=0;i<n;i++){
            li.add(new ArrayList<Integer>());
        }

        for(int i=0;i<m;i++){
    
            int u=edges[i][0];
            int v=edges[i][1];
            li.get(u).add(v);
            li.get(v).add(u);
        }

        for(int i=0;i<n;i++){
            ans[i]=new int[li.get(i).size()+1];
            ans[i][0]=i;
            int c=1;
            for(int j=0;j<li.get(i).size();j++){
                ans[i][c++]=li.get(i).get(j);
            }
        }
        return ans;
    }
}

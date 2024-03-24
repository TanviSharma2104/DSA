import java.util.*;

public class Solution {

    public static List<Integer> topologicalSort(int[][] edges, int e, int v) {
        // Write your code here!
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<v;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<e;i++){
            int u=edges[i][0];
            int vv=edges[i][1];
            adj.get(u).add(vv);
        }

        boolean[] vis=new boolean[v];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<v;i++){
            if(!vis[i]){
                dfs(adj, i, st, vis);
            }
        }

         List<Integer> ans=new ArrayList<>();
        while(!st.isEmpty()){
            ans.add(st.pop());
        }
        return ans;


    }

    public static void dfs( List<List<Integer>> adj, int node, Stack<Integer> st, boolean[] vis){
        vis[node]=true;
        for (int it : adj.get(node)) {
            if(!vis[it]){
                dfs(adj, it, st, vis);
            }
        }
        st.push(node);
    }

}

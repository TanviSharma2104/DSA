class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean vis[]=new boolean[V+1];
        // vis[0]=true;
        ArrayList<Integer> li=new ArrayList<>();
        dfs(0, vis, adj, li);
        return li;
    }
    
    private void dfs(int node, boolean vis[], ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> li){
        vis[node]=true;
        li.add(node);
        for(Integer i: adj.get(node)){
            if(vis[i]==false){
                dfs(i, vis,adj, li);
            }
        }
    }
}

//if not connected graph with edges given only no adj list given
import java.util.ArrayList;


public class Solution {
    public static ArrayList<ArrayList<Integer>> depthFirstSearch(int v, int e, ArrayList<ArrayList<Integer>> edges) {
        // Write your code here.
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        boolean[] vis=new boolean[v];
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<v;i++){
            adj.add(new ArrayList<Integer>());

        }
        for(int i=0;i<e;i++){
            int u=edges.get(i).get(0);
            int x=edges.get(i).get(1);
            adj.get(u).add(x);
            adj.get(x).add(u);
        }

        for(int i=0;i<v;i++){
            if(vis[i]==false){
                ArrayList<Integer> li=new ArrayList<>();
                dfs(i, vis, adj, li);
                // Collections.sort(li);
                ans.add(li);
            }
        }
        return ans;
    }

    private static void dfs(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj,ArrayList<Integer> li ){
        vis[node]=true;
        li.add(node);
        for(Integer it: adj.get(node)){
            if(vis[it]==false){
                dfs(it, vis, adj, li);
            }
        }
    }

    
}

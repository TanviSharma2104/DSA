import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Arrays;
public class Solution {
    static class Pair{
        int first;
        int second;
        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    static class Graph {
        boolean detectCycle(int V, List<List<Integer>> adj) {
            // Write your code here.
            
            boolean vis[] = new boolean[V];
            Arrays.fill(vis,false);

            for(int i=0;i<V;i++){
                if(vis[i]==false){
                    if(checkCycle(i,V,adj,vis))return true;
                }
            }
            return false;
        }
        boolean checkCycle(int src, int V, List<List<Integer>> adj,boolean vis[] ){
            vis[src]=true;
            Queue<Pair> q=new LinkedList<>();
            q.add(new Pair(src,-1));
            while(!q.isEmpty()){
                int curr=q.peek().first;
                int parent=q.peek().second;
                q.remove();
                for(int adjNode: adj.get(curr)){
                    if(vis[adjNode]==false){
                        vis[adjNode]=true;
                        q.add(new Pair(adjNode, curr));
                    }
                    else if(parent!=adjNode){
                        return true;
                    }
                }
            }
            return false;

        }
    };
}

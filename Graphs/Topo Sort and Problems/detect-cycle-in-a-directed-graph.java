import java.util.*;
public class Solution {
  public static boolean detectCycleInDirectedGraph(int n, ArrayList < ArrayList < Integer >> edges) {
    // Write your code here.
    //Kahn's algo
     List<List<Integer>> adj = new ArrayList<>();
     int[] indegree=new int[n+1];
     Arrays.fill(indegree,0);
     for(int i=0; i<=n; i++) {
        adj.add(new ArrayList<>());
     }

      for(int i=0;i<edges.size();i++){
        int u=edges.get(i).get(0);
        int v=edges.get(i).get(1);
        adj.get(u).add(v);
        indegree[v]++;
      }

   

      Queue<Integer> q=new LinkedList<>();
        for(int i=1;i<=n;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }

        int c=0;
        while(!q.isEmpty()){
            int node=q.peek();
            q.remove();
            c++;

            for(int it: adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0){
                    q.add(it);
                }
            }
        }
        if(c!=n)return true;
        return false;
  }
}

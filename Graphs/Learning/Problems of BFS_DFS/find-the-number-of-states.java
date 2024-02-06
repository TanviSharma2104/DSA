import java.util.*;
public class Solution {
    public static int findNumOfProvinces(int[][] roads, int n) {
        // Write your code here.
        boolean[] vis=new boolean[n];
        Queue<Integer> q=new LinkedList<>();
        int c=0;
        for(int i=0;i<n;i++){
            if(vis[i]==false){
                c++;
                bfs(vis,i,roads, n,q);
            }
        }
        return c;
    }

    static void bfs(boolean[] vis, int node, int[][] roads, int n, Queue<Integer> q){
        q.add(node);
        vis[node]=true;
        while(!q.isEmpty()){
            Integer x=q.poll();
            for(int i=0;i<n;i++){
                if(vis[i]==false && roads[x][i]==1){
                    q.add(i);
                    vis[i]=true;
                }
            }
        }
    }
    
}


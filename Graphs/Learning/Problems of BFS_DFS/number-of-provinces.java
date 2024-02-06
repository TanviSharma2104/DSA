class Solution {
    // public int findCircleNum(int[][] isConnected) {
    //     ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
    //     for(int i=0;i<isConnected.length;i++){
    //         adj.add(new ArrayList<Integer>());
    //     }
    //     for(int i=0;i<isConnected.length;i++){
    //         for(int j=0;j<isConnected.length;j++){
    //             if(i!=j && isConnected[i][j]==1){
    //                 adj.get(i).add(j);
    //             }
    //         }
    //     }
    //     boolean[] vis=new boolean[isConnected.length];
    //     int c=0;
    //     for(int i=0;i<isConnected.length;i++){
    //         if(vis[i]==false){
    //             c++;
    //             dfs(i, vis, adj);
    //         }
    //     }
    //     return c;
    // }
    // private void dfs(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj){
    //     vis[node]=true;
    //     for(Integer it: adj.get(node)){
    //         if(vis[it]==false){
    //             dfs(it, vis, adj);
    //         }
    //     }
    // }


    public int findCircleNum(int[][] isConnected){
        int c=0;
        boolean[] vis=new boolean[isConnected.length];
        for(int i=0;i<isConnected.length;i++){
            if(vis[i]==false){
                c++;
                dfs(i,vis, isConnected);
            }
        }
        return c;
    }

    private void dfs(int node, boolean[] vis, int[][] isConnected){
        vis[node]=true;
        for(int j=0;j<isConnected.length;j++){
            if(isConnected[node][j]==1 && vis[j]==false){
                dfs(j, vis, isConnected);
            }
        }
    }

}

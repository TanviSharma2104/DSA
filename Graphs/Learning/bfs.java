
class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean visited[]=new boolean[V];
        ArrayList<Integer> bfs=new ArrayList<>();
        Queue<Integer> q=new LinkedList<>();
        q.add(0);
        visited[0]=true;
        while(!q.isEmpty()){
            Integer node=q.poll();
            bfs.add(node);
            for(Integer it:adj.get(node)){
                if(visited[it]==false){
                    visited[it]=true;
                    q.add(it);
                }
            }
        }
        return bfs;
    }
}

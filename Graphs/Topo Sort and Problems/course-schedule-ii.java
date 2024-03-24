class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int V=numCourses;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        int m = prerequisites.length;
        for (int i = 0; i < m; i++) {
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        int indegree[] = new int[V];
        for (int i = 0; i < V; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }


        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        
        int[] topo=new int[V];
        int i=V-1;
    
        while (!q.isEmpty()) {
            int node = q.peek();

            q.remove();
            topo[i--]=node;

            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) q.add(it);
            }
        }
        int[] arr={};
        if(i>0) return arr; 
        return topo;
        
    }
}

public class Solution {

    //KAHN'S ALGO
    public static List<Integer> topologicalSort(int[][] edges, int e, int v) {
        int indegree[]=new int[v];
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<v;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<e;i++){
            int u=edges[i][0];
            int vv=edges[i][1];
            adj.get(u).add(vv);
        }

        for(int i=0;i<v;i++){
            for(int it: adj.get(i)){
                indegree[it]++;
            }
        }

        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<v;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }

        // int topo[]=new int[v];
        // int i=0;
        List<Integer> topo=new ArrayList<>();
        while(!q.isEmpty()){
            int node=q.peek();
            q.remove();
            // topo[i++]=node;
            topo.add(node);

            for(int it: adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0){
                    q.add(it);
                }
            }
        }
        return topo;
       
    }
}

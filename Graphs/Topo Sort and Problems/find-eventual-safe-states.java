class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> reverseAdj = new ArrayList<>();
        List<Integer> safeNodes = new ArrayList<>();
        int[] inDegree = new int[n];

        for(int i = 0; i < n; i++){
            reverseAdj.add(new ArrayList<>());
        }

        for(int i = 0; i < n; i++){
            for(int neighborNode: graph[i]){
                reverseAdj.get(neighborNode).add(i);
                inDegree[i]++;
            }
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i = 0; i < n; i++){
            if(inDegree[i] == 0){
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()){
            int safeNode = queue.poll();
            safeNodes.add(safeNode);

            for(int neighbor : reverseAdj.get(safeNode)){
                inDegree[neighbor]--;
                if(inDegree[neighbor] == 0){
                    queue.offer(neighbor);
                }
            }
        }
        Collections.sort(safeNodes);
        return safeNodes;
    }
}

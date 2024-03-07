class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        int [][] dis=new int[n][m];
        int vis[][]=new int[n][m];

        Queue<Node> q=new LinkedList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    vis[i][j]=1;
                    q.add(new Node(i,j,0));
                }
                else{
                    vis[i][j]=0;
                }
            }
        }

        int rows[]={-1,0,1,0};
        int cols[]={0,1,0,-1};

        while(!q.isEmpty()){
            int r=q.peek().row;
            int c=q.peek().col;
            int l=q.peek().level;

            dis[r][c]=l;
            q.remove();

            for(int i=0;i<4;i++){
                int nr=r+rows[i];
                int nc=c+cols[i];

                if(nr>=0 && nr<n && nc>=0 && nc<m && vis[nr][nc]==0){
                    vis[nr][nc]=1;
                    q.add(new Node(nr,nc,l+1));
                }
            }
        }

        return dis;
    }

    class Node{
        int row;
        int col;
        int level;
        public Node(int r, int c, int l){
            row=r;
            col=c;
            level=l;
        }
    }
}

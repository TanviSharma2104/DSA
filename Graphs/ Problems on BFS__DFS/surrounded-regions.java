class Solution {
    public void solve(char[][] board) {
        int rows[]={-1,0,1,0};
        int cols[]={0,1,0,-1};

        int n=board.length;
        int m=board[0].length;

        int vis[][]=new int[n][m];

        for(int j=0;j<m;j++){
            // first row
            if(vis[0][j]==0 && board[0][j]=='O'){
                dfs(0,j,vis, board, rows, cols);
            }

            //last row
            if(vis[n-1][j]==0 && board[n-1][j]=='O'){
                dfs(n-1,j,vis, board, rows, cols);
            }

        }


        for(int i=0;i<n;i++){
            //first col
            if(vis[i][0]==0 && board[i][0]=='O'){
                dfs(i,0,vis, board, rows, cols);
            }

            //last col
            if(vis[i][m-1]==0 && board[i][m-1]=='O'){
                dfs(i,m-1,vis, board, rows, cols);
            }
        }

        //rest O mark X
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0 && board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }
    }

    private void dfs(int r, int c, int vis[][], char board[][], int rows[], int cols[]){
        vis[r][c]=1;
        int n=board.length;
        int m=board[0].length;

        for(int i=0;i<4;i++){
            int nr=r+rows[i];
            int nc=c+cols[i];

            if(nr>=0 && nr<n && nc>=0 && nc<m && vis[nr][nc]==0 && board[nr][nc]=='O'){
                dfs(nr,nc, vis, board, rows, cols);
            }
        }


    }
}

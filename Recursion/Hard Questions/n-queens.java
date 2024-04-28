class Solution {
    public List<List<String>> solveNQueens(int n) {
     List<List<String>> ans=new ArrayList<>();
     char[][] board=new char[n][n];
     for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            board[i][j]='.';
        }
     }
     dfs(0, board, ans);
     return ans;   
    }

    private void dfs(int col, char[][] board, List<List<String>> ans){
        if(col==board.length){
            ans.add(construct(board));
            return;
        }
        for(int row=0; row< board.length; row++){
            if(valid(board, row, col)){
                board[row][col]='Q';
                dfs(col+1, board, ans);
                board[row][col]='.';
            }
        }
    }
    private List<String> construct(char[][] board){
        List<String> res=new LinkedList<>();
        for(int i=0;i<board.length;i++){
            String s=new String(board[i]);
            res.add(s);
        }
        return res;
    }

    private boolean valid(char[][] board, int row, int col){
        // check left, north west and south west direction
        int r=row;
        int c=col;
        while(row>=0 && col>=0){
            //diagonal check upper  north west
            if(board[row][col]=='Q')return false;
            row--;
            col--;
        }
        row=r;
        col=c;
        while(col>=0){
            //vertical check  left c
            if(board[row][col]=='Q')return false;
            col--;
        }

        col=c;
        while(col>=0 && row<board.length){
            // diagonal check bottom  south west
            if(board[row][col]=='Q')return false;
            col--;
            row++;
        }
        return true;
    }
}

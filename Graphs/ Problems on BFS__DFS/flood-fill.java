
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int ans[][]=image;
        int icolor=image[sr][sc];
        int nr[]={-1,0,1,0};
        int nc[]={0,1,0,-1};
        dfs(sr,sc,ans,image,color,nr,nc,icolor);
        return ans;
    }


    private void dfs(int r, int c,int[][] ans,int[][] image, int color, int[]nr,int[]nc,int icolor){
        ans[r][c]=color;
        int n=image.length;
        int m=image[0].length;
        for(int i=0;i<4;i++){
            int row=r+nr[i];
            int col=c+nc[i];
            if(row>=0 && row<n && col>=0 && col<m && image[row][col]==icolor && ans[row][col]!=color){
                dfs(row,col,ans,image, color, nr,nc,icolor);
            }
        }
    }
}

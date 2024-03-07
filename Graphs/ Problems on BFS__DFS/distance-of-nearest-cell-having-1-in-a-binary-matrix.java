import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	public static ArrayList<ArrayList<Integer>> nearest(ArrayList<ArrayList<Integer>> mat, int n, int m) {
		// Write your code here.
		int[][] vis=new int[n][m];
		ArrayList<ArrayList<Integer>> dis=new ArrayList<>();

		Queue<Node> q=new LinkedList<>();

		for(int i=0;i<n;i++){
			dis.add(new ArrayList<>());
			for(int j=0;j<m;j++){
				if(mat.get(i).get(j)==1){
					q.add(new Node(i, j, 0));
					vis[i][j]=1;
				}
				else{
					vis[i][j]=0;
				}
				dis.get(i).add(0);
			}
		}

		int rows[]={-1,0,1,0};
		int cols[]={0,1,0,-1};

		while(!q.isEmpty()){
			int r=q.peek().row;
			int c=q.peek().col;
			int l=q.peek().level;
			dis.get(r).set(c, l);

			q.remove();

			for(int i=0;i<4;i++){
				int nr=r+rows[i];
				int nc=c+cols[i];
				if(nr>=0 && nr<n && nc>=0 && nc<m && vis[nr][nc]==0){
					vis[nr][nc]=1;
					q.add(new Node(nr, nc, l+1));
				}
			}

		}

		return dis;
	}

	static class Node{
		int row;
		int col;
		int level;
		public Node(int r,int c,int l){
			row=r;
			col=c;
			level=l;
		}
	}
}

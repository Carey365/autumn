package algorithm.graph;

/**
 * 200. 岛屿数量
 */
public class IslandSolution {
    public int numIslands(char[][] grid) {
        boolean[][] searched=new boolean[grid.length][grid[0].length];
        int ans=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(!searched[i][j] && grid[i][j]=='1'){
                    search(grid,i,j,searched);
                    ans++;
                }
            }
        }
        return ans;
    }
    public void search(char[][] grid,int i,int j,boolean[][] searched){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || searched[i][j] || grid[i][j]=='0'){
            return;
        }
        searched[i][j]=true;
        search(grid,i+1,j,searched);
        search(grid,i,j+1,searched);
        search(grid,i-1,j,searched);
        search(grid,i,j-1,searched);
    }
}

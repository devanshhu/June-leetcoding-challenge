/*
------------------------------------PROBLEM--------------------------------------------------------

There is an m x n grid with a ball. The ball is initially at the position [startRow, startColumn]. You are allowed to move the ball to one of the four adjacent four cells in the grid (possibly out of the grid crossing the grid boundary). You can apply at most maxMove moves to the ball.

Given the five integers m, n, maxMove, startRow, startColumn, return the number of paths to move the ball out of the grid boundary. Since the answer can be very large, return it modulo 109 + 7.


---------------------------------------------------------------------------------------------------
----------------------------------SOLUTION---------------------------------------------------------
 Use the recursive idea that:
    moves(n) = moves_left(n-1)+moves_right(n-1)+ moves_top(n-1)+ moves_bottom(n-1)  
with the boundary conditions :
    if maxMoves is < 0, then we cannot move any further, hence return 0 &&
    if either i or j is out of bounds, then we have crossed boundary, hence return 1; 
Create a 3D array to keep track of mapping for every matrix node with the no. of moves.
i.e. NO. OF MOVES MATTER FOR EVERY X,Y PAIR.    
---------------------------------------------------------------------------------------------------
*/

class Solution {
    private long[][][] dp ;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        this.dp = new long[m+1][n+1][maxMove+1];
        for(int i=0;i< m+1;i++)
            for(int j=0;j<n+1;j++)
                Arrays.fill(this.dp[i][j],-1);
        return (int)helper(m,n,startRow, startColumn, maxMove);
    }
    
    private long helper(int m , int n, int x, int y, int moves){
        if(moves < 0)
            return 0;
        if(x < 0 || y < 0 || x >= m || y >=n )
            return 1;
        if( this.dp[x][y][moves] != -1)
            return this.dp[x][y][moves];
        
        long left = helper(m,n,x-1,y,moves-1)%1000000007;
        long right = helper(m,n,x+1,y,moves-1)%1000000007;

        long up = helper(m,n,x,y-1,moves-1)%1000000007;

        long bottom = helper(m,n,x,y+1,moves-1)%1000000007;

        long ans = (left + right + up + bottom)%1000000007;
        this.dp[x][y][moves] = ans;
        return ans;
        
    }
}
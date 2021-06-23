/*
    You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

The area of an island is the number of cells with a value 1 in the island.

Return the maximum area of an island in grid. If there is no island, return 0.

EXAMPLE: 
Input: grid = [ [0,0,1,0,0,0,0,1,0,0,0,0,0],
                [0,0,0,0,0,0,0,1,1,1,0,0,0],
                [0,1,1,0,1,0,0,0,0,0,0,0,0],
                [0,1,0,0,1,1,0,0,1,0,1,0,0],
                [0,1,0,0,1,1,0,0,1,1,1,0,0],
                [0,0,0,0,0,0,0,0,0,0,1,0,0],
                [0,0,0,0,0,0,0,1,1,1,0,0,0],
                [0,0,0,0,0,0,0,1,1,0,0,0,0]]
Output: 6
Explanation: The answer is not 11, because the island must be connected 4-directionally.


*/

// The idea is to 
class Solution {
    boolean[][] visited;
    int[][] mat;
    public int maxAreaOfIsland(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0 )
            return 0;
        this.mat = grid;
        int maxCount = 0;
        // an array that keeps track of visited nodes 
        this.visited = new boolean[grid.length][grid[0].length];
        // iterate for every element & recur for neighbours if they are landmass, ignore if water
        for(int i=0;i< grid.length;i++){
            for(int j=0 ; j < grid[0].length ; j++){
                maxCount = Math.max(logic(i,j), maxCount);                
            }
        }
        return maxCount;
    }
    
    int logic(int i, int j){
        // if indexes are invalid OR the node has been visited already, return 0.
        if( i < 0 || i >= this.mat.length || j < 0 || j >= this.mat[0].length || this.visited[i][j] || this.mat[i][j] == 0)
            return 0 ;
        // mark the node as visited
        this.visited[i][j] = true;
        // recur for neighbours , they will return their respective values & add them to get the max area. Added 1 to include current node.
       return 1 + this.logic(i-1,j) + this.logic(i+1,j)+ this.logic(i, j-1)+ this.logic(i,j+1);
    }
}
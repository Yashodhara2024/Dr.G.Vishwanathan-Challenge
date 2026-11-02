LeetCode Problem 994 : Rotting Oranges
You are given an m x n grid where each cell can have one of three values:
0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

Example 1:
Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
Output: 4

Code:
class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        int minutes = 0;
        int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 2) {
                    q.add(new int[]{i,j});
                }
                else if(grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        while(!q.isEmpty() && fresh > 0) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int[] curr = q.poll();
                for(int[] d : dir) {
                    int r = curr[0] + d[0];
                    int c = curr[1] + d[1];
                    if(r >= 0 && c >= 0 && r < m && c < n &&
                       grid[r][c] == 1) {

                        grid[r][c] = 2;
                        fresh--;
                        q.add(new int[]{r,c});
                    }
                }
            }
            minutes++;
        }
        if(fresh > 0)
            return -1;
        return minutes;
    }
}

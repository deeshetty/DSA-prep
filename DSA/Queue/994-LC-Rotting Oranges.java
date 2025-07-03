// https://leetcode.com/problems/rotting-oranges/description/

// You are given an m x n grid where each cell can have one of three values:

// 0 representing an empty cell,
// 1 representing a fresh orange, or
// 2 representing a rotten orange.
// Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

// Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

 

// Example 1:


// Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
// Output: 4
// Example 2:

// Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
// Output: -1
// Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
// Example 3:

// Input: grid = [[0,2]]
// Output: 0
// Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.
 

// Constraints:

// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 10
// grid[i][j] is 0, 1, or 2.

//old solution
class Pair {
    int first, second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    private int[][] moves = {{1,0}, {-1,0}, {0,1}, {0,-1}};

    public int orangesRotting(int[][] grid) {
        int cnt = 0;
        int cnt_fresh = 0;
        Queue<Pair> q = new LinkedList<>();

        int rows = grid.length;
        int cols = grid[0].length;

        // boolean rottenFound = false;

        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(grid[i][j] == 2) {
                    q.add(new Pair(i,j));
                    // rottenFound = true;
                } else if(grid[i][j] == 1) {
                    cnt_fresh++;
                }
            }
        }

        if(cnt_fresh == 0) {
            return 0;
        }

        while(!q.isEmpty()) {
            int size = q.size();
            cnt++;

            for(int i=0; i<size; i++) {
                Pair p = q.poll();
                int r = p.first;
                int c = p.second;

                for(int[] move : moves) {
                    int ur = r + move[0];
                    int uc = c + move[1];
                    if(ur >=0 && ur < rows && uc >=0 && uc < cols && grid[ur][uc] == 1) {
                        grid[ur][uc] = 2;
                        q.add(new Pair(ur,uc));
                        cnt_fresh--;
                    }
                }
            }
        }

        // for(int i=0; i<rows; i++) {
        //     for(int j=0; j<cols; j++) {
        //         if(grid[i][j] == 1) {
        //             return -1;
        //         }
        //     }
        // }

        return cnt_fresh > 0 ? -1 : cnt-1;
    }
}

//using visited array
class Solution {
    private class Pair {
        int r;
        int c;

        Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] visited = new int[rows][cols];
        int ans = 0;
        Deque<Pair> q = new ArrayDeque<>();

        int freshOranges = 0;
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(grid[i][j] == 2 && visited[i][j] == 0) {
                    visited[i][j] = 1;
                    q.addLast(new Pair(i, j));
                }
                else if(grid[i][j] == 0) {
                    visited[i][j] = 1;
                }
                else if(grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }

        if(freshOranges == 0) {
            return 0;
        }

        if(q.isEmpty()) {
            return -1;
        }

        int[][] moves = {{-1,0}, {0,1}, {0,-1}, {1,0}};

        while(!q.isEmpty()) {
            ans++;
            int qSize = q.size();
            for(int i=0; i<qSize; i++) {
                Pair curGrid = q.pollFirst();

                for(int[] move : moves) {
                    int newRow = curGrid.r + move[0];
                    int newCol = curGrid.c + move[1];

                    if(newRow >=0 && newRow < rows && newCol >=0 && newCol < cols && grid[newRow][newCol] == 1 && visited[newRow][newCol] == 0) {
                        freshOranges--;
                        visited[newRow][newCol] = 1;
                        q.addLast(new Pair(newRow, newCol));
                    }
                }
            }
        }

        return freshOranges == 0 ? ans - 1 : -1;
    }
}

//using the same grid as visited array
// This is a more optimal solution as it uses the grid itself to track visited cells, reducing
class Solution {
    private static final int[][] DIRECTIONS = {{-1,0}, {0,1}, {1,0}, {0,-1}};

    private class Pair {
        int r;
        int c;

        Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    private int initQueueAndCountFreshOranges(int[][] grid, int rows, int cols, Deque<Pair> q) {
        int freshOranges = 0;
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(grid[i][j] == 2) {
                    q.addLast(new Pair(i, j));
                }
                else if(grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }

        return freshOranges;
    }

    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] visited = new int[rows][cols];
        int ans = 0;
        Deque<Pair> q = new ArrayDeque<>();

        int freshOranges = initQueueAndCountFreshOranges(grid, rows, cols, q);

        if(freshOranges == 0) {
            return 0;
        }

        if(q.isEmpty()) {
            return -1;
        }

        int[][] moves = {{-1,0}, {0,1}, {0,-1}, {1,0}};

        while(!q.isEmpty()) {
            ans++;
            int qSize = q.size();
            for(int i=0; i<qSize; i++) {
                Pair curGrid = q.pollFirst();

                for(int[] move : DIRECTIONS) {
                    int newRow = curGrid.r + move[0];
                    int newCol = curGrid.c + move[1];

                    if(isValid(grid, newRow, newCol, rows, cols)) {
                        freshOranges--;
                        grid[newRow][newCol] = 2;
                        q.addLast(new Pair(newRow, newCol));
                    }
                }
            }
        }

        return freshOranges == 0 ? ans - 1 : -1;
    }

    private boolean isValid(int[][] grid, int row, int col, int rows, int cols) {
        return row >= 0 && row < rows && col >= 0 && col < cols && grid[row][col] == 1;
    }
}
//most optimal solution

// Intuition (Queue & Logic):

// Imagine all the rotten oranges as the starting points.
// Put the positions of all rotten oranges into a queue.
// Each minute, for every rotten orange in the queue, check its 4 neighbors (up, down, left, right).
// If a neighbor is a fresh orange, rot it (change its value to 2), and add its position to the queue.
// After processing all oranges in the queue for that minute, increase the minute counter.
// Repeat this process until the queue is empty (no more oranges can rot).
// If there are still fresh oranges left at the end, return -1 (not all can rot). Otherwise, return the number of minutes taken (subtract 1 because the last increment happens after all are rotten).

// In short:
// The queue keeps track of which oranges will rot next. Each round (minute), you rot all possible fresh oranges next to the current rotten ones and add them to the queue for the next round. This continues until no more fresh oranges can be rotted.
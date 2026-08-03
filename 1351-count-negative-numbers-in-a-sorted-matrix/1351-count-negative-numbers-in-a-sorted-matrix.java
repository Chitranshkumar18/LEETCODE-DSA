class Solution {
    public int countNegatives(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int i = n - 1;
        int j = 0;
        int count = 0;

        while (i >= 0 && j < m) {
            if (grid[i][j] < 0) {
                count += (m - j);
                i--;
            } else {
                j++;
            }
        }

        return count;
    }
}
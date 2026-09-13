class Solution {
    public int[] findPeakGrid(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;

        int l = 0, h = m - 1;

        while (l <= h) {
            int mid = l + (h - l) / 2;

            int max = Integer.MIN_VALUE;
            int idx = -1;

            // Find maximum element in current column
            for (int i = 0; i < n; i++) {
                if (arr[i][mid] > max) {
                    max = arr[i][mid];
                    idx = i;
                }
            }

            // Left and right values
            int left = (mid > 0) ? arr[idx][mid - 1] : -1;
            int right = (mid < m - 1) ? arr[idx][mid + 1] : -1;

            // Peak found
            if (max > left && max > right) {
                return new int[]{idx, mid};
            }

            // Move towards larger neighbour
            if (left > max) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return new int[]{-1, -1};
    }
}
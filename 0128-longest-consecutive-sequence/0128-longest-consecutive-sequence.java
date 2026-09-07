import java.util.Arrays;

class Solution {
    public int longestConsecutive(int[] arr) {

        int n = arr.length;

        if (n == 0) return 0;

        Arrays.sort(arr);

        int count = 1;
        int maxCount = 1;

        for (int i = 1; i < n; i++) {

            if (arr[i] == arr[i - 1]) {
                continue;
            }

            if (arr[i] == arr[i - 1] + 1) {
                count++;
            } else {
                count = 1;
            }

            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
    }
}
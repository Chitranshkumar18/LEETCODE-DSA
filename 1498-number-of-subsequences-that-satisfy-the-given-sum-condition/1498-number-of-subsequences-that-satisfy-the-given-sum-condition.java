class Solution {

    public int numSubseq(int[] arr, int target) {

        Arrays.sort(arr);

        int n = arr.length;
        int i = 0;
        int j = n - 1;

        long count = 0;
        long MOD = 1_000_000_007L;

        long[] pow = new long[n];
        pow[0] = 1;

        for (int x = 1; x < n; x++) {
            pow[x] = (pow[x - 1] * 2) % MOD;
        }

        while (i <= j) {

            if (arr[i] + arr[j] <= target) {

                count = (count + pow[j - i]) % MOD;
                i++;

            } else {

                j--;
            }
        }

        return (int) count;
    }
}
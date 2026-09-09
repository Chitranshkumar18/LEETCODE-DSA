class Solution {
    public long countCommas(long n) {
        long ans = 0;

        if (n < 1000) return 0;

        long start = 1000;

        while (start <= n) {
            long end = Math.min(n, start * 1000 - 1);
            long count = end - start + 1;

            ans += count * (digits(start) / 3);

            start *= 1000;
        }

        return ans;
    }

    private int digits(long n) {
        int count = 0;

        while (n > 0) {
            count++;
            n /= 10;
        }

        return count;
    }
}
class Solution {

    public String shortestCommonSupersequence(String s1, String s2) {

        String ans = lst(s1, s2);   // LCS

        int m = s1.length();
        int n = s2.length();

        int i = 0, j = 0, k = 0;

        StringBuilder str = new StringBuilder();

        while (k < ans.length()) {

            while (i < m && s1.charAt(i) != ans.charAt(k)) {
                str.append(s1.charAt(i));
                i++;
            }

            while (j < n && s2.charAt(j) != ans.charAt(k)) {
                str.append(s2.charAt(j));
                j++;
            }

            str.append(ans.charAt(k));
            i++;
            j++;
            k++;
        }

        while (i < m) {
            str.append(s1.charAt(i));
            i++;
        }

        while (j < n) {
            str.append(s2.charAt(j));
            j++;
        }

        return str.toString();
    }

    // Returns LCS String
    public String lst(String s1, String s2) {

        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        StringBuilder ans = new StringBuilder();

        int i = m;
        int j = n;

        while (i > 0 && j > 0) {

            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                ans.append(s1.charAt(i - 1));
                i--;
                j--;
            } else {
                if (dp[i - 1][j] > dp[i][j - 1])
                    i--;
                else
                    j--;
            }
        }

        return ans.reverse().toString();
    }
}
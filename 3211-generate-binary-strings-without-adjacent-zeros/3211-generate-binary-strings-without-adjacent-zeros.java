class Solution {

    public List<String> validStrings(int n) {

        List<String> ans = new ArrayList<>();

        helper(n, "", ans);

        return ans;
    }

    public void helper(int n, String str, List<String> ans) {

        if (str.length() == n) {
            ans.add(str);
            return;
        }

        // Add 1
        helper(n, str + "1", ans);

        // Add 0 only if previous character is 1
        if (str.length() == 0 || str.charAt(str.length() - 1) == '1') {
            helper(n, str + "0", ans);
        }
    }
}
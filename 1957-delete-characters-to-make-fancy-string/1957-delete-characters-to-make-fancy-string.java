class Solution {
    public String makeFancyString(String s) {
        if (s.length() < 3) {
            return s;
        }

        int n = s.length() - 1;
        StringBuilder sb = new StringBuilder();

        sb.append(s.charAt(n));
        sb.append(s.charAt(n - 1));

        for (int i = n - 2; i >= 0; i--) {
            if (s.charAt(i) == s.charAt(i + 1) &&
                s.charAt(i + 1) == s.charAt(i + 2)) {
                continue;
            }

            sb.append(s.charAt(i));
        }

        return sb.reverse().toString();
    }
}
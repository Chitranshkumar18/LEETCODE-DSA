class Solution {

    public String largestOddNumber(String s) {

        StringBuilder ans = new StringBuilder();

        for(int i = s.length() - 1; i >= 0; i--) {

            int ch = s.charAt(i) ;

            if(ch % 2 != 0) {

                ans.append(s.substring(0, i + 1));
                return ans.toString();

            }
        }

        return "";
    }
}
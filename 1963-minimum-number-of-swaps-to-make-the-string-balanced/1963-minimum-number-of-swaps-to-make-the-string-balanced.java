class Solution {
    public int minSwaps(String s) {
        int balance = 0;
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[') {
                balance++;
            } else {
                balance--;
            }

            max = Math.max(max, -balance);
        }

        return (max + 1) / 2;
    }
}
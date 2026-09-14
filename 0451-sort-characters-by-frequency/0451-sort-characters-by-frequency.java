class Solution {
    public String frequencySort(String s) {

        int[] arr = new int[256];

        for(int i = 0; i < s.length(); i++) {
            arr[s.charAt(i)]++;
        }

        StringBuilder ans = new StringBuilder();

        for(int freq = s.length(); freq > 0; freq--) {

            for(int i = 0; i < 256; i++) {

                if(arr[i] == freq) {

                    for(int j = 0; j < freq; j++) {
                        ans.append((char)i);
                    }
                }
            }
        }

        return ans.toString();
    }
}
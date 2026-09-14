class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()){
            return false;
        }

        String ss = s+s;
        if(ss.contains(goal)){
            return true;
        }
        return false;
        
    }
}
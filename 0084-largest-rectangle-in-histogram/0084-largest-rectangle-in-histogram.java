class Solution {
    public int largestRectangleArea(int[] arr) {
        int n=arr.length;
        Stack <Integer> st=new Stack<>();
        int []nse=new int [n];
        nse[n-1]=n;
        st.push(n-1);// idex dal rahe hai isliye -1 nhi hoga n-1 hoga
        for(int i=n-1;i>=0;i--){
            while(st.size()>0 && arr[st.peek()]>=arr[i]) st.pop();
            if(st.size()==0) nse[i]=n;
            else nse[i]=st.peek();
            st.push(i);
        }
        while(st.size()>0)st.pop();//stack ko khale kr rahe hai 
        int []pse=new int [n];
        pse[0]=-1;
        st.push(0);
        for(int i=1;i<n;i++){
            while(st.size()>0 && arr[st.peek()]>=arr[i]) st.pop();
            if(st.size()==0) pse[i]=-1;
            else pse[i]=st.peek();
            st.push(i);
        }
        int maxarea=0;
        for(int i=0;i<n;i++){
            int area= arr[i]*(nse[i]-pse[i]-1);
            maxarea=Math.max(maxarea,area);
        }
        return maxarea;
        
        
    }
}
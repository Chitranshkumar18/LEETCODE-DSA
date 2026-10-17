class Solution {
    public int maximalRectangle(char[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int[] height = new int [m];
        int max = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(arr[i][j] == '1'){
                    height[j]++;
                }
                else{
                    height[j] = 0;
                }
            }
            int result = largestRectangleArea(height);
            max = Math.max(max,result);

        }

        return max;
    }

    public int largestRectangleArea(int[] arr) {
        int n=arr.length;
        Stack <Integer> st=new Stack<>();
        int [] nse = new int [n];
        nse[n-1]=n;
        st.push(n-1);// idex dal rahe hai isliye -1 nhi hoga n-1 hoga
    for(int i=n-1;i>=0;i--){ // next smaller ele
            while(st.size()>0 && arr[st.peek()]>=arr[i]) st.pop();
            if(st.size()==0) nse[i]=n;
            else nse[i]=st.peek();
            st.push(i);
        }
        while(st.size()>0)st.pop();//stack ko khale kr rahe hai 
        int []pse=new int [n];
        pse[0]=-1;
        st.push(0);
    for(int i=1;i<n;i++){ // prevoius smaller ele
            while(st.size()>0 && arr[st.peek()]>=arr[i]) st.pop();
            if(st.size()==0) pse[i]=-1;
            else pse[i]=st.peek();
            st.push(i);
        }
        int maxarea=0;
    for(int i=0;i<n;i++){
            int area= arr[i]*(nse[i]-pse[i]-1); //number of bars the rectangle can cover
            maxarea=Math.max(maxarea,area);
        }
        return maxarea;    
    }
}
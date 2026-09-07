class Solution {
    public List<Integer> majorityElement(int[] arr) {
       int count1 = 0;
       int ele1 = Integer.MIN_VALUE;
       int count2 = 0;
       int ele2 = Integer.MIN_VALUE;
       for(int i=0;i<arr.length;i++){
        if(count1==0 && arr[i]!=ele2){
            count1 = 1; 
            ele1 = arr[i];
        }
        else if(count2==0 && arr[i]!=ele1){
            count2 = 1; 
            ele2 = arr[i];
        }
        else if(ele1 == arr[i]) count1++;
        else if(ele2 == arr[i]) count2++;
        else{
            count1--;
            count2--;
        }
       }

    List<Integer> ans= new ArrayList<>();
    count1 = 0;
    count2 = 0;
    for(int i=0;i<arr.length;i++){
        if(ele1==arr[i]) count1++;
        if(ele2==arr[i]) count2++;
    }
    int min = (int)(arr.length/3) + 1;
    if(count1 >= min) ans.add(ele1);
    if(count2 >= min) ans.add(ele2);

    Collections.sort(ans);
    return ans;

    }
}
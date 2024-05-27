class Solution {
    public int specialArray(int[] nums) {
       /*
        * nums = [0,4,3,0,4]
        * freq = [2,0,0,1,2]
        */
        int[] freq = new int[1001];
        for(int i : nums){ // O(n)
            freq[i]++;
        }
        int result = nums.length;
        for(int i=0;i<freq.length;i++){
            if(i == result){
                return i;
            }
            else if(i > result){
                return -1;
            }
            result -= freq[i];
        }
        return -1;
    }
}
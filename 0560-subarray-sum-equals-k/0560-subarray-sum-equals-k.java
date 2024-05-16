class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> prefixSum = new HashMap<>();
        int result = 0;
        int sum = 0;
        int prefix;
        int temp;
        prefixSum.put(0,1);
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            prefix = sum - k;
            if(prefixSum.containsKey(prefix))
                result += prefixSum.get(prefix);
            if(prefixSum.containsKey(sum)) {
                temp = prefixSum.get(sum);
                temp++;
                prefixSum.put(sum,temp);
            }
            else
                prefixSum.put(sum,1);
        }
        return result;
    }
}
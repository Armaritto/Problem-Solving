class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int i;
        for(i=0;i<nums.length;i++){
            if(!map.containsKey(target - nums[i])){
                map.put(nums[i],i);
            }
            else{
                break;
            }
        }
        return new int[]{map.get(target - nums[i]),i};
    }
}
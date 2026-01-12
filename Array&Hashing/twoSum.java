class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> prevMap = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            int num = nums[i];
            int needed = target-num;
            if(prevMap.containsKey(needed)) {
                return new int[] { prevMap.get(needed),i};
            }
            prevMap.put(num,i);
        }
        return new int[]{};
        
    }
    
}
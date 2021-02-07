class Solution {
    public int[] twoSum(int[] nums, int target) {

        
        int result[];
        int i = 0;
        int j = 0;
        boolean flag = false;
        for(;i<nums.length-1;i++){
            for(j = i+1;j<nums.length;j++){
                int sum = nums[i]+nums[j];
                if(sum == target){
                    flag = true;
                    break;
                }
            }
            if(flag){
                    break;
                }
        }
        return new int[]{i, j};

    }
}
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer> > answer = new ArrayList<>();
        
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length; i++) {
             if(i > 0 && nums[i] == nums[i - 1]) continue;
             
            int lt = i + 1, rt = nums.length - 1;
            
            while (lt < rt) {
                int total = nums[lt] + nums[rt] + nums[i];
                
                if(total > 0) {
                    rt--;
                } else if(total < 0) {
                    lt++;
                } else {
                    answer.add(List.of(nums[i], nums[lt], nums[rt]));
                    
                    while (lt < rt && nums[lt] == nums[lt + 1]) {
                        lt++;
                    }
                    
                    while (lt < rt && nums[rt] == nums[rt - 1]) {
                        rt--;
                    }
                    
                    lt++;
                    rt--;
                }
            }
        }
        
        return answer;
    }
}
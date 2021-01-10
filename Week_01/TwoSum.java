public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        //暴力解法：枚举所有满足 a + b = target
        // for(int i = 0 ; i < nums.length -1 ; i++){
        //     for(int j = i + 1 ; j < nums.length ; j++){
        //         if(target == nums[i] + nums[j]){
        //             return new int[]{i,j};
        //         }
        //     }
        // }
        // return new int[]{};
        //优化解法：使用hash存储计算过的元素，如果存在hash.containsKey(target-nums[i])则返回
        Map<Integer,Integer> hashMap = new HashMap<>();
        hashMap.put(nums[0],0);
        for(int i = 1 ; i < nums.length ; i++){
            if(hashMap.containsKey(target - nums[i])){
                return new int[]{hashMap.get(target-nums[i]),i};
            }
            hashMap.put(nums[i],i);
        }
        return new int[]{};
    }
}
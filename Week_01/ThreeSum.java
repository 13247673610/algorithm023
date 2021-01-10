public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
       //暴力解法，枚举所有可能性求解，同时利用set去重
        // Set<List<Integer>> result = new LinkedHashSet<>();
        // Arrays.sort(nums);
        // for(int i = 0 ; i < nums.length - 2 ; i++){
        //     for(int j = i + 1 ; j < nums.length - 1 ; j++){
        //         for(int k = j + 1 ; k < nums.length ; k++){
        //             if(nums[i] + nums[j] + nums[k] == 0){
        //                 result.add(Arrays.asList(nums[i],nums[j],nums[k]));
        //             }
        //         }
        //     }
        // }
        // return new ArrayList<>(result);
        //解法二：利用hash，简化成twoSum的解法，同时利用set去重
        // Arrays.sort(nums);
        // Set<List<Integer>> result = new LinkedHashSet<>();
        // for(int i = 0 ; i < nums.length - 1 ; i++){
        //     if(nums[i] > 0) break;
        //     // a + b + c = 0 a + b = -c
        //     int target = -nums[i];
        //     Map<Integer,Integer> hashMap = new HashMap<>();
        //     for(int j = i + 1 ; j < nums.length ; j++){
        //         if(hashMap.containsKey(target - nums[j])){
        //             result.add(Arrays.asList(hashMap.get(target - nums[j]),nums[i],nums[j]));
        //         }else{
        //             hashMap.put(nums[j],nums[j]);
        //         }
        //     }
        // }
        // return new ArrayList<>(result);
        //解法三：双指针，左右夹逼
       Arrays.sort(nums);
       List<List<Integer>> result = new ArrayList<>();
       for(int i = 0 ; i < nums.length - 2 ; i++){
           if(nums[i] > 0) break;
           if(i == 0 || (i > 0 && nums[i] != nums[i-1])){
               int left = i + 1 , right = nums.length - 1 , sum = -nums[i];
               while(left < right){
                   if(sum == nums[left] + nums[right]){
                       result.add(Arrays.asList(nums[i],nums[left],nums[right]));
                       //同时收敛
                       while(left < right && nums[left] == nums[left + 1]) left++;
                       while(left < right && nums[right] == nums[right - 1]) right--;
                       left++;
                       right--;
                   }else if(nums[left] + nums[right] > sum){
                       right--;
                   }else{
                       left++;
                   }
               }
           }
       }
       return result;
    }
} 


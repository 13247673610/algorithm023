public class MoveZeroes {
    public void moveZeroes(int[] nums) {
       //解法一：记录非0的个数，同时将非0往前挪，在通过尾部补0，时间复杂度为O(n)
    //    int j = 0;
    //    for(int i = 0 ; i < nums.length ; i++){
    //        if(nums[i] != 0){
    //            nums[j++] = nums[i];
    //        }
    //    }
    //    while(j < nums.length){
    //        nums[j++] = 0;
    //    }
        //解法二：双指针解法，j记录下一个非0元素要插入的位置，时间复杂度为O(n)
        // int j = 0 ;
        // for(int i = 0 ; i < nums.length ; i++){
        //     if(nums[i] != 0){
        //         int temp = nums[j];
        //         nums[j++] = nums[i];
        //         nums[i] = temp; 
        //     }
        // }
        int j = 0;
        for(int i = 0 ; i < nums.length; i++){
            if(nums[i] != 0){
                int temp = nums[j];
                nums[j++] = nums[i];
                nums[i] = temp;
            }
        }
    }
}
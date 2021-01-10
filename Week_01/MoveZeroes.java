public class MoveZeroes {
    public void moveZeroes(int[] nums) {
       //�ⷨһ����¼��0�ĸ�����ͬʱ����0��ǰŲ����ͨ��β����0��ʱ�临�Ӷ�ΪO(n)
    //    int j = 0;
    //    for(int i = 0 ; i < nums.length ; i++){
    //        if(nums[i] != 0){
    //            nums[j++] = nums[i];
    //        }
    //    }
    //    while(j < nums.length){
    //        nums[j++] = 0;
    //    }
        //�ⷨ����˫ָ��ⷨ��j��¼��һ����0Ԫ��Ҫ�����λ�ã�ʱ�临�Ӷ�ΪO(n)
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
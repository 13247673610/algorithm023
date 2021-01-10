public class MaxArea  {
    public int maxArea(int[] height) {
       //暴力解法，枚举所有可能性,复杂度为O(n^2)
    //    int max = 0;
    //    for(int i = 0 ; i < height.length - 1; i++){
    //        for(int j = i+1 ; j < height.length ; j++){
    //            int area = (j - i) * Math.min(height[i],height[j]);
    //            max = Math.max(max,area);
    //        }
    //    }
    //    return max;
        //双指针，左右夹逼解法,时间复杂度为O(n)
       int max = 0;
       for(int i = 0 , j = height.length - 1 ; i < j ;){
           int minHeight = height[i] < height[j] ? height[i++]:height[j--];
           max = Math.max(max,(j - i + 1) * minHeight);
       }
       return max;
    }
}
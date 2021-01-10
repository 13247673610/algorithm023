public class MaxArea  {
    public int maxArea(int[] height) {
       //�����ⷨ��ö�����п�����,���Ӷ�ΪO(n^2)
    //    int max = 0;
    //    for(int i = 0 ; i < height.length - 1; i++){
    //        for(int j = i+1 ; j < height.length ; j++){
    //            int area = (j - i) * Math.min(height[i],height[j]);
    //            max = Math.max(max,area);
    //        }
    //    }
    //    return max;
        //˫ָ�룬���Ҽбƽⷨ,ʱ�临�Ӷ�ΪO(n)
       int max = 0;
       for(int i = 0 , j = height.length - 1 ; i < j ;){
           int minHeight = height[i] < height[j] ? height[i++]:height[j--];
           max = Math.max(max,(j - i + 1) * minHeight);
       }
       return max;
    }
}
package Array;
/*
给定 nums = [2, 7, 11, 15], target = 9

因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]

 */
public class Test01 {

    public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        for(int i=0;i<nums.length;i++)
            for (int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    res[0]=i;
                    res[1]=j;
                }
            }
        return res;
    }

    public static void main(String[] args) {
        int[] nums={2,7,11,15};
        int[] res=twoSum(nums,9);
        System.out.println("["+res[0]+","+res[1]+"]");
    }
}

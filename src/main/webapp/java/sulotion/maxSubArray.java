package sulotion;

public class maxSubArray {
    public int maxSubArray(int[] nums) {
        int[] count=new int[nums.length];
        count[0]=nums[0];
        int max=nums[0];
        for(int i =1;i<nums.length;i++){
            count[i]=Math.max(count[i-1]+nums[i],nums[i]);
            if (count[i]>max)max=count[i];
        }
        return max;

    }
    }

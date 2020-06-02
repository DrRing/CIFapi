package sulotion;

public class minSubArrayLen {
    public int minSubArrayLen(int s, int[] nums){
        if(nums.length==0)return 0;
        int min=Integer.MAX_VALUE;
        int left=0;
        int right=0;
        int sum=0;
        while (right<nums.length){
            sum+=nums[right];
            right++;
            while (sum>=s){
                min=Math.min(min,right-left+1);
                sum-=nums[left];
                left++;
            }
        }
        return min==Integer.MAX_VALUE ? 0:min;
    }
    public int minSubArrayLen2(int s, int[] nums){
        if(nums.length==0)return 0;
        int[] sums=new int[nums.length];
        sums[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            sums[i]=sums[i-1]+nums[i];
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            int s2=s-nums[i];
            for (int j=i;j<nums.length;j++){
                if(sums[j]-sums[i]>=s2){
                    min = Math.min(min,j-i+1);
                }
            }
        }
        return min==Integer.MAX_VALUE ? 0:min;
    }
    int res=0;
    public int sumNums(int n) {
        boolean x=n > 1 && sumNums(n - 1) > 0;
        res += n;
        return res;
    }



}

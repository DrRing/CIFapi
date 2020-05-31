package sulotion;
/*你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额
链接：https://leetcode-cn.com/problems/house-robber
* */
public class rob {
    public int rob(int[] nums){
        int n=nums.length;
        if(n == 0) return 0;
        int[] dp=new int[n+1];
        dp[0] = 0;
        dp[1] = nums[0];
        for(int i =2;i<=n;i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i-1]);
        }
        return dp[n];
    }
    public int rob1(int[] nums){
        int sum1 =0;
        int sum2 =0;
        for(int i =0;i<nums.length;i++){
            if(i%2==0){
                sum1+=nums[i];
                sum1=Math.max(sum1,sum2);
            }
            else {
                sum2+=nums[i];
                sum2=Math.max(sum1,sum2);
            }
        }return Math.max(sum1,sum2);
    }
    public int rob3(int[] nums) {
        int[] dp = new int[nums.length + 2];
        for (int i = 0; i < nums.length; i++) {
            dp[i + 2] = Math.max(dp[i] + nums[i], dp[i + 1]);
        }
        return dp[nums.length + 1];
    }
}

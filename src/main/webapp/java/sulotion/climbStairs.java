package sulotion;

public class climbStairs {
    public int climbStairs1(int n){
        if(n<=2){
            return n;
        }
        int sum= climbStairs1(n-1)+climbStairs1(n-2);
        return sum;
    }
    public int climbStairs2(int n){
        int[] dp = new int[n+1];
        dp[0]=1;
        dp[1]=2;
        for (int i =2;i<n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    public int climbStairs(int n) {
        int pre=0;
        int index=1;
        for(int i=1;i<=n;i++){
            int sum=pre+index;
            pre=index;
            index=sum;
        }
        return index;

    }
}

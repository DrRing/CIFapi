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

    public static class longestCommonPrefix {
        public String longestCommonPrefix(String[] strs) {
            if(strs==null||strs.length==0) return "";
            String index=strs[0];
            for(int i =1;i<index.length();i++){
                char s=index.charAt(i);
                for(int j =1;j<strs.length;j++){
                    if(i==strs[j].length()||strs[j].charAt(j)!=s){
                        return index.substring(0,i);
                    }
                }
            }return index;
        }
        public String longestCommonPrefix2(String[] strs) {
            if(strs==null||strs.length==0) return "";
            String ind=strs[0];
            for(int i =1;i<strs.length;i++)
                while (strs[i].indexOf(ind)!=0){
                    ind=ind.substring(0,ind.length()-1);
                    if (ind.isEmpty()) return "";
                }
            return ind;
        }
        public String longestCommonPrefix3(String[] strs) {
            if (strs.length == 0) return "";
            String prefix = strs[0];
            for (int i = 1; i < strs.length; i++)
                while (strs[i].indexOf(prefix) != 0) {
                    prefix = prefix.substring(0, prefix.length() - 1);
                    if (prefix.isEmpty()) return "";
                }
            return prefix;
        }

    }
}

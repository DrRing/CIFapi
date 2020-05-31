package sulotion;

public class subArray {
    public boolean isSubsequence(String s, String t) {
        //考虑到  对第一个字符的处理 ，在t 之前一个空字符
        t=' '+t;
        //对t长字符串 做预处理
        int[][] dp = new int[t.length()][26];//存储每一个位置上  a--z的下一个字符出现的位置
        for (char c = 'a'; c <= 'z'; c++) {//依次对每个字符作处理
            int nextPos = -1;//表示接下来不会在出现该字符

            for (int i = t.length() - 1; i >= 0; i--) {//从最后一位开始处理
                dp[i][c - 'a'] = nextPos;//dp[i][c-'a']  加上外层循环  就是对每一个位置的a---z字符的处理了
                if (t.charAt(i) == c) {//表示当前位置有该字符  那么指向下一个该字符出现的位置就要被更新  为i
                    nextPos = i;
                }
            }
        }
        //数据的利用 ，开始匹配
        int index=0;
        for (char c:s.toCharArray()){
            index=dp[index][c-'a'];//因为加了' '，所以之后在处理第一个字符的时候  如果是在第一行，就会去第一行，不影响之后字符的判断
            if(index==-1){
                return false;
            }
        }
        return true;
    }
    public boolean isSubsequence1(String s, String t) {
        char[] qa=s.toCharArray();
        int j =-1;
        for(int i=0;i<qa.length;i++){
            j=t.indexOf(qa[i],i);
            if(j==-1) {
                return false;
            }
        }
        return true;
    }
    public boolean isSubsequence3(String s, String t) {
        char[] arr = s.toCharArray();
        int j = -1;
        for(int i = 0;i<arr.length;i++) {
            j = t.indexOf(arr[i],j+1);
            if(j==-1) {
                return false;
            }
        }
        return true;
    }
}

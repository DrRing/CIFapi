package sulotion;

import common.Log;

public class longestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        int n= strs.length;
        String pre= strs[0];
        if(n==0)return null;
        if(n==1)return pre;
        for(int i =1;i<n;i++){
            while (strs[i].indexOf(pre)!=0){
                pre = pre.substring(0,pre.length()-1);
                if(pre.isEmpty())return null;
            }
        }return pre;
    }
    public static String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }

    public static void main(String args[]) {
        String string = "aaa456ac";
        System.out.println(string.indexOf("6a45"));
        String[] strs={"asd123","8888"};
        //查找指定字符是在字符串中的下标。在则返回所在字符串下标；不在则返回-1.
        //String test=string.substring(0,-1);
       // System.out.println(test);
        String te= longestCommonPrefix2(strs);
        Log.info(te);
    }
}

package sulotion;

public class lengthOfLastWord {
    public int lengthOfLastWord(String s) {
        if(s.length()==0||s==null) return 0;
        int count=0;
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)==' '){
                if(count==0) continue;
                break;
            }
            count++;
        }return count;
    }
    public int lengthOfLastWord2(String s) {
        int end =s.length()-1;
        while(end>=0&&s.charAt(end)==' ')end--;
        if(end<0)return 0;
        int start=end;
        while (start>=0&&s.charAt(start)!=' ')start--;
        return  end-start;

    }
}

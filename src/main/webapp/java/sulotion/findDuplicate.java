package sulotion;

import common.Log;

import java.util.HashSet;

public class findDuplicate {
    public static  int findDuplicate(int[] nums){
        HashSet li=new HashSet<>();
        int ans=0;
        for(int i:nums){
            if(li.add(i)){
                continue;
            }else {
                ans= i;
            }
        }return ans;
    }
    public static void main(String[] args){
        int test[]={1,2,3,4,4,5};
        int ans=findDuplicate.findDuplicate(test);
        Log.info(ans);
    }
}

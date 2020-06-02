package sulotion;

import java.util.ArrayList;
import java.util.List;

public class kidsWithCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> ans= new ArrayList<>(candies.length);
        int maxcandy=0;
        for(int candy:candies){
            maxcandy=Math.max(maxcandy,candy);
        }
        for(int i=0;i<candies.length;i++){
            ans.add(candies[i]+extraCandies>=maxcandy);
        }return ans;

    }
    public List<Boolean> testkidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> res=new ArrayList<>(candies.length);
        int maxcandies=0;
        for (int candy:candies){
            maxcandies=Math.max(maxcandies,candy);
        }
        for(int i=0;i<candies.length;i++){
            res.add(maxcandies-extraCandies>=candies[i]);
        }return res;


    }



    }

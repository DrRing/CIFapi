package sulotion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class intersection {
    public int[] intersection(int[] nums1, int[] nums2) {

        HashSet<Integer> set1 = new HashSet<Integer>();//如果数据量大，应当考虑TreeSet
        for (Integer n : nums1) set1.add(n);
        List<Integer> list = new ArrayList<Integer>();
        for (Integer n : nums2) {
            if (set1.contains(n)) {
                list.add(n);
                set1.remove(n);
            }
        }
        int[] output = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            output[i] = list.get(i);
        }
        return output;
    }
    class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            HashSet<Integer> set1 = new HashSet<Integer>();
            HashSet<Integer> set2 = new HashSet<Integer>();
            for(int i:nums1) set1.add(i);
            for(int i:nums2){
                if(set1.contains(i)){
                    set2.add(i);
                }
            }
            int []new_num = new int[set2.size()];
            int j = 0;
            for(int i:set2){
                new_num[j] = i;
                j++;
            }
            return new_num;
        }
    }


}

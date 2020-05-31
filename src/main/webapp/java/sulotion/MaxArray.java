package sulotion;

public class MaxArray {
    public int maxArea(int[] height) {
        int left = 0;
        int rigjt = height.length - 1;
        int arr = 0;
        while (left < rigjt) {
            int arrcount = Math.min(height[left], height[rigjt]) * (rigjt - left);
            arr = Math.max(arrcount, arr);

            if (height[left] < height[rigjt]) {
                ++left;
            } else {
                --rigjt;
            }
        }
        return arr;
    }

    public int maxArea2(int[] a) {
        int max = 0;
        for (int i = 0, j = a.length - 1; i < j; ) {
            int minHeight = a[i] < a[j] ? a[i++] : a[j--];
            max = Math.max(max, (j - i + 1) * minHeight);
        }
        return max;
    }
}

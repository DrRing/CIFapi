package sulotion;

public class reverseChar {
    private void reverse(char[] s, int start, int end) {
        while (start < end) {
            char tem = s[end];
            s[end] = s[start];
            s[start] = tem;
            start = start + 1;
            end = end - 1;
        }
    }

    public String Charreverse(String s) {
        int n = s.length();
        char[] t = s.toCharArray();
        reverse(t, 0, n - 1);
        int i = 0;
        int j = 0;
        while (j < n - 1) {
            while (j < n && t[j] != ' ') {
                j++;
            }
            reverse(t, i, j - 1);
            i = j + 1;
            j++;
        }
        return t.toString().trim();
    }

    public String reverseWords(String s) {
        String word[] = s.split(" ");
        StringBuilder ans = new StringBuilder();
        for (String arr : word) {
            ans.append(new StringBuffer(arr).reverse().toString() + ' ');
        }
        return ans.toString().trim();
    }
}

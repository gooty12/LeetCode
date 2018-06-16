import java.util.Arrays;

public class AssignCookies455 {
    public int findContentChildren(int[] g, int[] s) {
        int res = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        for (int i = 0, j = 0; i < g.length;) {
            for (; j < s.length && g[i]>s[j]; j++);
            if (j < s.length) {
                i += 1;
                j += 1;
                res += 1 ;
            }
            else {
                break;
            }
        }
        return res;
    }
}

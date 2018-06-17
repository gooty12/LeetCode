import java.util.Arrays;

public class LongestPallindromeSubstring05 {
    int max, start; // Used for memoized version.
    public static void main(String[] args) {

        LongestPallindromeSubstring05 obj = new LongestPallindromeSubstring05();
        obj.longestPalindrome("abcba");
    }

    public String longestPalindrome(String s) {
        String res = "";
        if (s!= null && !s.isEmpty()) {
            int start = 0;
            int max = 1;
            boolean[][] dp = new boolean[s.length()+1][s.length()];
            Arrays.fill(dp[0], true);
            Arrays.fill(dp[1], true);
            for (int l = 2; l <= s.length(); l++) {
                int a = 2;
                for (int i = 0; i+l <= s.length(); i++) {
                    dp[l][i] = s.charAt(i)==s.charAt(i+l-1) &&  dp[l-2][i];
                    if (dp[l][i]) {
                        max = l;
                        start = i;
                    }
                }
            }
            res = s.substring(start, start+max);
        }

        return res;
    }

    // Memoization : TLE
    public String longestPalindrome2(String s) {
        String res = "";
        if (s!= null && !s.isEmpty()) {
            boolean[][] dp = new boolean[s.length()+1][s.length()];
            Arrays.fill(dp[0], true);
            Arrays.fill(dp[1], true);
            isPalindrome(0, s.length()-1, s, dp);
            res = s.substring(start, start+max);
        }

        return res;
    }

    public boolean isPalindrome(int i, int j, String s, boolean[][] dp) {
        if (j-i <= 1) {
            dp[i][j] = s.charAt(i)==s.charAt(j);
            update(dp[i][j], i, j);
        }
        else {
            dp[i][j] = isPalindrome(i+1, j-1, s, dp) && s.charAt(i)==s.charAt(j)  ;
            update(dp[i][j], i, j);
            boolean flag = dp[i][j];
            if (!flag && isPalindrome(i, j-1, s, dp) && s.charAt(i)==s.charAt(j-1)) {
                update(dp[i][j-1], i, j-1);
                flag = dp[i][j-1];
            }
            if (!flag && isPalindrome(i+1, j, s, dp) && s.charAt(i+1)==s.charAt(j)) {
                update(dp[i+1][j], i+1, j);
            }
        }
        return dp[i][j];
    }

    public void update(boolean b, int i, int j) {
        if (b && max < j-i+1) {
            max = j-i+1;
            start = i;
        }
    }
}

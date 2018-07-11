public class ScoreOfParantheses856 {
    public static void main(String[] args) {

        ScoreOfParantheses856 obj = new ScoreOfParantheses856();
        obj.scoreOfParentheses("(()(()))");
    }

    public int scoreOfParentheses(String S) {
        int score = 0;
        if (S != null && !S.isEmpty()) {
            score = recurse(S, 0, S.length()-1);
        }
        return score;
    }

    public int recurse(String S, int st, int end) {
        int score = 0;
        boolean flag = false;
        int start = -1;
        int depth = 0;
        for (int i = st; i <= end; i++) {
            if (!flag) {
                flag = true;
                start = i;
            }
            depth += S.charAt(i) == '(' ? 1 : -1;
            if (flag && depth == 0) {
                flag = false;
                if (i == start+1) {
                    score += 1;
                }
                else {
                    score += 2 * recurse(S, st+1, i-1);
                }
            }
        }
        return score;
    }
}

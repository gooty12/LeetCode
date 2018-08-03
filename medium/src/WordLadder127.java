import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordLadder127 {
    public static void main(String[] args) {

        WordLadder127 obj = new WordLadder127();
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int res = 0;
        Queue<Integer> q = new LinkedList<>();
        int[] dist = new int[wordList.size()];
        boolean[] visited = new boolean[wordList.size()];

        q.offer(-1);

        while (!q.isEmpty()) {
            int u = q.poll();
            String s = u==-1 ? beginWord : wordList.get(u);
            int d = u==-1 ? 1 : dist[u];
            if (s.equals(endWord)) {
                res = d;
                break;
            }
            for (int i = 0; i < visited.length; i++) {
                if (!visited[i]) {
                    int diffs = 0;
                    for (int j = 0; diffs<=1 && j < s.length(); j++) {
                        diffs += s.charAt(j)==wordList.get(i).charAt(j) ? 0 : 1;
                    }
                    if (diffs == 1) {
                        visited[i] = true;
                        q.offer(i);
                        dist[i] = d+1;
                    }
                }
            }
        }
        return res;
    }
}

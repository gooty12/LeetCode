import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CourseSchedule207 {
    public static void main(String[] args) {

        CourseSchedule207 obj = new CourseSchedule207();
        obj.canFinish(2, new int[][]{{1, 0}});
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] visit = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        boolean res = true;
        for (int i = 0; res && i < visit.length; i++) {
            res = visit[i] == 0 ? dfs(i, visit, adj) : res;
        }
        return res;
    }

    public boolean dfs(int u, int[] visit, List<List<Integer>> l) {
        boolean b = true;
        if (visit[u] == 0) {
            visit[u] = 1;
            List<Integer> adj = l.get(u);
            for (int i = 0; b && i < adj.size(); i++) {
                int v = adj.get(i);
                b = visit[v] == 1 ? false : dfs(v, visit, l);
            }
        }
        visit[u] = 2;
        return b;
    }
}

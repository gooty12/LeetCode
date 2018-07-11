import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left, right;
    public TreeNode(int val) {
        this.val = val;
    }
}
public class AllNodesKDistanceBinaryTree863 {
    public static void main(String[] args) {

        AllNodesKDistanceBinaryTree863 obj = new AllNodesKDistanceBinaryTree863();
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {

        List<Integer> res = new ArrayList<>();
        if (root != null) {
            List<List<Integer>> graph = new ArrayList<>();
            for (int i = 0; i <= 500; i++) {
                graph.add(new ArrayList<Integer>());
            }
            fillGraph(root, graph);

            Queue<Integer> q = new LinkedList<>();

            boolean[] visit = new boolean[502];
            visit[target.val] = true;

            int[] dist = new int[502];
            dist[target.val] = 0;

            q.add(target.val);
            if (K ==0) {
                res.add(target.val);
                return res;
            }
            while (!q.isEmpty()) {
                int u = q.remove();
                int d = dist[u];
                if (d >= K) {
                    break;
                }
                for (int v : graph.get(u)) {
                    if (!visit[v]) {
                        dist[v] = dist[u] + 1;
                        visit[v] = true;
                        if (dist[v] == K) {
                            res.add(v);
                        }
                        q.add(v);
                    }
                }
            }
        }
        return res;
    }

    public void fillGraph(TreeNode root, List<List<Integer>> graph) {
        if (root != null) {
            int v = root.val;
            int l = root.left == null ? -1 : root.left.val;
            int r = root.right == null ? -1 : root.right.val;
            if (l != -1) {
                graph.get(v).add(l);
                graph.get(l).add(v);
            }
            if (r != -1) {
                graph.get(v).add(r);
                graph.get(r).add(v);
            }
            fillGraph(root.left, graph);
            fillGraph(root.right, graph);
        }
    }
}

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph133 {
    public static void main(String[] args) {

        CloneGraph133 obj = new CloneGraph133();
        System.out.println(-2 % 5);
    }

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        return node == null ? null : recurse(node, new HashMap<>());
    }

    public UndirectedGraphNode recurse(UndirectedGraphNode node, Map<Integer, UndirectedGraphNode> map) {
        int label = node.label;
        UndirectedGraphNode clone = map.get(label);
        if (clone == null) {
            clone = new UndirectedGraphNode(label);
            map.put(label, clone);
            List<UndirectedGraphNode> adj = new ArrayList<>();
            for (int i = 0; i < node.neighbors.size(); i++) {
                adj.add(recurse(node.neighbors.get(i), map));
            }
            clone.neighbors = adj;
        }
        return clone;
    }
}

class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors = new ArrayList<>();
    public UndirectedGraphNode(int label) {
        this.label = label;
    }
}

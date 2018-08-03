import java.util.List;

public class Triangle120 {
    public static void main(String[] args) {

        Triangle120 obj = new Triangle120();
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        for (int i = triangle.size()-2; i >= 0; i--) {
            List<Integer> l1 = triangle.get(i);
            List<Integer> l2 = triangle.get(i+1);
            for (int j = 0; j < l1.size(); j++) {
                l1.set(j, l1.get(j)+Math.min(l2.get(j), l2.get(j+1)));
            }
        }
        return triangle.size()>0 && triangle.get(0).size()>0 ? triangle.get(0).get(0) : 0;
    }
}

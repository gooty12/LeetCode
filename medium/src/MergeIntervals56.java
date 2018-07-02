import java.util.ArrayList;
import java.util.List;

class Interval {
    int start;
    int end;
    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
public class MergeIntervals56 {
    public static void main(String[] args) {

        MergeIntervals56 obj = new MergeIntervals56();
    }

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        if (!intervals.isEmpty()) {
            intervals.sort((a, b) -> a.start - b.start == 0 ? a.end - b.end : a.start - b.start);
            Interval p = intervals.get(0);
            for (int i = 1; i < intervals.size(); i++) {
                Interval p2 = intervals.get(i);
                if (p2.start <= p.end) {
                    p = new Interval(p.start, Math.max(p.end, p2.end));
                }
                else {
                    res.add(p);
                    p = p2;
                }
            }
            res.add(p);
        }
        return res;
    }
}

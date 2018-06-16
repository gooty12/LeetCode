import java.util.ArrayList;
import java.util.List;

public class ThirdMaximumNumber414 {
    public int thirdMax(int[] nums) {
        ArrayList<Integer> l = new ArrayList<>();
        for (int n : nums) {
            if (l.size() == 0) {
                l.add(n);
            }
            else {
                if (!l.contains(n)) {
                    if (l.size() < 3) {
                        l.add(n);
                        l.sort(null);
                    }
                    else {
                        int j = 0;
                        for (; j < l.size() && n > l.get(j); j++);
                        for (int k = j-1; k >= 0; k--) {
                            int temp = n;
                            n = l.get(k);
                            l.set(k,temp);
                        }
                    }
                }
            }
        }
        int res;
        if (l.size() != 3) {
            res = l.get(l.size()-1);
        }
        else {
            res = l.get(0);
        }
        return res;
    }

    public static void main(String[] args) {
        ThirdMaximumNumber414 obj = new ThirdMaximumNumber414();
        obj.thirdMax(new int[]{3,2,1});
    }
}

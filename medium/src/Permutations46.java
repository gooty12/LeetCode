import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Permutations46 {
    public static void main(String[] args) {
        Integer[] arr = new Integer[1];
        //arr[0] = 2;
        List<Integer> l = new ArrayList<>();
        Collections.addAll(l,  arr);
        Permutations46 obj = new Permutations46();
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length > 0) {
            Arrays.sort(nums);
            Integer[] ns = new Integer[nums.length];
            int i = 0;
            for (int n : nums) {
                ns[i++] = n;
            }
            List<Integer> l = new ArrayList<>();
            Collections.addAll(l, ns);
            res.add(l);
            List<Integer> nextPerm = new ArrayList<>();
            while (true) {
                nextPerm = nextPermutation(ns);
                if (nextPerm != null) {
                    res.add(nextPerm);
                }
                else {
                    break;
                }
            }
        }
        return res;
    }

    public List<Integer> nextPermutation(Integer[] ns) {
        List<Integer> res = new ArrayList<>();
        int i = ns.length - 2;
        for (; i >= 0 && ns[i] > ns[i+1]; i--);
        if (i >= 0) {
            int st = i+1;
            int end = ns.length-1;
            while(st <= end) {
                int temp = ns[st];
                ns[st] = ns[end];
                ns[end] = temp;
                st += 1;
                end -= 1;
            }
            int j = i+1;
            for (; j < ns.length && ns[i] > ns[j]; j++);
            int temp = ns[i];
            ns[i] = ns[j];
            ns[j] = temp;
            Collections.addAll(res, ns);
        }
        else {
            res = null;
        }
        return res;
    }

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute2(int[] nums) {
        if (nums.length > 0) {
            recurse(new boolean[nums.length], nums, new ArrayList<>(), 0);
        }
        return res;
    }

    public void recurse(boolean[] used, int[] nums, List<Integer> perm, int ind) {
        if (ind >= nums.length) {
            res.add(perm);
        }
        else {
            long prev = Long.MAX_VALUE;
            for (int i = 0; i < nums.length; i++) {
                if (!used[i] && nums[i] != prev) {
                    int n = nums[i];
                    used[i] = true;
                    List<Integer> newPerm = new ArrayList<>(perm);
                    newPerm.add(n);
                    recurse(used, nums, newPerm, ind+1);
                    used[i] = false;
                    prev = n;
                }
            }
        }

    }

}

public class TwoSumII167 {
    public int[] twoSum(int[] numbers, int target) {
        int index1, index2;
        for (index1 = 0, index2 = numbers.length-1; index1 < index2; ) {
            int sum = numbers[index1] + numbers[index2];
            if (sum == target) {
                break;
            }
            else if (sum > target) {
                index2 -= 1;
            }
            else {
                index1 += 1;
            }
        }

        return new int[]{index1+1, index2+1};
    }
}

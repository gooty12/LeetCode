public class ContainerMostWater08 {
    public static void main(String[] args) {

        ContainerMostWater08 obj = new ContainerMostWater08();
    }

    public int maxArea(int[] height) {
        int res = 0;
        int i = 0, j = height.length-1;
        while (i < j) {
            int h1 = height[i];
            int h2 = height[j];
            if (h1 <= h2) {
                res = Math.max(res, h1*(j-i));
                i += 1;
            }
            else {
                res = Math.max(res, h2*(j-i));
                j -= 1;
            }
        }
        return res;
    }
}

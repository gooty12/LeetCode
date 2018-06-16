public class ConstructRectangle492 {
    public static void main(String[] args) {

        ConstructRectangle492 obj = new ConstructRectangle492();
    }

    public int[] constructRectangle(int area) {
        int sqrt = (int)(Math.sqrt(area));
        for(; area%sqrt != 0; sqrt--);
        return new int[]{Math.max(sqrt, area/sqrt), Math.min(sqrt, area/sqrt)};
    }
}

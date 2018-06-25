public class StringAndMisc {
    public static void main(String[] args) {

        StringAndMisc obj = new StringAndMisc();

        String[] arr1 = new String[] {"abc", "def", "ghi"};
        String joinedStr = String.join("->", arr1);

        System.out.println(joinedStr);
    }
}

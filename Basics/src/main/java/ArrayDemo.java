public class ArrayDemo {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }

        int[] nums = {10, 20, 30, 40, 50};
        System.out.println(nums.length);
        System.out.println(nums[1]);
    }
}

import java.util.Arrays;

public class TimSort{
    public static void main(String[] args) {
        int[] arr = {29, 25, 3, 49, 9, 37, 21, 43};

        System.out.println("Array antes do TimSort:");
        System.out.println(Arrays.toString(arr));

        Arrays.sort(arr);

        System.out.println("Array depois do TimSort:");
        System.out.println(Arrays.toString(arr));
    }
}
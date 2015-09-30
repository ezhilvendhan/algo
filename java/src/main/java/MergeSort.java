import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] inp = new int[]{1,2,232, 1,-34534,221,876,34,712324,12212,-11,0, -0, 24353};
    }

    private static int[] mergeSort(int[] inp) {
        int mid = inp.length/2;
        return merge(mergeSort(Arrays.copyOfRange(inp, 0, mid)),
                mergeSort(Arrays.copyOfRange(inp, mid + 1, inp.length)));
    }
    private static int[] merge(int[] one, int[] two) {
        int[] arr = new int[one.length + two.length];
        return one;
    }
}

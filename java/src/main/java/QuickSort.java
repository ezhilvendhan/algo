import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] inp = new int[]{1,2,232,1,-34534,221,876,-11,34,712324,12212,-11,0, -0, 24353};
        System.out.println(Arrays.toString(sort(inp, 0, inp.length-1)));
    }
    //take right most as pivot
    //traverse from left to arrange <=pivot on left & > on right
    //base case arr.length <= 1
    //combine
    public static int[] sort(int[] inp, int start, int end) {
        if(start >= end) {
            return inp;
        }
        int pivotIdx = start,
                left = start,
                right = end,
                pivot = inp[pivotIdx];
        while (left <= right) {
            while(inp[left] < pivot) {
                left++;
            }
            while(inp[right] > pivot) {
                right--;
            }
            if(left <= right) {
                swap(inp, left, right);
                left++;
                right--;
            }
        }
        sort(inp, start, right);
        sort(inp, left, end);
        return inp;
    }

    private static int[] swap(int[] inp, int aIdx, int bIdx) {
        int tmp = inp[aIdx];
        inp[aIdx] = inp[bIdx];
        inp[bIdx] = tmp;
        return inp;
    }
}

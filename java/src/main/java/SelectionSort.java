import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] inp = new int[]{1,2,232, 1,34534,221,876,324,12324,12123212,11,243};
        System.out.println(Arrays.toString(selSort(inp)));
    }

    private static int[] selSort(int[] inp) {
        int min, tmp, minIdx = 0;
        for(int idx = 0; idx < inp.length; idx++) {
            min = inp[idx];
            for(int subIdx = idx+1; subIdx < inp.length; subIdx++) {
                if(min > inp[subIdx]) {
                    min = inp[subIdx];
                    minIdx = subIdx;
                }
            }
            if(min != inp[idx]) {
                tmp = inp[minIdx];
                inp[minIdx] = inp[idx];
                inp[idx] = tmp;
            }
        }
        return inp;
    }
}

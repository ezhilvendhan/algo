import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] inp = new int[]{1,2,232, 1,34534,221,876,324,12324,12123212,11,243};
        System.out.println(Arrays.toString(sort(inp)));
    }

    private static int[] sort(int[] inp) {
        int outerNum;
        for(int idx = 1; idx < inp.length; idx++) {
            outerNum = inp[idx];
            for(int subIdx = idx-1; subIdx >=0; subIdx--) {
                if(outerNum < inp[subIdx]) {
                    swap(inp, subIdx, idx);
                    idx = subIdx;
                } else {
                    break;
                }
            }
        }
        return inp;
    }
    private static int[] swap(int[] inp, int aIdx, int bIdx) {
        int tmp = inp[aIdx];
        inp[aIdx] = inp[bIdx];
        inp[bIdx] = tmp;
        return inp;
    }
}

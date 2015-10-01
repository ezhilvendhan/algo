import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] inp = new int[]{1,2,232,1,-34534,221,876,34,712324,12212,-11,0, -0, 24353};
        System.out.println(Arrays.toString(sort(inp)));
    }

    private static int[] sort(int[] inp) {
        if(inp.length == 1) {
            return inp;
        }
        int mid = inp.length/2;
        return merge(sort(Arrays.copyOfRange(inp, 0, mid)),
                sort(Arrays.copyOfRange(inp, mid, inp.length)));
    }
    private static int[] merge(int[] one, int[] two) {
        int size = one.length + two.length,
            idx,
            newArrIdx = 0,
            subIdx = 0;
        int[] out = new int[size];
        for(idx = 0; idx < one.length; idx++) {
            for(; subIdx < two.length; subIdx++) {
                if(one[idx] > two[subIdx]) {
                    out[newArrIdx] = two[subIdx];
                    newArrIdx++;
                } else {
                    break;
                }
            }
            out[newArrIdx] = one[idx];
            newArrIdx++;
        }
        for(; subIdx < two.length; subIdx++) {
            out[newArrIdx] = two[subIdx];
            newArrIdx++;
        }
        return out;
    }
}

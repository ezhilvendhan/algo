
public class BinarySearch {
    public static void main(String[] args) {
        int[] inpSorted = new int[] {1,2,3,4,5,6,7,8,9,10};
        int toSearch = 9;
        int result = binS(inpSorted, toSearch);
        System.out.println("Index: "+ result+" - Value: "+ inpSorted[result]);
    }

    public static int binS(int[] inp, int toSearch) {
        return binS(inp, 0, inp.length - 1, toSearch);
    }

    private static int binS(int[] inp, int start, int end, int toSearch) {
        if(inp.length == 0) {
            return -1;
        }
        if(start >= end) {
            return inp[start] == toSearch ? start : -1;
        }
        if(inp[start] == toSearch) {
            return start;
        }
        if(inp[end] == toSearch) {
            return end;
        }
        int mid = (start + end)/2;
        if(inp[mid] == toSearch) {
            return mid;
        } else if(inp[mid] > toSearch) {
            return binS(inp, start, mid - 1, toSearch);
        } else {
            return binS(inp, mid + 1, end, toSearch);
        }
    }
}

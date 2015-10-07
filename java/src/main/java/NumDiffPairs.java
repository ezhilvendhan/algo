import java.util.*;

public class NumDiffPairs {
    public static void main(String[] args) {
        System.out.println(getPairs(new int[] {1, 2, 3, 5, 6, 8, 9, 11, 12, 13}, 3));
    }

    public static Set<String> getPairs(int[] nums, int diff) {
        Set<String> results = new HashSet<>();
        if(null == nums || nums.length == 0) {
            return results;
        }
        boolean hasPair;
        int numIdx, tmp;
        for(int idx=0; idx < nums.length; idx++) {
            hasPair = false;
            if(idx+3 < nums.length) {
                tmp = diff+nums[idx];
                numIdx = search(nums, tmp, 0, nums.length-1);
                if(numIdx > -1) {
                    results.add("("+nums[idx] + ", " + tmp+")");
                    hasPair = true;
                }
            }
            if(!hasPair && idx-3 > -1) {
                tmp = nums[idx]-diff;
                numIdx = search(nums, tmp, 0, nums.length-1);
                if(numIdx > -1) {
                    results.add("("+tmp + ", " + nums[idx]+")");
                }
            }
        }
        return results;
    }

    private static int search(int[] nums, int toSearch, int start, int end) {
        if(nums.length == 0) {
            return -1;
        }
        if(start >= end) {
            return nums[start] == toSearch ? start : -1;
        }
        if(nums[start] == toSearch) {
            return start;
        }
        if(nums[end] == toSearch) {
            return end;
        }
        int mid = (start+end)/2;
        if(nums[mid] == toSearch) {
            return mid;
        }
        if(nums[mid] > toSearch) {
            return search(nums, toSearch, start, mid-1);
        } else {
            return search(nums, toSearch, mid+1, end);
        }
    }
}

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
    public static void main(String[] args) {
        Integer[][] inp = new Integer[][]{
                new Integer[]{1,2}, new Integer[]{2}, new Integer[]{0, 3}, new Integer[]{3}};
        System.out.println(bfs(inp, 1));
    }

    public static List<Integer> bfs(Integer[][] inp, int start) {
        List<Integer> path = new LinkedList<>();
        return path;
    }
}
